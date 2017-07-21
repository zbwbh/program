package com.singleton;

/**
 * 懒汉模式最终版本
 * 
 *
 * @author koala
 * @since 2017年7月21日
 */
public class FinalLazySingleton {

    //volatile保证在分配内存空间以及引用的时候发生冲突，该关键字会禁止指令重排序优化，其他的暂时不知道
    private volatile static FinalLazySingleton finalLazySingleton = null;

    private FinalLazySingleton() {

    }

    public static FinalLazySingleton getInstance() {
        if (finalLazySingleton == null) {//如果实例已经被创建可以不用下面的判断了
            synchronized (FinalLazySingleton.class) {//保证创建同步
                if (finalLazySingleton == null) {
                    finalLazySingleton = new FinalLazySingleton();
                }
            }
        }
        return finalLazySingleton;
    }
}
