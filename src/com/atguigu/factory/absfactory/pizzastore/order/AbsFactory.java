package com.atguigu.factory.absfactory.pizzastore.order;

import com.atguigu.factory.absfactory.pizzastore.pizza.Pizza;

public interface AbsFactory {
    //让下面的工厂子类来具体实现
    public Pizza createPizza(String orderType);
}
