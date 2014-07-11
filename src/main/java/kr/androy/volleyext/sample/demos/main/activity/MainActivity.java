/*
 * Copyright (C) 2014 Naver Business Platform Corp.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package kr.androy.volleyext.sample.demos.main.activity;

import kr.androy.volleyext.sample.demos.R;
import kr.androy.volleyext.sample.demos.amazon.activity.AmazonActivity;
import kr.androy.volleyext.sample.demos.db.SQLiteTestActivity;
import kr.androy.volleyext.sample.demos.db.ormlite.ORMLiteTestActivity;
import kr.androy.volleyext.sample.demos.facebook.FaceBookMainActivity;
import kr.androy.volleyext.sample.demos.github.activity.GithubActivity;
import kr.androy.volleyext.sample.demos.view.activity.DoubleTapZoomNetworkImageViewActivity;
import kr.androy.volleyext.sample.demos.view.activity.SingleTapZoomNetworkImageViewActivity;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;

public class MainActivity extends Activity {

	ImageLoader loader;
	RequestQueue req;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
//		setStrictMode();
		
		Button instagramButton = (Button) findViewById(R.id.test_instagram);
		Button sqliteButton = (Button) findViewById(R.id.test_sqlite_button);
		Button ormliteButton = (Button) findViewById(R.id.test_ormlite_button);
		Button facebookActivityButton = (Button) findViewById(R.id.facebook_activity_button);
		Button githubActivityButton = (Button) findViewById(R.id.github_activity_button);
		Button amazonActivityButton = (Button) findViewById(R.id.amazon_activity_button);
		Button singleTapZoomNetworkImageViewActivityButton = (Button) findViewById(R.id.single_tap_zoom_network_image_view_activity_button);
		Button doubleTapZoomNetworkImageViewActivityButton = (Button) findViewById(R.id.double_tap_zoom_network_image_view_activity_button);
		
		instagramButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MainActivity.this, ORMLiteTestActivity.class);
				MainActivity.this.startActivity(intent);
			}
		});
		
		ormliteButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MainActivity.this, ORMLiteTestActivity.class);
				MainActivity.this.startActivity(intent);
			}
		});
		
		sqliteButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MainActivity.this, SQLiteTestActivity.class);
				MainActivity.this.startActivity(intent);
			}
		});
		
		facebookActivityButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MainActivity.this, FaceBookMainActivity.class);
				MainActivity.this.startActivity(intent);		
			}
		});
		githubActivityButton.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MainActivity.this, GithubActivity.class);
				MainActivity.this.startActivity(intent);		
			}});
		
		amazonActivityButton.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MainActivity.this, AmazonActivity.class);
				MainActivity.this.startActivity(intent);
			}});
		
		singleTapZoomNetworkImageViewActivityButton.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MainActivity.this, SingleTapZoomNetworkImageViewActivity.class);
				MainActivity.this.startActivity(intent);
			}});
		
		doubleTapZoomNetworkImageViewActivityButton.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MainActivity.this, DoubleTapZoomNetworkImageViewActivity.class);
				MainActivity.this.startActivity(intent);
			}});
	}

	@Override
	protected void onResume() {
		super.onResume();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	private void setStrictMode() {
		 StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
         .detectAll()
         .penaltyLog()
         .build());

		 StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder()
         .detectAll()
         .penaltyLog()
         .build());
	}

}
