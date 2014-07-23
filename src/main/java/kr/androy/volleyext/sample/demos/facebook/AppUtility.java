package kr.androy.volleyext.sample.demos.facebook;

import android.app.Activity;

public class AppUtility {

	public static final String USER_NAME = "aq.fb.user.name"; 
	
	public final static String APP_ID = "304050252938418";
	//private static String PERMISSIONS = "read_stream,read_friendlists,manage_friendlists,manage_notifications,publish_stream,publish_checkins,offline_access,user_photos,user_likes,user_groups,friends_photos";
	private static String PERMISSIONS = "read_stream,read_friendlists,manage_friendlists,manage_notifications,publish_stream,publish_checkins,offline_access,user_about_me,friends_about_me,user_activities,friends_activities,user_checkins,friends_checkins,user_events,friends_events,user_groups,friends_groups,user_interests,friends_interests,user_likes,friends_likes,user_notes,friends_notes,user_photos,friends_photos,user_status,friends_status,user_videos,friends_videos";
	
	
	public static FacebookHandle makeHandle(Activity act){
		
		FacebookHandle handle = new FacebookHandle(act, APP_ID, PERMISSIONS);
		handle.message("페이스북로그인");

		return handle;
		
	}

	
}
