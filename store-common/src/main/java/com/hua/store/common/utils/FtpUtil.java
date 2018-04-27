package com.hua.store.common.utils;

import org.apache.commons.net.ftp.FTPClient;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class FtpUtil {
    private static final String HOST_NAME = "10.0.0.100";
    private static final String USER_NAME = "ftpadmin";
    private static final String PASSWORD = "ftpadmin";
    private static final String WORKING_DIR = "/home/ftpadmin/www/images";
    private static final int PORT = 21;

    public static void upload(String fileName, InputStream inputStream) throws IOException {

        FTPClient ftpClient = new FTPClient();
        ftpClient.connect(HOST_NAME, PORT);
        ftpClient.login(USER_NAME, PASSWORD);
        System.out.println("Status: " + ftpClient.getStatus());
        ftpClient.changeWorkingDirectory(WORKING_DIR);
        System.out.println(ftpClient.getReplyString());
        ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);

        ftpClient.storeFile(fileName, inputStream);

        // Set permission, otherwise can't not access from url
        ftpClient.sendSiteCommand("chmod 744 " + fileName);
        System.out.println(ftpClient.getReplyString());
        ftpClient.logout();
        ftpClient.disconnect();
    }
}
