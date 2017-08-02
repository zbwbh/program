package com.reflect.annotation;

import java.lang.reflect.Field;

public class FruitInfoUtil {

    public static void getFruitInfo(Class<?> clazz) {
        String preName = "水果的名称:";
        String preColor = "水果的颜色:";
        String preAddress = "水果的地址:";
        
        Field[] fields = clazz.getDeclaredFields();
        for(Field field : fields) {
            if(field.isAnnotationPresent(FruitName.class)){
                FruitName fruitName = field.getAnnotation(FruitName.class);
                System.out.println(preName+fruitName.value());
            }else if(field.isAnnotationPresent(FruitColor.class)){
                FruitColor fruitColor = field.getAnnotation(FruitColor.class);
                System.out.println(preColor+fruitColor.value());
            }else if(field.isAnnotationPresent(FruitProvider.class)){
                FruitProvider fruitProvider = field.getAnnotation(FruitProvider.class);
                System.out.println(preAddress+"供应商id："+fruitProvider.id()+"供应商名称："+fruitProvider.name()+"供应商地址："+fruitProvider.address());
            }
        }
    }
}
