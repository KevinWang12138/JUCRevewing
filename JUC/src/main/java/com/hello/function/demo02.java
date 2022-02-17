package com.hello.function;

import java.util.function.Predicate;

public class demo02 {
    public static void main(String[] args) {
        Predicate predicate=new Predicate<String>() {
            @Override
            public boolean test(String str) {
                return str.isEmpty();
            }
        };
        System.out.println(predicate.test(""));
    }
}
