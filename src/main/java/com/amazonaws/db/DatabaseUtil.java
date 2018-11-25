package com.amazonaws.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseUtil {
	
	// These are to be configured and NEVER stored in the code.
	// once you retrieve this code, you can update
	public final static String rdsMySqlDatabaseUrl = "schedulerdb.c4dv7tplfdcj.us-east-2.rds.amazonaws.com";
	public final static String dbUsername = "schedulerAdmin";
	public final static String dbPassword = "scheduler:pass";
		
	public final static String jdbcTag = "jdbc:mysql://";
	public final static String rdsMySqlDatabasePort = "3306";
	public final static String multiQueries = "?allowMultiQueries=true";
}
