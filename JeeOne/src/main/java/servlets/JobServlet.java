package servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.JobBean;
import bean.ProposalBean;
import bean.UserBean;
import dao.JobDao;
import dao.ProposalDao;
import dao.RegisterDao;

@WebServlet("/joblist")
public class JobServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private JobBean job ;

	public void init() {
		job = new JobBean();
	}

	public JobServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
		if (request.getParameter("do")!=null) {
			try {
				switch(request.getParameter("do")) {
				case "new":
					showNewForm(request,response);
					break;
				case "insert":
					System.out.println(action);
					insertJob(request,response);
					break;
				case "delete":
					deleteJob(request,response);
					break;
				case "edit":
					showEditForm(request,response);
					break;
				case "update":
					updateJob(request,response);
					break;
				case "check" :
					showProposals(request,response);
					break;
				default :
					listJob(request,response);
					break;
				}	
			} catch (SQLException ex) {
				throw new ServletException(ex);
			};

		} else {
			try {
				listJob(request,response);
			} catch (SQLException ex) {
				throw new ServletException(ex);
			}
			
		}
		
	}

	private void showProposals(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		HttpSession session = request.getSession();
		UserBean currentUser = (UserBean)session.getAttribute("info");
		int employer_id = currentUser.getUser_id();
		
		JobDao jobdao = new JobDao();
		
		ProposalDao proposalDao = new ProposalDao();
		int job_id = Integer.parseInt(request.getParameter("job_id"));
		JobBean jobinfo = jobdao.selectJob(job_id, employer_id);
		List<ProposalBean> proposals = proposalDao.selectAllProposals(job_id);
		List<UserBean> freelancers = new ArrayList<>();;
		
		for (ProposalBean proposal : proposals) {
			int freelancer_id = proposal.getFreelancer_id();
			RegisterDao userdao = new RegisterDao();
			freelancers.add(userdao.returnUserWithId(freelancer_id));
		}
		request.setAttribute("proposals", proposals);
		request.setAttribute("jobinfo", jobinfo);
		request.setAttribute("freelancers", freelancers);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/proposal-list.jsp");
		dispatcher.forward(request, response);
	}

	private void listJob(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		HttpSession session = request.getSession();
		UserBean currentUser = (UserBean)session.getAttribute("info");
		JobDao jobDao = new JobDao();
		List<JobBean> listJobs = jobDao.selectAllJobs(currentUser.getUser_id());
		request.setAttribute("listJobs", listJobs);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/job-list.jsp");
		dispatcher.forward(request, response);
	}


	private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("new-job.jsp");
		dispatcher.forward(request, response);

	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		HttpSession session = request.getSession();
		UserBean currentUser = (UserBean)session.getAttribute("info");
		int job_id = Integer.parseInt(request.getParameter("job_id"));

		JobDao jobDao = new JobDao();
		JobBean existingJob = jobDao.selectJob(job_id,currentUser.getUser_id());

		RequestDispatcher dispatcher = request.getRequestDispatcher("new-job.jsp");
		request.setAttribute("job", existingJob);
		dispatcher.forward(request, response);

	}


	private void insertJob(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		HttpSession session = request.getSession();
		UserBean currentUser = (UserBean)session.getAttribute("info");
		String job_title = request.getParameter("headline");
		String job_description = request.getParameter("jobdescription");
		String job_category = request.getParameter("category");
		String[] jobskills = request.getParameterValues("skill_id");
		String job_skills =""; 
		for (String skill : jobskills) {
			job_skills+= skill + ".";
		}
		String job_size = request.getParameter("size");
		String job_lenght = request.getParameter("lenght");
		String job_experience = request.getParameter("experience");
		int job_budget = Integer.parseInt(request.getParameter("budget"));
		JobBean newJob = new JobBean(currentUser.getUser_id(),job_title,job_description,job_category,job_skills,job_size,job_lenght,job_experience,job_budget);
		JobDao jobDao = new JobDao();
		jobDao.insertJob(newJob);
		response.sendRedirect("/JeeOne/joblist");

	}

	private void updateJob(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		int job_id = Integer.parseInt(request.getParameter("job_id"));

		HttpSession session = request.getSession();
		UserBean currentUser = (UserBean)session.getAttribute("info");

		String job_title = request.getParameter("headline");
		String job_description = request.getParameter("jobdescription");
		String job_category = request.getParameter("category");
		String[] job_skills = request.getParameterValues("skill_id");
		String job_size = request.getParameter("size");
		String job_lenght = request.getParameter("lenght");
		String job_experience = request.getParameter("experience");
		int job_budget = Integer.parseInt(request.getParameter("budget"));

		JobBean updatedJob = new JobBean(currentUser.getUser_id(),job_title,job_description,job_category,"skill",job_size,job_lenght,job_experience,job_budget);
		JobDao jobDao = new JobDao();

		jobDao.updateJob(updatedJob);
		response.sendRedirect("joblist");
	}


	private void deleteJob(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		HttpSession session = request.getSession();
		UserBean currentUser = (UserBean)session.getAttribute("info");
		int job_id = Integer.parseInt(request.getParameter("job_id"));
		JobDao jobDao = new JobDao();
		jobDao.deleteJob(job_id,currentUser.getUser_id());
		response.sendRedirect("/JeeOne/joblist");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
