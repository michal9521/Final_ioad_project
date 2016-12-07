package Controller;

import java.sql.SQLException;
import java.util.List;

//import org.jasypt.util.password.StrongPasswordEncryptor;


import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.stmt.DeleteBuilder;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.stmt.UpdateBuilder;
import com.j256.ormlite.support.ConnectionSource;

import Model.Samolot;

/**
 * Class responsible for the database connection, download and pre-processing of data
 *
 */
public class MySQLAccess {

	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
//	static final String DB_URL = "jdbc:mysql://85.128.223.48:3306/szabat94_2"; // bledy z czasem dostepu na nazwa.pl
	static final String DB_URL = "jdbc:mysql://localhost:3306/lotnisko";

	static final String USER = "root1";
	static final String PASS = "test123";
	// Model fields

	private ConnectionSource connectionSource;
	
	private Dao<Samolot, String> planeDao;

	// Game Model Constructor
	public MySQLAccess() {
		openDatabaseConnection();
		createDAOs();
		closeDatabaseConnection();
	}

	/**
	 * Open database conntection with specific url, user and password
	 */
	private void openDatabaseConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connectionSource = new JdbcConnectionSource(DB_URL, USER, PASS);
		} catch (SQLException e) {
			//e.printStackTrace();
		} catch (Exception e){
			
		}
	}

	/**
	 * close existed database connection
	 */
	private void closeDatabaseConnection() {
		try {
			connectionSource.close();
		} catch (SQLException e) {
			//e.printStackTrace();
		} catch (Exception e){
			
		}
	}

	/**
	 * Create all DAOs 
	 */
	private void createDAOs() {
		createPlaneDAO();
//		createSpeciesDAO();
//		createAnimalDAO();
//		createHistoryDAO();
	}
	
	private void createPlaneDAO() {
		try {
			planeDao = DaoManager.createDao(connectionSource, Samolot.class);
		} catch (SQLException e1) {
			System.out.println("bbbb");
		} catch (Exception e){
			System.out.println("zzz");
		}
	}
	
	public List<Samolot> getSamolotyListFromDatabase() {
		openDatabaseConnection();
		List<Samolot> samoloty = null;
		try {
			samoloty = planeDao.queryForAll();
			return samoloty;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		closeDatabaseConnection();
		return samoloty;
	}
	
}
