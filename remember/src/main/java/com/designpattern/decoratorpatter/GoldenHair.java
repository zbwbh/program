package com.designpattern.decoratorpatter;


public class GoldenHair extends DecoratorGirl{

    private Girl girl;
    
    
    public GoldenHair(Girl g) {//从外部传入的girl替换当前类属性中的girl以用来扩展该类下的描述方法
        girl = g;
    }
    
    @Override
    public String getDescription() {
        //前面的girl.getDescription()代表上一层Girl类中对于女孩的描述
        return girl.getDescription() + " has goldenHair";
    }

}
