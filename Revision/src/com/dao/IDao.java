package com.dao;

import java.util.List;

import com.model.Post;
import com.model.User;

public interface IDao {

	public int adduser(String log,String pass,String role);
	public User authentification(String log,String pass);
	
	public int addpost(String titre,String contenu, int idu);
	public Post findByid(int id);
	public List<Post> findpostsByUser(int idu);
}
