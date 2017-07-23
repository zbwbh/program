package com.enums;
class Weekday{
    private Weekday(){
        //枚举类型底层就是这样的，该私有构造器也是为了防止产生多余的常量对象,同时底层中私有构造器是有两个参数的，一个是常量名称，一个是序号
    }
    public static final Weekday MONDAY = new Weekday();
    public static final Weekday TUESDAY = new Weekday();
    public static final Weekday WEDNESDAY = new Weekday();
    public static final Weekday THURSDAY = new Weekday();
    public static final Weekday FRIDAY =new Weekday();
    public static final Weekday SATURDAY =new Weekday();
    public static final Weekday SUNDAY =new Weekday();
}
public class Employee {

    private Weekday restday;

    public Weekday getRestday() {
        return restday;
    }

    public void setRestday(Weekday restday) {
        this.restday = restday;
    }

    public static void main(String[] args) {
        Employee e = new Employee();
        e.setRestday(Weekday.WEDNESDAY);
        if(e.getRestday() == Weekday.SUNDAY || e.getRestday() ==Weekday.SATURDAY){
            System.out.println("周末休息！");
        }else{
            System.out.println("周一至周五上班");
        }
    }
}
