package com.spoon.onews.api;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
import org.apache.http.client.params.ClientPNames;
import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

public class ApiHttpClient {


	public final static String HOST = "gaoguangqing.github.io";
    public static final String GET = "GET";
    public static final String POST = "POST";
    public static AsyncHttpClient client;
    
    static {
		AsyncHttpClient client = new AsyncHttpClient();
        client.setTimeout(20000);
        ApiHttpClient.setHttpClient(client);
    }
    

    public static AsyncHttpClient getHttpClient() {
        return client;
    }

    public static void get(String partUrl, AsyncHttpResponseHandler handler) {
        client.get(partUrl, handler);
    }


    public static void post(String partUrl, AsyncHttpResponseHandler handler) {
        client.post(partUrl, handler);
    }

    public static void post(String partUrl, RequestParams params,
            AsyncHttpResponseHandler handler) {
        client.post(partUrl, params, handler);
        
    }



	public static void setHttpClient(AsyncHttpClient c) {
		    client = c;
	        client.addHeader("Host", HOST);
	        client.addHeader("Connection", "Keep-Alive");    
	        client.getHttpClient().getParams()
	                .setParameter(ClientPNames.ALLOW_CIRCULAR_REDIRECTS, true);
	}
	
	
	  public static Object getBean(byte[]  arg2,Class<?> cls){
	    	String temp;
	    	Object object = null;
			try {
				temp = new String(arg2, "UTF-8");
				Gson gson = new Gson();
		    	 object = gson.fromJson(temp, cls);
		    	gson = null;
			} catch (UnsupportedEncodingException e) {
				System.out.println("转换出错");
				e.printStackTrace();
			}
	    	return object;
	    }
	  
	  
	  public static Object getArrayBean(byte[] arg2,Type type){
	    	String temp;
	    	Object object = null;
			try {
				temp = new String(arg2, "UTF-8");
				Gson gson = new Gson();
		    	 object = gson.fromJson(temp, type);
		    	gson = null;
			} catch (UnsupportedEncodingException e) {
				System.out.println("转换出错");
				e.printStackTrace();
			}
	    	return object;
	    }
	
}












