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

public class MixNewsAdapter extends BaseAdapter {
	private ArrayList<News> lists;
	private Context context;

	public MixNewsAdapter(ArrayList<News> list, Context context) {
		this.lists = list;
		this.context = context;
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
	public int getItemViewType(int i) {
		System.out.println(lists.get(i).picnews+"");
		return lists.get(i).picnews;
	
	}

	@Override
	public int getViewTypeCount() {
		// TODO Auto-generated method stub
		return 2;
	}

	@Override
	public View getView(final int i, View view, ViewGroup viewGroup) {
		if (getItemViewType(i)== -1) {
			TextNewsViewHolder tnViewHolder;

			if (view == null) {
				tnViewHolder = new TextNewsViewHolder();
				view = View.inflate(context, R.layout.textnews_item, null);
				tnViewHolder.tvNewsColumn = (TextView) view
						.findViewById(R.id.tv_newscolumn);
				tnViewHolder.tvNewsDate = (TextView) view
						.findViewById(R.id.tv_newsdate);
				tnViewHolder.tvNewsOrigin = (TextView) view
						.findViewById(R.id.tv_newsorigin);
				tnViewHolder.tvNewsText = (TextView) view
						.findViewById(R.id.tv_newstext);
				tnViewHolder.tvNewsTitle = (TextView) view
						.findViewById(R.id.tv_newstitle);
				view.setTag(tnViewHolder);
			} else {
				tnViewHolder = (TextNewsViewHolder) view.getTag();
			}
			tnViewHolder.tvNewsColumn.setText(lists.get(i).column);
			tnViewHolder.tvNewsDate.setText(lists.get(i).cdate);
			tnViewHolder.tvNewsOrigin.setText(lists.get(i).origin);
			tnViewHolder.tvNewsText.setText("ÔÝÎÞÄÚÈÝ");
			tnViewHolder.tvNewsTitle.setText(lists.get(i).title);
			return view;
		} else {
			GraphNewsHolder gnViewHolder;
			if (view == null) {
				gnViewHolder = new GraphNewsHolder();
				view = View.inflate(context, R.layout.grapnews_sitem, null);
				gnViewHolder.tvGrTitle = (TextView) view
						.findViewById(R.id.tv_gr_title);
				gnViewHolder.ivGrImg = (ImageView) view.findViewById(R.id.iv_gr_img);
				view.setTag(gnViewHolder);
			} else {
				gnViewHolder = (GraphNewsHolder) view.getTag();
			}
			gnViewHolder.tvGrTitle.setText(lists.get(i).title);

			Glide.with(context)
					.load("https://gaoguangqing.github.io/Lihangnews" + lists.get(i).picture)
					.into(gnViewHolder.ivGrImg);
			return view;
		}

	}

	class TextNewsViewHolder {
		TextView tvNewsTitle;
		TextView tvNewsText;
		TextView tvNewsColumn;
		TextView tvNewsOrigin;
		TextView tvNewsDate;
	}

	class GraphNewsHolder {
		TextView tvGrTitle;
		ImageView ivGrImg;
	}

}
