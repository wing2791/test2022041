package com.atguigu.factory.factorymethod.pizzastore.pizza;

public class BjCheesePizza extends Pizza{

    @Override
    public void prepare() {
        setName("北京的奶酪Pizza");
        System.out.println(" 北京的奶酪pizza 准备原材料");
    }
}
