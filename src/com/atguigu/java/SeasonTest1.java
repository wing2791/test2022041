package com.atguigu.java;

/**
 * @ClassName SeasonTest1
 * @Descriptiron TODO
 * @Author wing2791
 * @Date 2022/9/23 20:46
 * @Version 1.0
 **/
    //定义的枚举类默认继承于java.lang.Enum类
    //values方法:返回枚举类型的对象数组，该方法可以很方便地遍历所有的枚举值
    //valueof(String objName):返回枚举类中对象名是objName的对象
    //如果没有objName的枚举类对象，则抛异常，IllegalArgumentException
    //toString():返回当前枚举类对象常量的名称
    //使用enum关键字定义的枚举类实现接口的情况
    //情况一：实现接口，在enum类中实现抽象方法
    //情况二：让枚举类的对象分别实现接口中的抽象方法
public class SeasonTest1 {
    public static void main(String[] args) {
        Season1 spring = Season1.SPRING;
        System.out.println(spring);
        System.out.println(Season1.class.getSuperclass());

        Season1[] values = Season1.values();
        for(int i = 0;i<values.length;i++){
            System.out.println(i+1+".Season1的枚举类有:"+values[i]);
            values[i].show();
        }

        Season1 winter = Season1.valueOf("WINTER");
//如果没有objName的枚举类对象，则抛异常，IllegalArgumentException
//        Season1 winter = Season1.valueOf("WINTER1");
        System.out.println(winter);

    }
}

interface Info{
    void show();
}

enum Season1 implements Info{
    SPRING("春天","春暖花开"){
        @Override
        public void show() {
            System.out.println("这是春天写的show()方法");

        }
    },
    SUMMER("夏天","夏日炎炎"){
        @Override
        public void show() {
            System.out.println("这是夏天的show()方法");
            System.out.println("这是夏天的show()方法2");
            System.out.println("这是夏天的show()方法4");
        }
    },
    AUTUMN("秋天","秋高气爽"){
        @Override
        public void show() {
            System.out.println("这是秋天写的show()方法");

        }
    },
    WINTER("冬天","冰冷刺骨"){
        @Override
        public void show() {
            System.out.println("这是冬天写的show()方法");

        }
    };


    private final String seasonName;
    private final String seasonDesc;

    private Season1(String seasonName,String seasonDesc){
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }

    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }


//    @Override
//    public void show() {
//        System.out.println("这是一个季节写的show()方法");
//    }
}
