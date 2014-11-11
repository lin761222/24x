package com.dreamlin.activity;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v7.app.ActionBarActivity;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Students2 extends Activity implements OnPageChangeListener {

	ViewPager viewPager;
	// 裝點點的
	ImageView[] tips;
	// 裝圖片的
	ImageView[] mImageViews;
	// 圖片資源id
	int[] imgIdArray;
	// 文字組
	TextView txv, txv2;
	// String a = KindList.this.getResources().getString(R.string.kind_1);
	String txv_index[] = { "學員小資料1", "學員小資料2", "學員小資料3", "學員小資料4", "學員小資料5" };
	String txv_index2[] = { "學員小資料1 \n 50-100字", "學員小資料2 \n 50-100字",
			"學員小資料3 \n 50-100字", "學員小資料4 \n 50-100字", "學員小資料5 \n 50-100字" };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.students2);
		ViewGroup group = (ViewGroup) findViewById(R.id.viewGroup);
		viewPager = (ViewPager) findViewById(R.id.viewPager);

		imgIdArray = new int[] { R.drawable.student_1, R.drawable.student_2,
				R.drawable.student_3, R.drawable.student_4,
				R.drawable.student_5 };
		txv = (TextView) findViewById(R.id.txv);
		txv2 = (TextView) findViewById(R.id.txv2);

		// 將點點加入到ViewGroup中
		tips = new ImageView[imgIdArray.length];
		for (int i = 0; i < tips.length; i++) {
			ImageView imageView = new ImageView(this);
			imageView.setLayoutParams(new LayoutParams(10, 10));
			tips[i] = imageView;
			if (i == 0) {
				tips[i].setBackgroundResource(R.drawable.page);
			} else {
				tips[i].setBackgroundResource(R.drawable.page_now);
			}

			LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
					new ViewGroup.LayoutParams(LayoutParams.WRAP_CONTENT,
							LayoutParams.WRAP_CONTENT));
			layoutParams.leftMargin = 5;
			layoutParams.rightMargin = 5;
			group.addView(imageView, layoutParams);
		}
		// 將圖片裝載到數組中
		mImageViews = new ImageView[imgIdArray.length];
		for (int i = 0; i < mImageViews.length; i++) {
			ImageView imageView = new ImageView(this);
			mImageViews[i] = imageView;
			imageView.setBackgroundResource(imgIdArray[i]);
			// 設定文字
			txv.setText(txv_index[i]);
		}

		// 設置Adapter
		viewPager.setAdapter(new MyAdapter());
		// 設置監聽，主要是設置點點的背景
		viewPager.setOnPageChangeListener(this);
		// 設置ViewPager的默認項, 設置為長度的100倍，這樣子開始就能往左滑動
		viewPager.setCurrentItem((mImageViews.length * 100));
	}

	@Override
	public void onPageScrollStateChanged(int arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onPageScrolled(int arg0, float arg1, int arg2) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onPageSelected(int arg0) {
		Log.e("position", arg0 + "");
		setImageBackground(arg0 % mImageViews.length);
		setPageText(arg0 % mImageViews.length);

	}

	private void setPageText(int p) {
		txv.setText(txv_index[p]);
		txv2.setText(txv_index2[p]);
	}

	private void setImageBackground(int selectItems) {
		for (int i = 0; i < tips.length; i++) {
			if (i == selectItems) {
				tips[i].setBackgroundResource(R.drawable.page);
			} else {
				tips[i].setBackgroundResource(R.drawable.page_now);
			}
		}
	}

	public class MyAdapter extends PagerAdapter {

		@Override
		public int getCount() {
			return Integer.MAX_VALUE;
		}

		@Override
		public boolean isViewFromObject(View arg0, Object arg1) {
			return arg0 == arg1;
		}

		@Override
		public void destroyItem(View container, int position, Object object) {
			((ViewPager) container).removeView(mImageViews[position
					% mImageViews.length]);

		}

		/**
		 * 載入圖片進去，用當前的position 除以圖片數組長度取餘數是關鍵
		 */
		@Override
		public Object instantiateItem(View container, int position) {
			((ViewPager) container).addView(mImageViews[position
					% mImageViews.length], 0);
			return mImageViews[position % mImageViews.length];
		}

	}

	public void btn_back(View v) {
		finish();
	}
}
