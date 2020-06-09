package com.qst.note.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.qst.note.bean.UserBean;
import com.qst.note.util.DBUtil;

public class UserDao {
	public boolean regist(UserBean user) {
		Connection c=DBUtil.getConnection();
		PreparedStatement pst=null;
		try {
			pst=(PreparedStatement) c.prepareStatement("insert into user(name,pass,tel,qq,wechat) values(?,?,?,?,?)");
			pst.setString(1, user.getName());
			pst.setString(2, user.getPass());
			pst.setString(3, user.getTel());
			pst.setString(4, user.getQq());
			pst.setString(5, user.getWechat());
			pst.execute();
			return true;
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}finally {
			DBUtil.close(c, pst, null);
		}
		return false;
		
	}
	public boolean login(String tel,String pass) {
		Connection c=DBUtil.getConnection();
		PreparedStatement pst=null;
		ResultSet rs=null;
		try {
			pst=(PreparedStatement) c.prepareStatement("select pass from user where tel=?");
			pst.setString(1, tel);
			rs=pst.executeQuery();
			if(rs.first()&&rs.getString("pass").equals(pass)) {
				return true;
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}finally {
			DBUtil.close(c, pst, rs);
		}
		return false;
		
	}
	public int getIDbyTel(String tel) {
		Connection c=DBUtil.getConnection();
		PreparedStatement pst=null;
		ResultSet rs=null;
		int id=0;
		try {
			pst=(PreparedStatement) c.prepareStatement("select id from user where tel=?");
			pst.setString(1, tel);
			rs=pst.executeQuery();
			if(rs.first()) {
				id=rs.getInt("id");
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}finally {
			DBUtil.close(c, pst, rs);
		}
		return id;
	}
	

}
