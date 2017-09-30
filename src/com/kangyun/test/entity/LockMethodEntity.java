package com.kangyun.test.entity;

import static com.kangyun.test.constant.Constants.MS;

public class LockMethodEntity {

    public synchronized static void StaticA() {
        try {
            System.out.println("Method StaticA sleep");
            Thread.sleep(MS * 3);
            System.out.println("Method StaticA awake");
        } catch (InterruptedException e) {
            System.out.println("Error occurs at method StaticA");
        }
    }

    public synchronized static void StaticB() {
        System.out.println("Method StaticB is working!");
    }

    public synchronized void A() {
        try {
            System.out.println("Method A sleep");
            Thread.sleep(MS * 3);
            System.out.println("Method A awake");
        } catch (InterruptedException e) {
            System.out.println("Error occurs at method A");
        }
    }

    public synchronized void B() {
        System.out.println("Method B is working!");
    }
}
