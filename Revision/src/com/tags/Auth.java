package com.tags;

import java.io.IOException;

import javax.servlet.ServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class Auth extends TagSupport{

	String lang;
	
	public String getLang() {
		return lang;
	}

	public void setLang(String lang) {
		this.lang = lang;
	}

	@Override
	public int doStartTag() throws JspException {
		// TODO Auto-generated method stub
		String un="";
		String ps="";
		if(lang.equals("fr"))
		{
			un="Nom Utilisateur:";
			ps="Mot de passe: ";
		}
		if(lang.equals("en"))
		{
			un="Username:";
			ps="Password: ";
		}
		JspWriter out = pageContext.getOut();
		ServletRequest req = pageContext.getRequest();
		try {
			out.print("<form class='frm' method='post'><table>");
			out.print("<tr>");
			out.print("<td>"+un+"</td><td><input type='text' name='lg'/></td>");
			

			out.print("</tr>");
			out.print("<tr>");
			out.print("<td>"+ps+"</td><td><input type='password' name='ps'/></td>");
			out.print("</tr>");
			out.print("<tr>");
			out.print("<td><input type='reset' value='cancel'/></td><td><input type='submit' name='btn' value='connect'/></td>");

			out.print("</tr>");
			out.print("</table></form>");
			
			
			if(req.getParameter("btn")!=null)
			{
			String lg=req.getParameter("lg");
			String pas=req.getParameter("ps");
			out.print("<p> vous avez tappez :"+lg+" -- "+pas);
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return super.doStartTag();
	}
}
