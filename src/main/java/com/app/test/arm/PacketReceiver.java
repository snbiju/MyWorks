package com.app.test.arm;

import java.util.ArrayList;
import java.util.List;

public class PacketReceiver {

    // Define SOP, EOP, and CSUM constants
    private static final byte SOP = 0x01; // Example SOP value
    private static final byte EOP = 0x04; // Example EOP value

    private boolean receivingPacket = false;
    private List<Byte> data = new ArrayList<>();
    private byte checksum = 0;

    public int receivedNewByte(byte newByte) {
        if (newByte == SOP) {
            // Start of a new packet
            receivingPacket = true;
            data.clear();
            checksum = 0;
            return 0; // SOP detected
        } else if (newByte == EOP) {
            // End of the packet
            receivingPacket = false;
            if (validateChecksum()) {
                // Process the valid packet
                processData(data);
                return 1; // Packet successfully received
            } else {
                return -1; // Invalid checksum
            }
        } else if (receivingPacket) {
            // Accumulate data and update checksum
            data.add(newByte);
            checksum ^= newByte; // Example checksum (XOR of all bytes)
        }

        return 0; // Continue receiving
    }

    private boolean validateChecksum() {
        // Assuming last byte in data is checksum
        if (data.size() > 0) {
            byte receivedChecksum = data.remove(data.size() - 1); // Remove checksum from data list
            return checksum == receivedChecksum;
        }
        return false;
    }

    private void processData(List<Byte> data) {
        // Implement your logic to process the received data
        System.out.println("Packet received with data: " + data);
    }

    public static void main(String[] args) {
        PacketReceiver receiver = new PacketReceiver();

        byte[] incomingBytes = {SOP, 0x11, 0x22, 0x33, (byte) (0x11 ^ 0x22 ^ 0x33), EOP}; // Example packet

        for (byte b : incomingBytes) {
            int result = receiver.receivedNewByte(b);
            if (result == 1) {
                System.out.println("Valid packet received.");
            } else if (result == -1) {
                System.out.println("Invalid checksum.");
            }
        }
    }
}
