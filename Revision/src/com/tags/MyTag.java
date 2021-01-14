package com.tags;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class MyTag extends TagSupport{

	@Override
	public int doStartTag() throws JspException {
		JspWriter out = pageContext.getOut();
		try {
			
			out.print("<table border='1' bgcolor='gold'>");
			for(int i=0;i<5;i++)
			{
			out.print("<tr>");
			for(int j=0;j<5;j++)
			{
			out.print("<td>");
			out.print("<input type='text' value='"+i+";"+j+"'/>");
			out.print("</td>");
			}
			out.print("</tr>");
			}
			out.print("</table>");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
}
