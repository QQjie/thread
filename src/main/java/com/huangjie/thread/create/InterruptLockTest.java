package com.huangjie.thread.create;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author huangjie
 * @version 1.0
 * @description
 * @date 2021/7/13 16:54
 */
public class InterruptLockTest {
    public static void main(String[] args) throws InterruptedException {

       /* Object o = new Object();
        Thread t1=new Thread(()->{
            synchronized (o){
                try {
                    System.out.println("t1 start ...");
                    TimeUnit.SECONDS.sleep(10);
                    System.out.println("t1 end ...");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t1.start();
        Thread t2=new Thread(()->{
            synchronized (o){
                try {
                    System.out.println("t2 start ...");
                    TimeUnit.SECONDS.sleep(5);
                    System.out.println("t2 end ...");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t2.start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //此处是不可以通过interrupt进行打断的
        System.out.println("t2 interrupt start...");
        t2.interrupt();
        System.out.println("t2 interrupt end...");*/


        ReentrantLock lock = new ReentrantLock();
        Thread t1=new Thread(()->{
                lock.lock();
                try {
                    System.out.println("t1 start ...");
                    TimeUnit.SECONDS.sleep(10);
                    System.out.println("t1 end ...");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    lock.unlock();
                }
        });
        t1.start();
        Thread t2=new Thread(()->{
            lock.lock();
                try {
                    System.out.println("t2 start ...");
                    TimeUnit.SECONDS.sleep(5);
                    System.out.println("t2 end ...");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    lock.unlock();
                }
        });
        t2.start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //此处是不可以通过interrupt进行打断的
        System.out.println("t2 interrupt start...");
        t2.interrupt();
        System.out.println("t2 interrupt end...");

    }
}
