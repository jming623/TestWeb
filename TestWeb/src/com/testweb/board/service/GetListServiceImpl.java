package com.testweb.board.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.testweb.board.model.BbsDAO;
import com.testweb.board.model.BbsVO;
import com.testweb.util.PageVO;

public class GetListServiceImpl implements IBbsService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		int pageNum = 1;
		int amount = 10;
		
		if(request.getParameter("pageNum")!=null && request.getParameter("amount")!= null) {
			pageNum = Integer.parseInt(request.getParameter("pageNum"));
			amount = Integer.parseInt(request.getParameter("amount"));
		}
		
		BbsDAO dao = BbsDAO.getInstance();
		ArrayList<BbsVO> list = dao.getList(pageNum , amount);
		int total = dao.getTotal();
		PageVO pageVO = new PageVO(pageNum,amount,total);
		
		System.out.println(pageVO.isNext());
		System.out.println(pageVO.isPrev());	
				
				
		request.setAttribute("list", list);
		request.setAttribute("pageVO", pageVO);
	}

}
