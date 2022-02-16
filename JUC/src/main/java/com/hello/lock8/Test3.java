package com.hello.lock8;

import java.util.concurrent.TimeUnit;

/**
 * static 静态方法，锁在静态方法上的锁，锁的是class，同类下的所有对象公用一把锁
 */
public class Test3 {
    public static void main(String[] args) {
        Phone3 phone=new Phone3();
        Phone3 phone2=new Phone3();
        new Thread(()->{
            phone.sendSms();
        },"A").start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(()->{
            phone2.call();
        },"B").start();
    }
}
class Phone3{
    public static synchronized void sendSms(){
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("发短信");
    }
    public static synchronized void call(){
        System.out.println("打电话");
    }
}