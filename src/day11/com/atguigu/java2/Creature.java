package day11.com.atguigu.java2;

import java.io.Serializable;

/**
 * @ClassName Creature
 * @Descriptiron TODO
 * @Author wing2791
 * @Date 2022/9/30 21:29
 * @Version 1.0
 **/
public class Creature<T> implements Serializable {
    private char gender;
    public double weight;

    private void breath(){
        System.out.println("生物呼吸");

    }

    public void eat(){
        System.out.println("生物吃东东");
    }
}
