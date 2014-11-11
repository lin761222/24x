package com.dreamlin.activity;

import android.support.v7.app.ActionBarActivity;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		new Handler().postDelayed(new Runnable() {
			public void run() {
				Intent intent = new Intent(MainActivity.this, Login.class);
				startActivity(intent);
				MainActivity.this.finish();
			}
		}, 1000);
	}
}
