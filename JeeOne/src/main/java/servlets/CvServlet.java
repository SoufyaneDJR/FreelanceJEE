package servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.CvBean;
import bean.UserBean;
import dao.CvDao;

/**
 * Servlet implementation class CvServlet
 */
@WebServlet("/fillyourcv")
public class CvServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CvBean cv;

	public void init() {
		cv = new CvBean();
	}

	public CvServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String action = request.getServletPath();
		if (request.getParameter("do") != null) {
			try {
				switch (request.getParameter("do")) {
				case "new":
					showNewForm(request, response);
					break;
				case "insert":
					insertCv(request, response);
					break;
				default:
					showProfile(request, response);
					break;
				}
			} catch (SQLException ex) {
				throw new ServletException(ex);
			}
			;

		} else {
			try {
				System.out.println("Fillyourcv");
				showProfile(request, response);
			} catch (SQLException ex) {
				throw new ServletException(ex);
			}

		}
		 
	}

	private void showProfile(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		HttpSession session = request.getSession();
		UserBean currentUser = (UserBean) session.getAttribute("info");
		CvDao cvDao = new CvDao();
		int user_id ;
		if (request.getParameter("user").length()>0) {
			user_id = Integer.parseInt(request.getParameter("user"));
		} else {
			user_id = currentUser.getUser_id();
		}
		CvBean cvprofile = cvDao.selectCv(user_id);
		session.setAttribute("cvprofile", cvprofile);
		request.setAttribute("cvprofile", cvprofile);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/profile.jsp");
		dispatcher.forward(request, response);
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		UserBean currentUser = (UserBean) session.getAttribute("info");
		RequestDispatcher dispatcher = request.getRequestDispatcher("new-cv.jsp");
		dispatcher.forward(request, response);

	}
	private void insertCv(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		HttpSession session = request.getSession();
		UserBean currentUser = (UserBean) session.getAttribute("info");

		String cv_category = request.getParameter("cv_category");
		String[] cvskills = request.getParameterValues("cv_skills");
		String cv_skills = "";
		for (String skill : cvskills) {
			cv_skills += skill + ".";
		}
		String cv_language = request.getParameter("cv_language");
		String cv_hobbies = request.getParameter("cv_hobbies");
		String cv_title = request.getParameter("cv_title");
		String cv_description = request.getParameter("cv_description");
		String cv_project_title = request.getParameter("cv_project_title");
		String cv_project_url = request.getParameter("cv_project_url");
		System.out.println("ID : " + currentUser.getUser_id());
		CvBean newCv = new CvBean(currentUser.getUser_id(), currentUser.getFirstname(), currentUser.getLastname(), currentUser.getEmail(), cv_category, cv_skills,
				cv_language, cv_hobbies, cv_title, cv_description, cv_project_title, cv_project_url);
		CvDao cvDao = new CvDao();
		cvDao.insertCv(newCv);
		response.sendRedirect("/JeeOne/fillyourcv");

	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
