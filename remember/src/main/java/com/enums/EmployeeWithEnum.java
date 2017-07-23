package com.enums;

enum Restday {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY;// 这里的分号是可以不写的，但是如果不写后面无法写其他方法，因为枚举是特殊的类，但是它也属于类
    // 具有类的一些特点，有方法，有property，

    private String name;

    private int index;
    // 这里这个构造方法不知道为什么会编译报错，明明默认继承了java.lang.Enum类里面的私有构造方法，内部允许有一个枚举常量名，和一个编号(详见文档)
    // Restday(String name,int index){
    // this.name = name;
    // this.index=index;
    // }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

}

/*
 * 再来复习一下，JavaBean规范，必须有构造器，没有的话使用默认构造器，setget方法，相应的property
 * 这只是一个规范，业界通用的，实际上JDK当中的虚拟机也是属于规范的一种，就是为了方便大众统一使用
 */
public class EmployeeWithEnum {

    private Restday restday;//直接定义枚举类property

    public Restday getRestday() {
        return restday;
    }

    public void setRestday(Restday restday) {
        this.restday = restday;
    }

    public static void main(String[] args) {
        EmployeeWithEnum e = new EmployeeWithEnum();
        e.setRestday(Restday.WEDNESDAY);
        if(e.getRestday() == Restday.SATURDAY || e.getRestday() == Restday.SUNDAY){
            System.out.println("周末在家休息");
        }
        System.out.println("周一至周五上班");
    }
}
