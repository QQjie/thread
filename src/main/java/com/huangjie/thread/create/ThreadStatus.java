package com.huangjie.thread.create;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * @author huangjie
 * @version 1.0
 * @description
 * @date 2021/7/13 15:59
 */
public class ThreadStatus {

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            System.out.println("thread run status : "+Thread.currentThread().getState());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        System.out.println("before start status is : "+t1.getState());
        t1.start();
        t1.join();
        System.out.println("after start status is : "+t1.getState());

        Object o = new Object();




        //========================

        Thread t2 = new Thread(() -> {
            LockSupport.park();
            System.out.println("t2 go on ");
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        t2.start();
        TimeUnit.SECONDS.sleep(1);
        System.out.println(t2.getState());

        LockSupport.unpark(t2);
        TimeUnit.SECONDS.sleep(1);
        System.out.println(t2.getState());


        Thread t3 = new Thread(()->{
            synchronized(o){
                System.out.println("t3 get lock success");
                try {
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t3.start();
        TimeUnit.SECONDS.sleep(1);

        Thread t4 = new Thread(()->{
            synchronized(o){
                System.out.println("t4 get lock success "+Thread.currentThread().getState());
            }
        });
        t4.start();
        TimeUnit.SECONDS.sleep(1);
        System.out.println("t4 status is "+t4.getState());

        t4.interrupt();
    }
}
