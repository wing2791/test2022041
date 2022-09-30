package com.atguigu.java1;


import java.lang.annotation.*;

//注解声明为@interface
    //内部定义成员，通常使用value表示
    //可以指定成员的默认值，使用default定义 default "hello"
    //如果自定义注解没有成员，表明是一个标识作用
    //如果注解有成员，在使用注解时，需要指明成员的值
//自定义注解必须配上注释的信息处理流程（使用反射）才有意义
//一般自定义注解都会指明：Retention和Target
//元注解
//对现有注解进行修饰的注解
//Retention：SOURCE->修饰的注解不会被编译 CLASS->默认值 修饰的注解会被编译，但不会加载到内存中 RUNTIME->修饰的注解会被 编译，会加载到内存中
//只有声明为RUNTIME生命周期的注解，才能通过反射获取
//Target
//用于修饰Annotation定义，用于指定被修饰的Annotation能用于修饰哪些程序元素
//@Target也包含一个名为value的成员变量
//Documented：表示所修饰的注解被javadoc修饰时，保留下来
//用于指定被该元Annotation修饰的Annotation类将被javadoc工具提取成文档。默认情况下，javadoc是不包括注解的
//定义为Documented的注解必须设置Retention值为RUNTIME
//Inherited
//被它修饰的Annotation将具有继承性。如果某个类使用了被@Inherited修饰的Annotation，则其子类将自动具有该注解
//jdk8 可重复注解
@Inherited
@Repeatable(value = MyAnnotations.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE,ElementType.FIELD,ElementType.METHOD,ElementType.PARAMETER, ElementType.CONSTRUCTOR,ElementType.LOCAL_VARIABLE})
public @interface MyAnnotation {

    String value() default "hello";
}
