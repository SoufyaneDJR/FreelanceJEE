package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import java.util.ArrayList;
import java.util.List;

import bean.ProposalBean;

public class ProposalDao {

	private String dbUrl = "jdbc:mysql://localhost:3306/JEE?serverTimezone=UTC";
	private String dbUname = "root";
	private String dbPassword = "soufyane";
	private String dbDriver = "com.mysql.cj.jdbc.Driver";

	private static final String INSERT_PROPOSAL = "INSERT INTO PROPOSALS VALUES (?, ?, ?, ?, ?, ?);";

	private static final String SELECT_ALL_PROPOSALS_BY_IDS = "SELECT * FROM PROPOSALS WHERE JOB_ID = ?;";
	
	private static final String SELECT_PROPOSAL = "SELECT * FROM PROPOSALS WHERE JOB_ID = ? AND FREELANCER_ID = ? AND EMPLOYER_ID = ?;";

	public ProposalDao() {
	}

	public void loadDriver(String dbDriver) {
		try {
			Class.forName(dbDriver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Connection getConnection() throws SQLException {
		Connection con = DriverManager.getConnection(dbUrl, dbUname, dbPassword);
		return con;
	}

	// select one Proposal
	public ProposalBean selectProposal(int job_id, int freelancer_id,int employer_id) {
		ProposalBean proposal = null;
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PROPOSAL);) {
			preparedStatement.setInt(1, job_id);
			preparedStatement.setInt(2, freelancer_id);
			preparedStatement.setInt(2, employer_id);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				int job_bid = rs.getInt("job_bid");
				String job_coverletter = rs.getString("job_coverletter");
				Timestamp job_date = rs.getTimestamp("proposal_date");
				proposal = new ProposalBean(job_id,freelancer_id, employer_id, job_bid, job_coverletter,job_date);

			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return proposal;
	}

	// SELECTINGALL THE PORPOSALS FOR ONE JOB
	public List<ProposalBean> selectAllProposals(int jobid) {
		List<ProposalBean> proposals = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();

				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_PROPOSALS_BY_IDS);) {
			// Step 3: Execute the query or update query
			preparedStatement.setInt(1, jobid);

			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int job_id = rs.getInt("job_id");
				int freelancer_id = rs.getInt("freelancer_id");
				int employer_id = rs.getInt("employer_id");
				int job_bid = rs.getInt("job_bid");
				String job_coverletter = rs.getString("job_coverletter");
				Timestamp proposal_date = rs.getTimestamp("proposal_date");
				proposals.add(new ProposalBean(job_id, freelancer_id,employer_id,job_bid,job_coverletter,proposal_date));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return proposals;
	}

	public void insertProposal(ProposalBean proposal) throws SQLException {
		// try-with-resource statement will auto close the connection.
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PROPOSAL)) {
			preparedStatement.setInt(1, proposal.getJob_id());
			preparedStatement.setInt(2, proposal.getFreelancer_id());
			preparedStatement.setInt(3, proposal.getEmployer_id());
			preparedStatement.setInt(4, proposal.getJob_bid());
			preparedStatement.setString(5, proposal.getJob_coverletter());
			preparedStatement.setObject(6, proposal.getProposal_date());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
	}
	
	void printSQLException(SQLException ex) {
		for (Throwable e : ex) {
			if (e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
				System.err.println("Message: " + e.getMessage());
				Throwable t = ex.getCause();
				while (t != null) {
					System.out.println("Cause: " + t);
					t = t.getCause();
				}
			}
		}
	}

}
