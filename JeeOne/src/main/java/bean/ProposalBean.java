package bean;

import java.sql.Timestamp;

public class ProposalBean {
	private int job_id;
	private int freelancer_id;
	private int employer_id;
	private int job_bid;
	private String job_coverletter;
	private Timestamp proposal_date;
	
	public ProposalBean() {
		super();
	}
	
	public ProposalBean(int job_id, int freelancer_id, int employer_id, int job_bid, String job_coverletter) {
		super();
		this.job_id = job_id;
		this.freelancer_id = freelancer_id;
		this.employer_id = employer_id;
		this.job_bid = job_bid;
		this.job_coverletter = job_coverletter;
		java.util.Date date = new java.util.Date();
		this.proposal_date = new java.sql.Timestamp(date.getTime());
	}

	public ProposalBean(int job_id, int freelancer_id, int employer_id, int job_bid, String job_coverletter,
			Timestamp proposal_date) {
		super();
		this.job_id = job_id;
		this.freelancer_id = freelancer_id;
		this.employer_id = employer_id;
		this.job_bid = job_bid;
		this.job_coverletter = job_coverletter;
		this.proposal_date = proposal_date;
	}

	public int getJob_id() {
		return job_id;
	}
	public void setJob_id(int job_id) {
		this.job_id = job_id;
	}
	public int getFreelancer_id() {
		return freelancer_id;
	}
	public void setFreelancer_id(int freelancer_id) {
		this.freelancer_id = freelancer_id;
	}
	public int getEmployer_id() {
		return employer_id;
	}
	public void setEmployer_id(int employer_id) {
		this.employer_id = employer_id;
	}
	public int getJob_bid() {
		return job_bid;
	}
	public void setJob_bid(int job_bid) {
		this.job_bid = job_bid;
	}
	public String getJob_coverletter() {
		return job_coverletter;
	}
	public void setJob_coverletter(String job_coverletter) {
		this.job_coverletter = job_coverletter;
	}
	public Timestamp getProposal_date() {
		return proposal_date;
	}
	public void setProposal_date(Timestamp proposal_date) {
		this.proposal_date = proposal_date;
	}
	
	
}
