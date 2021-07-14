package com.huangjie.thread.create;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author huangjie
 * @version 1.0
 * @description
 * @date 2021/7/13 16:20
 */
public class TreadInterrupt {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            for (; ; ) {
                System.out.println("Thread start ");
                if (Thread.currentThread().isInterrupted()) {
                    System.out.println("Thread is interrupted");
                    System.out.println(Thread.currentThread().isInterrupted());
                }
            }
        });
        thread.start();

        TimeUnit.SECONDS.sleep(5);

        thread.interrupt();


        Thread t2 = new Thread(() -> {
            try {
                System.out.println("t2 start ... ");
                TimeUnit.SECONDS.sleep(10);
                System.out.println("t2 end ... ");
            } catch (InterruptedException e) {
                System.out.println("t2 is interrupted ...");
                //自动恢复标志位
                System.out.println(Thread.currentThread().isInterrupted());
            }
        });

        t2.start();
        System.out.println("interrupt  start ... ");
        TimeUnit.SECONDS.sleep(5);
        System.out.println("interrupt  end ... ");

        //sleep 和 wait可通过设置标志位 让线程抛出异常 打断线程
        t2.interrupt();

    }



}
