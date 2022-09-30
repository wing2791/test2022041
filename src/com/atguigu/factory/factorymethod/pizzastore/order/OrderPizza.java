package com.atguigu.factory.factorymethod.pizzastore.order;
import com.atguigu.factory.factorymethod.pizzastore.pizza.Pizza;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public abstract class OrderPizza {
    //定义一个抽象方法，createPizza,让各个工程子类自己实现
    abstract  Pizza createPizza(String orderType);

    public OrderPizza(){
        Pizza pizza = null;
        String orderType; //订购披萨的类型
        do{
            orderType = getType();
            pizza = createPizza(orderType);//抽象方法，由工厂子类完成
            pizza.prepare();
            pizza.bake();
            pizza.cut();
            pizza.bake();
        }while(true);
    }


    private String getType(){
        try{
            BufferedReader strin = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("input pizza type:");
            String str = strin.readLine();
            return str;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

}
