package com.atguigu.factory.absfactory.pizzastore.order;

import com.atguigu.factory.absfactory.pizzastore.pizza.BJPepperPizza;
import com.atguigu.factory.absfactory.pizzastore.pizza.BjCheesePizza;
import com.atguigu.factory.absfactory.pizzastore.pizza.Pizza;

//这是一个工厂子类
public class BJFactory implements  AbsFactory{

    @Override
    public Pizza createPizza(String orderType) {
        System.out.println("使用的是抽象工厂模式");
        Pizza pizza = null;
        if(orderType.equals("cheese")){
            pizza = new BjCheesePizza();

        }else if(orderType.equals("pepper")){
            pizza = new BJPepperPizza();

        }
        return pizza;
    }
}
