package com.testweb.user.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.testweb.user.service.IUserService;
import com.testweb.user.service.UserJoinServiceImpl;


@WebServlet("*.user")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public UserController() {
      
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
	}
	
	protected void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String uri = request.getRequestURI();
		String path = request.getContextPath();
		
		System.out.println("uri="+uri);
		System.out.println("path="+path);
		
		String command = uri.substring(path.length());
		
		IUserService service;
		
		System.out.println(command);
		
		if(command.equals("/user/join.user")) {
			
			service = new UserJoinServiceImpl();
			service.execute(request, response);
			response.sendRedirect("user_login.jsp");
			
		}else if(command.equals("경로")){
			
		}else if(command.equals("경로")){
			
		}
	}

}
