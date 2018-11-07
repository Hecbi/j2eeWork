package team1.web;


import team1.dao.UserDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Servlet implementation class BlogServlet
 */
@WebServlet("/login")
public class UserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
//    private UserDAO userDAO = new UserDAO();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /*
    登录
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //設置編碼格式
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        HttpSession session = request.getSession(false);

        // 注销
        if(request.getParameter("logout")!=null) {
            session.removeAttribute("loginName");
            response.sendRedirect(request.getContextPath()+"/");
            return;
        }

        // 注册
        if(request.getParameter("register")!=null) {
            request.getRequestDispatcher("system/register.jsp").forward(request, response);
            return;
        }

        // 登录
        if (session!=null){
            String loginName = (String)session.getAttribute("loginName");
            if (loginName!=null){
                response.sendRedirect(request.getContextPath()+"/admin?method=list");
                return;
            }
        }
        request.setAttribute("loginerror", "0");
        request.getRequestDispatcher("system/login.jsp").forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        UserDAO userDAO = new UserDAO();

        // 注册的post处理
        if(request.getParameter("register")!=null){
            if (!userDAO.register(username, password)){
                response.sendRedirect(request.getContextPath()+"/login?register&message=sameusername");
                return;
            }
            response.sendRedirect(request.getContextPath()+"/login?message=registersuccess");
            return;
        }

        // 登录的post处理
        if (userDAO.checkLogin(username,password)){
            HttpSession session = request.getSession();
            session.setAttribute("loginName", username);
            response.sendRedirect(request.getContextPath()+"/admin?method=list");
        }else{
            request.setAttribute("loginerror", "1");
            request.getRequestDispatcher("system/login.jsp").forward(request, response);
        }
    }


}
