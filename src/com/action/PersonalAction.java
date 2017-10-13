package com.action;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.dao.PersonalDao;
import com.entity.T_User;
import com.entity.T_Yuding;
import com.opensymphony.xwork2.ActionSupport;

public class PersonalAction extends ActionSupport{
	private T_User tu;
	private String name;
	private int id;
	private String userPw1;
	private int  u_id;
	private String op;
	
	HttpServletRequest request=ServletActionContext.getRequest();
	HttpSession session=request.getSession();
	PersonalDao pd=new PersonalDao();
	
	@Override
	public String execute() throws Exception {
		String res=null;
		if("ppw".equals(op)) {
			if(this.Pw())
				res="changepw";
		}if("pxx".equals(op)) {
			if(this.userxinxi())
				res="pxx";
		}if("score".equals(op)) {
		    if(this.score()){
			res="score";
		}
		}
		if("userpiao".equals(op)) {
			if(this.piaoall()!=null) {
				res="userpiao";
			}else {
				res="userpiao";
			}
		}
		return res;
	}

	//修改个人密码
		public boolean Pw() throws SQLException {
			if(pd.Pw(name, userPw1)) {
				return true;
			}
			return false;
		}
		
		// 用户信息
				public boolean userxinxi() throws SQLException {
					T_User t=pd.userxinxi(u_id);
					if(t!=null) {
						session.setAttribute("user", t);
						return true;
					}
					return false;
				}
		
	
				//查看当前用户的积分
				public boolean score() throws SQLException {
					int i=pd.score(id);
					session.setAttribute("score", i);
					return true;
				}
				
				
				// 当前用户的车票订单
				public List<T_Yuding> piaoall() throws SQLException{
					List<T_Yuding> list=pd.piaoall(id);
					session.setAttribute("list", list);
					return list;
				}
				
				
	public T_User getTu() {
		return tu;
	}

	public void setTu(T_User tu) {
		this.tu = tu;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserPw1() {
		return userPw1;
	}

	public void setUserPw1(String userPw1) {
		this.userPw1 = userPw1;
	}

	public String getOp() {
		return op;
	}

	public void setOp(String op) {
		this.op = op;
	}
	
	
}
