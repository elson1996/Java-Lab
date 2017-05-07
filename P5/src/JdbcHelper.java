import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;

public class JdbcHelper {
	// JDBC driver name and database URL
	   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	   static final String DB_URL = "jdbc:mysql://localhost:3306/representative";

	   //  Database credentials
	   static final String USER = "root";
	   static final String PASS = "3070";
	   Connection conn;
	   JdbcHelper()	{
		   try{
		      //STEP 2: Register JDBC driver
		      Class.forName(JDBC_DRIVER);
		      //STEP 3: Open a connection
		      conn = DriverManager.getConnection(DB_URL,USER,PASS);
		   }catch(SQLException se){
		      //Handle errors for JDBC
		      se.printStackTrace();
		   }catch(Exception e){
		      //Handle errors for Class.forName
		      e.printStackTrace();
		   }
	   }
	   void insertCustomer(int id, String name, String state, double creditLimit, int repNo) throws SQLException	{
		   String query = "INSERT into Cust VALUES (?,?,?,?,?)";
		   PreparedStatement pstmt = conn.prepareStatement(query);
		   pstmt.setInt(1, id);
		   pstmt.setString(2, name);
		   pstmt.setString(3, state);
		   pstmt.setFloat(4, (float) creditLimit);
		   pstmt.setInt(5, repNo);
		   int row = pstmt.executeUpdate();
		   System.out.println("Rows Affected: " + row);
		   pstmt.close();
	   }
	   void insertRep(int repNo, String name, String state, double commission, double rate) throws SQLException	{
		   String query = "INSERT into Rep VALUES (?,?,?,?,?)";
		   PreparedStatement pstmt = conn.prepareStatement(query);
		   pstmt.setInt(1, repNo);
		   pstmt.setString(2, name);
		   pstmt.setString(3, state);
		   pstmt.setFloat(4, (float) commission);
		   pstmt.setFloat(5, (float) rate);
		   int row = pstmt.executeUpdate();
		   System.out.println("Rows Affected: " + row);
		   pstmt.close();
	   }
	   void getReps(DefaultTableModel model) throws SQLException	{
		   //String query = "SELECT * FROM Rep";
		   String query =  "SELECT  `RepNo` ,  `RepName` FROM  `Rep` , Cust WHERE Cust.CustRepNo = Rep.`RepNo`  AND Cust.CustCredLimit >6000 GROUP BY  `RepNo`"; 
		   Statement stmt = conn.createStatement();
		   ResultSet res = stmt.executeQuery(query);
		   while(res.next()){
			   String repNo = res.getString(1);
			   String repName = res.getString(2);
			   model.addRow(new Object []{repNo,repName});
		   }
		   stmt.close();
	   }
	   protected void finalize()	{
		   try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   }
}
