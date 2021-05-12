package com.testweb.board.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.testweb.board.model.BbsDAO;

public class RegistServiceImpl implements IBbsService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		String writer = request.getParameter("writer");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		BbsDAO dao = BbsDAO.getInstance();
		dao.regist(writer, title, content);

	}

}
