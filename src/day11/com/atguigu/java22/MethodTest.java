package day11.com.atguigu.java22;

import day11.com.atguigu.java2.Person;
import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * @ClassName MethodTest
 * @Descriptiron TODO
 * @Author wing2791
 * @Date 2022/10/1 10:04
 * @Version 1.0
 **/
public class MethodTest {
    @Test
    public void test1(){
        Class clazz = Person.class;
        //getMethods():获取当前运行时类及其所有父类中声明为public权限的方法
        Method[] methods = clazz.getMethods();
        for(Method m: methods){
            System.out.println(m);
        }
        System.out.println();

        //getDeclaredMethods：获取当前运行时类中声明的所有的方法。（不包含弗雷中声明的方法）
        Method[] declaredMethods = clazz.getDeclaredMethods();
        for(Method m: declaredMethods){
            System.out.println(m);
        }
        System.out.println();
    }

    @Test
    public void test2(){
        Class clazz = Person.class;
        Method[] declaredMethods = clazz.getDeclaredMethods();
        //获取方法声明的注解
        for(Method m: declaredMethods){
            Annotation[] annotations = m.getAnnotations();
            for(Annotation a:annotations){
                System.out.print(a+"\t");
            }

            //权限修饰符
            System.out.print(Modifier.toString(m.getModifiers())+"\t");

            //返回值类型
            System.out.print(m.getReturnType().getName()+"\t");

            //方法名
            System.out.print(m.getName());
            System.out.print("(");

            Class[] paramterTypes = m.getParameterTypes();
            if(paramterTypes!=null && paramterTypes.length!=0){
                for(int i = 0;i<paramterTypes.length;i++){
                    if(i == paramterTypes.length-1){
                        System.out.println(paramterTypes[i].getName()+"args_"+i);
                        break;
                    }
                    System.out.println(paramterTypes[i].getName()+"args_"+i+",");
                }
            }
            System.out.print(")");

            //抛出的异常
            Class[] exceptionTypes = m.getExceptionTypes();
            if(exceptionTypes!=null && exceptionTypes.length!=0){
                System.out.print("throws");
                for(int i = 0;i<exceptionTypes.length-1;i++){
                    if(i == exceptionTypes.length-1){
                        System.out.print(exceptionTypes[i].getName());
                        break;
                    }
                    System.out.print(exceptionTypes[i].getName()+",");
                }
            }

            System.out.println();
        }




    }
}
