package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.CvBean;
import bean.JobBean;
import bean.UserBean;
import dao.CvDao;
import dao.JobDao;

/**
 * Servlet implementation class RecomServlet
 */
@WebServlet("/recommendations")
public class RecomServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public RecomServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		HttpSession session = request.getSession();
		UserBean currentUser = (UserBean)session.getAttribute("info");
		
		//getting user skills 
		CvBean cv = new CvBean();
		CvDao cvdao = new CvDao();
		cv = cvdao.selectCv(currentUser.getUser_id());
		JobDao jobDao = new JobDao();
		List<JobBean> listJobs = jobDao.selectJobByRecommendation(cv.getCv_skills());
		request.setAttribute("listJobs", listJobs);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/recommendation-page.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
		
	}

}