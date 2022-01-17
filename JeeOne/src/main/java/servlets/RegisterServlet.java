package servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.RegisterBean;
import dao.RegisterDao;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public RegisterServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String status = request.getParameter("status");
		
		RegisterBean newUser = new RegisterBean(email,firstname,lastname,password,status);
		
		RegisterDao rDao = new RegisterDao();
		boolean result = false;
		try {
			result = rDao.insert(newUser);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (result == true) {
			HttpSession session = request.getSession();
			session.setAttribute("info", (LoginBean)newUser);
			response.sendRedirect("loginSuccess.jsp");
		} else {
			response.getWriter().append("Internal DataBase Error , Please try again !");
		}
	}

}