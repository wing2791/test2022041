package com.atguigu.principle.segregation.improve;


public class Segregation1 {
    public static void main(String[] args) {
        //使用一把
        A a = new A();
        a.depend1(new B());//A类通过接口去依赖B类
        a.depend2(new B());
        a.depend3(new B());

        C c = new C();
        c.depend1(new D());//C类通过接口去依赖（使用）D类
        c.depend4(new D());
        c.depend5(new D());
    }
}

interface  Interface1{
    void  operation1();
}
interface Interface2{
    void operation2();
    void operation3();
}
interface  Interface3{
    void operation4();
    void operation5 ();
}

class B implements Interface1,Interface2{

    @Override
    public void operation1() {
        System.out.println("B 实现了operation1");
    }

    @Override
    public void operation2() {
        System.out.println("B 实现了operation2");
    }

    @Override
    public void operation3() {
        System.out.println("B 实现了operation3");
    }
}

class D implements Interface1,Interface3{

    @Override
    public void operation1() {
        System.out.println("D 实现了operation1");
    }

    @Override
    public void operation4() {
        System.out.println("D 实现了operation4");
    }

    @Override
    public void operation5() {
        System.out.println("D 实现了operation5");
    }
}


class A {//A类通过结构Interface1,Interface2依赖（使用）B类，但是只会用到1,2,3,方法
    public void depend1(Interface1 i){
        i.operation1();
    }
    public void depend2(Interface2 i){
        i.operation2();
    }
    public void depend3(Interface2 i){
        i.operation3();
    }
}

class C{//C类通过结构Interface1依赖（使用）D类，但是只会用到1,4,5,方法
    public void depend1(Interface1 i){
        i.operation1();
    }
    public void depend4(Interface3 i){
        i.operation4();
    }
    public void depend5(Interface3 i){
        i.operation5();
    }
}
