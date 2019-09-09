import java.sql.*;
public class JDBCDemo2 {

	public static void main(String[] args) {
		//create a connection object 
		Connection conn = null;
		try {
			//create a string variable for the connection
			String dbURL ="jdbc:sqlserver://localhost;" 
					+ "instaceName=MSSQLSERVER;"
					+"databaseName=university;"
					+"user=sa;"
					+"password=csis3300";
			
			//establish the connection to the database server
			conn = DriverManager.getConnection(dbURL);
			
			if(conn!= null) // if the connection is successful
			{
				DatabaseMetaData dm = conn.getMetaData();
				
				//create PreparedStatement object stmt and a ResultSet object rs
				PreparedStatement prepStmt1 = null;
				String selectSQL = "Select ID, name from instructor where dept_name = ?";
				prepStmt1 = conn.prepareStatement(selectSQL);
				prepStmt1.setString(1,"Finance");
				
				// Run a simple sql statement 
				ResultSet rs = prepStmt1.executeQuery();
				
				while(rs.next())
				{
					System.out.println(rs.getString(1)+ "\t" + rs.getString(2));
				}
				
				//run a second sql statement 
				System.out.println("------------------------");
				
				PreparedStatement prepStmt2 = null;
				String insertSql = "Insert into instructor values(?,?,?,?)";
				prepStmt2 = conn.prepareStatement(insertSql);
				prepStmt2.setString(1, "88877");
				prepStmt2.setString(2, "Perry");
				prepStmt2.setString(3, "Finance");
				prepStmt2.setDouble(4, 125000);
				prepStmt2.executeUpdate();
			
				
			}
		}catch(SQLException ex)
		{
			ex.printStackTrace();
		}finally
		{
			//close the connection after the job is done 
			try {
				if(conn!=null && !conn.isClosed())
				{
					conn.close();
				}
			}catch (SQLException ex)
			{
				ex.printStackTrace();
			}
		}
		
	}
}
