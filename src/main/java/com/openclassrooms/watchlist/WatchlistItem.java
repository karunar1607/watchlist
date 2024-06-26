package com.openclassrooms.watchlist;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class WatchlistItem {
	
	private Integer id;
	@NotBlank( message="Please enter the title")
	private String title;
	private String rating;
	@Priority
	private String priority;
	@Size(max=50,  message="Comment should be maximum 50 characters")
	private String comment;
	public WatchlistItem(Integer id, String title, String rating, String priority, String comment) {
		super();
		this.id = id;
		this.title = title;
		this.rating = rating;
		this.priority = priority;
		this.comment = comment;
	}
	public WatchlistItem() {
		// TODO Auto-generated constructor stub
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	public String getPriority() {
		return priority;
	}
	public void setPriority(String priority) {
		this.priority = priority;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	
	
	

}
