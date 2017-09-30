package com.kangyun.test.concurrent;

import com.kangyun.test.entity.LockMethodEntity;

import static com.kangyun.test.constant.Constants.MS;

public class LockMethod {
    public static void main(String[] args) {
        try {
            //test static method lock
            new Thread(LockMethodEntity::StaticA).start();
            new Thread(LockMethodEntity::StaticB).start();

            Thread.sleep(MS * 5);

            //test in the same entity
            LockMethodEntity entity = new LockMethodEntity();
            new Thread(entity::A).start();
            new Thread(entity::B).start();

            Thread.sleep(MS * 5);

            //test in different entity
            LockMethodEntity entity2 = new LockMethodEntity();
            new Thread(entity::A).start();
            new Thread(entity2::B).start();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
