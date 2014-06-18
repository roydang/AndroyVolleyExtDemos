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
package kr.androy.volleyext.sample.demos.application;

import kr.androy.volleyext.sample.demos.application.volley.MyVolley;

import android.app.Application;
import android.util.Log;

public class MyApplication extends Application {


	@Override
	public void onCreate() {
		Log.d("unknown","## MyApplication init1");
//		System.setProperty("org.apache.commons.logging.simplelog.log.org.apache.http", "debug");
		com.android.volley.VolleyLog.DEBUG  = true;
		super.onCreate();
		MyVolley.init(this);
	}

}
