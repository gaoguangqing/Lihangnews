package com.spoon.onews.ui;

import java.util.ArrayList;

import org.apache.http.Header;

import com.loopj.android.http.AsyncHttpResponseHandler;
import com.spoon.onews.R;
import com.spoon.onews.adapter.GraphNewsAdapter;
import com.spoon.onews.api.ApiHttpClient;
import com.spoon.onews.api.NewsApi;
import com.spoon.onews.bean.News;
import com.spoon.onews.bean.NewsContainer;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.GridView;
import android.widget.Toast;

public class GraphNewsActivity extends Activity {
	private GridView gv;
	
	
	
	
	
	ArrayList<News> news;



	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_graph_news);
		gv=(GridView) findViewById(R.id.graph_news);
		
	
		
		
		NewsApi.getGraphNewsInfoBase(mHandler);
	
	}

	private void getData() {
		// TODO Auto-generated method stub
		GraphNewsAdapter adapter=new GraphNewsAdapter(news, this);
		gv.setAdapter(adapter);
	}
	
	
protected AsyncHttpResponseHandler mHandler = new AsyncHttpResponseHandler() {

		
		@Override
		public void onSuccess(int statusCode, Header[] headers,
				byte[] responseBytes) {
			executeOnLoadDataSuccess(responseBytes);
			getData();
		}



		@Override
		public void onFailure(int arg0, Header[] arg1, byte[] arg2,
				Throwable arg3) {
			Toast.makeText(GraphNewsActivity.this, "«Î«Û≥¨ ±", Toast.LENGTH_SHORT).show();
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
