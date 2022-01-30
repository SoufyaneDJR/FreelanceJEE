package bean;

import java.sql.Date;

public class UserBean {

	private int user_id = 0;
	private String email;
	private String firstname;
	private String lastname;
	private String password;
	private String status;
	private Date creationDate;
	

	public String toString() {
		return user_id + " | " + email + " | " + firstname + " | " + lastname + " | " + password + " | " + status + " | " + creationDate ;
	}
	
	public UserBean() {
		super();
	}

	public UserBean(String email, String firstname, String lastname, String password, String status) {
		// To be used when registring a user
		super();
		this.email = email;
		this.firstname = firstname;
		this.lastname = lastname;
		this.password = password;
		this.status = status;
		this.creationDate = new Date(System.currentTimeMillis());
	}
	
	public UserBean(int user_id, String email, String firstname, String lastname, String password, String status,
			Date creationDate) {
		// To be Used when creating a session & Login
		super();
		this.user_id = user_id;
		this.email = email;
		this.firstname = firstname;
		this.lastname = lastname;
		this.password = password;
		this.status = status;
		this.creationDate = creationDate;
	}
	
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
		this.lastname = lastname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	
}
