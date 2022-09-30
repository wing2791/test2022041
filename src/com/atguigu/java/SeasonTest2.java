package com.atguigu.java;

/**
 * @ClassName SeasonTest2
 * @Descriptiron TODO
 * @Author wing2791
 * @Date 2022/9/23 20:40
 * @Version 1.0
 **/
public class SeasonTest2 {
    public static void main(String[] args) {
        Season spring = Season.SPRING;
        System.out.println(spring);
    }
}

 class Season2{
    private final String seasonDesc;
    private final String seasonName;

    private Season2(String seasonName,String seasonDesc){
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }

    public static final Season2 SPRING = new Season2("春天","春暖花开");

     @Override
     public String toString() {
         return "Season2{" +
                 "seasonDesc='" + seasonDesc + '\'' +
                 ", seasonName='" + seasonName + '\'' +
                 '}';
     }
 }
