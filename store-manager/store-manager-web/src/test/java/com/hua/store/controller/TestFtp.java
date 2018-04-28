package com.hua.store.controller;


import com.github.pagehelper.PageInterceptor;
import com.hua.store.common.utils.FtpUtil;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

public class TestFtp {

    private static final String HOST_NAME = "10.0.0.100";
    private static final String USER_NAME = "ftpadmin";
    private static final String PASSWORD = "ftpadmin";
    private static final String WORKING_DIR = "/home/ftpadmin/www/images";
    private static final String BASE_PATH = "/home/ftpadmin/www/";
    private static final String FILE_PATH = "images";
    private static final String FILE_NAME = "java.jpg";

    private static final int PORT = 21;

    @Test
    public void testFtpClient() throws IOException {

        // create a ftp client object
        FTPClient ftpClient = new FTPClient();
        ftpClient.connect(HOST_NAME, PORT);
        ftpClient.login(USER_NAME, PASSWORD);

        System.out.println("Status: " + ftpClient.getStatus());
        ftpClient.changeWorkingDirectory(WORKING_DIR);
        System.out.println(ftpClient.getReplyString());
        ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);

        ftpClient.storeFile(FILE_NAME,  getClass().getClassLoader().getResourceAsStream("java.jpg"));
        ftpClient.logout();
        ftpClient.disconnect();
    }

    @Test
    public void testFtpUpload() throws IOException {
        FtpUtil.upload(FILE_NAME, getClass().getClassLoader().getResourceAsStream("java.jpg"));
    }

    @Test
    public void testFtpUpload1l() throws IOException {
        FtpUtil.upload(HOST_NAME, PORT, USER_NAME, PASSWORD, BASE_PATH, FILE_PATH, FILE_NAME, getClass().getClassLoader().getResourceAsStream("java.jpg"));
    }

    @Test
    public void testFtpUpload12() throws IOException {
        FtpUtil.upload(HOST_NAME, PORT, USER_NAME, PASSWORD, BASE_PATH, FILE_PATH, "mango.jpg", getClass().getClassLoader().getResourceAsStream("mango.jpg"));
    }
}

