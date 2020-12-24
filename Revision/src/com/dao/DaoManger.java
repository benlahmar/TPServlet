package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.model.Commentaire;
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
		List<Post> ps=new ArrayList<Post>();
		DBInteraction.connect();
		ResultSet rs = DBInteraction.Select("select * from post");
		try {
			while(rs.next())
			{
				Post p=new Post();
				p.setIdp(rs.getInt(1));
				p.setTitre(rs.getString(2));
				p.setContnent(rs.getString(3));
				//p.setDate(rs.getDate(4));
				ps.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ps;
	}

	@Override
	public int addcomm(String contenu, int idp, int idu) {
		DBInteraction.connect();
		String sql="insert into commentaire(contenu,idp,idu) values('"+contenu+"',"+idp+","+idu+")";
		int nb=DBInteraction.Maj(sql);
		DBInteraction.disconnect();
		return nb;
	}

	@Override
	public List<Commentaire> allcommentaire(int idp) {
		List<Commentaire> cms=new ArrayList<Commentaire>();
		DBInteraction.connect();
		
		String sql="select * from commentaire where idp="+idp;
		ResultSet rs = DBInteraction.Select(sql);
		try {
			while(rs.next())
			{
				Commentaire c=new Commentaire();
				c.setId(rs.getInt(1));
				c.setContenu(rs.getString(2));
				c.setDate(rs.getDate(3));
				cms.add(c);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cms;
	}

}
