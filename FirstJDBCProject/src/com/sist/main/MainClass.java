package com.sist.main;
import java.sql.*;
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        try
        {
        	// 핵심 => 자바 (12장)
        	Class.forName("oracle.jdbc.driver.OracleDriver");//오라클 => 드라이버 설정 
            // 오라클 연결 conn hr/happy
        	String url="jdbc:oracle:thin:@localhost:1521:XE";
        	// 네트워크 => ip/port XE=> 데이터베이스 이름 
        	// 파일 / 폴더 
        	// 테이블 / 데이터베이스 => book , emp ,dept
        	String id="hr";
        	String pwd="happy";
        	Connection conn=
        			DriverManager.getConnection(url,id,pwd);
        	String sql="SELECT ename,hiredate,job FROM emp";
        	PreparedStatement ps=conn.prepareStatement(sql);
        	ResultSet rs=ps.executeQuery();
        	while(rs.next())
        	{
        		System.out.println(rs.getString(1)+" "
        				+rs.getDate(2)+" "
        				+rs.getString(3));
        	}
        	rs.close();
        	ps.close();
        	conn.close();
        }catch(Exception ex) {}
	}

}