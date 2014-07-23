package kr.androy.volleyext.sample.demos.db.ormlite;

import java.sql.SQLException;
import java.util.List;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.j256.ormlite.android.AndroidDatabaseResults;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.CloseableIterator;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.GenericRawResults;
import com.j256.ormlite.dao.RawRowMapper;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

/**
 * Database helper class used to manage the creation and upgrading of your database. This class also usually provides
 * the DAOs used by the other classes.
 */
public class DatabaseHelper extends OrmLiteSqliteOpenHelper {

	// name of the database file for your application -- change to something appropriate for your app
	private static final String DATABASE_NAME = "OrmBookDB.db";
	// any time you make changes to your database objects, you may have to increase the database version
	private static final int DATABASE_VERSION = 1;

	// the DAO object we use to access the SimpleData table
	private Dao<Book, Integer> simpleDao = null;

	public DatabaseHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}


	@Override
	public void onCreate(SQLiteDatabase db, ConnectionSource connectionSource) {
		try {
			Log.i(DatabaseHelper.class.getName(), "onCreate");
			TableUtils.createTable(connectionSource, Book.class);
		
		} catch (SQLException e) {
			Log.e(DatabaseHelper.class.getName(), "Can't create database", e);
			throw new RuntimeException(e);
		}
	}

	/**
	 * This is called when your application is upgraded and it has a higher version number. This allows you to adjust
	 * the various data to match the new version number.
	 */
	@Override
	public void onUpgrade(SQLiteDatabase db, ConnectionSource connectionSource, int oldVersion, int newVersion) {
		try {
			Log.i(DatabaseHelper.class.getName(), "onUpgrade");
			TableUtils.dropTable(connectionSource, Book.class, true);
			onCreate(db, connectionSource);
		} catch (SQLException e) {
			Log.e(DatabaseHelper.class.getName(), "Can't drop databases", e);
			throw new RuntimeException(e);
		}
	}

	/**
	 * Returns the Database Access Object (DAO) for our SimpleData class. It will create it or just give the cached
	 * value.
	 */
	public Dao<Book, Integer> getSimpleDataDao() throws SQLException {
		if (simpleDao == null) {
			simpleDao = getDao(Book.class);
		}
		return simpleDao;
	}

	/**
	 * Close the database connections and clear any cached DAOs.
	 */
	@Override
	public void close() {
		super.close();
		simpleDao = null;
	}
	
	//---------------------------------------------------------------------
	
	public void addBook(Book book) throws SQLException {
		 
		Dao<Book, Integer> dao = getSimpleDataDao();
		dao.create(book);	 
	}
	public Book getBook(int id) throws SQLException {

		Dao<Book, Integer> dao = getSimpleDataDao();
		Book book = dao.queryForId(id);
		return book;
	}
	public List<Book> getAllBooks() throws SQLException {
		Dao<Book, Integer> dao = getSimpleDataDao();
		List<Book> bookList = dao.queryForAll();
		return bookList;
	}
	public int updateBook(Book book) throws SQLException {
		Dao<Book, Integer> dao = getSimpleDataDao();
		int cnt = dao.update(book);
		return cnt;		
	}
	public void deleteBook(Book book) throws SQLException {
		Dao<Book, Integer> dao = getSimpleDataDao();
		dao.delete(book);
	}
	public void deleteAllBook() throws SQLException {
		TableUtils.clearTable(getConnectionSource(), Book.class);
	}
	public List<String> getAllBooksTitle() throws SQLException {
		Dao<Book, Integer> dao = getSimpleDataDao();
		
		QueryBuilder<Book, Integer> builder= dao.queryBuilder().selectColumns("title");
		
		final GenericRawResults<String> rawResults = dao.queryRaw(builder.prepareStatementString(), new RawRowMapper<String>() {
            public String mapRow(String[] columnNames, String[] resultColumns) {
                return resultColumns[0];
           }
        });
		List<String> results = rawResults.getResults();
		return results;
	}
    public Cursor getAllBooksTitleCursor() throws SQLException {
    	Dao<Book, Integer> dao = getSimpleDataDao();
    	QueryBuilder<Book, Integer> builder= dao.queryBuilder();
    	CloseableIterator<Book> iterator = dao.iterator(builder.prepare());
    	
    	AndroidDatabaseResults results = (AndroidDatabaseResults)iterator.getRawResults();
    	Cursor cursor = results.getRawCursor();
    	
    	return cursor;
    }
}
