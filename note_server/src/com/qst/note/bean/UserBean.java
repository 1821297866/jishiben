package com.qst.note.bean;

public class UserBean {
	private int id;
	private String name;
	private String pass;
	private String tel;
	private String qq;
	private String wechat;

	public UserBean() {
		super();
	}
	public UserBean(int id, String name, String pass, String tel, String qq, String wechat) {
		super();
		this.id = id;
		this.name = name;
		this.pass = pass;
		this.tel = tel;
		this.qq = qq;
		this.wechat = wechat;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	public String getWechat() {
		return wechat;
	}
	public void setWechat(String wechat) {
		this.wechat = wechat;
	}
	

}
