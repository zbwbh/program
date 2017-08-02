package com.reflect.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)//注解作用在类的什么位置上，在反射的学习中知道了field是域，表示字段
@Retention(RetentionPolicy.RUNTIME)//注解在什么状态下被保留，这里写的是运行时，也就是会被加入到JVM中
@Documented//这个代表会根据javadoc生成在文档里面
public @interface FruitName {

    String value() default "";//这里的default应该是默认值的意思，网上的答案让人心寒，
    //如果default作为修饰符，那么是java1.8新引进的一个用法，具体细节还没看
}
