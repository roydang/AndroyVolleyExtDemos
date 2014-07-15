package kr.androy.volleyext.sample.demos.db.ormlite;

import java.sql.SQLException;
import java.util.List;

import com.j256.ormlite.android.apptools.OpenHelperManager;

import kr.androy.volleyext.sample.demos.R;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class ORMLiteTestActivity extends Activity {
	
	private DatabaseHelper databaseHelper;
	private ListView listView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {	
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sqllite_test);
		setTitle("ORMLiteTestActivity test1");
		initView();
	}
	private void initView() {
				
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
				try {
					getHelper().deleteAllBook();
				} catch (SQLException e) {
					new RuntimeException(e);
				}
				testShowList();
			}
		});
		testShowList();
	}
	private void testShowList() {
		
		List<String> bookList = null;
		try {
			bookList = getHelper().getAllBooksTitle();
		} catch (SQLException e) {
			new RuntimeException(e);
		}
		
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, bookList);
		
		listView.setAdapter(adapter);
	}
	private void testInsert() {
			  

		try {
			getHelper().addBook(new Book("Android Application Development Cookbook", "Wei Meng Lee"));
			getHelper().addBook(new Book("Android Programming: The Big Nerd Ranch Guide", "Bill Phillips and Brian Hardy"));       
			getHelper().addBook(new Book("Learn Android App Development", "Wallace Jackson"));
	 
		} catch (SQLException e) {
			new RuntimeException(e);
		}   
		
	}
	private DatabaseHelper getHelper() {
		if (databaseHelper == null) {
			databaseHelper = OpenHelperManager.getHelper(this, DatabaseHelper.class);
		}
		return databaseHelper;
	}
	
	
  
}
