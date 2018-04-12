package com.youquan.main.core.activity.main;

import com.base.BFActivity;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.youquan.R;
import com.youquan.custom.NoScrollViewPager;
import com.youquan.main.core.fragment.FindFragment;
import com.youquan.main.core.fragment.HomeFragment;
import com.youquan.main.core.fragment.MineFragment;
import com.youquan.main.core.fragment.QuanFragment;

import android.app.Activity;
import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends BFActivity implements OnClickListener {
	@ViewInject(R.id.ly_tab_home)
	LinearLayout lyHome;
	@ViewInject(R.id.ly_tab_find)
	LinearLayout lyFind;
	@ViewInject(R.id.ly_tab_quan)
	LinearLayout lyQuan;
	@ViewInject(R.id.ly_tab_mine)
	LinearLayout lyMine;

	@ViewInject(R.id.iv_tab_home)
	ImageView ivHome;
	@ViewInject(R.id.iv_tab_find)
	ImageView ivFind;
	@ViewInject(R.id.iv_tab_quan)
	ImageView ivQuan;
	@ViewInject(R.id.iv_tab_mine)
	ImageView ivMine;

	@ViewInject(R.id.tv_tab_home)
	TextView tvHome;
	@ViewInject(R.id.tv_tab_find)
	TextView tvFind;
	@ViewInject(R.id.tv_tab_quan)
	TextView tvQuan;
	@ViewInject(R.id.tv_tab_mine)
	TextView tvMine;

	@ViewInject(R.id.myViewPager)
	NoScrollViewPager mViewPager;
	MyViewPagerAdapter mAdapter;

	// Fragment 数组
	private final Fragment[] TAB_FRAGMENTS = new Fragment[] { new HomeFragment(), new FindFragment(),
			new QuanFragment(), new MineFragment() };

	@Override
	public Activity getInstance() {
		return this;
	}

	@Override
	public int getXML() {
		return R.layout.activity_main;
	}

	@Override
	public void onCreate() {
		// 初始化监听
		lyHome.setOnClickListener(this);
		lyFind.setOnClickListener(this);
		lyQuan.setOnClickListener(this);
		lyMine.setOnClickListener(this);
		// 设置ViewPager
		mAdapter = new MyViewPagerAdapter(getSupportFragmentManager());
		mViewPager.setAdapter(mAdapter);
		mViewPager.setOffscreenPageLimit(4);
		lyHome.performClick();
	}

	@Override
	public int getBarColor() {
		return Color.TRANSPARENT;
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.ly_tab_home:
			setSelected();
			ivHome.setSelected(true);
			ivHome.setSelected(true);
			mViewPager.setCurrentItem(0);
			break;
		case R.id.ly_tab_find:
			setSelected();
			ivFind.setSelected(true);
			tvFind.setSelected(true);
			mViewPager.setCurrentItem(1);
			break;
		case R.id.ly_tab_quan:
			setSelected();
			ivQuan.setSelected(true);
			tvQuan.setSelected(true);
			mViewPager.setCurrentItem(2);
			break;
		case R.id.ly_tab_mine:
			setSelected();
			ivMine.setSelected(true);
			tvMine.setSelected(true);
			mViewPager.setCurrentItem(3);
			break;
		}
	}

	// 重置所有文本的选中状态
	private void setSelected() {
		ivHome.setSelected(false);
		ivFind.setSelected(false);
		ivQuan.setSelected(false);
		ivMine.setSelected(false);
		tvHome.setSelected(false);
		tvFind.setSelected(false);
		tvQuan.setSelected(false);
		tvMine.setSelected(false);
	}

	/**
	 * @description: ViewPager 适配器
	 */
	private class MyViewPagerAdapter extends FragmentPagerAdapter {
		public MyViewPagerAdapter(FragmentManager fm) {
			super(fm);
		}

		@Override
		public Fragment getItem(int position) {
			return TAB_FRAGMENTS[position];
		}

		@Override
		public int getCount() {
			return TAB_FRAGMENTS.length;
		}
	}

	@Override
	public void onBackPressed() {
		exitByDoubelClick();
	}
}
