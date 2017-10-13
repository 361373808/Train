package com.action;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.opensymphony.xwork2.ActionSupport;
import com.util.SqlConn;

public class StreamResultAction extends ActionSupport{	
	private InputStream inputStream;
	private String name;

	SqlConn s = new SqlConn();
	
	public  String execute() throws Exception{
		String result = null;
		String res=null;
		if(name==null||"".equals(name))
			result = "<font color='red'>用户名不能为空</font>";
		else if("hava".equals(this.res()))
			result = "<font color='red'>该用户名已使用</font>";
		else if("not".equals(this.res()))
			result = "<font color='green'>用户名可以使用</font>";
		inputStream = new ByteArrayInputStream(result.getBytes("utf-8"));
		return SUCCESS;
	}
	
	public String res(){
		String res=null;
		SqlConn db=new SqlConn();
		String ss="select count(*) from t_user";
		int k=0;
		try{
		ResultSet rr=db.query(ss);
			if(rr.next()){
				k=rr.getInt(1);
			}
			String sql="select u_name from t_user";
			ResultSet rs=db.query(sql);
			int i=0;
					while(rs.next()){
						i++;
						if(name.equals(rs.getString(1))){
							res="hava";
							break;
						}
						if(i==k){
							res="not";
						}
					}
		}catch(Exception e){
			e.printStackTrace();
		}
		return res;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	
	
}
