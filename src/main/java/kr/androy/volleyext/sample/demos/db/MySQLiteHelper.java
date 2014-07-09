package kr.androy.volleyext.sample.demos.db;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class MySQLiteHelper extends SQLiteOpenHelper {

	private static final String LOG_TAG = "MySQLiteHelper";
	// Database Version
    private static final int DATABASE_VERSION = 1;
    // Database Name
    private static final String DATABASE_NAME = "BookDB";
    
	public MySQLiteHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}
	 
	@Override
	public void onCreate(SQLiteDatabase db) {
		Log.d(LOG_TAG, "onCreate SQLiteDatabase=" + db);
		 // SQL statement to create book table
        String CREATE_BOOK_TABLE = "CREATE TABLE books (id INTEGER PRIMARY KEY AUTOINCREMENT, title TEXT, author TEXT)";
 
        // create books table
        db.execSQL(CREATE_BOOK_TABLE);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// Drop older books table if existed
        db.execSQL("DROP TABLE IF EXISTS books");
 
        // create fresh books table
        this.onCreate(db);
	}
	//---------------------------------------------------------------------
	 
    /**
     * CRUD operations 
     */
    // Books table name
    public static final String TABLE_BOOKS = "books";
 
    // Books Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_TITLE = "title";
    private static final String KEY_AUTHOR = "author";
 
    private static final String[] COLUMNS = {KEY_ID,KEY_TITLE,KEY_AUTHOR};

    public void addBook(Book book){
        Log.d("addBook", book.toString());

        SQLiteDatabase db = this.getWritableDatabase();
 
        ContentValues values = new ContentValues();
        values.put(KEY_TITLE, book.getTitle()); // get title 
        values.put(KEY_AUTHOR, book.getAuthor()); // get author
 
        db.insert(TABLE_BOOKS, // table
                null, //nullColumnHack
                values); // key/value -> keys = column names/ values = column values
 
        db.close(); 
    }
 
    public Book getBook(int id){
 
        SQLiteDatabase db = this.getReadableDatabase();
 
        Cursor cursor = 
                db.query(TABLE_BOOKS, // a. table
                COLUMNS, // b. column names
                " id = ?", // c. selections 
                new String[] { String.valueOf(id) }, // d. selections args
                null, // e. group by
                null, // f. having
                null, // g. order by
                null); // h. limit
 
        
        if (cursor != null)
            cursor.moveToFirst();
 
        
        Book book = new Book();
        book.setId(Integer.parseInt(cursor.getString(0)));
        book.setTitle(cursor.getString(1));
        book.setAuthor(cursor.getString(2));
 
        Log.d("getBook("+id+")", book.toString());
        db.close();
        
        return book;
    }
 
    // Get All Books
    public List<Book> getAllBooks() {
        List<Book> books = new ArrayList<Book>();
 
        String query = "SELECT  * FROM " + TABLE_BOOKS;
 
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);
 
        Book book = null;
        if (cursor.moveToFirst()) {
            do {
                book = new Book();
                book.setId(Integer.parseInt(cursor.getString(0)));
                book.setTitle(cursor.getString(1));
                book.setAuthor(cursor.getString(2));

                books.add(book);
            } while (cursor.moveToNext());
        }
 
        Log.d("getAllBooks()", books.toString());
        db.close();

        return books;
    }
  
     // Updating single book
    public int updateBook(Book book) {
 
        SQLiteDatabase db = this.getWritableDatabase();
 
        ContentValues values = new ContentValues();
        values.put("title", book.getTitle()); // get title 
        values.put("author", book.getAuthor()); // get author
        
        int i = db.update(TABLE_BOOKS, //table
                values, // column/value
                KEY_ID+" = ?", // selections
                new String[] { String.valueOf(book.getId()) }); //selection args
 
        db.close();
 
        return i;
 
    }
 
    // Deleting single book
    public void deleteBook(Book book) {

        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_BOOKS,
                KEY_ID+" = ?",
                new String[] { String.valueOf(book.getId()) });
 

        db.close();
 
        Log.d("deleteBook", book.toString());
 
    }
    public int deleteAllBook() {
        SQLiteDatabase db = this.getWritableDatabase();
 
        int cnt = db.delete(TABLE_BOOKS,  null,  null);
 
        db.close();
        
        return cnt; 
    }
    
    // Get All Books Title
    public List<String> getAllBooksTitle() {
        List<String> books = new ArrayList<String>();
 
        String query = "SELECT title FROM " + TABLE_BOOKS;
 
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);
 
        if (cursor.moveToFirst()) {
            do {
                books.add(cursor.getString(0));
                
            } while (cursor.moveToNext());
        }
 
        Log.d("getAllBooks()", books.toString());
 
        return books;
    }
    public Cursor getAllBooksTitleCursor() {

        String query = "SELECT title FROM " + TABLE_BOOKS;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        
        return cursor;
    }
}
