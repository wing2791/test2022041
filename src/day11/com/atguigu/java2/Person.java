package day11.com.atguigu.java2;

/**
 * @ClassName Person
 * @Descriptiron TODO
 * @Author wing2791
 * @Date 2022/9/30 21:32
 * @Version 1.0
 **/
@MyAnnotation(value = "hi")
public class Person extends Creature<String> implements Comparable<String>,MyInterface{
    private String name;
    int age;
    public int id;

    public Person(){}
    Person(String name){
        this.name = name;
    }
    @MyAnnotation(value = "abc")
    Person(String name,int age){
        this.name = name;
        this.age = age;
    }
    @MyAnnotation
    private String show(String nation){
        System.out.println("我的国籍是："+nation);
        return nation;
    }

    public String display(String interest){
        return interest;
    }



    @Override
    public void info() {
        System.out.println("我是一个人");
    }

    @Override
    public int compareTo(String o) {
        return 0;
    }

    private static void showDesc(){
        System.out.println("静态类");
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", id=" + id +
                '}';
    }
}
