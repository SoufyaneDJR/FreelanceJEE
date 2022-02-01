package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.JobBean;
import dao.JobDao;

@WebServlet("/search")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public SearchServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String job_id = request.getParameter("job_id");
		if (job_id != null) {
			JobDao jobdao = new JobDao();
			JobBean selectedjob = jobdao.selectJobByJobId(Integer.parseInt(job_id));
			request.setAttribute("selectedjob", selectedjob);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/job-page.jsp");
			dispatcher.forward(request, response);
		}
		String search = request.getParameter("search");
		if (search !=null) {
			JobDao jobDao = new JobDao();
			List<JobBean> listJobs = jobDao.selectJobBySearch(search);
			request.setAttribute("listJobs", listJobs);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/search-page.jsp");
			dispatcher.forward(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
		
	}

}
