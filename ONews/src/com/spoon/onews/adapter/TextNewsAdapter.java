package com.spoon.onews.adapter;

import java.util.ArrayList;

import com.spoon.onews.R;
import com.spoon.onews.bean.News;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class TextNewsAdapter extends BaseAdapter{
	private ArrayList<News> lists;
	private Context context;

	public TextNewsAdapter(ArrayList<News> list,Context context) {
		this.lists = list;
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
			  view=View.inflate(context, R.layout.textnews_item,null );
			  holder.tvNewsColumn=(TextView) view.findViewById(R.id.tv_newscolumn);
			  holder.tvNewsDate=(TextView) view.findViewById(R.id.tv_newsdate);
			  holder.tvNewsOrigin=(TextView) view.findViewById(R.id.tv_newsorigin);
			  holder.tvNewsText=(TextView) view.findViewById(R.id.tv_newstext);
			  holder.tvNewsTitle=(TextView) view.findViewById(R.id.tv_newstitle);
			  view.setTag(holder);
		}
		else{
			holder=(ViewHolder) view.getTag();
		}
		holder.tvNewsColumn.setText(lists.get(i).column);
		holder.tvNewsDate.setText(lists.get(i).cdate);
		holder.tvNewsOrigin.setText(lists.get(i).origin);
		holder.tvNewsText.setText("ÔÝÎÞÄÚÈÝ");
		holder.tvNewsTitle.setText(lists.get(i).title);
		
		
		
		return view;
	}
	
	class ViewHolder{
		TextView tvNewsTitle;
		TextView tvNewsText;
		TextView tvNewsColumn;
		TextView tvNewsOrigin;
		TextView tvNewsDate;
	}

}
