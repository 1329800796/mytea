package com.zhang.xmtea.ui;

import com.zhang.xmtea.R;
import com.zhang.xmtea.config.MyConfig;
import com.zhang.xmtea.help.SharepreferencesHelp;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.app.Activity;
import android.content.Intent;

/**
 * 
 * 实现每次启动软件显示3秒界面，并判断是否是第一次运行，是否要开启引导页。
 * 
 * @author zhangyg
 * 
 */
public class StartActivity extends Activity {

	/** 日志标记 */
	private final String TAG = "StartActivity";
	/** SharedPreferences操作,功能判断是否是首次运行 */
	private SharepreferencesHelp sph;
	/** 主要功能，跳转到不同的界面 */
	private Handler mHandler;

	/**
	 * 生命周期最开始
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_start);
		initData();
	}

	/**
	 * 数据初始化
	 */
	private void initData() {
		Log.i(TAG, "==initData()");
		sph = new SharepreferencesHelp(StartActivity.this);
		mHandler = new Handler() {
			/**
			 * 0：跳转到用户首页；1：跳转到引导页。
			 */
			public void handleMessage(android.os.Message msg) {
				super.handleMessage(msg);

				switch (msg.what) {
				case 0:
					goActivity(MainActivity.class);
					break;
				case 1:
					goActivity(GuideActivity.class);
					break;
				}
			};
		};
		int isFirst = sph.getInt(MyConfig.IS_FIRST_RUN);

		if (isFirst == MyConfig.NOT_FIRST) {
			mHandler.sendEmptyMessageDelayed(0, 3000);
		} else {
			mHandler.sendEmptyMessageDelayed(1, 3000);
		}
	}

	/**
	 * 路转到某页面
	 */
	protected void goActivity(Class<?> cls) {

		Intent intent = new Intent(this, cls);
		startActivity(intent);
		this.finish();
	}

}
