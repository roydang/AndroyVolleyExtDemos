package kr.androy.volleyext.sample.demos.db;

import java.util.List;

import kr.androy.volleyext.sample.demos.R;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class SQLiteTestActivity extends Activity {
	
	private MySQLiteHelper db;
	private ListView listView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {	
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sqllite_test);
		setTitle("SQLiteTestActivity");
		initView();
	}
	private void initView() {
		db = new MySQLiteHelper(this);
		
		listView = (ListView)findViewById(R.id.sqlite_list);		
		Button insertBtn = (Button)findViewById(R.id.test_sqlite_insert);
		insertBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				testInsert();
				testShowList();
			}
		});
		Button deleteBtn = (Button)findViewById(R.id.test_sqlite_delete);
		deleteBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				db.deleteAllBook();
				testShowList();
			}
		});
		testShowList();
	}
	private void testShowList() {
		
		List<String> bookList = db.getAllBooksTitle();
		
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, bookList);
		
		listView.setAdapter(adapter);
	}
	private void testInsert() {

        // add Books
        db.addBook(new Book("Android Application Development Cookbook", "Wei Meng Lee"));   
        db.addBook(new Book("Android Programming: The Big Nerd Ranch Guide", "Bill Phillips and Brian Hardy"));       
        db.addBook(new Book("Learn Android App Development", "Wallace Jackson"));
 
    
	}
	
	
  
}
