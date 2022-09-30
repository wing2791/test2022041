package com.atguigu.java;

public class SeasonTest {
    public static void main(String[] args) {
        Season spring = Season.SPRING;
        System.out.println(spring);
    }
}


class Season{
    private final String seasonName;
    private final String seasonDesc;
    private Season(String seasonName,String seasonDesc){
        this.seasonDesc = seasonDesc;
        this.seasonName = seasonName;
    }

    public static final Season SPRING = new Season("春天","春暖花开");
    public static final Season SUMMER = new Season("夏天","夏日炎炎");

    @Override
    public String toString() {
        return "Season{" +
                "seasonName='" + seasonName + '\'' +
                ", seasonDesc='" + seasonDesc + '\'' +
                '}';
    }
}