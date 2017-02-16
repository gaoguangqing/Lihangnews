package com.spoon.onews.api;

import com.loopj.android.http.AsyncHttpResponseHandler;

public class NewsApi {
	
	//http://172.19.24.23/fr-here/rest/app/news/list?picnews=-1&pageNum=1&pageSize=10
	//https://gaoguangqing.github.io/Lihangnews/txtnews.json
    public static void getTextNewsInfoBase(AsyncHttpResponseHandler handler){
        String url = "https://gaoguangqing.github.io/Lihangnews/txtnews.json";
        ApiHttpClient.get(url,handler);	
    }
    
    //http://172.19.24.23/fr-here/rest/app/news/list?picnews=1&pageNum=1&pageSize=10
    public static void getGraphNewsInfoBase(AsyncHttpResponseHandler handler){
        String url = "https://gaoguangqing.github.io/Lihangnews/graphnews.json";
        ApiHttpClient.get(url,handler);	
    }
    
    
    //https://gaoguangqing.github.io/Lihangnews/fr-here/news_img/news_20160811091447.jpg
    //http://172.19.24.23/fr-here/rest/app/news/list?picnews=0&pageNum=1&pageSize=10
    public static void getMixNewsInfoBase(AsyncHttpResponseHandler handler){
        String url = "https://gaoguangqing.github.io/Lihangnews/mixnews.json";
        ApiHttpClient.get(url,handler);	
    }

}


