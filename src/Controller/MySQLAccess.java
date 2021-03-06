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

import Model.Lot;
import Model.ModeleSamolotow;
import Model.Samolot;
import Model.SamolotDB;

/**
 * Class responsible for the database connection, download and pre-processing of data
 *
 */
public class MySQLAccess {

	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
//	static final String DB_URL = "jdbc:mysql://85.128.223.48:3306/szabat94_2"; // bledy z czasem dostepu na nazwa.pl
	static final String DB_URL = "jdbc:mysql://localhost:3306/lotnisko";

	static final String USER = "root";
	static final String PASS = "test123";
	// Model fields

	private ConnectionSource connectionSource;
	
	private Dao<SamolotDB, String> planeDao;
	private Dao<Lot, String> lotyDao;
	private Dao<ModeleSamolotow, String> modeleSamolotowDao;


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
		createLotDAO();
		createModeleSamolotowDAO();
//		createSpeciesDAO();
//		createAnimalDAO();
//		createHistoryDAO();
	}
	
	private void createPlaneDAO() {
		try {
			planeDao = DaoManager.createDao(connectionSource, SamolotDB.class);
		} catch (SQLException e1) {
			System.out.println("bbbb");
		} catch (Exception e){
			e.printStackTrace();
			System.out.println("zzz");
		}
	}
	
	private void createLotDAO() {
		try {
			lotyDao = DaoManager.createDao(connectionSource, Lot.class);
		} catch (SQLException e1) {
			System.out.println("bbbb");
		} catch (Exception e){
			e.printStackTrace();
			System.out.println("zzz");
		}
	}
	private void createModeleSamolotowDAO(){
		try {
			modeleSamolotowDao = DaoManager.createDao(connectionSource, ModeleSamolotow.class);
		} catch (SQLException e1) {
			System.out.println("bbbb");
		} catch (Exception e){
			e.printStackTrace();
			System.out.println("zzz");
		}
	}
	
	public List<SamolotDB> getSamolotyListFromDatabase() {
		openDatabaseConnection();
		List<SamolotDB> samoloty = null;
		try {
			samoloty = planeDao.queryForAll();
			return samoloty;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		closeDatabaseConnection();
		return samoloty;
	}
	
	public List<Lot> getLotyListFromDatabase() {
		openDatabaseConnection();
		List<Lot> loty = null;
		try {
			loty = lotyDao.queryForAll();
			return loty;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		closeDatabaseConnection();
		return loty;
	}
	
	public List<ModeleSamolotow> getModeleSamolotowListFromDatabase(){
			openDatabaseConnection();
			List<ModeleSamolotow> modele = null;
			try {
				modele = modeleSamolotowDao.queryForAll();
				return modele;
			} catch (SQLException e) {
				e.printStackTrace();
			}
			closeDatabaseConnection();
			return modele;
	}
	
	 
	public void UpdateStatus(int samolotId, int status)
	{
		openDatabaseConnection();
		UpdateBuilder<SamolotDB, String> u = planeDao.updateBuilder();
		try {
			u.updateColumnValue("status_samolotu", status).where().eq("id_samolotu", samolotId);
			u.update();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		closeDatabaseConnection();
	}
	
	public void updateMiejsceParkingowe(int samolotId, String parking)
	{
		openDatabaseConnection();
		UpdateBuilder<SamolotDB, String> u = planeDao.updateBuilder();
		try {
			u.updateColumnValue("miejsce_parkowania_samolotu", parking).where().eq("id_samolotu", samolotId);
			u.update();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		closeDatabaseConnection();
	}
	
	public int ostatnieIdSamolotu(){
		
		openDatabaseConnection();
		int lastID = -1;
	    QueryBuilder<SamolotDB, String> q = planeDao.queryBuilder();
		try {
			q.orderBy("id_samolotu", false);
			lastID = planeDao.queryForFirst(q.prepare()).getIdSamolotu();
			return lastID;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		closeDatabaseConnection();
		return lastID;
	}
	
	public void dodajSamolot(ModeleSamolotow model){
	
		int idSamolotu = ostatnieIdSamolotu();
		
		openDatabaseConnection();
		try {
			SamolotDB plane = new SamolotDB(idSamolotu+1 ,model, 1, "Nie dotyczy");
			planeDao.create(plane);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		closeDatabaseConnection();
	}
}
