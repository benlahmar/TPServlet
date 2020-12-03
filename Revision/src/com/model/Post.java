package com.model;

import java.time.LocalDate;

public class Post {

	int idp;
	String titre,contnent;
	LocalDate date;
	
	User user;

	public int getIdp() {
		return idp;
	}

	public void setIdp(int idp) {
		this.idp = idp;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getContnent() {
		return contnent;
	}

	public void setContnent(String contnent) {
		this.contnent = contnent;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}
