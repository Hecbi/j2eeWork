package team1.dao;

import team1.model.Comment;
import team1.util.CommonValue;

import java.sql.*;
import java.util.ArrayList;

public class CommentDAO {
    public ArrayList<Comment> findCommentById(int id){
        String dbURL = CommonValue.JDBC_URL;
        String dbUser = CommonValue.JDBC_USER;
        String dbPwd = CommonValue.JDBC_PWD;
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<Comment> commentList = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(dbURL, dbUser, dbPwd);
            stmt = conn.prepareStatement("Select * from comment where articleId=?");
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            commentList = new ArrayList<Comment>();
            System.out.println(".......数据库处理中........");
            while(rs.next()) {
                Comment comment = new Comment();
                comment.setNickname(rs.getString("nickname"));
                comment.setValue(rs.getString("value"));
                commentList.add(comment);
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
        return commentList;
    }

    public void addComment(String articleId, String nickname, String value){
        String dbURL = CommonValue.JDBC_URL;
        String dbUser = CommonValue.JDBC_USER;
        String dbPwd = CommonValue.JDBC_PWD;
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(dbURL, dbUser, dbPwd);
            stmt = conn.prepareStatement("insert into comment (articleId,nickname,value) values (?,?,?)");
            stmt.setString(1, articleId);
            stmt.setString(2, nickname);
            stmt.setString(3, value);
            stmt.executeUpdate();
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
    }
}
