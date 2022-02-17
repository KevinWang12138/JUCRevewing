package com.hello.function;

import java.util.function.Function;

/**
 * Function函数式接口，有一个输入参数，有一个输出
 * 只要是函数接口，就可以用lambda表达式简化
 */
public class demo01 {
    public static void main(String[] args) {
        Function function=new Function<String,String>(){
            @Override
            public String apply(String str) {
                return str;
            }
        };



        System.out.println(function.apply("asd"));
    }
}
