package com.model;

import java.time.LocalDate;

public class Invitation {

	int id;
	LocalDate date;
	User usend;
	User urecieve;
	boolean etat;
	
	public boolean isEtat() {
		return etat;
	}
	public void setEtat(boolean etat) {
		this.etat = etat;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public User getUsend() {
		return usend;
	}
	public void setUsend(User usend) {
		this.usend = usend;
	}
	public User getUrecieve() {
		return urecieve;
	}
	public void setUrecieve(User urecieve) {
		this.urecieve = urecieve;
	}
	
	
}
