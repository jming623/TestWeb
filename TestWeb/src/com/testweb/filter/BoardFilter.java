package com.testweb.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter({"/board/bbs_write.bbs","/board/bbs_regist.bbs"})
public class BoardFilter implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse res = (HttpServletResponse)response;
		
		String user_id = (String)req.getAttribute("user_id");
		
		if(user_id == null) {
//			res.sendRedirect("board/bbs.bbs");
			
			res.setContentType("text/html");
			res.setCharacterEncoding("UTF-8");
			
			PrintWriter out = res.getWriter();
			
			out.println("<script>");
			out.println("alert('로그인후 사용해 주십시요.');");
			out.println("location.href='bbs.bbs?pageNum=1&&amount=10'");
			out.println("</script>");
			return;
		}
		
		chain.doFilter(request, response);
		
	}

}
