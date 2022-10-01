package day11.com.atguigu.java22;

import day11.com.atguigu.java2.Person;
import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * @ClassName FidleTest
 * @Descriptiron TODO
 * @Author wing2791
 * @Date 2022/10/1 9:44
 * @Version 1.0
 **/
public class FidleTest {
    @Test

    public void test1(){
        Class clazz = Person.class;
        //获取属性结构
        //getFields()：获取当前运行时类及其父类中声明为public访问权限的属性
        Field[] fields = clazz.getFields();
        for(Field f: fields){
            System.out.println(f);
        }
        System.out.println();


        //getDeclareFields():获取当前运行时类中声明的所有属性。（不包含弗雷中声明的属性）

        Field[] declareFields = clazz.getDeclaredFields();
        for(Field f:declareFields){
            System.out.println(f);
        }


    }

    @Test
    public void test2(){
        Class clazz = Person.class;
        Field[] declaredFields= clazz.getDeclaredFields();
        for(Field f:declaredFields){
            //权限修饰符,如果是默认的则不会输出内容，输出“空“
            int modifier = f.getModifiers();
            System.out.print(Modifier.toString(modifier)+"\t");


            //数据类型
            Class dataType = f.getType();
            System.out.print(dataType.getName()+"\t");

            //变量名
            String fName = f.getName();
            System.out.println(fName);
        }
    }
}
