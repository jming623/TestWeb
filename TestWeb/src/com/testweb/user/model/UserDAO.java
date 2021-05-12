package com.testweb.user.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.testweb.util.JdbcUtil;

public class UserDAO {

	private static UserDAO instance = new UserDAO();
	
	private DataSource ds;
	
	private UserDAO() {
				
		try {
			//커넥션 풀
			InitialContext ctx = new InitialContext();
			ds= (DataSource)ctx.lookup("java:comp/env/jdbc/oracle");
			
		} catch (NamingException e) {
			System.out.println("드라이버 생성예외 발생");			
		}
	}

	public static UserDAO getInstance() {
		return instance;
	}
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs =null;
	
	//필요한 메서드 선언부분
	
	//join메서드
	public void join(UserVO vo) {
		
		String sql = "insert into bbs_users values(?,?,?,?,?,?,?,?,?,?)";
		
		try {
			
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPw());
			pstmt.setString(3, vo.getName());
			pstmt.setString(4, vo.getPhone1());
			pstmt.setString(5, vo.getPhone2());
			pstmt.setString(6, vo.getPhone3());
			pstmt.setString(7, vo.getEmail1());
			pstmt.setString(8, vo.getEmail2());
			pstmt.setString(9, vo.getAddress1());
			pstmt.setString(10, vo.getAddress2());
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(conn, pstmt, null);
		}
		
	}
	
	
	
}//end
