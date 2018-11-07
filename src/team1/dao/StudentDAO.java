package team1.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import team1.model.Student;
import team1.util.CommonValue;

public class StudentDAO {
	
	/**
	 * 获取所有学生信息
	 * @return
	 */
	public ArrayList<Student> findAll(){
		String dbURL = CommonValue.JDBC_URL;
		String dbUser = CommonValue.JDBC_USER;
		String dbPwd = CommonValue.JDBC_PWD;
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<Student> stuList = null; 
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(dbURL, dbUser, dbPwd);
			stmt = conn.createStatement();
			String sql = "Select * from students";
			rs = stmt.executeQuery(sql);
			stuList = new ArrayList<Student>();
			System.out.println(".......数据库处理中........");
			while(rs.next()) {
				Student stu = new Student();
				stu.setId(rs.getInt("id"));
				stu.setStuName(rs.getString("stu_name"));
				stu.setAge(rs.getInt("age"));
				stu.setEmail(rs.getString("email"));
				stu.setTel(rs.getString("tel"));
				stu.setPicUrl(rs.getString("pic_url"));
				stuList.add(stu);
			}

		}catch(Exception ex) {
			System.out.println(".......error......" );
			System.out.println(ex.toString());
		}finally {
			try {
				stmt.close();
			} catch (SQLException ex) {
				System.out.println(".......statment's error......" );
				System.out.println(ex.toString());
			}
			try {
				conn.close();
			} catch (SQLException ex) {
				System.out.println(".......connection's error......" );
				System.out.println(ex.toString());
			}
		}
		return stuList;	
	}

	
	/**
	 * 根据学生ID获得学生信息
	 * @return
	 */
	public Student findStudentByID(int id){
		String dbURL = CommonValue.JDBC_URL;
		String dbUser = CommonValue.JDBC_USER;
		String dbPwd = CommonValue.JDBC_PWD;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Student stu = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(dbURL, dbUser, dbPwd);
			stmt = conn.prepareStatement("Select * from students where id=?");
			stmt.setInt(1, id);
			rs = stmt.executeQuery();
			while(rs.next()) {
				stu = new Student();
				stu.setId(rs.getInt("id"));
				stu.setStuName(rs.getString("stu_name"));
				stu.setAge(rs.getInt("age"));
				stu.setEmail(rs.getString("email"));
				stu.setTel(rs.getString("tel"));
				stu.setPicUrl(rs.getString("pic_url"));
			}

		}catch(Exception ex) {
			System.out.println(".......error......" );
			System.out.println(ex.toString());
		}finally {
			try {
				stmt.close();
			} catch (SQLException ex) {
				System.out.println(".......statment's error......" );
				System.out.println(ex.toString());
			}
			try {
				conn.close();
			} catch (SQLException ex) {
				System.out.println(".......connection's error......" );
				System.out.println(ex.toString());
			}
		}
		return stu;	
	}

	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StudentDAO stuDao = new StudentDAO();
		System.out.println(stuDao.findAll().size());
	}

}
