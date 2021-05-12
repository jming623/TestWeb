package com.testweb.user.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.testweb.user.model.UserDAO;
import com.testweb.user.model.UserVO;

public class UserJoinServiceImpl implements IUserService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String p1 = request.getParameter("phone1");
		String p2 = request.getParameter("phone2");
		String p3 = request.getParameter("phone3");
		String e1 = request.getParameter("email1");
		String e2  = request.getParameter("email2");
		String a1 = request.getParameter("address1");
		String a2  = request.getParameter("address2");
		
		UserVO vo = new UserVO(id,pw,name,p1,p2,p3,e1,e2,a1,a2);
		
		UserDAO dao = UserDAO.getInstance();
		dao.join(vo);
	}

}
