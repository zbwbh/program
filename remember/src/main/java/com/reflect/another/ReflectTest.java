package com.reflect.another;


public class ReflectTest {

    public static void main(String[] args) {
        try {
            Class c1 = Class.forName("com.reflect.another.Employee");
            Class c2 = Employee.class;
            System.out.println(c1 == c2);
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        
    }
}
