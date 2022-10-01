package day11.com.atguigu.java22;

import com.sun.media.jfxmediaimpl.HostUtils;
import day11.com.atguigu.java2.Person;
import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @ClassName OtherTest
 * @Descriptiron TODO
 * @Author wing2791
 * @Date 2022/10/1 11:12
 * @Version 1.0
 **/
public class OtherTest {
    @Test
    public void test1(){
        Class clazz = Person.class;
        Constructor[] constructors = clazz.getConstructors();
        for(Constructor c:constructors){
            System.out.print(c);
        }
        System.out.println();

        Constructor[] declaredConstructors = clazz.getDeclaredConstructors();
        for(Constructor declaredConstructor:declaredConstructors){
            System.out.println(declaredConstructor);
        }


    }
    @Test
    public void test2(){
        Class clazz = Person.class;
        Class superclass = clazz.getSuperclass();
        System.out.println(superclass);

    }

    //获取运行时类的带泛型的父类
    @Test
    public void test3(){
        Class clazz  = Person.class;
        Type genericSuperclass = clazz.getGenericSuperclass();
        System.out.println(genericSuperclass);
    }

    @Test
    public void test4(){
        Class clazz = Person.class;

        Type genericSuperclass = clazz.getGenericSuperclass();
        ParameterizedType paramType = (ParameterizedType) genericSuperclass;
        Type[] actualTypeArguments = paramType.getActualTypeArguments();
        System.out.println(actualTypeArguments[0]);
        System.out.println(actualTypeArguments[0].getTypeName());
        System.out.println(((Class)actualTypeArguments[0]).getName());
    }

    @Test
    public void test5(){
        Class clazz = Person.class;

        //获取运行时类接口
        Class[] interfaces = clazz.getInterfaces();
        for(Class c:interfaces){
            System.out.print(c);
        }
        System.out.println();

        //获取运行时类的父类的接口
        Class[] interface1 = clazz.getSuperclass().getInterfaces();
        for(Class c : interface1){
            System.out.print(c);
        }
    }

    @Test
    //获取运行时类所在的包
    public void test6(){
        Class clazz = Person.class;
        Package pack = clazz.getPackage();
        System.out.println(pack);
    }

    @Test

    //获取运行时类的注解
    public void test7(){
        Class clazz = Person.class;
        Annotation[] ann = clazz.getAnnotations();
        for(Annotation a:ann){
            System.out.print(a);
        }
    }




}
