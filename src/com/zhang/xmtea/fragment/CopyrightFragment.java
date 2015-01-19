package com.zhang.xmtea.fragment;

import com.zhang.xmtea.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * 显示版权信息
 * 
 * @author zhangyg
 * 
 */
public class CopyrightFragment extends Fragment {
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_copyright, null);
		return view;
	}
}

