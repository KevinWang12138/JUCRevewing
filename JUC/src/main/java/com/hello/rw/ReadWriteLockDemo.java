package com.hello.rw;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockDemo {
    public static void main(String[] args) {
        MyCacheLock myCache=new MyCacheLock();
        //写入
        for(int i=0;i<5;i++){
            final int temp=i;
            new Thread(()->{
                myCache.put(temp+"",temp+"");
            },String.valueOf(i)).start();
        }
        //读取
        for(int i=0;i<5;i++){
            final int temp=i;
            new Thread(()->{
                myCache.get(temp+"");
            },String.valueOf(i)).start();
        }
    }
}

/**
 * 自定义缓存
 */
class MyCache{
    private volatile Map<String,Object> map=new HashMap<>();
    //存
    public void put(String key,Object value){
        System.out.println(Thread.currentThread().getName()+"写入"+key);
        map.put(key,value);
        System.out.println(Thread.currentThread().getName()+"写入完成");
    }
    //取
    public void get(String key){
        System.out.println(Thread.currentThread().getName()+"读取"+key);
        Object o=map.get(key);
        System.out.println(Thread.currentThread().getName()+"写入完成");
    }
}

class MyCacheLock{
    private volatile Map<String,Object> map=new HashMap<>();
    //读写锁，更加细粒度的控制
    private ReadWriteLock readWriteLock=new ReentrantReadWriteLock();
    //存
    public void put(String key,Object value){
        readWriteLock.writeLock().lock();
        System.out.println(Thread.currentThread().getName()+"写入"+key);
        map.put(key,value);
        System.out.println(Thread.currentThread().getName()+"写入完成");
        readWriteLock.writeLock().unlock();
    }
    //取
    public void get(String key){
        readWriteLock.readLock().lock();
        System.out.println(Thread.currentThread().getName()+"读取"+key);
        Object o=map.get(key);
        System.out.println(Thread.currentThread().getName()+"读取完成");
        readWriteLock.readLock().unlock();
    }
}