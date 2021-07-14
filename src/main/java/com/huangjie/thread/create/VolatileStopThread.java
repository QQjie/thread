package com.huangjie.thread.create;

import java.util.concurrent.TimeUnit;

/**
 * @author huangjie
 * @version 1.0
 * @description
 * @date 2021/7/13 17:29
 */
public class VolatileStopThread {
    private static volatile boolean flag = true;
    public static void main(String[] args) throws InterruptedException {
        Thread t1=new Thread(()->{
            while (flag){
                System.out.println("go on ");
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t1.start();
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        flag = false;
    }
}
