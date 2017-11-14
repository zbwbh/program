package com.hashmap;


public class Person {

    private String name;
    
    private int age;
    
    
    public Person(String name,int age) {
        this.name = name;
        this.age = age;
    }
    
    public void setAge(int age) {
        this.age = age;
    }
    
    public boolean equals(Object obj) {
        return this.name.equals(((Person)obj).name) && this.age == ((Person)obj).age;
    }
    
    public int hashCode() {
        return name.hashCode()* 37 + age;
    }
}
