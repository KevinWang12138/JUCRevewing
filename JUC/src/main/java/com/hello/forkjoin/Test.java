package com.hello.forkjoin;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;

public class Test {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        test1();
        test2();
    }
    public static void test1(){
        long start=System.currentTimeMillis();
        long sum=0;
        for(long i=1;i<1000000000;i++){
            sum+=i;
        }
        long end=System.currentTimeMillis();
        System.out.println("sum="+"时间"+(end-start));
    }
    public static void test2() throws ExecutionException, InterruptedException {
        long start=System.currentTimeMillis();
        ForkJoinPool forkJoinPool=new ForkJoinPool();
        ForkJoinTask task=new ForkJoinDemo(0,1000000000);
        ForkJoinTask submit=forkJoinPool.submit(task);
        Long sum= (Long) submit.get();
        long end=System.currentTimeMillis();
        System.out.println("sum="+"时间"+(end-start));
    }
    public static void test3(){
        long start=System.currentTimeMillis();
        long end=System.currentTimeMillis();
        System.out.println("sum="+"时间"+(end-start));
    }

}
