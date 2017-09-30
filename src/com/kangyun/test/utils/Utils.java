package com.kangyun.test.utils;

public class Utils {
    /**
     * 判断是否是素数
     */
    public static boolean isPrime(int num) {
        if (num < 2) return false;
        for (int i = 2; i <= (int) Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}
