package com.app.test.arm;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class ByteOrderSwap {
    public static int swapByteOrder(int value) {
        // Swap the bytes of the integer using bitwise operations
        return ((value >> 24) ) |        // Move byte 3 to byte 0
                ((value >> 8)) |       // Move byte 2 to byte 1
                ((value << 8) & 0xFF0000) |     // Move byte 1 to byte 2
                ((value << 24) & 0xFF000000);   // Move byte 0 to byte 3
    }

    public static int swapBytesOrder(int value) {
        ByteBuffer buffer = ByteBuffer.allocate(4);
        buffer.order(ByteOrder.LITTLE_ENDIAN); // Set to little endian
        buffer.putInt(value);
        buffer.flip();
        return buffer.getInt();
    }

    public static void main(String[] args) {
        int original = 0x12345678;
        int original1=0x78563412;
        int swapped = swapByteOrder(original);

        System.out.printf("Original: %08X\n", original);
        System.out.printf("Swapped: %08X\n", swapped);
     //   System.out.printf("swapped:: 0x%08X\n",swapByteOrder(original1));


        int originalValue = 0x12345678;
      //  int swappedValue = swapBytesOrder(originalValue);
      //  System.out.println(Integer.toHexString(originalValue)); // Output: 12345678
    //    System.out.println(Integer.toHexString(swappedValue)); // Output: 78563412

    }
}
