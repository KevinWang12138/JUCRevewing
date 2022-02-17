package com.hello.pool;

import java.util.concurrent.*;

public class Demo02 {
    public static void main(String[] args) {
        ExecutorService threadPool=new ThreadPoolExecutor(2,
                5,
                5,
                TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.DiscardOldestPolicy());
        try{
            for(int i=0;i<100;i++){
                threadPool.execute(()->{
                    System.out.println(Thread.currentThread().getName()+" ok");
                });
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            threadPool.shutdown();
        }
    }
}
