package com.sist.dao;
import java.util.*;
import java.sql.*;
public class EmpDAO {
   // 오라클 연결 => 객체 
   private Connection conn;// Socket
   // SQL을 전송하는 객체 
   private PreparedStatement ps;
   // BufferedReader / OutputStream
   // 오라클 주소 
   private final String URL="jdbc:oracle:thin:@localhost:1521:XE";
   
   // 연결 => Driver 등록 
   public EmpDAO()
   {
	   try
	   {
		   Class.forName("oracle.jdbc.driver.OracleDriver");
		   // new 대신 사용 => 클래스명으로 메모리 할당 => 리플렉션 
	   }catch(Exception ex) {}
   }
   // 오라클 연동 
   public void getConnection()
   {
	   try
	   {
		   conn=DriverManager.getConnection(URL,"hr","happy");
		   // => conn hr/happy
	   }catch(Exception ex) {}
   }
   // 오라클 닫기
   public void disConnection()
   {
	   try
	   {
		   if(ps!=null) ps.close();
		   if(conn!=null) conn.close();
	   }catch(Exception ex) {}
   }
   /////  필수 
   // 전체 데이터를 읽어 온다 
   public ArrayList<EmpVO> empListData()
   {
	  ArrayList<EmpVO> list=
			  new ArrayList<EmpVO>();
	  try
	  {
		  // 연결 
		  getConnection();
		  // SQL문장 전송 
		  String sql="SELECT empno,ename,job,hiredate,sal "
				    +"FROM emp "
				    +"ORDER BY 1";
		  ps=conn.prepareStatement(sql);
		  ResultSet rs=ps.executeQuery();//Enter
		  while(rs.next())
		  {
			  EmpVO vo=new EmpVO();
			  vo.setEmpno(rs.getInt(1));
			  vo.setEname(rs.getString(2));
			  vo.setJob(rs.getString(3));
			  vo.setHiredate(rs.getDate(4));
			  vo.setSal(rs.getInt(5));
			  list.add(vo);
		  }
	  }catch(Exception ex)
	  {
		  ex.printStackTrace();
	  }
	  finally
	  {
		  // 닫기
		  disConnection();
	  }
	  return list;
   }
   
   // 뮤직 데이터 읽기
   public ArrayList<MusicVO> musicListData()
   {
	   ArrayList<MusicVO> list=
			   new ArrayList<MusicVO>();
	   try
	   {
		   getConnection();
		   String sql="SELECT title,poster,rownum "
				     +"FROM genie_music "
				     +"WHERE rownum<=20 ";
		   ps=conn.prepareStatement(sql);
		   ResultSet rs=ps.executeQuery();
		   while(rs.next())
		   {
			   MusicVO vo=new MusicVO();
			   vo.setTitle(rs.getString(1));
			   vo.setPoster(rs.getString(2));
			   list.add(vo);
		   }
		   rs.close();
	   }catch(Exception ex)
	   {
		   ex.printStackTrace();
	   }
	   finally
	   {
		   disConnection();
	   }
	   return list;
   }
   
}





