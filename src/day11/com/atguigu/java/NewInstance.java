package day11.com.atguigu.java;

import org.junit.Test;

import java.util.Random;
import java.util.Date;
/**
 * @ClassName NewInstance
 * @Descriptiron TODO
 * @Author wing2791
 * @Date 2022/9/30 20:57
 * @Version 1.0
 **/
public class NewInstance {
    @Test
    public void test1() throws InstantiationException, IllegalAccessException {
        Class<Person> clazz = Person.class;

//        要想此方法正常的创建运行时类的对象，要求：
//        1.运行时类必须提供空参的构造器
//        2.空参的构造器的访问权限要够，通常设置为public
//        在Javabean中要求提供一个public的空参构造器，原因：
//        1.便于通过反射创建运行时类的对象
//        2.便于子类继承此运行时类时，默认调用super()时，保证父类有此构造器

        Person obj = clazz.newInstance();
        System.out.println(obj);

    }

    @Test
    public void test2() throws Exception {
        int num = new Random().nextInt(3);//0 1 2
        num = 1;
        String classPath = "";
        switch (num){
            case 0:
                classPath = "java.util.Date";
                break;
            case 1:
                //没有空参构造器
//                classPath = "java.sql.Date";
                classPath = "java.lang.Object";

                break;

            case 2:
                classPath = "day11.com.atguigu.java.Person";
                break;

        }
        Object obj = getInstance(classPath);
        System.out.println(obj);
    }

    public Object getInstance(String classPath) throws Exception{
        Class clazz = Class.forName(classPath);
        return clazz.newInstance();
    }


}
