package com.hello.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //怎么启动callable
        MyThread thread=new MyThread();
        //适配类
        FutureTask futureTask=new FutureTask(thread);
        FutureTask futureTask2=new FutureTask(thread);
        new Thread(futureTask,"A").start();
        new Thread(futureTask2,"B").start();
        //获取callable的返回值
        String ret=(String)futureTask.get();//这个方法可能产生阻塞，把他放在最后，或者使用异步通信
        System.out.println(ret);
    }

}
class MyThread implements Callable<String> {

    @Override
    public String call() throws Exception {
        System.out.println("call()");
        return "123456";
    }
}
