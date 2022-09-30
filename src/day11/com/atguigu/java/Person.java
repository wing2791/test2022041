package day11.com.atguigu.java;

/**
 * @ClassName Person
 * @Descriptiron TODO
 * @Author wing2791
 * @Date 2022/9/27 16:06
 * @Version 1.0
 **/
public class Person {


    private String name;
    public int age;

    public Person(){

    }

    private Person(String name) {
        this.name = name;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void show(){
        System.out.println("你好，我是一个人");
    }

    private String showNation(String nation){
        System.out.println(String.format("我的国籍是:"+nation));
        return nation;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
