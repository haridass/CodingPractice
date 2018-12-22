package com.cars.userconversion.teradata;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;


public class TruncateTerdataTable  {
	private static final Logger log = Logger.getLogger(TruncateTerdataTable.class);
	
	static final String JDBC_DRIVER = "com.teradata.jdbc.TeraDriver";
	
	public static void main(String[] args) throws ClassNotFoundException  {
		if(args.length < 5) {
			System.out.println("usage :  hostName, databaseName, tableName, username, password ");
			return ;
		}
		
	final String  hostname = args[0].toString();
	final String  databaseName = args[1].toString();
	final String  tableName = args[2].toString();
	final String  username = args[3].toString();
	final String  password = args[4].toString();
	Connection conn = null;
    Statement stmt = null;
    final String DBURL =
    		"jdbc:teradata://" + hostname +"/DATABASE="+ databaseName;
    
    try {
    	Class.forName(JDBC_DRIVER);
    	
		conn = DriverManager.getConnection(DBURL, username, password);
		
		log.info("Connecting To Database");
		stmt = conn.createStatement();
		stmt.execute("delete  from " + tableName + " all");
		stmt.execute("commit");
		log.info("truncated Table "+tableName );
	} catch (SQLException e) {
		log.error("Something went wrong " + e.getMessage() );
		e.printStackTrace();
		System.exit(-1);
		
	}
    
	}

}
