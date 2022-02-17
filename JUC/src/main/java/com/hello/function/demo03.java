package com.hello.function;

import com.hello.pc.C;

import java.util.function.Consumer;

public class demo03 {
    public static void main(String[] args) {
        Consumer consumer=new Consumer<String>() {
            @Override
            public void accept(String str) {
                System.out.println(str);
            }
        };
        consumer.accept("hello");
    }
}
