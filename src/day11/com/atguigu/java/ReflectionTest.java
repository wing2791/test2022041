package day11.com.atguigu.java;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionTest {


    @Test
    public void test1(){
        //1.创建Person类的对象
        Person p1 = new Person("Tom",12);

        //2.通过对象，调用其内部的属性、方法
        p1.age = 10;
        System.out.println(p1.toString());

        p1.show();

        //在Person类外部，不可以通过Person类的对象调用其内部私有结构
//        比如：name、showNation()以及私有的构造器



    }

    @Test
    public void test2() throws Exception{
        Class clazz = Person.class;
        //通过反射，创建Person类的对象
        Constructor cons = clazz.getConstructor(String.class,int.class);

        Object obj = cons.newInstance("Tom",12);
        Person p = (Person)obj;
        System.out.println(obj.toString());
        //2.通过反射，调用对象指定的属性和方法
        //调用属性
        Field age = clazz.getDeclaredField("age");
        //p对象的age属性变成10
        age.set(p,10);
        System.out.println(p.toString());

        Method show =  clazz.getDeclaredMethod("show");
        show.invoke(p);

        System.out.println("=====================================");

        //通过反射，可以调用Person类的私有结构，比如：私有的构造器，方法、属性
        //调用私有的构造器
        Constructor cons1 = clazz.getDeclaredConstructor(String.class);
        cons1.setAccessible(true);
        Person p1 = (Person) cons1.newInstance("Jerry");
        System.out.println(p1);

        //调用私有的属性
        Field name = clazz.getDeclaredField("name");
        name.setAccessible(true);
        name.set(p1,"HanMeimei");
        System.out.println(p1);

        //调用私有的方法
        Method showNation = clazz.getDeclaredMethod("showNation", String.class);
        showNation.setAccessible(true);
        String nation = (String) showNation.invoke(p1, "中国");//invoke是调用，相当于p1.showNation("中国")
        System.out.println(nation);

    }

    //疑问：通过直接new的方式或反射的方式都可以调用公共的结构，开发中到底用那个
//    建议：直接new的方式
//    什么时候用反射：需要使用的是时候再用 反射的特征：动态性
    //疑问：反射机制与面向对象中的封装行是不是矛盾，如何看待两个技术
//不矛盾，封装是建议你不要调用，反射是可以动态的进行使用类

//    关于java.lang.Class类的理解
//    1.类的加载过程
//    程序经过javac.exe命令以后，会生成一个或多个字节码文件(.class结尾)，接着
//    我们使用java.exe命令对某个字节码文件进行解释运行。相当于将某个字节码文件加载到内存中
//    此过程成为类的加载。加载到内存中的类，我们就成为运行时类，此运行时类，
//    就作为Class的一个实例。
//    2.换句话说，Class的实例就对应着一个运行时类。
        public void test3(){
            //方式一：调用运行时类的属性：.class
            Class clazz1 = Person.class;
            System.out.println(clazz1);
        }

}
