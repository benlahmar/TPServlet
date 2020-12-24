package com.model;

import java.util.Date;

public class Commentaire {

	int id;
	String contenu;
	Date date;
	User us;
	Post p;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getContenu() {
		return contenu;
	}
	public void setContenu(String contenu) {
		this.contenu = contenu;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public User getUs() {
		return us;
	}
	public void setUs(User us) {
		this.us = us;
	}
	public Post getP() {
		return p;
	}
	public void setP(Post p) {
		this.p = p;
	}
	
	
}
