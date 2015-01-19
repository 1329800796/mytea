package com.zhang.xmtea.fragment.base;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.zhang.xmtea.R;
import com.zhang.xmtea.ui.ContentActivity;
import com.zhang.xmtea.weight.XListView;
import com.zhang.xmtea.weight.XListView.IXListViewListener;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * 对于共同的fragment中，研究一下共同的，，都要实现一个可以上拉加载的，自定义的listView，以及它的监听
 * 
 * 简单点说，所有需要listView的fragment，就继承这个
 * 
 * @author zhangyg
 * 
 */
public class BaseListFragment extends Fragment implements IXListViewListener{

	private final String TAG = "BaseListFragment";
	
	/** 自定义listView */
	protected XListView listview;
	
	/** 用来填充整个listview布局 */
	protected View view;
	
	/** inflater填充布局器 */
	LayoutInflater mInflater;
	
	/** 卷轴标记 */
	protected boolean mIsScroll = false;
	
	public ExecutorService executorService = Executors.newFixedThreadPool(5);
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		mInflater = inflater;
		view = inflater.inflate(R.layout.fragment_content, null);
		listview = (XListView) view.findViewById(R.id.listView_contentfragment);
		listview.setPullLoadEnable(true);
		listview.setPullRefreshEnable(false);
		return super.onCreateView(inflater, container, savedInstanceState);
	}
	
	/**
	 * 跳转到网页内容页
	 * 
	 * @param position
	 *            项目行数
	 */
	public void goContentActivity(String idStr) {
		Intent intent = new Intent(getActivity(), ContentActivity.class);
		intent.putExtra("id", idStr);
		startActivity(intent);
	}
	
	public BaseListFragment() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onRefresh() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onLoadMore() {
		// TODO Auto-generated method stub
		
	}

}
