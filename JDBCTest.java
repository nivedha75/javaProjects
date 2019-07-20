package Restaurant;

import java.sql.*;

//Standard JDBC packages.

//import java.math.*;

//The BigDecimal and BigInteger classes. You can omit this package if you are not going to use these
//classes in your application.

import oracle.jdbc.*;

import oracle.jdbc.pool.OracleDataSource;

import oracle.sql.*;

//Oracle extensions to JDBC. This is optional.

//OracleDataSource.

//Oracle type extensions. This is optional.

public class JDBCTest {

	public static void main(String[] args) throws SQLException  {
		// TODO Auto-generated method stub
		
	    testSelect();
		testInsert();
	
		

	}
    static void testInsert() throws SQLException  {
    	OracleDataSource ods = new OracleDataSource();
		ods.setURL("jdbc:oracle:thin:@//localhost:1521/XE");
		// jdbc:oracle:thin@//[hostname]:[port]/[DB service name]
		ods.setUser("SYSTEM"); // [username]
		ods.setPassword("javajuice"); // [password]
		Connection conn = ods.getConnection();

    	String sql = "insert into ORDERHISTORY (orderNumber,TELEPHONENUM,foodOrdered,Quantity,PRICE) values (?, ?,?,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, 1);
		pstmt.setInt(2, 1);
		pstmt.setString(3, "CHEESE PIZZA");
		pstmt.setInt(4, 1);
		pstmt.setDouble(5, 15);
		pstmt.execute();	
    }
	static  void testSelect() throws SQLException  {
		OracleDataSource ods = new OracleDataSource();
		ods.setURL("jdbc:oracle:thin:@//localhost:1521/XE");
		// jdbc:oracle:thin@//[hostname]:[port]/[DB service name]
		ods.setUser("SYSTEM"); // [username]
		ods.setPassword("javajuice"); // [password]
		Connection conn = ods.getConnection();

		//PreparedStatement stmt = conn.prepareStatement("SELECT * from customer");
		Statement stmt = conn.createStatement();
		stmt.executeQuery("SELECT * from customer");
		ResultSet rslt = stmt.executeQuery("SELECT * from customer");

		boolean dataFoundflag = false;
		while (rslt.next()) {
			System.out.println(rslt.getString(1));
			System.out.println(rslt.getString(2));
			System.out.println(rslt.getString(3));
			System.out.println(rslt.getString(4));
			dataFoundflag = true;
		}
		if (!dataFoundflag) {
			System.out.println("Data not found");

		}

	}

}
