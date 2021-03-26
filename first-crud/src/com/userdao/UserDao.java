package com.userdao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.user.User;

public class UserDao {

	private static String jdbcURL = "jdbc:mysql://localhost:3306/project1?useSSL=false";
	private static String jdbcUsername = "root";
	private static String jdbcPassword = "root";

	private static final String SELECT_Login = "select * from pass where login = ? and Passw = ? ";
	private static final String INSERT_user_SQL = "INSERT INTO user" + " (emp_id,name,age,position) VALUES" + " (?,?,?,?);";

	private static final String SELECT_user_BY_EMP_ID = "select emp_id,name ,age,position from user where emp_id = ?";
	private final String SELECT_ALL_user = "select * from user";
	private static final String DELETE_user_SQL = "delete from user where emp_id =?;";
	private static final String UPDATE_user_SQL = "update user set name = ?,age =?,position=? where emp_id =?;";
	private static final String INSERT_Pass = "INSERT INTO pass" + " (name,login,passw) VALUES" + " (?,?,?);";

	public static Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return connection;
	}

	public static void insertpass(User pass) throws Exception {

		try (Connection connection = getConnection(); 
				PreparedStatement preparedstatement = connection.prepareStatement(INSERT_Pass)) {
			preparedstatement.setString(1, pass.getUname());
			preparedstatement.setString(2, pass.getUsername());
			preparedstatement.setString(3, pass.getPass());
			preparedstatement.executeUpdate();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	// login
	
	public static boolean validate(User pass) throws ClassNotFoundException {
		boolean status = false;

		try (Connection connection = getConnection(); 
				PreparedStatement preparedstatement = connection.prepareStatement(SELECT_Login)) {
			preparedstatement.setString(1, pass.getUsername());
			preparedstatement.setString(2, pass.getPass());
			System.out.println(preparedstatement);
			ResultSet rs = preparedstatement.executeQuery();
			status = rs.next();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}
	
	//create/insert
	public static void insert(User user) throws Exception {

		try (Connection connection = getConnection(); 
				PreparedStatement preparedstatement = connection.prepareStatement(INSERT_user_SQL)) {
			preparedstatement.setInt(1, user.getEmp_id());
			preparedstatement.setString(2, user.getName());
			preparedstatement.setInt(3, user.getAge());
			preparedstatement.setString(4, user.getPosition());
			preparedstatement.executeUpdate();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// update
	public boolean update(User user) throws Exception {
		boolean rowUpdated;
		try (Connection connection = getConnection(); 
			PreparedStatement preparedstatements = connection.prepareStatement(UPDATE_user_SQL)) {
			preparedstatements.setString(1, user.getName());
			preparedstatements.setInt(2, user.getAge());
			preparedstatements.setString(3, user.getPosition());
			preparedstatements.setInt(4, user.getEmp_id());

			rowUpdated = preparedstatements.executeUpdate() > 0;
			connection.close();
		}
		return rowUpdated;

	}

	//edit
	
	public  User select(int emp_id) {

		User newuser = null;

		try (

				Connection connection = getConnection();
				PreparedStatement preparedstatement = connection.prepareStatement(SELECT_user_BY_EMP_ID);) {
			preparedstatement.setInt(1, emp_id);
			System.out.println(preparedstatement);
			ResultSet rs = preparedstatement.executeQuery();
			while (rs.next()) {
				String name = rs.getString("name");
				int age = (int) rs.getLong("age");
				String position = rs.getString("position");

				newuser = new User(emp_id, name, age, position);
				
			}
			rs.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return newuser;
	}

	//view
	public List<User> selectAllUsers() {
		List<User> users = new ArrayList<>();
		try (Connection connection = getConnection();

				PreparedStatement preparedstatement = connection.prepareStatement(SELECT_ALL_user);) {
			System.out.println(preparedstatement);
			ResultSet rs = preparedstatement.executeQuery();

			while (rs.next()) {
				int emp_id = (int) rs.getLong("emp_id");
				String name = rs.getString("name");
				int age = (int) rs.getLong("age");
				String position = rs.getString("position");

			 users.add(new User(emp_id, name, age, position));
			}
		rs.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
	}

	
	//delete
	public static boolean delete(int emp_id) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(DELETE_user_SQL);) {
			statement.setInt(1, emp_id);
			rowDeleted = statement.executeUpdate() > 0;
			connection.close();
		}
		return rowDeleted;
	}

}
