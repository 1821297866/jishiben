package com.qst.note.util;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Connection;

public class DBUtil {
	static String name="root";
	static String pass="mysql";
	static String url="jdbc:mysql://localhost:3306/note";
	public static Connection getConnection() {
		Connection c=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			c=(Connection) DriverManager.getConnection(url, name, pass);
		} catch (ClassNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return c;
	}
	public static void close(Connection c,Statement stat,ResultSet rs)
	{
		if(c!=null) {
			try {
				c.close();
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
		if(stat!=null) {
			try {
				stat.close();
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
		if(rs!=null) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
	}

}
