package com.qst.note.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.qst.note.bean.NoteBean;
import com.qst.note.util.DBUtil;

public class NoteDao {
	public boolean insert(String title,String content,String noteTime,String tel) {
		int user_id=new UserDao().getIDbyTel(tel);
		if(user_id<1) {
			return false;
		}
		Connection c=DBUtil.getConnection();
		PreparedStatement pst=null;
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
		String nowTime=sdf.format(new Date());
		try {
			pst=(PreparedStatement) c.prepareStatement("insert into note_table(title,content,note_Time,user_id,create_time) values(?,?,?,?,?)");
			pst.setString(1, title);
			pst.setString(2, content);
			pst.setString(3, noteTime);
			pst.setInt(4, user_id);
			pst.setString(5, nowTime);
			pst.execute();
			return true;
	}catch (SQLException e) {
		// TODO 自动生成的 catch 块
		e.printStackTrace();
	}finally {
		DBUtil.close(c, pst, null);
	}
	return false;
	
}
	public NoteBean getNoteByID(int id) {
		NoteBean note=new NoteBean();
		Connection c=DBUtil.getConnection();
		PreparedStatement pst=null;
		ResultSet rs=null;
		try {
			pst=(PreparedStatement) c.prepareStatement("select*from note_table where id=?");
			pst.setInt(1, id);
			rs=pst.executeQuery();
			if(rs.first()) {
				note.setId(id);
				note.setTitle(rs.getString("title"));
				note.setContent(rs.getString("content"));
				note.setCreateTime(rs.getString("create_Time"));
				note.setUpdateTime(rs.getString("update_Time"));
				note.setNoteTime(rs.getString("note_Time"));
				note.setUserId(rs.getInt("user_Id"));
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}finally {
			DBUtil.close(c, pst, rs);
		}
		return note;
		
	}
	public boolean ModifyNote(int id,String title,String content,String noteTime) {
		if(id<1)
			return false;
		Connection c=DBUtil.getConnection();
		PreparedStatement pst=null;
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
		String nowTime=sdf.format(new Date());
		try {
			pst=(PreparedStatement) c.prepareStatement("update note_table set title=?,content=?,note_Time=?,update_time=?where id=?");
			pst.setString(1, title);
			pst.setString(2, content);
			pst.setString(3, noteTime);
			pst.setString(4, nowTime);
			pst.setInt(5, id);
			pst.execute();
			return true;
	}catch (SQLException e) {
		// TODO 自动生成的 catch 块
		e.printStackTrace();
	}finally {
		DBUtil.close(c, pst, null);
	}
	return false;
	
}
	public ArrayList<NoteBean> getAllNotes(String tel) {
		ArrayList<NoteBean> all=new ArrayList<>();
		int id=new UserDao().getIDbyTel(tel);
		Connection c=DBUtil.getConnection();
		PreparedStatement pst=null;
		ResultSet rs=null;
		try {
			pst=(PreparedStatement) c.prepareStatement("select * from note_table where user_id=?");
			pst.setInt(1, id);
			rs=pst.executeQuery();
			while(rs.next()) {
				NoteBean note=new NoteBean();
				note.setId(rs.getInt("id"));
				note.setTitle(rs.getString("title"));
				note.setContent(rs.getString("content"));
				note.setCreateTime(rs.getString("create_Time"));
				note.setUpdateTime(rs.getString("update_Time"));
				note.setNoteTime(rs.getString("note_Time"));
				note.setUserId(rs.getInt("user_Id"));
				all.add(note);
			}
	}catch (SQLException e) {
		// TODO 自动生成的 catch 块
		e.printStackTrace();
	}finally {
		DBUtil.close(c, pst, null);
	}
	return all;
	
}
	public boolean deleteById(int id) {
		Connection c=DBUtil.getConnection();
		PreparedStatement pst=null;
		try {
			pst=(PreparedStatement) c.prepareStatement("delete from note_table where id=?");
			pst.setInt(1, id);
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

}
