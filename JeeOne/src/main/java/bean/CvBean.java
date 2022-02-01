package bean;

public class CvBean {
	private int user_id;
	private String firstname;
	private String lastname;
	private String email;
	private String cv_category;
	private String cv_skills ; 
	private String cv_language;
	private String cv_hobbies;
	private String cv_title;
	private String cv_description;
	private String cv_project_title;
	private String cv_project_url;
	
	
	public CvBean() {
		super();
	}
	
	
	public CvBean(String firstname, String lastname, String email, String cv_category, String cv_skills,
			String cv_language, String cv_hobbies, String cv_title, String cv_description, String cv_project_title,
			String cv_project_url) {
		// For adding a new cv
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.cv_category = cv_category;
		this.cv_skills = cv_skills;
		this.cv_language = cv_language;
		this.cv_hobbies = cv_hobbies;
		this.cv_title = cv_title;
		this.cv_description = cv_description;
		this.cv_project_title = cv_project_title;
		this.cv_project_url = cv_project_url;
	}
	
	public CvBean(int user_id, String firstname, String lastname, String email, String cv_category, String cv_skills,
			String cv_language, String cv_hobbies, String cv_title, String cv_description, String cv_project_title,
			String cv_project_url) {
		// To generate profile page
		super();
		this.user_id = user_id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.cv_category = cv_category;
		this.cv_skills = cv_skills;
		this.cv_language = cv_language;
		this.cv_hobbies = cv_hobbies;
		this.cv_title = cv_title;
		this.cv_description = cv_description;
		this.cv_project_title = cv_project_title;
		this.cv_project_url = cv_project_url;
	}


	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		lastname = lastname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public String getCv_category() {
		return cv_category;
	}
	public void setCv_category(String cv_category) {
		this.cv_category = cv_category;
	}
	public String getCv_skills() {
		return cv_skills;
	}
	public void setCv_skills(String cv_skills) {
		this.cv_skills = cv_skills;
	}
	public String getCv_language() {
		return cv_language;
	}
	public void setCv_language(String cv_language) {
		this.cv_language = cv_language;
	}
	public String getCv_hobbies() {
		return cv_hobbies;
	}
	public void setCv_hobbies(String cv_hobbies) {
		this.cv_hobbies = cv_hobbies;
	}
	public String getCv_title() {
		return cv_title;
	}
	public void setCv_title(String cv_title) {
		this.cv_title = cv_title;
	}
	public String getCv_description() {
		return cv_description;
	}
	public void setCv_description(String cv_description) {
		this.cv_description = cv_description;
	}
	public String getCv_project_title() {
		return cv_project_title;
	}
	public void setCv_project_title(String cv_project_title) {
		this.cv_project_title = cv_project_title;
	}
	public String getCv_project_url() {
		return cv_project_url;
	}
	public void setCv_project_url(String cv_project_url) {
		this.cv_project_url = cv_project_url;
	}
	
}
