package com.spoon.onews.adapter;

import java.util.ArrayList;

import com.bumptech.glide.Glide;
import com.spoon.onews.R;
import com.spoon.onews.bean.News;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class GraphNewsAdapter extends BaseAdapter{

	
	private Context context;
	private ArrayList<News> lists;

	public GraphNewsAdapter(ArrayList<News> news,
			Context context) {
		// TODO Auto-generated constructor stub
		this.lists=news;
		this.context=context;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return lists.size();
	}

	@Override
	public Object getItem(int i) {
		// TODO Auto-generated method stub
		return lists.get(i);
	}

	@Override
	public long getItemId(int i) {
		// TODO Auto-generated method stub
		return i;
	}

	@Override
	public View getView(final int i, View view, ViewGroup viewGroup) {
		ViewHolder holder;
		if(view==null){
			  holder=new ViewHolder();
			  view=View.inflate(context, R.layout.grapnews_sitem,null );
			  holder.tvGrTitle=(TextView) view.findViewById(R.id.tv_gr_title);
			  holder.ivGrImg=(ImageView) view.findViewById(R.id.iv_gr_img);
			  view.setTag(holder);
		}
		else{
			holder=(ViewHolder) view.getTag();
		}
		holder.tvGrTitle.setText(lists.get(i).title);
		//https://gaoguangqing.github.io/Lihangnews/
		//http://172.19.24.23/
		System.out.println("https://gaoguangqing.github.io/Lihangnews"+lists.get(i).picture);
		Glide.with(context)  
	    .load("https://gaoguangqing.github.io/Lihangnews"+lists.get(i).picture)  
	    .into(holder.ivGrImg);  
		return view;
	}
	
	class ViewHolder{
		TextView tvGrTitle;
		ImageView ivGrImg;
	}

}
