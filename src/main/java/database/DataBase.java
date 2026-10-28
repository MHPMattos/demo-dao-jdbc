package database;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import exceptions.DbException;

public class DataBase {

	private static Connection connection = null;

	private static Properties loadProperties() {

		try (InputStream fis = DataBase.class.getClassLoader().getResourceAsStream("db.properties")) {

			Properties properties = new Properties();

			properties.load(fis);

			return properties;

		} catch (IOException e) {
			throw new DbException(e.getMessage());
		}
	}

	public static Connection getConnection() {

		try {
			if (connection == null) {
				Properties properties = loadProperties();
				String url = properties.getProperty("dburl");
				connection = DriverManager.getConnection(url, properties);

				return connection;
			}
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		return connection;
	}

	public static void closeConnection() {

		try {
			if (connection != null) {
				connection.close();
			}
		} catch (SQLException e) {
			throw new DbException(e.getLocalizedMessage());
		}
	}

	public static void closeStatement(Statement statement) {
		if (statement != null) {
			try {
				statement.close();
			} catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
		}

	}

	public static void closeResultSet(ResultSet resultSet) {
		if (resultSet != null) {
			try {
				resultSet.close();
			} catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
	}
}
