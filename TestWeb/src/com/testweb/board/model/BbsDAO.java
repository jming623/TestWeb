package com.testweb.board.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.sql.DataSource;


import com.testweb.util.JdbcUtil;


public class BbsDAO {

	private static BbsDAO instance = new BbsDAO();
	
	private BbsDAO() {
		
		try {
			InitialContext ctx = new InitialContext();
			ds = (DataSource)ctx.lookup("java:comp/env/jdbc/oracle");
			
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	
	public static BbsDAO getInstance() {
		return instance;
	}
	
	DataSource ds = null;
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	//게시글 리스트를 가져오는 메서드
	/*
	 * public ArrayList<BbsVO> getList(){ ArrayList<BbsVO> list = new ArrayList<>();
	 * 
	 * String sql = "select * from bbs order by bno desc";
	 * 
	 * try { conn = ds.getConnection(); pstmt = conn.prepareStatement(sql); rs =
	 * pstmt.executeQuery();
	 * 
	 * while(rs.next()) { int bno = rs.getInt("bno"); String writer =
	 * rs.getString("writer"); String title = rs.getString("title"); String content
	 * = rs.getString("content"); Timestamp regdate = rs.getTimestamp("regdate");
	 * 
	 * BbsVO vo = new BbsVO(bno,writer,title,content,regdate); list.add(vo); } }
	 * catch (Exception e) { e.printStackTrace(); }finally { JdbcUtil.close(conn,
	 * pstmt, rs); }
	 * 
	 * 
	 * return list; }
	 */
	
	//amount수만큼 게시글을 불러오는 메서드
	public ArrayList<BbsVO> getList(int pageNum , int amount){
		ArrayList<BbsVO> list = new ArrayList<>();
		
		String sql = "select *\r\n" + 
				"from(select rownum as rn,\r\n" + 
				"            a.* \r\n" + 
				"     from(select *\r\n" + 
				"          from bbs \r\n" + 
				"          order by bno desc\r\n" + 
				"          )a\r\n" + 
				") where rn > ? and rn <=? ";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, (pageNum-1)*10);
			pstmt.setInt(2, pageNum*amount);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int bno = rs.getInt("bno");
				String writer = rs.getString("writer");
				String title = rs.getString("title");
				String content = rs.getString("content");
				Timestamp regdate = rs.getTimestamp("regdate");
				
				BbsVO vo = new BbsVO(bno,writer,title,content,regdate);
				list.add(vo);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(conn, pstmt, rs);
		}
				
		return list;
	}

	
	//전체게시글 갯수 
	public int getTotal() {
		int result = 0;
		
		String sql = "select count(*) as total from bbs";
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				result = rs.getInt("total");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			JdbcUtil.close(conn, pstmt, rs);
		}
		return result;
	}
	
	//글작성 메서드
	public void regist(String writer, String title, String content) {
		
		String sql = "insert into bbs (bno,writer,title,content) values(bbs_seq.nextval,?,?,?)";
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, writer);
			pstmt.setString(2, title);
			pstmt.setString(3, content);
			
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(conn, pstmt, null);
		}
	}
	
	//getContnet메서드
	public BbsVO getContent(String bno1) {
		BbsVO vo = null;
		
		String sql = "select * from bbs where bno = ?";
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bno1);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				int bno = rs.getInt("bno");
				String writer = rs.getString("writer");
				String title = rs.getString("title");
				String content = rs.getString("content");
				Timestamp regdate = rs.getTimestamp("regdate");
				
				vo = new BbsVO(bno, writer, title, content, regdate);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(conn, pstmt, rs);
		}
		
		return vo;
	}
	
	//update메서드
	public void update(String bno, String title, String content ) {
		
		String sql = "update bbs set title=?, content=?, regdate=sysdate where bno = ?";
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, title);
			pstmt.setString(2, content);
			pstmt.setString(3, bno);
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(conn, pstmt, null);
		}
	}
	
	//delete메서드
	public void delete(String bno) {
		
		String sql = "delete from bbs where bno = ?";
		
		try {
			
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bno);
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(conn, pstmt, null);
		}
		
	}
		
}//end
