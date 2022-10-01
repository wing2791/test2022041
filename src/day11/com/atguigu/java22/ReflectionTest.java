package day11.com.atguigu.java22;

import day11.com.atguigu.java2.Person;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @ClassName ReflectionTest
 * @Descriptiron TODO
 * @Author wing2791
 * @Date 2022/10/1 11:50
 * @Version 1.0
 **/
public class ReflectionTest {

    @Test
    public void testField() throws InstantiationException, IllegalAccessException, NoSuchFieldException {
        Class clazz = Person.class;

        //创建运行时类的对象
        Person p = (Person)clazz.newInstance();

        //获取指定的属性,要求运行时类中属性声明为public
        Field id = clazz.getField("id");

        //设置当前属性
        //set()：参数1：指明设置那个对象的属性 参数2：将次属性值设置为多少

        id.set(p,1001);

        /*
        获取当前属性的值
        get():参数1：获取哪个对象的当前属性值
        * */
        int pId = (int)id.get(p);
        System.out.println(pId);


    }

    @Test
    public void testField1() throws Exception{
        Class clazz = Person.class;

        Person p = (Person)clazz.newInstance();
        //获取运行时类中指定变量名的属性
        Field name = clazz.getDeclaredField("id");

        //保证当前属性是可访问的
        name.setAccessible(true);

        //指定对象的属性值
        name.set(p,"Tom");
        System.out.println(name.get(p));

    }

    //操作运行时类中的指定的方法
    @Test
    public void testMethod() throws Exception {
        Class clazz = Person.class;
        Person p = (Person)clazz.newInstance();

        //获取指定的某个方法
        //getDeclaredMethod():参数1：指明获取的方法的名称
        //参数2：指明获取的方法的形参列表类型
        Method show = clazz.getDeclaredMethod("show",String.class);
        //保证当前方法是可访问的
        show.setAccessible(true);

        //调用方法的invoke()：参数1：方法的调用者，参数2：给方法形参赋值的实参
        //invoke()的返回值即为对应类中调用方法的返回值
        Object returnValue = show.invoke(p,"CHN");
        System.out.println(returnValue);


        //调用静态方法
        Method showDesc = clazz.getDeclaredMethod("showDesc");
        showDesc.setAccessible(true);
        //如何调用的运行时类没有返回值，则此时返回null
        Object returnValue1 = showDesc.invoke(Person.class);
        //静态方法知道类就能调用，不区分那个类
        Object returnValue2 = showDesc.invoke(null);
        System.out.println(returnValue1);
        System.out.println(returnValue2);

    }

    //调用运行时类中的构造器
    @Test
    public void testConstructor() throws Exception{
        Class clazz = Person.class;
        //获取指定的构造器
        //getDeclaredConstructor():参数：指明构造器的参数列表
        Constructor constructor = clazz.getDeclaredConstructor(String.class);

        constructor.setAccessible(true);

        Person per = (Person)constructor.newInstance("Tom");
        System.out.println(per);

    }

}
