package com.huangjie.thread.create;

import java.util.concurrent.*;

/**
 * @author huangjie
 * @version 1.0
 * @description
 * @date 2021/7/13 15:26
 */
public class TreadCreate {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //第一种 直接继承Thread类 然后调用start方法
        Thread1 thread1 = new Thread1();
        thread1.start();

        //实现Runnable接口 用Thread调度
        Thread thread = new Thread(new RunClass());
        thread.start();

        //实现CallAble接口 配合FutureTask和Thread一起使用
        FutureTask<String> stringFutureTask = new FutureTask<String>(new CallClass());
        Thread thread2 = new Thread(stringFutureTask);
        thread2.start();
        String s = null;
        try {
            s = stringFutureTask.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("future task result is :"+s);

        //使用线程池
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        Future<String> submit = executorService.submit(new CallClass());
        String s1 = submit.get();
        System.out.println(s1);
        executorService.shutdown();

        //lamda
        new Thread(()->{
            System.out.println(11111);
        }).start();
    }

    public static class Thread1 extends Thread{
        @Override
        public void run() {
            System.out.println("thread start ... ");
        }
    }

    public static class RunClass implements Runnable{

        @Override
        public void run() {
            System.out.println("runable start ... ");
        }
    }

    public static class CallClass implements Callable<String>{

        @Override
        public String call() throws Exception {
            System.out.println("callable start ...");
            return "ssssss";
        }
    }
}
