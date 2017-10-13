package com.service;

import java.sql.SQLException;
import java.util.List;

import com.dao.UserDao;
import com.entity.T_Admin;
import com.entity.T_User;

public class UserService {

	UserDao ud=new UserDao();
	boolean f=false;
	
	//用户与管理员登录
	public String Login(String name,String password,String score){
		String i=null;
		i=ud.Login(name, password,score);
		return i;
	}
	
	//会员注册
	public boolean Register(T_User u){
		if(ud.Register(u)){
			f=true;
		}
		return f;
	}
	
	//管理员注册
	public boolean ARegister(T_Admin a){
		if(ud.ARegister(a)){
			f=true;
		}
		return f;
	}
	
	//修改会员密码
	public boolean Pw(String userName,String userPw,String userPw1) throws SQLException{
		if(ud.Pw(userName, userPw, userPw1)){
			f=true;
		}
		return f;
	}
	
	//查询所有会员
	public List<T_User> user() throws SQLException {
		List<T_User> tu=ud.user();
		return tu;
	}
	//删除用户
	public boolean delete(int id) throws SQLException{
		if(ud.delete(id)) {
			f=true;
		}
		return f;
	}
}
