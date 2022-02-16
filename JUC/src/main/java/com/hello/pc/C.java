package com.hello.pc;

import com.sun.xml.internal.ws.developer.HttpConfigFeature;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class C {
    public static void main(String[] args) {
        Data3 data=new Data3();
        new Thread(()->{
            for(int i=0;i<10;i++){
                data.printA();
            }
        },"1").start();
        new Thread(()->{
            for(int i=0;i<10;i++){
                data.printB();
            }
        },"2").start();
        new Thread(()->{
            for(int i=0;i<10;i++){
                data.printC();
            }
        },"3").start();
    }
}
class Data3{
    //资源类
    private Lock lock=new ReentrantLock();
    private Condition condition1=lock.newCondition();
    private Condition condition2=lock.newCondition();
    private Condition condition3=lock.newCondition();
    private int number=1;


    public void printA(){
        lock.lock();
        try{
            //业务，判断->执行->通知
            while(number!=1){
                condition1.await();
            }
            System.out.println(Thread.currentThread().getName()+"AAAA");
            number=2;
            condition2.signal();
        }catch (Exception e){

        }finally {
            lock.unlock();
        }
    }
    public void printB(){
        lock.lock();
        try{
            //业务，判断->执行->通知
            while(number!=2){
                condition2.await();
            }
            System.out.println(Thread.currentThread().getName()+"BBBB");
            number=3;
            condition3.signal();
        }catch (Exception e){

        }finally {
            lock.unlock();
        }
    }
    public void printC(){
        lock.lock();
        try{
            //业务，判断->执行->通知
            while(number!=3){
                condition3.await();
            }
            System.out.println(Thread.currentThread().getName()+"CCCC");
            number=1;
            condition1.signal();
        }catch (Exception e){

        }finally {
            lock.unlock();
        }
    }
}