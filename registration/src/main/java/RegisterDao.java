import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RegisterDao {
	private String dburl = "jdbc:mysql://localhost:3306/userdb1";
	private String dbuname = "root";
	private String dbpassword = "";
	private String dbdriver = "com.mysql.jdbc.Driver";

	public void loadDriver(String dbDriver)
	{
		try {
			Class.forName(dbDriver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public Connection getConnection() {
		Connection con = null;
		try {
			con = DriverManager.getConnection(dburl, dbuname, dbpassword);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}

	public String insert(Member member) {
	    loadDriver(dbdriver);
	    Connection con = getConnection();
	    String sql = "INSERT INTO member (uname, password, email, phone) VALUES (?,?,?,?)";
	    String result = "Data Entered Successfully";

	    try {
	        PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
	        ps.setString(1, member.getUname());
	        ps.setString(2, member.getPassword());
	        ps.setString(3, member.getEmail());
	        ps.setString(4, member.getPhone());

	        ps.executeUpdate();

	        // Retrieve the auto-generated key
	        try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
	            if (generatedKeys.next()) {
	                int generatedId = generatedKeys.getInt(1);
	                System.out.println("Generated Product ID: " + generatedId);
	            }
	        }

	        ps.close();
	    } catch (SQLException e) {
	        result = "Data Not Entered Successfully";
	        e.printStackTrace();
	    } finally {
	        try {
	            con.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    return result;
	}

	





}