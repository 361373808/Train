package com.entity;

import java.io.Serializable;

public class T_Admin implements Serializable{
	private int a_id;
	private String a_userName;
	private String a_userPw;
	private String a_type;

	public int getA_id() {
		return a_id;
	}

	public void setA_id(int a_id) {
		this.a_id = a_id;
	}

	public String getA_userName() {
		return a_userName;
	}

	public void setA_userName(String a_userName) {
		this.a_userName = a_userName;
	}

	public String getA_userPw() {
		return a_userPw;
	}

	public void setA_userPw(String a_userPw) {
		this.a_userPw = a_userPw;
	}

	public String getA_type() {
		return a_type;
	}

	public void setA_type(String a_type) {
		this.a_type = a_type;
	}

}
