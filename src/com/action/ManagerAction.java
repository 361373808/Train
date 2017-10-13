package com.action;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.dao.ManagerDao;
import com.entity.T_Admin;
import com.entity.T_Checi;
import com.entity.T_Gonggao;
import com.entity.T_Liuyan;
import com.entity.T_User;
import com.entity.T_Yuding;
import com.opensymphony.xwork2.ActionSupport;

public class ManagerAction extends ActionSupport{
	private T_Admin a;
	private T_Checi tc;
	private T_Gonggao tg;
	private T_User tu;
	private T_Checi  checi;
	private String a_id;
	private String op;
	private String title;
	private String content;
	private int c_id;
	private int u_id;
	private int id;
	private T_Yuding ty;
	
	HttpServletRequest request=ServletActionContext.getRequest();
	HttpSession session=request.getSession();
	
	ManagerDao md=new ManagerDao();
	boolean f=false;
	@Override
	public String execute() throws Exception {
		String res=null;
		if("am".equals(op)){
			if(this.adminMana()){
				res="am";
			}
		}
		if("del".equals(op)){
			if(this.del()){
				res="del";
			}
		}if("cm".equals(op)) {
			if(this.checi())
				res="cm";
		}if("ac".equals(op)) {
			if(this.addche())
				res="ac";
		}if("ce".equals(op)) {
			if(this.editChe())
				res="ce";
		}if("ec".equals(op)) {
			if(this.checie())
				res="ec";
		}if("ec2".equals(op)) {
			if(this.checie2())
				res="ec2";
		}if("dc".equals(op)) {
			if(this.delche()) 
				res="dc";
		}if("yda".equals(op)){
			if(this.piaoall())
				res="all";
		}if("shouli".equals(op)) {
			if(this.shouli()) 
				res="sl";
		}if("deldd".equals(op)) {
			if(this.deldd()) 
				res="dd";
		}if("uxx".equals(op)) {
			if(this.userxinxi()) 
				res="uxx";
		}if("gga".equals(op)) {
			if(this.ggadd())
				res="ggadd";
		}if("gg".equals(op)) {
			if(this.gonggao()!=null)
				res="gg";
		}if("liuyan".equals(op)) {
			if(this.liuyan()!=null) {
				res="ly";
			}else {
				res="ly";
			}
		}if("con".equals(op)) {
			if(this.content()) 
				res="content";
		}if("delcon".equals(op)) {
			if(this.delcon())
				res="delcon";
		}if("delliu".equals(op)) {
		if(this.delliu())
			res="delliu";
	}
			
		return res;
	}

	//所有管理员信息
	public boolean adminMana(){
		List<T_Admin> list=md.adminMana();
		session.setAttribute("admin", list);
		return true;
	}
	//删除会员[
	public boolean del() throws SQLException{
		if(md.del(a_id)){
			f=true;
		}
		return f;
	}
	
	//管理车次信息
	public boolean checi() throws SQLException{
		List<T_Checi> list=md.checi();
		if(list!=null) {
		session.setAttribute("list", list);
		f=true;
		}
		return f;
	}
	
	//查询出车次信息编辑页面用
	public boolean checie() throws SQLException{
		tc=md.checie(c_id);
		if(tc!=null)
			f=true;
		return f;
	}
	//订单中查询出车次信息
	public boolean checie2() throws SQLException{
		T_Checi t=md.checie(c_id);
		if(t!=null)
			request.setAttribute("checi", t);
			f=true;
		return f;
	}
	//添加车次
	public boolean addche() {
		if(md.addChe(tc))
			f=true;
		return f;
	}
	
	//车次编辑
	public boolean editChe() {
		md.editChe(tc);
			f=true;
		return f;
	}
		
	//车次删除
	public boolean delche() throws SQLException {
		boolean f=md.delChe(c_id);
		return f;
	}
	
	//所有车票订单
	public boolean piaoall() throws SQLException {
		List<T_Yuding> list1=md.piaoall();
		if(list1!=null) {
			session.setAttribute("list1", list1);
			return true;
		}else {
			return false;
		}
	}
	
	//受理及之后的操作
	public boolean shouli() throws SQLException {
		if(md.shouli(id)) {
			return true;
		}
		return false;
	}
	
	//删除订单
		public boolean deldd() throws SQLException {
			if(md.deldd(id)) {
				return true;
			}
			return false;
		}
	
		// 交易订单的用户信息
		public boolean userxinxi() throws SQLException {
			T_User t=md.userxinxi(u_id);
			if(t!=null) {
				request.setAttribute("user", t);
				return true;
			}
			return false;
		}

		//公告添加
		public boolean ggadd() throws SQLException {
			if(md.ggadd(tg)) {
				return true;
			}
			return false;
		}
		
		
		//显示所有公告
		public List<T_Gonggao> gonggao() throws SQLException{
			List<T_Gonggao> lt =md.gonggao();
			if(lt!=null) {
				request.setAttribute("gg", lt);
			}
			return lt;
		}
		
		//显示所有留言
		public List<T_Liuyan> liuyan() throws SQLException{
			List<T_Liuyan> liu=md.liuyan();
			if(liu!=null) {
				request.setAttribute("ly", liu);
			}
			return liu;
		}
		
		//显示某一公告内容
		public boolean content() throws SQLException {
			String c=md.content(id);
			request.setAttribute("gonggao", c);
			return true;
		}
		
		//删除某一公告
		public boolean delcon() throws SQLException {
			if(md.delcon(id)) {
				return true;
			}
			return false;
		}
		
		//删除某一留言
		public boolean delliu() throws SQLException {
			if(md.delliu(id)) {
				return true;
			}
			return false;
		}
		
	public String getOp() {
		return op;
	}

	public void setOp(String op) {
		this.op = op;
	}

	public T_Admin getA() {
		return a;
	}

	public void setA(T_Admin a) {
		this.a = a;
	}

	public String getA_id() {
		return a_id;
	}

	public void setA_id(String a_id) {
		this.a_id = a_id;
	}

	public T_Checi getTc() {
		return tc;
	}

	public void setTc(T_Checi tc) {
		this.tc = tc;
	}

	public Integer getC_id() {
		return c_id;
	}

	public void setC_id(Integer c_id) {
		this.c_id = c_id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setC_id(int c_id) {
		this.c_id = c_id;
	}

	public int getU_id() {
		return u_id;
	}

	public void setU_id(int u_id) {
		this.u_id = u_id;
	}

	public T_Gonggao getTg() {
		return tg;
	}

	public void setTg(T_Gonggao tg) {
		this.tg = tg;
	}

	public T_User getTu() {
		return tu;
	}

	public void setTu(T_User tu) {
		this.tu = tu;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public T_Yuding getTy() {
		return ty;
	}

	public void setTy(T_Yuding ty) {
		this.ty = ty;
	}


	
}
