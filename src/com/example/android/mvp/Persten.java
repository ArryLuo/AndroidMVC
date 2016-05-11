package com.example.android.mvp;

import java.util.List;

import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;

import com.example.android.appliction.MyAppliction;
import com.example.androidmvc.RequestBiz;
import com.example.androidmvc.RequestBizImp;
import com.example.androidmvc.RequestListener;

public class Persten {
	private RequestBiz biz;
	private Myview myview;
	private Handler handler;

	public Persten(Myview myview) {
		// 初始化
		this.myview = myview;
		// 实现接口
		biz = new RequestBizImp();
		handler = new Handler(Looper.getMainLooper());
	}

	// 初始化数据
	public void onResume() {
		biz.requestData(new RequestListener() {
			@Override
			public void onsucess(final List<String> data) {
				// TODO Auto-generated method stub
				handler.post(new Runnable() {

					@Override
					public void run() {
						myview.listData(data);
					}
				});
			}

		});
	}

	public void getPostion(int postion) {
		Toast.makeText(MyAppliction.getContext(), "第" + postion + "项", 0)
				.show();
	}
}
