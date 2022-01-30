package servlets;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/test")
public class test extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void init(ServletConfig config) throws ServletException {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
		response.getWriter().append(action);
		String id = request.getParameter("id");
		String fullname = request.getParameter("param");
		response.getWriter().append("\n ID : ").append(id);
		response.getWriter().append("\n Full Name : ").append(fullname);
		HttpSession session = request.getSession();
		response.getWriter().append("\n String : ").append(session.toString());
		
		if (session.getAttribute("info") !="fhhehe") {
			session.removeAttribute("info");
			response.getWriter().append("\n Status : ").append((String)session.getAttribute("info"));
			//response.sendRedirect("login.jsp");
			return;
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
