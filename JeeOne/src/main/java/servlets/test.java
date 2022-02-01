package servlets;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.ocpsoft.prettytime.*;

import bean.UserBean;

import java.util.*;
import java.text.ParseException;
import java.text.SimpleDateFormat; 

@WebServlet("/test")
public class test extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void init(ServletConfig config) throws ServletException {
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*PrettyTime p = new PrettyTime(new Locale("fr"));
		SimpleDateFormat formatter=new SimpleDateFormat("2022-01-31 13:27:33");
		try {
			Date date=formatter.parse("2021-12-31 13:27:33");
			String f = p.format(date);
			System.out.println(f);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("");

		String action = request.getServletPath();
		response.getWriter().append(action);
		String id = request.getParameter("id");
		String fullname = request.getParameter("param");
		response.getWriter().append("\n ID : ").append(id);
		response.getWriter().append("\n Full Name : ").append(fullname);
		HttpSession session = request.getSession();
		response.getWriter().append("\n String : ").append(session.toString());*/
		HttpSession session = request.getSession();
		//to generate errors to refresh this dumb of an app called eclipse
		//session.invalidate();
		if (session.getAttributeNames().hasMoreElements()) {
			session.invalidate();
			response.getWriter().append("\n Status : ").append("SESSION DELETED");
		} else {
			response.getWriter().append("\n Status : ").append("SESSION DOESN'T EXIST");
		}
		}

		
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
