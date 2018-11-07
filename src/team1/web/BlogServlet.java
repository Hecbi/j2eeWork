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
@WebServlet("/blog")
public class BlogServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private BlogDAO blogDAO = new BlogDAO();
    private CommentDAO commentDAO = new CommentDAO();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BlogServlet() {
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
		//获取调用方法名称
		String method = request.getParameter("method");
		
		if("findOne".equals(method)) {
			String articleId = request.getParameter("id");
			ArrayList<Comment> comment = null;
			Blog blog = null;
			if(articleId != null) {
				blog = blogDAO.findBlogByID(Integer.parseInt(articleId));
				comment = commentDAO.findCommentById(Integer.parseInt(articleId));
			}
			request.setAttribute("blog", blog);
			request.setAttribute("COMMENT_LIST", comment);
			request.getRequestDispatcher("system/articleShow.jsp").forward(request, response);
		} else if("findAll".equals(method)) {
			String page = request.getParameter("page");
			if(page==null){
				page = "1";
			}
			List<Blog> blogList = blogDAO.findAll(Integer.parseInt(page));
			System.out.println("博客息查询结果： " + blogList.size());
			if (blogList.size()==0){
				System.out.println("本页没有结果");
			}
			request.setAttribute("BLOG_LIST", blogList);
			request.getRequestDispatcher("system/articles.jsp").forward(request, response);
		} else if("addComment".equals(method)) {
			String nickname = request.getParameter("nickname");
			String value = request.getParameter("editorValue");
			String articleId = request.getParameter("articleId");
			commentDAO.addComment(articleId,nickname,value);
			request.setAttribute("addCommentResult", "ok");
			request.getRequestDispatcher("system/articleShow.jsp").forward(request, response);
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
