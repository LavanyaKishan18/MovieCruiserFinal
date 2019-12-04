package com.MovieCruiser.Dao;

import java.io.File;
import java.io.FileInputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author Lavanya_K
 *
 */

public class ConnectionHandler {
	public static Connection getConnection() {
		// TODO Auto-generated method stub
		Connection conn = null;

		try {
			URL resource = Thread.currentThread().getContextClassLoader()
					.getResource("connection.properties");
			Properties prop = new Properties();
			File file = new File(resource.toURI());
			FileInputStream fis = new FileInputStream(file);
			prop.load(fis);

			String dbDriverName = prop.getProperty("driver");
			System.out.println("dbDriverName.." + dbDriverName);
			String jdbcURL = prop.getProperty("connection-url");
			System.out.println("jdbcurl.." + jdbcURL);
			String dbUserName = prop.getProperty("user");
			System.out.println("dbUserName.." + dbUserName);
			String dbPassword = prop.getProperty("password");
			System.out.println("dbpassword.." + dbPassword);

			Class.forName(dbDriverName);
			conn = DriverManager.getConnection(jdbcURL, dbUserName, dbPassword);

		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;

	}

}
