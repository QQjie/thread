package com.huangjie.thread.create;

import java.util.concurrent.TimeUnit;

/**
 * @author huangjie
 * @version 1.0
 * @description
 * @date 2021/7/13 17:20
 */
public class StopThread {
    public static void main(String[] args) throws InterruptedException {
        Thread t1=new Thread(()->{
            while(true){
                System.out.println("go on ...");
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t1.start();
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t1.stop();
    }
}
