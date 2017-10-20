package com.designpattern.decoratorpatter;


public class Tall extends DecoratorGirl{

    private Girl girl;
    
    
    public Tall(Girl g) {
        girl = g;
    }
    
    @Override
    public String getDescription() {
        return girl.getDescription() + " and is very tall.";
    }

}
