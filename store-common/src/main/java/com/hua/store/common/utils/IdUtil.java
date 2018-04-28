package com.hua.store.common.utils;

import java.util.Random;

public class IdUtil {

    public static String genImageName() {
        long millis = System.currentTimeMillis();
        Random random = new Random();
        int end3 = random.nextInt(999);
        return millis + String.format("%03d", end3);
    }

    public static long genItemId() {
        long millis = System.currentTimeMillis();
        Random random = new Random();
        int end2 = random.nextInt(99);
        return  new Long(millis + String.format("%02d", end2));
    }
}
