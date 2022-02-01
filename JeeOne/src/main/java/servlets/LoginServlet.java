package servlets;

import java.io.IOException;

import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.UserBean;
import dao.LoginDao;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public LoginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LoginDao loginDao = new LoginDao();
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		UserBean loginBean = new UserBean();
		loginBean.setEmail(email);
		loginBean.setPassword(password);
		
		try { 
			loginBean = loginDao.validate(loginBean);
			if (loginBean != null)
			{	
				HttpSession session = request.getSession();
				session.setAttribute("info", loginBean);
				System.out.println(loginBean.getStatus());
				if (loginBean.getStatus().equals("employer")) {
					response.sendRedirect("/JeeOne/joblist");
				} else {
					//profile hada 
					response.sendRedirect("/JeeOne/recommendations");
				}
				
			}
			else 
			{
				response.sendRedirect("signin.jsp");
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
