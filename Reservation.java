package RestaurantCentral;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import oracle.jdbc.pool.OracleDataSource;

class Reservation {

	static int findTable() throws SQLException {
		OracleDataSource ods = new OracleDataSource();
		ods.setURL("jdbc:oracle:thin:@//localhost:1521/XE");
		// jdbc:oracle:thin@//[hostname]:[port]/[DB service name]
		ods.setUser("SYSTEM"); // [username]
		ods.setPassword("javajuice"); // [password]
		Connection conn = ods.getConnection();

		String selectsql = "SELECT CAPACITY FROM SEATING_CAPACITY";
				//WHERE DATEOFRESERVATION = ? AND TIMESLOT = ?";

		PreparedStatement pstmt1 = conn.prepareStatement(selectsql);

		boolean foundflag;
		int count = 0;
		System.out.println("DEBUG : select from SEATING_CAPACITY: ");
		//pstmt1.setString(1, dateOfReservation);
		//pstmt1.setString(2, timeSlot);
		foundflag = pstmt1.execute();
		System.out.println("DEBUG : foundflag :" + foundflag);
		if (foundflag) {
			ResultSet rslt = pstmt1.getResultSet();
			while (rslt.next()) {
				count = rslt.getInt(1);
				System.out.println("DEBUG : COUNT " + count);
			}
		}
		// pstmt1.getUpdateCount()

		return count;
	}

	/*
	 * static int findTable(String dateOfReservation, String timeSlot) throws
	 * SQLException { OracleDataSource ods = new OracleDataSource();
	 * ods.setURL("jdbc:oracle:thin:@//localhost:1521/XE"); //
	 * jdbc:oracle:thin@//[hostname]:[port]/[DB service name] ods.setUser("SYSTEM");
	 * // [username] ods.setPassword("javajuice"); // [password] Connection conn =
	 * ods.getConnection();
	 * 
	 * String selectreservationsql =
	 * "SELECT COUNT(*) FROM RESERVATION  WHERE DATEOFRESERVATION = ? AND TIMESLOT = ?"
	 * ;
	 * 
	 * PreparedStatement pstmt1 = conn.prepareStatement(selectreservationsql);
	 * 
	 * boolean foundflag; int count = 0;
	 * System.out.println("DEBUG : select from reservations: "); pstmt1.setString(1,
	 * dateOfReservation); pstmt1.setString(2, timeSlot); foundflag =
	 * pstmt1.execute(); System.out.println("DEBUG : foundflag :" + foundflag); if
	 * (foundflag) { ResultSet rslt = pstmt1.getResultSet(); while (rslt.next()) {
	 * count = rslt.getInt(1); System.out.println("DEBUG : COUNT " + count); } } //
	 * pstmt1.getUpdateCount()
	 * 
	 * return count; }
	 */
	static void placeReservation(String name, String phoneNum, String numOfPeople, String dateOfReservation,
			String timeSlot, int count) throws SQLException {
		/**
		 * CREATE TABLE RESERVATION( NAME VARCHAR(20) NOT NULL, PHONENUMBER VARCHAR(12)
		 * NOT NULL, numOfPeople VARCHAR(12) NOT NULL, dateOfReservation VARCHAR(12) NOT
		 * NULL, timeSlot VARCHAR(12) NOT NULL );
		 */
		OracleDataSource ods = new OracleDataSource();

		ods.setURL("jdbc:oracle:thin:@//localhost:1521/XE");
		// jdbc:oracle:thin@//[hostname]:[port]/[DB service name]
		ods.setUser("SYSTEM"); // [username]
		ods.setPassword("javajuice"); // [password]
		Connection conn = ods.getConnection();

		// String insertcustsql = "insert into CUSTOMER (ID,
		// NAME,PHONENUMBER,ADDRESS,CITY,ZIP) " + "VALUES (SEQ_ID.nextval,?,?,?,?,?)";
		String insertreservationsql = "insert into RESERVATION (NAME,PHONENUMBER,NUMOFPEOPLE,DATEOFRESERVATION,TIMESLOT) "
				+ "VALUES (?,?,?,?,?)";

		PreparedStatement pstmt1 = conn.prepareStatement(insertreservationsql);

		boolean flag1;
		System.out.println("DEBUG : insert into reservations: numOfPeople "+ numOfPeople);
		pstmt1.setString(1, name);
		pstmt1.setString(2, phoneNum);
		pstmt1.setString(3, numOfPeople);
		pstmt1.setString(4, dateOfReservation);
		pstmt1.setString(5, timeSlot);
		flag1 = pstmt1.execute();
		int capacity = count;
		int people = Integer.parseInt(numOfPeople);
		capacity = (capacity - people);

		// ADD LOGIC to update/adjust SEATING_CAPACITY
		// UPDATE SEATING_CAPACITY SET CAPACITY = count

	}
}
