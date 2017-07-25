package com.arithmetic.second;

//安排篮球运动员上场
public class BasketballPlayerDemo {

    //存储场上球员的球衣号码
    private static Integer[] players = null;
    //场上球员的个数
    private static int size = 0;
    //1、初始容量为5的线性列表，准备用来存储场上的5个球衣号码
    private static void init(int initialCapacity) {
        if(initialCapacity<0){
            //改异常专门跑出非法参数异常
            throw new IllegalArgumentException("容量不能为负数");
        }
        //因为静态方法只能访问静态成员变量，所以上面两个变量都加上了static
        players = new Integer[initialCapacity];
    }
    //2、安排5个球员上场[11,22,33,44,55]
    public static void add(Integer playerNum){
//        数组[index] = 元素值；
        players[size] = playerNum;
        size++;//这个是比较简单的实现，没有考虑其他情况，JDK中的java.util.ArrayList里面的add方法也有size++，并且有很多重载方法
    }
    //3、查询指定位置的球员的球衣号码是多少，查询索引位置为2的球衣号码是33.
    private static Integer get(int index){
        if(index<0||index>=size) {
            throw new IllegalArgumentException("数组越界异常");
        }
        return players[index];//根据索引取元素
    }
    //4、根据球衣号码查询该球员在场上的索引位置，44球衣号的球员在场上的索引位置是3
    private static int getIndexPlayerNum(Integer playerNum) {
        for (int i = 0; i < size; i++) {
            //取出每个球员的球衣号码
            if(players[i].equals(playerNum)){
                return i;
            }
        }
        return -1;
    }
    //5、替换场上索引位置为2的球员，替换之后该位置的球衣编号为333,333把33替换了
    private static void set(int index, int newPlayerNum) {
        players[index] = newPlayerNum;
    }
    //6、替换球衣号码为22的球员，替换之后为222.
    private static void update(Integer playerNum, Integer newPlayerNum) {
        int index = getIndexPlayerNum(playerNum);
        if(index>=0){
            set(index,newPlayerNum);
        }
        
    }
    //7、把场上索引位置为2的球衣罚下场，是删除
    private static void delete(int index) {
        if(index<0||index>=size) {
            throw new IllegalArgumentException("数组越界异常");
        }
        //为了防止数组越界，直接把访问到的最后一位减一
        for (int i = index; i < size - 1; i++) {//因为要删除index位置的元素，所以从index的位置开始遍历
            players[i] = players[i+1];//把后一位的元素值往前挪一位
        }
        //把最后一位设置为null，如果不设置为null，那么原始数据会占用空间的
        players[size-1] = null;
        //没有--的话会显示null
        size -- ;
    }
    //8、按照球员在场上的位置，打印出球衣号码，打印风格就是数组风格
    public static void print(){
        if(players == null){
            System.out.println("null");
            return ;
        }
        if(size == 0){
            System.out.println("[]");
            return ;
        }
        //sb底层也是使用的char数组，默认初始容量是16，一旦超出该容量需要扩容
        //，扩容就涉及到数组的拷贝，可以使用它的构造器告诉底层我究竟想要多少空间
        StringBuilder sb = new StringBuilder(size * 2 + 1);
        sb.append("[");
        for (int index = 0; index < size; index++) {
            sb.append(players[index]);
            if(index != size-1){//判断是不是最后一个元素
                sb.append(",");
            }else{
                sb.append("]");
            }
        }
        System.out.println(sb.toString());
    }
    public static void main(String[] args) {
        //1、初始容量为5的线性列表
        init(5);
        print();
        add(11);
        add(22);
        add(33);
        add(44);
        add(55);
        print();
        //查询索引位置为2的球衣号码
        Integer num = get(2);
        System.out.println(num);
//        int index = getIndexPlayerNum(33);
//        System.out.println(index);
        //把索引为2的球员替换为333
//        set(2,333);
//        print();
//        update(33,888);
//        print();
//        update(333,888);
//        print();
        delete(2);
        print();
    }
    
}
