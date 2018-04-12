package com.youquan.main.core.fragment;

import com.base.BFragment;
import com.youquan.R;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

@SuppressLint("InflateParams")
public class MineFragment extends BFragment {
	@Override
	protected View getView(LayoutInflater layoutInflater, ViewGroup root) {
		return layoutInflater.inflate(R.layout.fragment_mine, null);
	}

	@Override
	protected void loadView() {
	}

	@Override
	protected void onActivityCreated() {
	}
}
