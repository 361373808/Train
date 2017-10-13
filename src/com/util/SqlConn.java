package com.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class SqlConn{
	private static ComboPooledDataSource dataSource=new ComboPooledDataSource("c3p0");
	Connection conn=null;
	PreparedStatement ps=null;
	
	public ResultSet query(String sql,Object...obj) throws SQLException{
		conn=dataSource.getConnection();
	//	System.out.println(dataSource.getProperties());
		ResultSet rs=null;
		try {
			ps=conn.prepareStatement(sql);
			for(int i=0;i<obj.length;i++){
				ps.setObject(i+1, obj[i]);
			}
			rs=ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	public int update(String sql,Object...obj) throws SQLException{
		conn=dataSource.getConnection();
		int i=0;
		beginTx(conn);
		try {
			ps=conn.prepareStatement(sql);
			for(int a=0;a<obj.length;a++){
				ps.setObject(a+1, obj[a]);
			}
			i=ps.executeUpdate();
			commit(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}
	
	//commit
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
