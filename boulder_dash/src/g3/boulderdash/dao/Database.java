package g3.boulderdash.dao;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;


public class Database {
	private final static String URL = new String("jdbc:mysql://localhost/Corbeille?autoReconnect=true&useSSL=false");
	private final static String LOGIN = new String("Remi");
	private final static String PASSWORD = new String("remig14");
	private Connection connection;
	private Statement statement;
	
	
	
	public Database() {
		this.connection = null;
		this.statement = null;
	}
	
	
}
