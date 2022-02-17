package com.hello.bq;

import com.hello.pc.A;

import java.util.Collections;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

public class test {
    public static void main(String[] args) throws InterruptedException {
        //抛出异常
        //test1();
        //有返回值
        //test2();
        //一直等待
        //test3();
        //超时等待
        test4();
    }
    /**
     * 抛出异常
     */
    public static void test1(){
        ArrayBlockingQueue blockingQueue=new ArrayBlockingQueue<>(3);
        System.out.println(blockingQueue.add("1"));
        System.out.println(blockingQueue.add("2"));
        System.out.println(blockingQueue.add("3"));

        //抛出异常，队列已满
        //System.out.println(blockingQueue.add("4"));

        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());

        //抛出异常，队列为空java.util.NoSuchElementException
        //System.out.println(blockingQueue.remove());

        //抛出异常，队首为空java.util.NoSuchElementException
        System.out.println(blockingQueue.element());
    }

    public static void test2(){
        ArrayBlockingQueue blockingQueue=new ArrayBlockingQueue<>(3);
        System.out.println(blockingQueue.offer("a"));
        System.out.println(blockingQueue.offer("b"));
        System.out.println(blockingQueue.offer("c"));

        //System.out.println(blockingQueue.offer("d"));

        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());

        System.out.println(blockingQueue.peek());
    }

    public static void test3() throws InterruptedException {
        ArrayBlockingQueue blockingQueue=new ArrayBlockingQueue<>(3);
        blockingQueue.put("a");
        blockingQueue.put("b");
        blockingQueue.put("c");


        System.out.println(blockingQueue.take());
        System.out.println(blockingQueue.take());
        System.out.println(blockingQueue.take());
        System.out.println("开始等待...");
        //blockingQueue.put("d");

        //System.out.println(blockingQueue.take());

        System.out.println("等待结束...");
    }

    public static void test4() throws InterruptedException {
        ArrayBlockingQueue blockingQueue=new ArrayBlockingQueue<>(3);
        System.out.println(blockingQueue.offer("a"));
        System.out.println(blockingQueue.offer("b"));
        System.out.println(blockingQueue.offer("c"));
        //System.out.println(blockingQueue.offer("d",2, TimeUnit.SECONDS));

        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll(2,TimeUnit.SECONDS));
    }

}
