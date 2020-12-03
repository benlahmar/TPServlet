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
 * Servlet implementation class Ajoutuser
 */
@WebServlet("/Ajoutuser")
public class Ajoutuser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	DaoManger um=new DaoManger();
    /**
     * Default constructor. 
     */
    public Ajoutuser() {
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
		
		String log=request.getParameter("lg");
		String pass=request.getParameter("ps");
		String role=request.getParameter("role");
		um.adduser(log, pass, role);

	}
	

}
