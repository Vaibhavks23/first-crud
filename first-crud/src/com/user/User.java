package com.user;

public class User {

	private int emp_id;
	private String name;
	private int age;
	private String position;
	private String uname;
	
	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public User(String name, int age, String position,String username, String pass,String uname) {
		super();
		this.name = name;
		this.age = age;
		this.position = position;
		this.username = username;
		this.pass = pass;
		
	}

	public User(int emp_id, String name, int age, String position) {
		super();
		this.emp_id= emp_id;
		this.name = name;
		this.age = age;
		this.position = position;
		}

	public User(String uname, String username, String pass) {
		super();
		this.uname = uname;
		this.username = username;
		this.pass = pass;
	}

	public User(String name, int age, String position) {
		this.age = age;
		this.name = name;
		this.position = position;
		
	}

	public int getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	private String username;
	private  String pass;
	
	
	
	
	public  String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public  String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	
	
	
}
