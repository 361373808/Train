package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.entity.T_Admin;
import com.entity.T_Checi;
import com.entity.T_Gonggao;
import com.entity.T_Liuyan;
import com.entity.T_User;
import com.entity.T_Yuding;
import com.util.SqlConn;

public class ManagerDao {
	SqlConn s = new SqlConn();
	boolean f = false;

	// 所有管理员
	public List<T_Admin> adminMana() {
		List<T_Admin> list = new ArrayList<T_Admin>();
		try {
			String sql = "select * from t_admin where a_type='管理员'";
			ResultSet rs = s.query(sql);
			while (rs.next()) {
				T_Admin ad = new T_Admin();
				ad.setA_id(rs.getInt(1));
				ad.setA_userName(rs.getString(2));
				ad.setA_userPw(rs.getString(3));
				ad.setA_type(rs.getString(4));
				list.add(ad);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	// 删除管理员
	public boolean del(String id) throws SQLException {
		String sql = "delete from t_admin where a_id=?";
		int i = s.update(sql, id);
		if (i != 0) {
			f = true;
		}
		return f;
	}

	// 车次查询
	public List<T_Checi> checi() throws SQLException {
		List<T_Checi> list = new ArrayList<T_Checi>();
		ResultSet rs = null;
		String sql = "select * from t_checi";
		rs = s.query(sql);
		while (rs.next()) {
			T_Checi tc = new T_Checi();
			tc.setC_id(rs.getInt("c_id"));
			tc.setShifazhan(rs.getString("shifazhan"));
			tc.setDaodazhan(rs.getString("daodazhan"));
			tc.setPiaoshijian(rs.getString("piaoshijian"));
			tc.setStartshijian(rs.getString("startshijian"));
			tc.setEndshijian(rs.getString("endshijian"));
			tc.setCtype(rs.getString("ctype"));
			tc.setPiaojia(rs.getInt("piaojia"));
			tc.setPiaoshu(rs.getInt("piaoshu"));
			tc.setDel(rs.getString("del"));
			list.add(tc);
		}
		return list;
	}

	// 修改时车次查询      & 	 交易订单的车次信息
	public T_Checi checie(int id) throws SQLException {
		T_Checi tc = null;
		ResultSet rs = null;
		String sql = "select * from t_checi where c_id=?";
		rs = s.query(sql, id);
		while (rs.next()) {
			tc = new T_Checi();
			tc.setC_id(rs.getInt("c_id"));
			tc.setShifazhan(rs.getString("shifazhan"));
			tc.setDaodazhan(rs.getString("daodazhan"));
			tc.setPiaoshijian(rs.getString("piaoshijian"));
			tc.setStartshijian(rs.getString("startshijian"));
			tc.setEndshijian(rs.getString("endshijian"));
			tc.setCtype(rs.getString("ctype"));
			tc.setPiaojia(rs.getInt("piaojia"));
			tc.setPiaoshu(rs.getInt("piaoshu"));
			tc.setDel(rs.getString("del"));
		}
		return tc;
	}

	// 添加车次
	public boolean addChe(T_Checi tc) {
		try {
			String sql = "insert into t_checi(c_id,shifazhan,daodazhan,piaoshijian,startshijian,endshijian,piaojia,piaoshu) values(tcheci_id.nextval,?,?,?,?,?,?,?)";
			int row = s.update(sql, tc.getShifazhan(), tc.getDaodazhan(), tc.getPiaoshijian(), tc.getStartshijian(),
					tc.getEndshijian(), tc.getPiaojia(), tc.getPiaoshu());
			if (row != 0) {
				f = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return f;
	}

	// 车次编辑
	public boolean editChe(T_Checi tc) {
		try {
			String sql = "update t_checi set shifazhan=?,daodazhan=?,piaoshijian=?,startshijian=?,endshijian=?,piaojia=?,piaoshu=? where c_id";
			int row = s.update(sql, tc.getShifazhan(), tc.getDaodazhan(), tc.getPiaoshijian(), tc.getStartshijian(),
					tc.getEndshijian(), tc.getPiaojia(), tc.getPiaoshu());
			if (row != 0)
				f = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return f;
	}

	// 车次删除
	public boolean delChe(int id) throws SQLException {
		String sql = "delete  from t_checi where c_id=?";
		int row = s.update(sql, id);
		if (row != 0) {
			return true;
		} else {
			return false;
		}
	}

	// 所有车票订单
	public List<T_Yuding> piaoall() throws SQLException {
		List<T_Yuding> list = new ArrayList<T_Yuding>();
		String sql = "select * from T_Yuding";
		ResultSet rs = s.query(sql);
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
	/*
	 * //添加订单 public boolean add(T_Yuding ty) { String
	 * sql="update t_yuding piaoshu=(piaoshu-?) where c_id=?"; int row=s.update(sql,
	 * ty.getYudingshumu(),ty.getC_id());
	 * 
	 * }
	 */

	// 受理的操作
	public boolean shouli(int id) throws SQLException {
		T_Yuding ty = null;
		String sql = "select * from t_yuding where id=?";
		ResultSet rs = s.query(sql, id);
		if (rs.next()) {
			ty = new T_Yuding();
			ty.setId(rs.getInt("id"));
			ty.setC_id(rs.getInt("c_id"));
			ty.setU_id(rs.getInt("u_id"));
			ty.setYudingshumu(rs.getInt("yudingshumu"));
			ty.setYudingjine(rs.getInt("yudingjine"));
			ty.setZhifufangshi(rs.getString("zhifufangshi"));
			ty.setYuding_shijian(rs.getString("yuding_shijian"));
			ty.setZhuangtai(rs.getString("yuding_zhuangtai"));
		}
		String sqll = "update t_yuding set yuding_zhuangtai='已受理' where id=?";
		int row = s.update(sqll, id);
		if (row != 0) {
			this.sl_late(ty);
			return true;
		}
		return false;
	}

	// 受理之后的操作
	public boolean sl_late(T_Yuding ty) throws SQLException {
		String sql0="update t_checi set piaoshu=piaoshu-? where c_id=?";
		int row0=s.update(sql0, ty.getYudingshumu(),ty.getC_id());
		if(row0!=0) {
		String sql = "update t_user score=(score+?) where u_id=?";
		int row = s.update(sql, ty.getYudingshumu(), ty.getU_id());
		if (row != 0) {
			String sql3 = "select * from t_user where u_id=?";
			ResultSet rs = s.query(sql3, ty.getU_id());
			if (rs.next()) {
				int score = rs.getInt("score");
				if (score > 15) {
					String sql5 = "update t_user u_type='高级会员' where u_id=?";
					int row2 = s.update(sql5, ty.getU_id());
				} else if (score > 30) {
					String sql5 = "update t_user u_type='超级会员' where u_id=?";
					int row2 = s.update(sql5, ty.getU_id());
				}
				return true;
			}
		}}
		return false;
	}

	// 删除订单
	public boolean deldd(int id) throws SQLException {
		String sql = "delete from t_yuding where id=?";
		int row = s.update(sql, id);
		if (row != 0) {
			return true;
		}
		return false;
	}

	// 交易订单的用户信息
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
	
	//公告添加
	public boolean ggadd(T_Gonggao tg) throws SQLException {
		Date date=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String d=sdf.format(date);
		String sql="insert into t_gonggao values(tgonggao_id.nextval,?,?,?,?)";
		int row=s.update(sql, tg.getTitle(),tg.getContent(),d,tg.getA_id());
		if(row!=0) {
			return true;
		}
		return false;
	}
	
	//显示所有公告
	public List<T_Gonggao> gonggao() throws SQLException {
		System.out.println("显示所有公告");
		List<T_Gonggao> list = new ArrayList<T_Gonggao>();
		T_Gonggao tg=null;
		String sql = "select * from T_Gonggao";
		ResultSet rs = s.query(sql);
		while (rs.next()) {
			tg = new T_Gonggao();
			tg.setId(rs.getInt("id"));
			tg.setTitle(rs.getString("title"));
			tg.setContent(rs.getString("content"));
			tg.setShijian(rs.getString("shijian"));
			tg.setA_id(rs.getInt("a_id"));
			list.add(tg);
		}
		return list;
	}
	//显示所有留言
	public List<T_Liuyan> liuyan() throws SQLException {
		List<T_Liuyan> list = new ArrayList<T_Liuyan>();
		T_Liuyan ly=null;
		String sql = "select * from T_liuyan";
		ResultSet rs=s.query(sql);
		while (rs.next()) {
			ly = new T_Liuyan();
			ly.setId(rs.getInt("id"));
			ly.setTitle(rs.getString("title"));
			ly.setContent(rs.getString(3));
			ly.setShijian(rs.getString("shijian"));
			ly.setU_id(rs.getInt("u_id"));
			list.add(ly);
		}
		return list;
	}
	
	//显示某一公告内容
	public String content(int id) throws SQLException {
		String sql="select content from t_gonggao where id=?";
		ResultSet rs=s.query(sql, id);
		String c=null;
		if(rs.next()) {
			c =rs.getString("content");
		}
		return c;
	}
	
	//删除某一公告
		public boolean delcon(int id) throws SQLException {
				String sql="delete from t_gonggao where id=?";
				int row=s.update(sql, id);
				if(row!=0) {
					return true;
				}
				return false;
			}
		//删除某一留言
		public boolean delliu(int id) throws SQLException {
			String sql="delete from t_liuyan where id=?";
			int row=s.update(sql, id);
			if(row!=0) {
				return true;
			}
			return false;
		}
}
