package com.testweb.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.testweb.board.service.DeleteServiceImpl;
import com.testweb.board.service.GetContentServiceImpl;
import com.testweb.board.service.GetListServiceImpl;
import com.testweb.board.service.IBbsService;
import com.testweb.board.service.RegistServiceImpl;
import com.testweb.board.service.UpdateServiceImpl;


@WebServlet("*.bbs")
public class BbsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public BbsController() {
        super();    
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
		
//		System.out.println("uri="+uri);
//		System.out.println("path="+path);
		
		String command = uri.substring(path.length());
		
		System.out.println(command);
		IBbsService service;
		
		if(command.equals("/board/bbs.bbs")) {
			
			service = new GetListServiceImpl();
			service.execute(request, response);
			request.getRequestDispatcher("bbs.jsp").forward(request, response);
			
		}else if(command.equals("/board/bbs_write.bbs")) {
			
			request.getRequestDispatcher("bbs_write.jsp").forward(request, response);
		}else if(command.equals("/board/bbs_regist.bbs")) {
			
			service = new RegistServiceImpl();
			service.execute(request, response);
			response.sendRedirect("bbs.bbs");
		}else if(command.equals("/board/getContent.bbs")) {//게시글 상세정보
						
			service = new GetContentServiceImpl();
			service.execute(request, response);
			
			request.getRequestDispatcher("bbs_content.jsp").forward(request, response);
			
		}else if(command.equals("/board/modify.bbs")) {//게시글 수정란에 값 불러오기
			
			service = new GetContentServiceImpl();
			service.execute(request, response);
			
			request.getRequestDispatcher("bbs_modify.jsp").forward(request, response);
			
		}else if(command.equals("/board/update.bbs")) {
			
			service = new UpdateServiceImpl();
			service.execute(request, response);
			
			response.sendRedirect("getContent.bbs?bno="+request.getParameter("bno"));
		}else if(command.equals("/board/delete.bbs")) {
			
			service = new DeleteServiceImpl();
			service.execute(request, response);
			
			response.sendRedirect("bbs.bbs");
		}
	}
}
