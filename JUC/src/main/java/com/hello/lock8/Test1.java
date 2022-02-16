package com.hello.lock8;

import java.util.concurrent.TimeUnit;

/**
 * 8锁问题就是关于锁的八个问题
 * 1. 标准情况下，两个线程先发短信还是先打电话？
 * 2. 发短信的线程睡眠4秒，两个线程先发短信还是先打电话？
 */
public class Test1 {
    public static void main(String[] args) {
        Phone phone=new Phone();
        new Thread(()->{
            phone.sendSms();
        },"A").start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(()->{
            phone.call();
        },"B").start();
    }
}

class Phone{
    /**
     * synchronized虽然写在了方法上，但是锁的对象是方法的调用者
     * 谁先拿到锁谁就先执行
     */
    public synchronized void sendSms(){
        System.out.println("发短信");
    }
    public synchronized void call(){
        System.out.println("打电话");
    }
}
