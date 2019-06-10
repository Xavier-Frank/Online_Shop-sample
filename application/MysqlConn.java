package application;
import java.sql.Connection;
import java.sql.SQLException;

public class MysqlConn {

	public static void main(String[] args) throws SQLException {
		
		Connection conn = null;
	try {
		
		conn = DBConnection.getConnection();
		System.out.println("Success");
	} catch(SQLException e) {
		System.err.println(e);
		
	} finally {
		if (conn != null) {
			conn.close();
		}
	}
}
}
