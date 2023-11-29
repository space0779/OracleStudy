package com.sist.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.*;
public class TripDAO {
	private Connection conn;
	private PreparedStatement ps;
	private final String URL="jdbc:oracle:thin:@211.238.142.113:1521:XE";
	// 에러 => output => this.conn NULL
	public TripDAO()
	{
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(Exception e) {}
	}
	public void getConnection()
	{
		try {
			conn=DriverManager.getConnection(URL,"hr","happy");
		}catch(Exception e)
		{
			
		}
	}
	public void disConnection()
	{
        try {
			if(ps!=null) ps.close();
			if(conn!=null) conn.close();
		}catch(Exception e)
		{
			
		}
	}
	
	public void musicInsert(ArrayList<TripVO> voList)
	{
		try {
			getConnection();
			String sql="INSERT INTO trip VALUES("
					+"?,?,?,?,?,?,?,?,?,?,0,0,0,?)";
			ps=conn.prepareStatement(sql);
			for (TripVO vo : voList) {
                ps.setInt(1, vo.getFno());
                ps.setString(2, vo.getTitle());
                ps.setString(3, vo.getPoster());
                ps.setString(4, vo.getCont());
                ps.setString(5, vo.getNavi());
                ps.setString(6, vo.getAddr());
                ps.setString(7, vo.getPhone());
                ps.setString(8, vo.getRestday());
                ps.setString(9, vo.getBhour());
                ps.setString(10, vo.getTag());
                ps.setString(11, vo.getDeimage());
                
                ps.executeUpdate();
            }
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disConnection();
		}
		
	}
}