package team1.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import team1.model.Blog;
import team1.util.CommonValue;

public class BlogDAO {

    /**
     * 获取所有博客信息
     * @return
    */
    public ArrayList<Blog> findAll(int page){
        String dbURL = CommonValue.JDBC_URL;
        String dbUser = CommonValue.JDBC_USER;
        String dbPwd = CommonValue.JDBC_PWD;
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        PreparedStatement stmtA = null;
        ArrayList<Blog> blogList = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(dbURL, dbUser, dbPwd);
            stmt = conn.createStatement();
            String sql = "select count(*) from blog;";
            rs = stmt.executeQuery(sql);
            rs.next();
            if(Integer.parseInt(rs.getString("count(*)"))>10){
                int totalPage = Integer.parseInt(rs.getString("count(*)"))/10;
            }else{
                int totalPage = 1;
            }
            stmt.close();
            stmtA = conn.prepareStatement("Select * from blog where page=?");
            stmtA.setInt(1, page);
            rs = stmtA.executeQuery();
            blogList = new ArrayList<Blog>();
            System.out.println(".......数据库处理中........");
            while(rs.next()) {
                Blog blog = new Blog();
                blog.setTitle(rs.getString("title"));
                blog.setArticleId(rs.getString("articleId"));
                blog.setTime(rs.getString("time"));
                blog.setPage(rs.getString("page"));
                blog.setAuthor(rs.getString("author"));
                blogList.add(blog);
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
        return blogList;
    }


    /**
     * 根据用户名获取所有博客信息
     * @return
     */
    public ArrayList<Blog> findAllbyUsername(String username){
        String dbURL = CommonValue.JDBC_URL;
        String dbUser = CommonValue.JDBC_USER;
        String dbPwd = CommonValue.JDBC_PWD;
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement stmtA = null;
        ArrayList<Blog> blogList = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(dbURL, dbUser, dbPwd);
            stmtA = conn.prepareStatement("Select * from blog where author=?");
            stmtA.setString(1, username);
            rs = stmtA.executeQuery();
            blogList = new ArrayList<Blog>();
            System.out.println(".......数据库处理中........");
            while(rs.next()) {
                Blog blog = new Blog();
                blog.setTitle(rs.getString("title"));
                blog.setArticleId(rs.getString("articleId"));
                blog.setTime(rs.getString("time"));
                blog.setPage(rs.getString("page"));
                blogList.add(blog);
            }
        }catch(Exception ex) {
            System.out.println(".......error......" );
            System.out.println(ex.toString());
        }finally {
            try {
                stmtA.close();
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
        return blogList;
    }


    /**
     * 根据用户名获取一篇博客信息
     * @return
     */
    public Blog findOnebyArticleId(String articleId){
        String dbURL = CommonValue.JDBC_URL;
        String dbUser = CommonValue.JDBC_USER;
        String dbPwd = CommonValue.JDBC_PWD;
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement stmtA = null;
        ArrayList<Blog> blogList = null;
        Blog blog = new Blog();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(dbURL, dbUser, dbPwd);
            stmtA = conn.prepareStatement("Select * from blog where articleId=?");
            stmtA.setString(1, articleId);
            rs = stmtA.executeQuery();
            blogList = new ArrayList<Blog>();
            System.out.println(".......数据库处理中........");
            while(rs.next()) {
                blog.setTitle(rs.getString("title"));
                blog.setArticleId(rs.getString("articleId"));
                blog.setTime(rs.getString("time"));
                blog.setPage(rs.getString("page"));
                blog.setValue(rs.getString("value"));
            }
        }catch(Exception ex) {
            System.out.println(".......error......" );
            System.out.println(ex.toString());
        }finally {
            try {
                stmtA.close();
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
        return blog;
    }

    /**
     * 根据用户名删除博客信息
     * @return
     */
    public ArrayList<Blog> delArticleByArticleId(String articleId){
        String dbURL = CommonValue.JDBC_URL;
        String dbUser = CommonValue.JDBC_USER;
        String dbPwd = CommonValue.JDBC_PWD;
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement stmt = null;
        ArrayList<Blog> blogList = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(dbURL, dbUser, dbPwd);
            stmt = conn.prepareStatement("delete from Blog where articleId=?");
            stmt.setString(1, articleId);
            System.out.println(".......数据库处理中........");
            stmt.executeUpdate();
            blogList = new ArrayList<Blog>();
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
        return blogList;
    }


    /**
     * 根据用户名添加博客信息
     * @return
     */
    public void addArticle(String title, String value, String author){
        String dbURL = CommonValue.JDBC_URL;
        String dbUser = CommonValue.JDBC_USER;
        String dbPwd = CommonValue.JDBC_PWD;
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement stmt = null;
        ArrayList<Blog> blogList = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(dbURL, dbUser, dbPwd);
            stmt = conn.prepareStatement("insert into blog(time,value,page,title,author) values ('time',?,1,?,?)");
            stmt.setString(1, value);
            stmt.setString(2, title);
            stmt.setString(3, author);
            System.out.println(".......数据库处理中........");
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

    /**
     * 根据博客id修改博客信息
     * @return
     */
    public void editArticleByArticleId(String value,String title ,String articleId){
        String dbURL = CommonValue.JDBC_URL;
        String dbUser = CommonValue.JDBC_USER;
        String dbPwd = CommonValue.JDBC_PWD;
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement stmt = null;
        ArrayList<Blog> blogList = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(dbURL, dbUser, dbPwd);
            stmt = conn.prepareStatement("update blog set value=? , title=? where articleId=?");
            stmt.setString(1, value);
            stmt.setString(2, title);
            stmt.setString(3, articleId);
            System.out.println(".......数据库处理中........");
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


    /**
     * 根据博客ID获得博客内容
     * @return
     */
    public Blog findBlogByID(int id){
        String dbURL = CommonValue.JDBC_URL;
        String dbUser = CommonValue.JDBC_USER;
        String dbPwd = CommonValue.JDBC_PWD;
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Blog blog = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(dbURL, dbUser, dbPwd);
            stmt = conn.prepareStatement("Select * from blog where articleId=?");
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            rs.next();
            blog = new Blog();
            blog.setArticleId(rs.getString("articleId"));
            blog.setPage(rs.getString("page"));
            blog.setTime(rs.getString("time"));
            blog.setTitle(rs.getString("title"));
            blog.setValue(rs.getString("value"));

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
        return blog;
    }



    public static void main(String[] args) {
        // TODO Auto-generated method stub
        BlogDAO blogDA = new BlogDAO();
//        System.out.println(blogDA.findAll().size());
    }

}
