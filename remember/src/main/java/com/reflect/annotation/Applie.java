package com.reflect.annotation;

import com.reflect.annotation.FruitColor.Color;

public class Applie {

    @FruitName("红富士")
    private String name;

    @FruitColor// (value=Color.GREEN)后面这个没有就是默认的
    private String color;

    @FruitProvider(id = 1, name = "不知道哪儿", address = "屯子里出来的")
    private String appleProvider;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getAppleProvider() {
        return appleProvider;
    }

    public void setAppleProvider(String appleProvider) {
        this.appleProvider = appleProvider;
    }

    public void displayName(){
        System.out.println("水果的名字：苹果");
    }
}
