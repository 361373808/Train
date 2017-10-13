package com.action;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.dao.UserDao;
import com.entity.T_Admin;
import com.entity.T_Checi;
import com.entity.T_Gonggao;
import com.entity.T_User;
import com.entity.T_Yuding;
import com.opensymphony.xwork2.ActionSupport;
import com.service.UserService;

public class UserAction extends ActionSupport{
private String userName;
private String userPw;
private String userPw1;
private int id;
private String shifazhan;
private String daodazhan;
private String piaoshijian;
private int piaoshu;
private T_User u;
private T_Admin a;
private T_Yuding y; 
private String score;

HttpServletRequest request=ServletActionContext.getRequest();
HttpSession session=request.getSession();
String op=request.getParameter("op");

UserDao ud=new UserDao();
UserService us=new UserService();
String res=null;
boolean f=false;

@Override
public String execute() throws Exception {
	if("u_login".equals(op)){//用户登录
		if(this.login()!=null)
				res="ulogin_ok";
			else
				res="ulogin_fail";
	}if("a_login".equals(op)){//管理员登录
		if(this.login()!=null)
			res="alogin_ok";
		else
			res="alogin_fail";
	}if("userLogout".equals(op)){//用户退出
		session.removeAttribute("tu");
		res="userLogout";
	}if("u_reg".equals(op)){//用户注册
		if(this.register()){
			res="u_reg";
		}
	}
	if("a_reg".equals(op)){
		if(this.Aregister()){
			res="a_reg";
		}
	}
	if("pw".equals(op)){//修改个人密码
		if(this.Pw()){
			res="pw_ok";
		}
	}if("all".equals(op)){
		if(this.user())
			res="um";
	}if("delete".equals(op)) {
		if(this.delete()) {
			res="delete";
		}
	}if("allche".equals(op)) {
		if(this.allche()) {
			res="allche";
		}
	}if("buy".equals(op)) {
		if(this.buy()) {
			res="buy";
		}
	}if("cheall".equals(op)) {
		if(this.user_all()) {
			res="cheall";
		}
	}if("show".equals(op)) {
		if(this.show()){
			res="show";
		}
	}
	
	return res;
}

//会员和管理员登录
public String login(){
	String i=null;
	i=us.Login(userName,userPw, score);
	return i;
}

//会员注册
public boolean register(){
	if(us.Register(u))
		f=true;
	return f;
}

//管理员注册
public boolean Aregister(){
	if(us.ARegister(a))
		f=true;
	return f;
}

//修改密码
public boolean Pw(){
	try {
		if(us.Pw(userName, userPw, userPw1)){
			f=true;
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return f;
}


//查询所有会员
public boolean user() throws SQLException {
	List<T_User> tu=us.user();
	System.out.println(tu);
	if(tu!=null) {
		request.setAttribute("all", tu);
		f=true;
	}
	return f;
}

//删除会员
public boolean delete() throws SQLException{
	if(us.delete(u.getU_id())) {
		f=true;
	}
	return f;
}

//前台为用户显示已有车次
	public boolean allche() throws Exception {
		boolean f=false;
		List<T_Checi> list=ud.allche();
		if(list!=null) {
			session.setAttribute("list", list);
			f=true;
		}
		return f;
	}

	//购票
		public boolean buy() throws Exception {
			boolean f=false;
			if(ud.buy(y)) {
				f=true;
			}
			return f;
		}
	
		//查询指定车次
		public boolean user_all() throws Exception{
			boolean f=false;
			List<T_Checi> all=ud.user_all(shifazhan, daodazhan, piaoshijian);
			if(all!=null) {
				session.setAttribute("list", all);
				f=true;
			}
			return f;
		}
		
		//查询公告详情
				public boolean show() throws Exception {
					boolean f=false;
					T_Gonggao tg=ud.show(id);
						if(tg!=null) {
							session.setAttribute("list", tg);
							f=true;
					}
						return f;
				}
		
public String getUserName() {
	return userName;
}

public void setUserName(String userName) {
	this.userName = userName;
}

public String getUserPw() {
	return userPw;
}

public void setUserPw(String userPw) {
	this.userPw = userPw;
}

public String getScore() {
	return score;
}

public void setScore(String score) {
	this.score = score;
}

public T_User getU() {
	return u;
}

public void setU(T_User u) {
	this.u = u;
}

public T_Admin getA() {
	return a;
}

public void setA(T_Admin a) {
	this.a = a;
}

public String getUserPw1() {
	return userPw1;
}

public void setUserPw1(String userPw1) {
	this.userPw1 = userPw1;
}

public T_Yuding getY() {
	return y;
}

public void setY(T_Yuding y) {
	this.y = y;
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getShifazhan() {
	return shifazhan;
}

public void setShifazhan(String shifazhan) {
	this.shifazhan = shifazhan;
}

public String getDaodazhan() {
	return daodazhan;
}

public void setDaodazhan(String daodazhan) {
	this.daodazhan = daodazhan;
}

public String getPiaoshijian() {
	return piaoshijian;
}

public void setPiaoshijian(String piaoshijian) {
	this.piaoshijian = piaoshijian;
}



}
