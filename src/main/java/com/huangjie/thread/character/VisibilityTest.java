package com.huangjie.thread.character;

import java.util.concurrent.TimeUnit;

/**
 * @author huangjie
 * @version 1.0
 * @description
 * @date 2021/7/13 17:51
 */
public class VisibilityTest {
    /**
     * volatile 保证可见性
     */
    private static volatile boolean flag = true;

    private static void m(){
        System.out.println("m method start ... ");
        while (flag){
            //此处不能加sout或者log否则操作系统会有优化
        }
        System.out.println("m method end ... ");
    }

    public static void main(String[] args) {
        Thread t1=new Thread(()->{
            m();
        });
        t1.start();
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        flag = false;

    }
}
