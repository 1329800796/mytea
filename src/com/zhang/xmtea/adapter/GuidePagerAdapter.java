package com.zhang.xmtea.adapter;

import java.util.List;

import com.zhang.xmtea.R;
import com.zhang.xmtea.ui.MainActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class GuidePagerAdapter extends PagerAdapter {
	
	private final String TAG = "GuidePagerAdapter";
	/** 界面列表 */
	private List<View> views = null;
	/** 上下文内容 */
	private Context context = null;

	public GuidePagerAdapter(List<View> views, Context context) {
		// TODO Auto-generated constructor stub
		this.views = views;
		this.context = context;
	}

	@Override
	public void destroyItem(View container, int position, Object object) {
		// TODO Auto-generated method stub
		((ViewPager) container).removeView(views.get(position));
	}
	
	//获得当前界面数  
    @Override  
    public int getCount() {  
        if (views != null)  
        {  
            return views.size();  
        }  
          
        return 0;  
    }  

	@Override
	public Object instantiateItem(View container, int position) {
		((ViewPager) container).addView(views.get(position), 0);
		if (position == views.size() - 1) {
			/* 若是最后一个界面 */
			Button guide_btn = (Button) container.findViewById(R.id.guide_btn);
			/* 设置图片按钮监听，做跳转操作 */
			guide_btn.setOnClickListener(new View.OnClickListener() {

				@Override
				public void onClick(View v) {
					Intent intent = new Intent(context, MainActivity.class);
					context.startActivity(intent);
					((Activity) context).finish();

				}
			});
		}
		return views.get(position);
	}

	@Override
	public boolean isViewFromObject(View arg0, Object arg1) {
		// TODO Auto-generated method stub
		return arg0==arg1;
	}

}
