package com.atguigu.factory.absfactory.pizzastore.pizza;

import com.atguigu.factory.absfactory.pizzastore.order.BJFactory;
import com.atguigu.factory.absfactory.pizzastore.order.OrderPizza;


public class PizzaStore {
    public static void main(String[] args) {
        new OrderPizza(new BJFactory());
    }
}
