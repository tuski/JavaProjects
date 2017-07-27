package com.controller.util;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Connection;

public class DBConnector {

	//this is database connection
	private Connection conn;
	
	//this is db url connect
	private final String DB_URL = "jdbc:mysql://localhost/test";
	private final String USER = "root";
	private final String PASSWORD = "";
	
	
	public DBConnector() throws SQLException{
		super();
		conn=(Connection) DriverManager.getConnection(DB_URL, USER, PASSWORD);
	}

	public Statement getStatement() throws SQLException {
		return conn.createStatement();
	}
	
	
	/**
	 *  /** then press enter
	 * <h1> prepared statement</h1>
	 * @param sql
	 * @return {@link Prepared State
	 * @throws SQLException
	 */
	
	public PreparedStatement getPreparedStatement(String sql) throws SQLException{
		
		return conn.prepareStatement(sql,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE,ResultSet.CLOSE_CURSORS_AT_COMMIT);
		
	}
	
}
