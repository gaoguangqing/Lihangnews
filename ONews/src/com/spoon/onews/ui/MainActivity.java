package com.spoon.onews.ui;

import com.spoon.onews.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

	private Button btnTextNews;
	private Button btnGraphNews;
	private Button btnMixNews;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		btnTextNews=(Button) findViewById(R.id.bt_textnews);	
		btnTextNews.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent=new Intent(MainActivity.this,TextNewsActivity.class);
				startActivity(intent);
				
			}
		});
		
		
		
		btnGraphNews=(Button) findViewById(R.id.btn_graphnews);
		btnGraphNews.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent=new Intent(MainActivity.this,GraphNewsActivity.class);
				startActivity(intent);
			}
		});
		
		
		btnMixNews=(Button) findViewById(R.id.btn_mixnews);
		btnMixNews.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent=new Intent(MainActivity.this,MixNewsActivity.class);
				startActivity(intent);
			}
		});
	}
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode== KeyEvent.KEYCODE_BACK)
        {
            finish();

        }
        return super.onKeyDown(keyCode, event);

    }
}
