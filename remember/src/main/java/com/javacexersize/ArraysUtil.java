package com.javacexersize;

/**
 * 该类是数组操作算法的一个工具类，提供了大量的静态方法用于操作数组
 * 比如，排序，搜索，等等
 * 
 *
 * @author koala
 * @since 2017年7月23日
 */
public class ArraysUtil {

    /**
     * 工具类如果方法是静态的，构造器私有化，不允许再创建实例
     * 嗯，应该是这样的
     */
    private ArraysUtil(){}
    
    /**
     * 
     * 文档注释一定用两个星的
     * 使用xx算法对指定的数组进行升序排序
     * @param arr 要排序的数组
     *
     * @author koala
     */
    public static void sort(int[]arr){
        
    }
    
    /**
     * 
     * 使用二分法来搜索指定的int型数组，以获得指定的值
     * 必须在进行此调用之前对数组进行排序，(通过sort(int[])方法)
     * 意思就是使用二分法方法的前提是必须是有序数组
     * @param a 要搜索的数组
     * @param key 要搜索的值
     * @return 如果他包含在数组中，则返回搜索键的索引，如果找不到返回-1
     *
     * @author koala
     */
    public static int binarySearch(int[]a,int key){
        return -1;
    }
}
