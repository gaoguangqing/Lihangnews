package com.spoon.onews.ui;

import java.util.ArrayList;

import org.apache.http.Header;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshBase.OnRefreshListener;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.spoon.onews.R;
import com.spoon.onews.adapter.TextNewsAdapter;
import com.spoon.onews.api.ApiHttpClient;
import com.spoon.onews.api.NewsApi;
import com.spoon.onews.bean.News;
import com.spoon.onews.bean.NewsContainer;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

public class TextNewsActivity extends Activity {
	
	private PullToRefreshListView lvTextNews;
	
	
	ArrayList<News> news;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_text_news);
		
		initView();
		NewsApi.getTextNewsInfoBase(mHandler);
		
		
		
	}
	
	private void initData() {
		TextNewsAdapter tNadapter=new TextNewsAdapter(news,this);
		lvTextNews.setAdapter(tNadapter);
		
		lvTextNews.setOnRefreshListener(new OnRefreshListener<ListView>() {

			@Override
			public void onRefresh(PullToRefreshBase<ListView> refreshView) {
				// TODO Auto-generated method stub
				NewsApi.getTextNewsInfoBase(mHandler);
				
				new AsyncTask<Void, Void, Void>() {

					@Override
					protected Void doInBackground(Void... params) {
						
						try {
							Thread.sleep(2000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						
						
						return null;
					}
					
					
					protected void onPostExecute(Void result) {
						
						NewsApi.getTextNewsInfoBase(mHandler);
						lvTextNews.onRefreshComplete();
					};
					
				}.execute();
				
				
				
			}
			
		});
		
	}

	private void initView() {
		// TODO Auto-generated method stub
		lvTextNews=(PullToRefreshListView) findViewById(R.id.lv_textNews);
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
			Toast.makeText(TextNewsActivity.this, "«Î«Û≥¨ ±", Toast.LENGTH_SHORT).show();
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
