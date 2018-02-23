package com.jdbc;

import java.sql.ResultSet;


public class DBDemo {

    static String sql = null;
    
    static DBHelper db1 = null;
    
    static ResultSet rst = null;
    
    public static void main(String[] args) {
        sql = "select * from student";// sql语句
        db1 = new DBHelper(sql);//创建对象,使用有参构造器
        
        try {
            rst = db1.pst.executeQuery();
            while (rst.next()) {
                String uid = rst.getString(1);
                String uname = rst.getString(2);
                String udate = rst.getString(3);
                System.out.println("....");
            }
            // 应该是按顺序关闭的吧，这里不太清楚
            rst.close();
            db1.close();
        }
        catch (Exception e) {
            
        }
    }
}
