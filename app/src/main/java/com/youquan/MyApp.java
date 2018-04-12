package com.youquan;

import com.App;
import com.Utils;
import com.youquan.R;
import com.youquan.config.Config;

public class MyApp extends App {
	@SuppressWarnings("deprecation")
	@Override
	public void onCreate() {
		super.onCreate();
		Utils.initDefaultBarColor(getResources().getColor(R.color.main_color));
	}

	@Override
	protected void onConfig() {
		super.onConfig();
		config.setConfig(Config.IS_DEBUG, Config.APP_COMP, Config.SOFTWARE_NO);
	}
}
