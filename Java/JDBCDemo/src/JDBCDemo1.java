import java.sql.*;

public class JDBCDemo1 {

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
				
				//print some driver information to check the connection
				/*System.out.println("Driver name :" + dm.getDriverName());
				System.out.println("Driver Version :" + dm.getDriverVersion());
				System.out.println("Product name : " + dm.getDatabaseProductName());
				System.out.println("Product Version :" + dm.getDatabaseProductVersion());*/
				
				//create statements object stmt and a ResultSet object rs
				Statement stmt = conn.createStatement();
				ResultSet rs;
				
				// Run a simple sql statement 
				rs = stmt.executeQuery("select * from instructor");
				/*while(rs.next())
				{
					//System.out.println(rs.getString(1)+ "\t" + rs.getDouble(4));
					System.out.println(rs.getString("ID")+ "\t" + rs.getDouble("salary"));
				}*/
				
				//run a second sql statement 
				rs = stmt.executeQuery("select ID,name from instructor");
				while (rs.next())
				{
					System.out.println(rs.getString(1)+ "\t" + rs.getString(2));
				}

				
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
