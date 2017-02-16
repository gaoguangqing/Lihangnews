package com.spoon.onews.ui;

import java.util.ArrayList;

import org.apache.http.Header;

import com.loopj.android.http.AsyncHttpResponseHandler;
import com.spoon.onews.R;
import com.spoon.onews.adapter.MixNewsAdapter;
import com.spoon.onews.api.ApiHttpClient;
import com.spoon.onews.api.NewsApi;
import com.spoon.onews.bean.News;
import com.spoon.onews.bean.NewsContainer;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

public class MixNewsActivity extends Activity {
	
	private  ListView lvMixNews;
	
	
	ArrayList<News> news;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_mix_news);
		initView();
		NewsApi.getMixNewsInfoBase(mHandler);
		
		
		
	}
	
	private void initData() {
		MixNewsAdapter mixNewsAdapter=new MixNewsAdapter(news,this);
		lvMixNews.setAdapter(mixNewsAdapter);
		
	}

	private void initView() {
		// TODO Auto-generated method stub
		lvMixNews=(ListView) findViewById(R.id.lv_mixNews);
	}

protected AsyncHttpResponseHandler mHandler = new AsyncHttpResponseHandler() {

		
		@Override
		public void onSuccess(int statusCode, Header[] headers,
				byte[] responseBytes) {
			executeOnLoadDataSuccess(responseBytes);
			initData();
		}



		@Override
		public void onFailure(int arg0, Header[] arg1, byte[] arg2,
				Throwable arg3) {
			Toast.makeText(MixNewsActivity.this, "«Î«Û≥¨ ±", Toast.LENGTH_SHORT).show();
			Log.e(TextNewsActivity.class.getSimpleName(), arg3.getMessage());
			executeOnLoadDataError();
		}
	};

	
	protected void executeOnLoadDataSuccess(byte[] responseBytes) {
		NewsContainer nsContain=new NewsContainer();
		  nsContain= (NewsContainer) ApiHttpClient.getBean(responseBytes, NewsContainer.class);
		  news=new ArrayList<News>();
		  news=nsContain.list;
	}
	
	private void executeOnLoadDataError() {
		
	}

}
