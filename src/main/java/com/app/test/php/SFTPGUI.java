package com.app.test.php;

import com.jcraft.jsch.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class SFTPGUI extends JFrame {
    // SFTP server details
    private static final String SFTP_HOST = "remotehost.example.com";
    private static final int SFTP_PORT = 22;
    private static final String SFTP_USER = "your_username";
    private static final String SFTP_PASSWORD = "your_password";

    // GUI components
    private JTextField localFilePathField;
    private JTextField remoteFilePathField;
    private JButton uploadButton;
    private JButton downloadButton;
    private JLabel statusLabel;

    public SFTPGUI() {
        // Initialize the GUI components
        localFilePathField = new JTextField(30);
        remoteFilePathField = new JTextField(30);
        uploadButton = new JButton("Upload");
        downloadButton = new JButton("Download");
        statusLabel = new JLabel("Status: ");

        // Set the layout and add components
        setLayout(new FlowLayout());
        add(new JLabel("Local File Path:"));
        add(localFilePathField);
        add(new JLabel("Remote File Path:"));
        add(remoteFilePathField);
        add(uploadButton);
        add(downloadButton);
        add(statusLabel);

        // Add action listeners for buttons
        uploadButton.addActionListener(new UploadAction());
        downloadButton.addActionListener(new DownloadAction());

        // Set the frame properties
        setTitle("SFTP File Transfer");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    // Action listener for the upload button
    private class UploadAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String localFilePath = localFilePathField.getText().trim();
            String remoteFilePath = remoteFilePathField.getText().trim();

            try {
                uploadFile(localFilePath, remoteFilePath);
                statusLabel.setText("Status: Upload successful");
            } catch (Exception ex) {
                statusLabel.setText("Status: Upload failed - " + ex.getMessage());
            }
        }
    }

    // Action listener for the download button
    private class DownloadAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String localFilePath = localFilePathField.getText().trim();
            String remoteFilePath = remoteFilePathField.getText().trim();

            try {
                downloadFile(remoteFilePath, localFilePath);
                statusLabel.setText("Status: Download successful");
            } catch (Exception ex) {
                statusLabel.setText("Status: Download failed - " + ex.getMessage());
            }
        }
    }

    // Method to upload a file using SFTP
    private void uploadFile(String localFilePath, String remoteFilePath) throws JSchException, SftpException, IOException {
        // Create an instance of JSch
        JSch jsch = new JSch();
        // Set up the session
        Session session = jsch.getSession(SFTP_USER, SFTP_HOST, SFTP_PORT);
        session.setPassword(SFTP_PASSWORD);

        // Configure session
        Properties config = new Properties();
        config.put("StrictHostKeyChecking", "no");
        session.setConfig(config);
        session.connect();

        // Open an SFTP channel
        Channel channel = session.openChannel("sftp");
        channel.connect();
        ChannelSftp sftpChannel = (ChannelSftp) channel;

        // Upload the file
        try (FileInputStream fis = new FileInputStream(localFilePath)) {
            sftpChannel.put(fis, remoteFilePath);
        }

        // Close the channel and session
        sftpChannel.exit();
        session.disconnect();
    }

    // Method to download a file using SFTP
    private void downloadFile(String remoteFilePath, String localFilePath) throws JSchException, SftpException, IOException {
        // Create an instance of JSch
        JSch jsch = new JSch();
        // Set up the session
        Session session = jsch.getSession(SFTP_USER, SFTP_HOST, SFTP_PORT);
        session.setPassword(SFTP_PASSWORD);

        // Configure session
        Properties config = new Properties();
        config.put("StrictHostKeyChecking", "no");
        session.setConfig(config);
        session.connect();

        // Open an SFTP channel
        Channel channel = session.openChannel("sftp");
        channel.connect();
        ChannelSftp sftpChannel = (ChannelSftp) channel;

        // Download the file
        try (FileOutputStream fos = new FileOutputStream(localFilePath)) {
            sftpChannel.get(remoteFilePath, fos);
        }

        // Close the channel and session
        sftpChannel.exit();
        session.disconnect();
    }

    public static void main(String[] args) {
        // Run the GUI
        SwingUtilities.invokeLater(SFTPGUI::new);
    }
}

