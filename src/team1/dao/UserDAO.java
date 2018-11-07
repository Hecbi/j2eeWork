package team1.dao;

import team1.util.CommonValue;

import java.sql.*;

public class UserDAO {
    public boolean checkLogin(String username, String password) {
        String dbURL = CommonValue.JDBC_URL;
        String dbUser = CommonValue.JDBC_USER;
        String dbPwd = CommonValue.JDBC_PWD;
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(dbURL, dbUser, dbPwd);
            stmt = conn.prepareStatement("Select username,password from user where username=? and password=?");
            stmt.setString(1, username);
            stmt.setString(2, password);
            rs = stmt.executeQuery();

            // 通过是否有next判断是否存在这个用户
            if(rs.next()!=true) {
                return false;
            }
        }catch(Exception ex) {
            System.out.println(".......error......" );
            System.out.println(ex.toString());
            return false;
        }finally {
            try {
                stmt.close();
            } catch (SQLException ex) {
                System.out.println(".......statment's error......" );
                System.out.println(ex.toString());
                return false;
            }
            try {
                conn.close();
            } catch (SQLException ex) {
                System.out.println(".......connection's error......" );
                System.out.println(ex.toString());
                return false;
            }
        }
        return true;
    }

    // 注册
    public boolean register(String username, String password) {
        String dbURL = CommonValue.JDBC_URL;
        String dbUser = CommonValue.JDBC_USER;
        String dbPwd = CommonValue.JDBC_PWD;
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        PreparedStatement stmtA = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(dbURL, dbUser, dbPwd);

            stmtA = conn.prepareStatement("select username from user where username=?");
            stmtA.setString(1, username);
            rs = stmtA.executeQuery();
            if (rs.next()!=false){
                System.out.println(".......注册同样id的用户........");
                stmtA.close();
                return false;
            }
            stmt = conn.prepareStatement("insert into user values (?,?)");
            stmt.setString(1, username);
            stmt.setString(2, password);
            System.out.println(".......数据库处理中........");
            stmt.executeUpdate();
        }catch(Exception ex) {
            System.out.println(".......error......" );
            System.out.println(ex.toString());
            return false;
        }finally {
            try {
                if (stmt != null){
                    stmt.close();
                }
            } catch (SQLException ex) {
                System.out.println(".......statment's error......" );
                System.out.println(ex.toString());
                return false;
            }
            try {
                conn.close();
            } catch (SQLException ex) {
                System.out.println(".......connection's error......" );
                System.out.println(ex.toString());
                return false;
            }
        }
        return true;
    }
}
