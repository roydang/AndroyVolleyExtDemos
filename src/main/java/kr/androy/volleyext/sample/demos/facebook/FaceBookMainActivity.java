package kr.androy.volleyext.sample.demos.facebook;

import kr.androy.base.util.log.Logger;
import kr.androy.volleyext.sample.demos.R;
import kr.androy.volleyext.sample.demos.facebook.FacebookHandle.FBHandleListener;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class FaceBookMainActivity extends Activity {
	
	private static Logger logger = Logger.getLogger(FaceBookMainActivity.class);
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {	
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_facebook_main);
		
		Button facebookLoginBtn = (Button)findViewById(R.id.facebook_login_button);
		facebookLoginBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				final FacebookHandle fbHandle = AppUtility.makeHandle(FaceBookMainActivity.this);
				fbHandle.setListener(new FBHandleListener() {
					
					@Override
					public void onSuccess() {
						logger.d("# login success token:%s", fbHandle.getToken());
					}
					
					@Override
					public void onFail() {
						logger.d("# login fail token:%s", fbHandle.getToken());
					}
				});
				fbHandle.auth();
			}
		});
	}
}
