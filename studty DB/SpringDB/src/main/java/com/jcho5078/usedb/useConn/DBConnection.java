package com.jcho5078.usedb.useConn;

import java.sql.*;

import org.springframework.stereotype.Component;

/************ jdbc 사용 테스트 ***********/

//java application으로 오라클 db연동시 ojdbc.jar을 프로젝트에 첨부.
//서버로 db 연동시 ojdbc.jar을 톰캣 lib폴더에 첨부.

@Component
public class DBConnection {

	private static final String OJDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";
	private static Connection conn = null;

	private String username;
	private String password;
	private String DB_QUERY;
	private boolean isConnected;
	
	private String DB_HOST = "127.0.0.1";
	private String DB_PORT = "1521";
	private String DB_DBNAME = "orcl";
	
	public void main() throws ClassNotFoundException, SQLException{
		try {
			
			try {
				Class.forName(OJDBC_DRIVER);
			} catch (ClassNotFoundException e) {
				System.out.println("Oracle JDBC Driver error");
				e.printStackTrace();
				throw e;
			}
			
			System.out.println("Oracle JDBC Driver Registered");
			
			try {
				conn = DriverManager.getConnection("jdbc:oracle:thin:@" + DB_HOST + ':' + DB_PORT + ':' + DB_DBNAME, username, password);
				isConnected = true;
			} catch (SQLException e) {
				e.printStackTrace();
				isConnected = false;
			}
			
			System.out.println(username + " " + password + " " + isConnected);
			
			if (isConnected) {
				System.out.print("Oracle database is connected");
				System.out.println();
				Statement statement = null;
				ResultSet resultSet = null;
				try {
					// Create Statement
					statement = conn.createStatement();

					// Execute SQL query
					resultSet = statement.executeQuery(DB_QUERY);
					// get ResultMetaData
					ResultSetMetaData rsMetaData = resultSet.getMetaData();
					// column length in table
					int numberOfColumn = rsMetaData.getColumnCount();

					// Print columns
					for (int i = 0; i < numberOfColumn; i++) {
						System.out.print(rsMetaData.getColumnLabel(i + 1));
						System.out.print("    ");
					}
					System.out.println();

					// Print rows
					while (resultSet.next()) {
						for (int i = 1; i <= numberOfColumn; ++i) {
							String value = resultSet.getString(i);
							System.out.print(value);
							System.out.print("    ");
						}
						System.out.println();
					}


				} catch (SQLException e) {
					System.out.println("SQL error : " + e.getMessage());
				}
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("Error : " + e.getMessage());
		}
	}
	
	public void setDB(String username, String password, String DB_QUERY) {
		this.username = username;
		this.password = password;
		this.DB_QUERY = DB_QUERY;
	}
	
}
