/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javatrydatabase;

import java.io.File;
import java.sql.*;

/**
 *
 * @author dh
 */
public class JavaTryDataBase {
    
      // JDBC 驱动名及数据库 URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
    static final String DB_URL = "jdbc:mysql://localhost:3306/newspaper";
 
    // 数据库的用户名与密码，需要根据自己的设置
    static final String USER = "root";
    static final String PASS = "123456";
    public static void updateDB(){
        Connection conn = null;
        Statement stmt = null;
        try{
            // 注册 JDBC 驱动
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("连接数据库...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            System.out.println(" 实例化Statement对...");
            stmt = conn.createStatement();
            String sql;
            //sql = "INSERT INTO news (data1,data2,data3) VALUE (3,5,9)";
            //System.out.println(sql);
            //stmt.executeUpdate(sql);
            sql = "SELECT * FROM news";
            //System.out.println(sql);
            // 展开结果集数据库
            try (ResultSet rs = stmt.executeQuery(sql)) {
                // 展开结果集数据库
                while (rs.next()) {
                    // 通过字段检索
                    //int data1  = rs.getInt("data1");
                    
                    // 输出数据
                    
                    //System.out.println("data1 is "+data1);
                }
                // 完成后关闭
            }
            stmt.close();
            conn.close();
        }catch(SQLException se){
            // 处理 JDBC 错误
            se.printStackTrace();
        }catch(Exception e){
            // 处理 Class.forName 错误
            e.printStackTrace();
        }finally{
            // 关闭资源
            try{
                if(stmt!=null) stmt.close();
            }catch(SQLException se2){
            }// 什么都不做
            try{
                if(conn!=null) conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
        System.out.println("Goodbye!");
    }
    
    private static void getFile(String path){   
        // get file list where the path has   
        File file = new File(path);   
        // get the folder list   
        File[] array = file.listFiles();   
          
        for(int i=0;i<array.length;i++){   
            if(array[i].isFile()){   
                // only take file name   
                System.out.println(array[i].getName());   
                 
            }else if(array[i].isDirectory()){   
                getFile(array[i].getPath());   
            }   
        }   
    }   
  

    public static void main(String[] args) {
        getFile("./");
        updateDB();
    }
    
}
