package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

//import com.sun.xml.internal.fastinfoset.sax.Properties;

public class DBConnect {

	private Connection connect = null;
	private Statement statement = null;

	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;

	List<String> list = new ArrayList<String>();

	public static Properties loadProperties() throws IOException {
		Properties prop = new Properties();
		InputStream ism = new FileInputStream("Path to my sql properties");
		prop.load(ism);
		ism.close();

		return prop;
	}

	// Connect to Database
	public void connectToDataBase() throws Exception {
		Properties prop = loadProperties();
		String driverClass = prop.getProperty("MYSQLJDBC.driver");
		String url = prop.getProperty("MYSQLJDBC.url");
		String userName = prop.getProperty("MYSQLJDBC.userName");
		String passWord = prop.getProperty("MYSQLJDBC.passWord");
		// this will load the mysql driver
		Class.forName(driverClass);
		// set up the connection with db
		connect = DriverManager.getConnection(url, userName, passWord);
		System.out.println("Database connected");

	}

	public List<String> readDataBase() throws Exception {
		try {

			connectToDataBase();
			// statements allow to issue sql queries to the database
			statement = connect.createStatement();
			// result set get the result of the sql query
			resultSet = statement.executeQuery("select * from CNNNews");
			getResultSetData(resultSet);

		} finally {
			close();
		}
		return list;
	}

	private List<String> getResultSetData(ResultSet resultSet) throws SQLException {
		while (resultSet.next()) {
			String itemName = resultSet.getString("NewsTitle");
			list.add(itemName);

		}
		return list;

	}

	public void writeResultSetToConsole(ResultSet resultSet) throws SQLException {
		while (resultSet.next()) {
			String itemName = resultSet.getString("NewsTitle");
			System.out.println("News Title " + itemName);
		}
	}

	private void close() {
		try {
			if (resultSet != null) {
				resultSet.close();
			}

			if (statement != null) {
				statement.close();

			}
			if (connect != null) {
				connect.close();
			}
		} catch (Exception e) {

		}
	}

	// done so far here still need to make the properties file though
	private List<String> getResultSetData(ResultSet resultSet2, String columnName) throws SQLException {
		// TODO Auto-generated method stub

		List<String> dataList = new ArrayList<String>();
		while (resultSet.next()) {
			String itemName = resultSet.getString(columnName);
			dataList.add(itemName);
		}

		return dataList;

	}

	// functions for Data insert into MySql Database
	public void InsertDataFromArrayToMySql(int[] ArrayData, String tableName, String coumnName) throws Exception {
		// insert data from arryalist to mysql
		try {
			connectToDataBase();

			for (Object st : list) {
				preparedStatement = connect
						.prepareStatement("Insert into " + tableName + "(" + coumnName + ") values (?)");
				preparedStatement.setObject(1, st);
			}

		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
