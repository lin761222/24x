package com.dreamlin.activity;

import android.support.v7.app.ActionBarActivity;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class Login extends Activity {
	private EditText mUser; // 帳號編輯框
	private EditText mPassword; // 密碼編輯框

	final String PREFS_NAME = "ACCOUNT";// 喜好設定名稱
	final String User = "User";
	final String Password = "Password";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);

		mUser = (EditText) findViewById(R.id.login_user_edit);
		mPassword = (EditText) findViewById(R.id.login_passwd_edit);

		// 取得SharedPerferences物件
		SharedPreferences sp = getSharedPreferences(PREFS_NAME,
				Context.MODE_PRIVATE);

		mUser.setText(sp.getString(User, ""));
		mPassword.setText(sp.getString(Password, ""));
	}

	public void login_mainweixin(View v) {
		SharedPreferences sp = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);

		Editor editor = sp.edit(); // 取得編輯器物件
		String user = mUser.getText() + "";
		editor.putString(User, user);
		String password = mPassword.getText() + "";
		editor.putString(Password, password);
		editor.commit();

		if ("alex".equals(mUser.getText().toString())
				&& "123".equals(mPassword.getText().toString())) // 判斷帳號和密碼
		{
			Intent intent = new Intent();
			intent.setClass(Login.this, Loading.class);
			startActivity(intent);
		} else if ("".equals(mUser.getText().toString())
				|| "".equals(mPassword.getText().toString())) // 判斷帳號和密碼
		{
			new AlertDialog.Builder(Login.this)
					.setIcon(
							getResources().getDrawable(
									R.drawable.login_error_icon))
					.setTitle("登入錯誤").setMessage("登入帳號或密碼不能為空，\n請輸入後再登入！")
					.create().show();
		} else {

			new AlertDialog.Builder(Login.this)
					.setIcon(
							getResources().getDrawable(
									R.drawable.login_error_icon))
					.setTitle("登入失敗").setMessage("登入帳號或密碼不正確，\n請檢查後重新輸入！")
					.create().show();
		}
	}

	public void login1(View v) {
		Intent it = new Intent(Login.this, MainApp.class);
		startActivity(it);
	}
}
