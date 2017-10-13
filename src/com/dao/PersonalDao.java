package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.entity.T_User;
import com.entity.T_Yuding;
import com.util.SqlConn;

public class PersonalDao{
	SqlConn s=new SqlConn();
	
	//修改个人密码
	public boolean Pw(String name,String userPw1) throws SQLException{
		int k=0;
		String sql="update t_user set u_Pw=? where u_name=?";
		k=s.update(sql, userPw1,name);
		if(k!=0){
			return true;
	}
		return false;
	}
	
	//用户信息
	public T_User userxinxi(int id) throws SQLException {
		T_User tu = null;
		ResultSet rs = null;
		String sql = "select * from T_User where u_id=?";
		rs = s.query(sql,id);
		while (rs.next()) {
			tu = new T_User();
			tu.setU_id(rs.getInt("u_id"));
			tu.setU_name(rs.getString("u_name"));
			tu.setU_pw(rs.getString("u_pw"));
			tu.setU_realname(rs.getString("u_realname"));
			tu.setU_address(rs.getString("u_address"));
			tu.setU_sex(rs.getString("u_sex"));
			tu.setU_tel(rs.getString("u_tel"));
			tu.setU_email(rs.getString("u_email"));
			tu.setU_qq(rs.getString("u_qq"));
			tu.setU_type(rs.getString("u_type"));
			tu.setU_score(rs.getInt("u_score"));
		}
		return tu;
	}
	
	//查看当前用户的积分
	public int score(int id) throws SQLException {
		String sql="select u_score from t_user where u_id=?";
		ResultSet rs=s.query(sql,id);
		int i=0;
		if(rs.next()) {
			i=rs.getInt("u_score");
		}
		return i;
	}
	
	// 当前用户的车票订单
		public List<T_Yuding> piaoall(int id) throws SQLException {
			List<T_Yuding> list = new ArrayList<T_Yuding>();
			String sql = "select * from T_Yuding where u_id=?";
			ResultSet rs = s.query(sql,id);
			while (rs.next()) {
				T_Yuding ty = new T_Yuding();
				ty.setId(rs.getInt("id"));
				ty.setC_id(rs.getInt("c_id"));
				ty.setU_id(rs.getInt("u_id"));
				ty.setYudingshumu(rs.getInt("yudingshumu"));
				ty.setYudingjine(rs.getInt("yudingjine"));
				ty.setZhifufangshi(rs.getString("zhifufangshi"));
				ty.setYuding_shijian(rs.getString("yuding_shijian"));
				ty.setZhuangtai(rs.getString("yuding_zhuangtai"));
				list.add(ty);
			}
			return list;
		}
}
