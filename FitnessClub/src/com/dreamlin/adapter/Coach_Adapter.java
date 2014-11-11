package com.dreamlin.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.dreamlin.activity.R;

public class Coach_Adapter extends BaseAdapter {
	Context context;
	int[] items_img;
	String[] names;

	public Coach_Adapter(Context context, int[] items_img, String[] names) {
		this.context = context;
		this.items_img = items_img;
		this.names = names;
	}

	@Override
	public int getCount() {
		return items_img.length;
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int pos, View view, ViewGroup arg2) {
		view = LinearLayout.inflate(context, R.layout.coach_adapter, null);
		ImageView img = (ImageView) view.findViewById(R.id.imageView1);
		TextView txv = (TextView) view.findViewById(R.id.txv);

		txv.setText(names[pos]);
		img.setImageResource(items_img[pos]);
		return view;
	}
}
