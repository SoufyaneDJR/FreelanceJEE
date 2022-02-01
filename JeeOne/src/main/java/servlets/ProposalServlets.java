package servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
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

@WebServlet("/proposals")
public class ProposalServlets extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ProposalServlets() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		UserBean freelancer =(UserBean)session.getAttribute("info");
		int freelancer_id = freelancer.getUser_id();
		String action = request.getParameter("do");
		if (action.equals("submit")) {
			int employer_id= Integer.parseInt(request.getParameter("employer_id"));
			int job_id= Integer.parseInt(request.getParameter("job_id"));
			int job_bid = Integer.parseInt(request.getParameter("job_bid"));
			String job_coverletter = request.getParameter("job_coverletter");
			ProposalBean newProposal = new ProposalBean(job_id,freelancer_id,employer_id,job_bid,job_coverletter);
			ProposalDao proposalDao = new ProposalDao();
			try {
				proposalDao.insertProposal(newProposal);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			response.sendRedirect("/JeeOne/recommendations");
		}
		
		if (action.equals("read")) {
			int employer_id= Integer.parseInt(request.getParameter("employer_id"));
			int job_id= Integer.parseInt(request.getParameter("job_id"));
			int job_bid = Integer.parseInt(request.getParameter("job_bid"));
			String job_coverletter = request.getParameter("job_coverletter");
			ProposalBean newProposal = new ProposalBean(job_id,freelancer_id,employer_id,job_bid,job_coverletter);
			ProposalDao proposalDao = new ProposalDao();
			try {
				proposalDao.insertProposal(newProposal);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			response.sendRedirect("/JeeOne/recommendations");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
