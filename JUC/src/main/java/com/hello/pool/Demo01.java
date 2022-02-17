package com.hello.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//Executors 工具类 三大方法
//使用线程池之后要使用线程池创建线程
public class Demo01 {
    public static void main(String[] args) {
        ExecutorService threadPool=Executors.newSingleThreadExecutor();//单个线程
        //ExecutorService threadPool=Executors.newFixedThreadPool(5);//创建一个固定的线程池大小
        //ExecutorService threadPool=Executors.newCachedThreadPool();//可伸缩的，遇强则强，遇弱则弱

        try{
            for(int i=0;i<10;i++){
                threadPool.execute(()->{
                    System.out.println(Thread.currentThread().getName()+"ok");
                });
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //程序结束后关闭线程池
            threadPool.shutdown();
        }

    }
}
