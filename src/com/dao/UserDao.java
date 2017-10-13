package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.entity.T_Admin;
import com.entity.T_Checi;
import com.entity.T_Gonggao;
import com.entity.T_User;
import com.entity.T_Yuding;
import com.util.SqlConn;

public class UserDao {

	HttpServletRequest request = ServletActionContext.getRequest();
	HttpSession session = request.getSession();
	SqlConn s = new SqlConn();
	ResultSet rs = null;
	T_User tu = null;
	T_Admin ad = null;
	boolean f = false;

	// 登录
	public String Login(String name, String password, String score) {
		tu = new T_User();
		ad = new T_Admin();
		String i = null;
		try {
			if (score == null) {
				String sql = "select * from t_admin where a_username=? and a_userpw=?";
				rs = s.query(sql, name, password);
				if (rs.next()) {
					ad.setA_id(rs.getInt("a_id"));
					ad.setA_userName(rs.getString("a_username"));
					ad.setA_userPw(rs.getString("a_userpw"));
					ad.setA_type(rs.getString("a_type"));
					session.setAttribute("ad", ad);
					i = ad.toString();
				}
			} else {
				String sql = "select * from t_user where u_name=? and u_pw=?";
				rs = s.query(sql, name, password);
				if (rs.next()) {
					tu.setU_id(rs.getInt("u_id"));
					tu.setU_name(rs.getString("u_name"));
					tu.setU_pw(rs.getString("u_pw"));
					session.setAttribute("tu", tu);
					i = tu.toString();
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}

	// 会员注册
	public boolean Register(T_User u) {
		int i = 0;
		System.out.println(u+"2");
		System.out.println("2"+u.getU_name());
			try {
				String sql = "insert into t_user(u_id,u_name,u_pw,u_realname,u_address,u_sex,u_tel,u_email,u_qq) values(tuser_id.nextval,?,?,?,?,?,?,?,?)";
				i = s.update(sql, u.getU_name(), u.getU_pw(), u.getU_realname(), u.getU_address(), u.getU_sex(),
						u.getU_tel(), u.getU_email(), u.getU_qq());
				if (i != 0) {
					f = true;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return f;
		}
	//管理员添加
	public boolean ARegister(T_Admin a) {
			int i = 0;
			try {
				String sql = "insert into t_admin(a_id,a_username,a_userpw) values(tadmin_id.nextval,?,?)";
				i = s.update(sql, a.getA_userName(), a.getA_userPw() );
				if (i != 0) {
					f = true;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return f;
		}

	//修改个人密码【后台】
	public boolean Pw(String name,String userPw,String userPw1) throws SQLException{
		int k=0;
		String sql="update t_admin set a_userPw=? where a_username=?";
		k=s.update(sql, userPw1,name);
		if(k!=0){
			f=true;
	}
		return f;
	}
	
	//查询所有会员
	public List<T_User> user() throws SQLException {
		List<T_User> list=new ArrayList<T_User>();
		 ResultSet rs=null;
			String sql="select * from T_User";
			rs=s.query(sql);
		while(rs.next()) {
			T_User tu=new T_User();
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
			list.add(tu);
		}
		return list;
	}

	//删除某个会员
	public boolean delete(int id) throws SQLException {
		int k=0;
		String sql="delete from t_user where u_id=?";
		k=s.update(sql, id);
		if(k!=0) {
			f=true;
		}
		return f;
	}

	//前台为用户显示已有车次
	public List<T_Checi> allche() throws Exception{
		List<T_Checi> list=new ArrayList<T_Checi>();
		T_Checi tc=null;
		String sql="select * from T_Checi";
		ResultSet rs=s.query(sql);
		while(rs.next()) {
			tc=new T_Checi();
			tc.setC_id(rs.getInt("c_id"));
			tc.setCtype(rs.getString("ctype"));
			tc.setDaodazhan(rs.getString("daodazhan"));
			tc.setEndshijian(rs.getString("endshijian"));
			tc.setPiaojia(rs.getInt("piaojia"));
			tc.setPiaoshijian(rs.getString("piaoshijian"));
			tc.setPiaoshu(rs.getInt("piaoshu"));
			tc.setShifazhan(rs.getString("shifazhan"));
			tc.setStartshijian(rs.getString("startshijian"));
			list.add(tc);
		}
		return list;
	}
	
	//购票
	public boolean buy(T_Yuding ty) throws Exception {
		boolean f=false;
		Date date=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String d=sdf.format(date);
		System.out.println( ty.getYudingshumu()+"--"+ty.getC_id()+"--"+ty.getU_id()+"--"+ty.getYudingjine()+"--"+ty.getZhifufangshi()+"--"+d);
		String sql="insert into t_yuding(id,yudingshumu,c_id,u_id,yudingjine,zhifufangshi,yuding_shijian) values(tyuding_id.nextval,?,?,?,?,?,?)";
		int row=s.update(sql, ty.getYudingshumu(),ty.getC_id(),ty.getU_id(),ty.getYudingjine(),ty.getZhifufangshi(),d);
		if(row!=0) {
			f=true;
		}
		return f;
	}
	
	//查询指定车次
	public List<T_Checi> user_all(String shifazhan,String daodazhan,String piaoshijian) throws Exception{
		String sql="SELECT * FROM (SELECT * FROM t_checi where shifazhan like '%"+shifazhan+"%' and daodazhan like '%"+daodazhan+"%' and piaoshijian like '%"+piaoshijian+"%') ";
		List<T_Checi> all=new ArrayList<T_Checi>();
		ResultSet rs=s.query(sql);
		while(rs.next()){
			T_Checi checi=new T_Checi();
			checi.setC_id(rs.getInt(1));
			checi.setShifazhan(rs.getString(2));
			checi.setDaodazhan(rs.getString(3));
			checi.setPiaoshijian(rs.getString(4));
			checi.setStartshijian(rs.getString(5));
			checi.setEndshijian(rs.getString(6));
			checi.setCtype(rs.getString(7));
			checi.setPiaojia(rs.getInt(8));
			checi.setPiaoshu(rs.getInt(9));
			checi.setDel(rs.getString(10));
			all.add(checi);
		}
		return all;
	}
	
	//查询公告详情
		public T_Gonggao show(int id) throws Exception{
			T_Gonggao gg=null;
			String sql="select * from t_gonggao where id=?";
			ResultSet rs=s.query(sql, id);
			if(rs.next()){
				gg=new T_Gonggao();
				gg.setA_id(rs.getInt(5));
				gg.setTitle(rs.getString(2));
				gg.setContent(rs.getString(3));
				gg.setShijian(rs.getString(4));
				gg.setId(id);
			}
			return gg;
		}
}
