package com.atguigu.java1;


public class AnnotationTest {
}
//jdk8之前的写法：
//@MyAnnotations(values = {@MyAnnotation(value = "hi"), @MyAnnotation(value = "hi")})
//可重复注解 一、在MyAnnotation上声明@Repeatable,成员值为MyAnnotations.class
//二、Mynnotation的Target和Retention和MyAnnotations，Inherited相同，我觉得修饰注解的注解都要相同
@MyAnnotation(value = "hi")
@MyAnnotation(value = "abc")
class Person{
    private String name;
    private int age;

    public Person(){

    }

    @MyAnnotation
    public Person(String name,int age){
        this.age = age;
        this.name = name;
    }
}
