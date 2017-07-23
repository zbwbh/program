package com.javacexersize;

/**
 * 生成文档练习
 * 定义一个走路规范，包含一个可走路的行为，适用于爬行动物
 * 
 * 在jdk以及spring框架中的含有链接的注释是配置文件中定义的，因为我看到有一个类似于el表达式的东西
 * @see 详见<a href="www.baidu.com">百度</a>
 * @version 1.1
 * @author koala
 * @since 2017年7月23日
 */
public interface IWalkable {

    /**
     * 可走路的行为
     * **在接口中定义方法都要添加注释，当然那肯定达到一定水平才能写接口
     *
     * @author koala
     * @since 2017年7月23日
     */
   void walk();
}
