package com.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.DaoManger;
import com.model.Post;

/**
 * Servlet implementation class Ajoutpost
 */
@WebServlet("/Ajoutpost")
public class Ajoutpost extends HttpServlet {
	private static final long serialVersionUID = 1L;
       DaoManger pm=new DaoManger();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ajoutpost() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String titre=request.getParameter("titre");
		String contenu=request.getParameter("contenu");
		int idu =Integer.parseInt(request.getParameter("iduser"));
		pm.addpost(titre, contenu, idu);
		
		List<Post> ps = pm.findpostsByUser(idu);
		out.println("<table border='1' bgcolor='gold'>");
		for (Post p : ps) {
			out.println("<tr><td>"+p.getIdp()+"</td><td>"+p.getTitre()+"</td><td>"+p.getContnent()+"</td></tr>");
		}
		out.println("</table>");
	}

}
