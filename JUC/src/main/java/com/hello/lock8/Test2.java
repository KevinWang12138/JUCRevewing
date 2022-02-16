package com.hello.lock8;

import java.util.concurrent.TimeUnit;

/**
 * 3. 增加了一个普通方法hello，先执行发短信还是hello?
 *  普通方法hello不受锁的影响
 * 4. 两个对象，两个synchronized方法，两者互不影响，因为synchronized锁的是调用方法的对象，两个实体对象就是两把锁
 */
public class Test2 {

    public static void main(String[] args) {
        Phone2 phone=new Phone2();
        Phone2 phone2=new Phone2();
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
class Phone2{
    public synchronized void sendSms(){
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
    public void hello(){
        System.out.println("hello");
    }
}
