package com.testweb.board.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.testweb.board.model.BbsDAO;
import com.testweb.board.model.BbsVO;

public class GetContentServiceImpl implements IBbsService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		String bno = request.getParameter("bno");
		BbsDAO dao = BbsDAO.getInstance();
		BbsVO vo = dao.getContent(bno);
		request.setAttribute("vo", vo);
	}

}
