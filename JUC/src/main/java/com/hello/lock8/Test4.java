package com.hello.lock8;

import java.util.concurrent.TimeUnit;

/**
 * 同一个类下的普通同步方法和静态同步方法，只有一个对象。
 * 两个方法是两把锁，一个锁在实体对象上，一个锁在类模板上
 */
public class Test4 {
    public static void main(String[] args) {
        Phone4 phone=new Phone4();
        Phone4 phone2=new Phone4();
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
class Phone4{
    public static synchronized void sendSms(){
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("发短信");
    }
    public synchronized void call(){
        System.out.println("打电话");
    }
}