package com.kangyun.test.concurrent;

import com.kangyun.test.utils.Utils;

/**
 * 在线程A中打印1~100的素数，线程B中打印非素数
 */
public class PrintPrime {
    private static int count = 1;
    private static final Object lock = new Object();

    public static void main(String[] args) {
        Thread a = new Thread(() -> {
            while (check(count)) {
                synchronized (lock) {
                    if (!Utils.isPrime(count)) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } else {
                        System.out.println(Thread.currentThread().getName() + " : " + count);
                        count++;
                        lock.notify();
                    }
                }
            }
        }, "A");
        Thread b = new Thread(() -> {
            while (check(count)) {
                synchronized (lock) {
                    if (Utils.isPrime(count)) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } else {
                        System.out.println(Thread.currentThread().getName() + " : " + count);
                        count++;
                        lock.notify();
                    }
                }
            }
        }, "B");

        b.start();
        a.start();
    }

    private static boolean check(int num) {
        return num <= 100;
    }
}
