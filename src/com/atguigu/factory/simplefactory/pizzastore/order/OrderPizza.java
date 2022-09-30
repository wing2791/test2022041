package com.atguigu.factory.simplefactory.pizzastore.order;
import com.atguigu.factory.simplefactory.pizzastore.pizza.CheesePizza;
import com.atguigu.factory.simplefactory.pizzastore.pizza.GreekPizza;
import com.atguigu.factory.simplefactory.pizzastore.pizza.Pizza;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class OrderPizza {
//    public OrderPizza(){
//        Pizza pizza = null;
//        String orderType; //订购披萨的类型
//        do{
//            orderType = getType();
//            if(orderType.equals("greek")){
//                pizza = new GreekPizza();
//                pizza.setName(" 希腊披萨");
//            }else if(orderType.equals("cheese")){
//                pizza = new CheesePizza();
//                pizza.setName(" 奶酪披萨");
//            }else{
//                break;
//            }
//            pizza.prepare();
//            pizza.bake();
//            pizza.cut();
//            pizza.bake();
//        }while(true);
//    }
    //定义一个简单工厂对象
    SimpleFactory simpleFactory;
    Pizza pizza = null;

    public OrderPizza(){

    }

    public OrderPizza(SimpleFactory simpleFactory){
        setFactory(simpleFactory);
    }

    public void setFactory(SimpleFactory simpleFactory){
        String orderType = "";//用户输入

        this.simpleFactory = simpleFactory;//是指简单工厂对象
        do {
            orderType = getType();
            pizza = this.simpleFactory.createPizza(orderType);
            if(pizza != null){
                pizza.prepare();
                pizza.bake();
                pizza.cut();
                pizza.bake();
            }else{
                System.out.println("订购披萨失败");
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
