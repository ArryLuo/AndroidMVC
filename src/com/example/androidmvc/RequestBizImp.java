package com.example.androidmvc;

import java.util.ArrayList;
import java.util.List;

public class RequestBizImp implements RequestBiz {

	@Override
	public void requestData(final RequestListener listener) {
		new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				List<String> list = new ArrayList<String>();
				for (int i = 0; i < 10; i++) {
					String name = "刘备" + i;
					list.add(name);
				}
				if (list != null) {
					// 获取到的数据添加到回调函数中
					listener.onsucess(list);
				}
			}
		}).start();
	}

}
