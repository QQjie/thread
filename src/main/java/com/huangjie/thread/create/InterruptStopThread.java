package com.huangjie.thread.create;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

/**
 * @author huangjie
 * @version 1.0
 * @description
 * @date 2021/7/13 17:39
 */
public class InterruptStopThread {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            while (!Thread.interrupted()) {
                try {
                    System.out.println("go on ...");
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    break;
                }
            }
        });

        t1.start();

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        t1.interrupt();

    }
}
