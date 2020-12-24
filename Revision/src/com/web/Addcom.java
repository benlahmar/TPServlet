package com.web;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.DaoManger;

/**
 * Servlet implementation class Addcom
 */
@WebServlet("/Addcom")
public class Addcom extends HttpServlet {
	private static final long serialVersionUID = 1L;
       DaoManger dao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Addcom() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		dao=new DaoManger();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String contenu = request.getParameter("contenu");
		int idp =Integer.parseInt(request.getParameter("idp"));
		int idu =Integer.parseInt(request.getParameter("idu"));
		dao.addcomm(contenu, idp, idu);
		response.sendRedirect("post.jsp");
		}

}
