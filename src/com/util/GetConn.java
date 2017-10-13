package com.util;
/**
 * 工具lei
 */
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class GetConn {
public static  Connection conn(){
		Connection conn=null;
	try{
		//读取属性文件得到输入流
		InputStream in=GetConn.class.getClassLoader().getResourceAsStream("jdbc.properties");
		Properties p=new Properties();//实例化对象
		p.load(in);//加载流
		//加载数据库驱动程序
		Class.forName(p.getProperty("Driver"));
		conn=DriverManager.getConnection(p.getProperty("url"),p.getProperty("user"),p.getProperty("pwd"));
	}catch(Exception e){
		e.printStackTrace();
		System.out.println("connection fail!");
	}
	return conn;
}
public static void closeDB(ResultSet rs,Statement st,Connection conn){
	try {
		if(rs!=null)rs.close();
		if(st!=null)st.close();
		if(conn!=null)conn.close();
	} catch (Exception e) {
		e.printStackTrace();
		System.out.println("关闭失败");
	}
}
public static void main(String[] args) {
	System.out.println(GetConn.conn());
}
//开启事务提交
public static void commit(Connection conn){
	try {
		conn.commit();
	} catch (SQLException e) {
		e.printStackTrace();
	}
}
//开启事务回滚
public static void rollback(Connection conn){
	try {
		conn.rollback();
	} catch (SQLException e) {
		e.printStackTrace();
	}
}
//开启提交
public static void beginTx(Connection conn){
	try {
		conn.setAutoCommit(true);//开启自动提交
	} catch (SQLException e) {
		e.printStackTrace();
	}
}


}
