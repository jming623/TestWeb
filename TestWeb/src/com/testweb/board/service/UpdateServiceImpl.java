package com.testweb.board.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.testweb.board.model.BbsDAO;

public class UpdateServiceImpl implements IBbsService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		String bno = request.getParameter("bno");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		System.out.println(bno);
		System.out.println(title);
		System.out.println(content);
		
		BbsDAO dao = BbsDAO.getInstance();
		dao.update(bno, title, content);
	}

}
