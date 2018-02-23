package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 当你写到这里的时候，我想你可能有点对不起“不忘初心”这四个字了吧
 * 
 *
 * @author zbw
 * @since 2018年2月23日
 */
public class DBHelper {

    public static final String url = "jdbc:mysql://localhost/student";
    
    public static final String name = "com.mysql.jdbc.Driver";
    
    public static final String user = "root";
    
    public static final String password = "123456";
    
    public Connection conn = null;//写在里面和写在外面都可以
    
    public PreparedStatement pst = null;
    
    // 有参构造器。。。好长时间没见过了
    public  DBHelper(String sql) {
        try {
            //指定连接类型
            Class.forName(name);
            //获取连接
            conn = DriverManager.getConnection(url, user, password);
            // 准备执行语句
            pst = conn.prepareStatement(sql);
        }
        catch (Exception e) {
        }
    }
    
    // 有用就得有关，资源有限，不能随便用
    public void close() {
        try {
            this.conn.close();
            this.pst.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * 在Java开发特别是数据库开发中，经常会用到Class.forName()这个方法。通过查询
     * Java Documentation 我们会发现使用Class.forName()静态方法的目的是为了动态加载类。
     * 在加载完成后，一般还要调用Class下的newInstance()静态方法来实例化对象以便操作。
     * 因此，单单使用Class.forName()动态加载类是没有用的，其最终目的是为了实例化对象
     * 
     * Class.forName("")返回的是类
     * Class.forName("").newInstance()返回的是Object
     * 
     * 刚才提到，Class.forName("");的作用是要求JVM查找并加载指定的类，如果在类中有静态代码块
     * 的话，JVM必然会执行该类的静态代码段。而在JDBC规范中明确要求这个Driver类必须像
     * DriverManager注册自己，即任何一个JDBC Driver的Driver类的代码都必须类似如下：
     * public class MyJDBCDriver implements Driver {
     *      static {
     *          DriverManager.registerDriver(new MyJDBCDriver());
     *      }
     * }
     * 既然在静态代码块中已经进行了注册，所以我们在使用JDBC时只需要Class.forName("")就可以了
     * 
     * we just want to load the driver to jvm only ,but not need to user the instance of
     * driver ,so call Class.forName(xxx.xx.xx) is enough, if you call
     * Class.forName(xxx.xx.xx).newInstance(), the result will same as calling 
     * Class.forName(xxx.xx.xx), because Class.forName(xxx.xx.xx).newInstance()
     * will load driver first, and then create instance, but the instance you will 
     * never use in usual(通常永远不会用上该实例), so you need not to create it.
     * 总结：
     * jdbc数据库驱动程序最终的目的，是为了程序员能拿到数据库连接，而进行jdbc规范的数据库操作
     * 。拿到连接的过程式不需要你自己来实例化驱动程序的，而是通过DriverManager.getConnection(String str);
     * 因此一般情况下，对于程序员来说，除非特别需求，是不会自己去实例化一个数据库驱动使用里面的
     * 方法的。
     */
}
