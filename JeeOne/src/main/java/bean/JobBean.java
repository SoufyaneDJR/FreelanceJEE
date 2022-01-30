package bean;

import java.sql.Timestamp;

public class JobBean {
	private int job_id;
	private int user_id;
	private String job_title;
	private String job_description;
	private int job_category;
	private String job_skills;
	private String job_size;
	private String job_lenght;
	private String job_experience;
	private int job_budget;
	private Timestamp job_date;
	private String job_status;
	
	
	
	public JobBean() {
		super();
	}
	public JobBean(int job_id, int user_id, String job_title, String job_description, int job_category,
			String job_skills, String job_size, String job_lenght, String job_experience,int job_budget, Timestamp job_date,
			String job_status) {
		//Used When selecting a single job offer 
		super();
		this.job_id = job_id;
		this.user_id = user_id;
		this.job_title = job_title;
		this.job_description = job_description;
		this.job_category = job_category;
		this.job_skills = job_skills;
		this.job_size = job_size;
		this.job_lenght = job_lenght;
		this.job_experience = job_experience;
		this.job_budget = job_budget;
		this.job_date = job_date;
		this.job_status = job_status;
	}

	public JobBean(int user_id, String job_title, String job_description, int job_category,
			String job_skills, String job_size, String job_lenght, String job_experience,int job_budget) {
		// Add new job for a certain *USER_ID*
		super();
		java.util.Date date = new java.util.Date();
		this.user_id = user_id;
		this.job_title = job_title;
		this.job_description = job_description;
		this.job_category = job_category;
		this.job_skills = job_skills;
		this.job_size = job_size;
		this.job_lenght = job_lenght;
		this.job_experience = job_experience;
		this.job_budget = job_budget;
		this.job_date = new java.sql.Timestamp(date.getTime());
		this.job_status = "Active";
	}
	public int getJob_id() {
		return job_id;
	}

	public void setJob_id(int job_id) {
		this.job_id = job_id;
	}

	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getJob_title() {
		return job_title;
	}
	public void setJob_title(String job_title) {
		this.job_title = job_title;
	}
	public String getJob_description() {
		return job_description;
	}
	public void setJob_description(String job_description) {
		this.job_description = job_description;
	}
	public int getJob_category() {
		return job_category;
	}
	public void setJob_category(int job_category) {
		this.job_category = job_category;
	}
	public String getJob_skills() {
		return job_skills;
	}
	public void setJob_skills(String job_skills) {
		this.job_skills = job_skills;
	}
	public String getJob_size() {
		return job_size;
	}
	public void setJob_size(String job_size) {
		this.job_size = job_size;
	}
	public String getJob_lenght() {
		return job_lenght;
	}
	public void setJob_lenght(String job_lenght) {
		this.job_lenght = job_lenght;
	}
	public String getJob_experience() {
		return job_experience;
	}
	public void setJob_experience(String job_experience) {
		this.job_experience = job_experience;
	}
	public int getJob_budget() {
		return job_budget;
	}

	public void setJob_budget(int job_budget) {
		this.job_budget = job_budget;
	}
	public Timestamp getJob_date() {
		return job_date;
	}
	public void setJob_date(Timestamp job_date) {
		this.job_date = job_date;
	}
	public String getJob_status() {
		return job_status;
	}
	public void setJob_status(String job_status) {
		this.job_status = job_status;
	}
}
