package com.spoon.onews.bean;


public class News {
	public Integer id;
	public Integer cid;
	public String title;
	public String content;
	public String abstract_;
	public String keywords;
	public Integer picnews;
	public String picture;
	public String origin;
	public String cdate;
	public String author;
	public String editor;
	public Integer clicks;
	public Integer status;
	public Integer priority;
	public String column;
	
	public News() {
	}

	@Override
	public String toString() {
		return "News{" + "id=" + id + ", cid=" + cid + ", title='" + title
				+ '\'' + ", content='" + content + '\'' + ", abstract_='"
				+ abstract_ + '\'' + ", keywords='" + keywords + '\''
				+ ", picnews=" + picnews + ", picture='" + picture + '\''
				+ ", origin='" + origin + '\'' + ", cdate=" + cdate
				+ ", author='" + author + '\'' + ", editor='" + editor + '\''
				+ ", clicks=" + clicks + ", status=" + status + ", priority="
				+ priority + ", column='" + column + '\'' + '}';
	}


}
