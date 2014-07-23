package kr.androy.volleyext.sample.demos.view.activity;

import kr.androy.volleyext.sample.demos.R;
import kr.androy.volleyext.sample.demos.application.MyApplication;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ProgressBar;

import com.android.volley.toolbox.ImageLoader;
import com.navercorp.volleyextensions.view.ZoomableNetworkImageView;
import com.navercorp.volleyextensions.view.ZoomableNetworkImageView.OnImageChangedListener;

public class DoubleTapZoomNetworkImageViewActivity extends Activity {
	private static final String SAMPLE_IMAGE_URL = "http://www.phototravelpages.com/wallpapers/sunny-gardens-1024.jpg";
	private ZoomableNetworkImageView zoomableImageView;
	private ImageLoader imageLoader;
	private ProgressBar circleProgressBar;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_double_tap_zoom_network_image_view);
		imageLoader = MyApplication.getImageLoader();
		initializeZoomableImageView();
	}

	private void initializeZoomableImageView() {
		zoomableImageView = (ZoomableNetworkImageView) findViewById(R.id.zoom_imageview);
		circleProgressBar = (ProgressBar) findViewById(R.id.circleProgressBar);
		OnImageChangedListener listener = new OnImageChangedListener(){

			@Override
			public void onImageChanged(ZoomableNetworkImageView zoomableImageView) {
				if ( zoomableImageView.getDrawable() == null) {
					return;
				}
				circleProgressBar.setVisibility(View.GONE);
				zoomableImageView.removeOnImageChangedListener();
			}};
		zoomableImageView.setOnImageChangedListener(listener);
		zoomableImageView.setImageUrl(SAMPLE_IMAGE_URL, imageLoader);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		return true;
	}
}
