package com.atguigu.factory.absfactory.pizzastore.order;

import com.atguigu.factory.absfactory.pizzastore.pizza.Pizza;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class OrderPizza {
    AbsFactory factory;

    public OrderPizza(){

    }
    public OrderPizza(AbsFactory factory){
        setFactory(factory);
    }

    private void setFactory(AbsFactory factory){
        Pizza pizza = null;
        String orderType = "";//用户输入
        this.factory = factory;

        do{
            orderType = getType();
            //factory可能是北京的工厂子类，也可能是伦敦的工厂子类
            pizza = factory.createPizza(orderType);
            if(pizza != null){//披萨是有的
                pizza.prepare();
                pizza.bake();
                pizza.cut();
                pizza.bake();
            }else{
                System.out.println("订购失败");
                break;
            }
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
