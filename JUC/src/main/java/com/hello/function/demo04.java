package com.hello.function;

import java.util.function.Supplier;

public class demo04 {
    public static void main(String[] args) {
        Supplier supplier=new Supplier<Integer>() {
            @Override
            public Integer get() {
                return 1000;
            }
        };
        Supplier supplier1=()->{return 1000;};
        System.out.println(supplier1.get());
    }

}
