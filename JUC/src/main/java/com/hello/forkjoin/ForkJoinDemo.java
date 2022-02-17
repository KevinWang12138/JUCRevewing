package com.hello.forkjoin;

import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * 求和计算的任务
 * 如何使用forkjoin
 * 1. forkjoinPool 通过它来执行
 * 2. 计算任务 forkjoinPool.execute(ForkJoinTask task)
 * 3. 计算类要继承RecursiveTask
 */
public class ForkJoinDemo extends RecursiveTask<Long> {
    private long start;
    private long end;

    private long temp=1000000L;

    public ForkJoinDemo(long start,long end){
        this.start=start;
        this.end=end;
    }

    @Override
    protected Long compute() {
        if((end-start)<temp){
            //分支合并计算
            long sum=0;
            for(long i=start;i<=end;i++){
                sum+=i;
            }
            return sum;
        }else{
            //forkjoin
            long mid=(end+start)/2;
            ForkJoinDemo task1=new ForkJoinDemo(start,mid);
            task1.fork();//拆分任务，把任务压入线程队列
            ForkJoinDemo task2=new ForkJoinDemo(mid+1,end);
            task2.fork();

            return task1.join()+task2.join();
        }
    }
}
