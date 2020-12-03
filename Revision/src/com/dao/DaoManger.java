package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.model.DBInteraction;
import com.model.Post;
import com.model.User;

public class DaoManger implements IDao {

	@Override
	public int adduser(String log, String pass, String role) {
		DBInteraction.connect();
		String sql="insert into user values(null,'"+log+"','"+pass+"','"+role+"')";
		int nb=DBInteraction.Maj(sql);
		DBInteraction.disconnect();
		return nb;
	}

	@Override
	public User authentification(String log, String pass) {
		User u=null;
		DBInteraction.connect();
		 String sql="select * from user where log='"+log+"' and pass='"+pass+"'";
		ResultSet rs = DBInteraction.Select(sql);
		try {
			if(rs.next())
			{
				u=new User(rs.getString(2), rs.getString(3), rs.getString(4))	;
				u.setId(rs.getInt(1));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return u;
	}

	@Override
	public int addpost(String titre, String contenu, int idu) {
		DBInteraction.connect();
		String sql="insert into post(titre,contenu,idu) values('"+titre+"','"+contenu+"',"+idu+")";
		int nb=DBInteraction.Maj(sql);
		DBInteraction.disconnect();
		return nb;
	}

	@Override
	public Post findByid(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Post> findpostsByUser(int idu) {
		// TODO Auto-generated method stub
		return null;
	}

}
