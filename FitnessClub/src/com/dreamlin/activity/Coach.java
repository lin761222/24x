package com.dreamlin.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.AdapterView.OnItemClickListener;

import com.dreamlin.adapter.Coach_Adapter;

public class Coach extends Activity implements OnItemClickListener {
	GridView gridView;
	int[] items_img = { R.drawable.coach_1, R.drawable.coach_2,
			R.drawable.coach_3, R.drawable.coach_4, R.drawable.coach_5,
			R.drawable.coach_6 };
	String[] names = { "LEO", "阿翰", "2", "3", "4", "5", "6" };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.coach);

		gridView = (GridView) findViewById(R.id.gridView1);
		gridView.setAdapter(new Coach_Adapter(this, items_img, names));
		gridView.setOnItemClickListener(this);
	}

	public void btn_back(View v) {
		finish();
	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View view, int pos, long arg3) {
		switch (pos) {
		case 0:
			Builder MyAlertDialog = new AlertDialog.Builder(Coach.this);
			MyAlertDialog.setIcon(getResources().getDrawable(R.drawable.line))
					.setTitle("leonchen15").setMessage("一分耕耘一分收獲").show();
			break;
		case 1:
			MyAlertDialog = new AlertDialog.Builder(Coach.this);
			MyAlertDialog.setIcon(getResources().getDrawable(R.drawable.line))
					.setTitle("Fuhunghan").setMessage("幫你瘦到你媽認不得").show();
			break;
		case 2:
			new AlertDialog.Builder(Coach.this)
					.setIcon(
							getResources().getDrawable(
									R.drawable.login_error_icon))
					.setTitle("神的領域").setMessage("神就是如此囂張\nLINE_ID=LINE！")
					.create().show();
		}
	}
}
