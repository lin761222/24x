package com.dreamlin.activity;

import android.support.v7.app.ActionBarActivity;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class Loading extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.loading);
		
		new Handler().postDelayed(new Runnable() {
			public void run() {
				Intent intent = new Intent(Loading.this, News.class);
				startActivity(intent);
				Loading.this.finish();
				Toast.makeText(getApplicationContext(), "已登入\n請向右滑動\n查看近期活動",
						Toast.LENGTH_LONG).show();
			}
		}, 500);
	}
}
