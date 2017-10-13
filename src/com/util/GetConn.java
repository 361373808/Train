package com.util;
/**
 * ����lei
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
		//��ȡ�����ļ��õ�������
		InputStream in=GetConn.class.getClassLoader().getResourceAsStream("jdbc.properties");
		Properties p=new Properties();//ʵ��������
		p.load(in);//������
		//�������ݿ���������
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
		System.out.println("�ر�ʧ��");
	}
}
public static void main(String[] args) {
	System.out.println(GetConn.conn());
}
//���������ύ
public static void commit(Connection conn){
	try {
		conn.commit();
	} catch (SQLException e) {
		e.printStackTrace();
	}
}
//��������ع�
public static void rollback(Connection conn){
	try {
		conn.rollback();
	} catch (SQLException e) {
		e.printStackTrace();
	}
}
//�����ύ
public static void beginTx(Connection conn){
	try {
		conn.setAutoCommit(true);//�����Զ��ύ
	} catch (SQLException e) {
		e.printStackTrace();
	}
}


}
