package team1.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import team1.dao.BlogDAO;
import team1.dao.CommentDAO;
import team1.model.Blog;
import team1.model.Comment;


/**
 * Servlet implementation class BlogServlet
 */
@WebServlet("/admin")
public class AdminServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private BlogDAO blogDAO = new BlogDAO();
    private CommentDAO commentDAO = new CommentDAO();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //設置編碼格式
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        HttpSession session = request.getSession(false);

        if(session==null){
            // 没有登录成功，跳转到登录页面
            response.sendRedirect(request.getContextPath()+"/login");
            return;
        }

        if((String)session.getAttribute("loginName")==null){
            // 没有登录成功，跳转到登录页面
            response.sendRedirect(request.getContextPath()+"/login");
            return;
        }
        String loginName = (String)session.getAttribute("loginName");
        String method = request.getParameter("method");
        if("edit".equals(method)) {
            // 取出文章
            String articleId = request.getParameter("id");
            Blog blog = blogDAO.findOnebyArticleId(articleId);
            request.setAttribute("blog", blog);
            request.getRequestDispatcher("system/admin_edit.jsp").forward(request, response);
        } else if("doEdit".equals(method)) {
            // 修改文章
            String articleId = request.getParameter("id");
            String value = request.getParameter("editorValue");
            String title = request.getParameter("title");
            blogDAO.editArticleByArticleId(value, title, articleId);
            response.sendRedirect(request.getContextPath()+"/admin?method=list&message=editsuccess");
//            request.getRequestDispatcher("system/admin.jsp?message=editsuccess").forward(request, response);
        } else if("delete".equals(method)) {
            // 删除文章
            String articleId = request.getParameter("id");
            blogDAO.delArticleByArticleId(articleId);
            response.sendRedirect(request.getContextPath()+"/admin?method=list&message=deletesuccess");
//            request.getRequestDispatcher("system/admin.jsp?message=deletesuccess").forward(request, response);
        } else if("list".equals(method)){
            // 列出文章
            List<Blog> blogList = blogDAO.findAllbyUsername(loginName);
            request.setAttribute("BLOG_LIST", blogList);
            request.setAttribute("username", loginName);
            request.getRequestDispatcher("system/admin.jsp").forward(request, response);
        }else if("addArticle".equals(method)){
            request.getRequestDispatcher("system/admin_add.jsp").forward(request, response);
        }else if("doAddArticle".equals(method)){
            // 添加文章
            String value = request.getParameter("editorValue");
            String title = request.getParameter("title");
            blogDAO.addArticle(title,value,loginName);
            response.sendRedirect(request.getContextPath()+"/admin?method=list&message=addsuccess");
//            request.getRequestDispatcher("system/admin.jsp?message=addsuccess").forward(request, response);
        }
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}
