package com.example.androidmvc;

import java.util.List;

import com.example.android.appliction.MyAppliction;
import com.example.android.mvp.Myview;
import com.example.android.mvp.Persten;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class MainActivity extends Activity implements Myview,
		OnItemClickListener {
	private ListView listview;
	private Handler handler = new Handler();
	private Persten persten;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		listview = (ListView) findViewById(R.id.listview);
		// mvcģʽ
		 //mvc();
		persten = new Persten(this);
		listview.setOnItemClickListener(this);
	}

	private void mvc() {
		RequestBiz biz = new RequestBizImp();
		biz.requestData(new RequestListener() {

			@Override
			public void onsucess(final List<String> data) {
				// TODO Auto-generated method stub
				handler.post(new Runnable() {

					@Override
					public void run() {
						// TODO Auto-generated method stub
						ArrayAdapter<String> adapter = new ArrayAdapter<String>(
								getApplicationContext(),
								android.R.layout.simple_list_item_1, data);
						listview.setAdapter(adapter);
					}
				});
			}

		});
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		// 初始化数据
		persten.onResume();
	}

	@Override
	public void listData(List<String> list) {
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(
				getApplicationContext(), android.R.layout.simple_list_item_1,
				list);
		listview.setAdapter(adapter);
	}

	@Override
	public void onItemClick(AdapterView<?> adapterView, View view, int postion,
			long l) {
		// TODO Auto-generated method stub
		persten.getPostion(postion);
	}

}
