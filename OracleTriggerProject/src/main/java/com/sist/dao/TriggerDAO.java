package com.sist.dao;
import java.util.*;
import java.sql.*;
public class TriggerDAO {
   private Connection conn;
   private PreparedStatement ps; // SQL 문장 전송 
   // CallableStatement => 프로시저 호출시에만 사용 
   private final String URL="jdbc:oracle:thin:@localhost:1521:XE";
   // 드라이버 등록 ==> Singleton 사용이 기본 
   public TriggerDAO()
   {
      try
      {
         Class.forName("oracle.jdbc.driver.OracleDriver");
         // ojdbc8.jar => 11g 이상  
         // ojdbc6.jar => 11g
         // 9i , 10g ... 12c ... 21c
      }catch(Exception ex) {}
   }
   // 오라클 연결 
   public void getConnection()
   {
      try
      {
         conn=DriverManager.getConnection(URL,"hr","happy");
         // conn hr/happy 라고 오라클에 보내주는 명령어 
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
   // 기능 설정 => 가장 많이 나올 부분
   public void inputInsert(int no,int account,int price)
   {
	   try
	   {
		   getConnection();
		   String sql="INSERT INTO 입고 VALUES(?,?,?)";
		   ps=conn.prepareStatement(sql);
		   ps.setInt(1, no);
		   ps.setInt(2, account);
		   ps.setInt(3, price);
		   ps.executeUpdate();
	   }catch(Exception ex)
	   {
		   ex.printStackTrace();
	   }
	   finally
	   {
		   disConnection();
	   }
   }
   
   public void outputInsert(int no,int account,int price)
   {
	   try
	   {
		   getConnection();
		   String sql="INSERT INTO 출고 VALUES(?,?,?)";
		   ps=conn.prepareStatement(sql);
		   ps.setInt(1, no);
		   ps.setInt(2, account);
		   ps.setInt(3, price);
		   ps.executeUpdate();
	   }catch(Exception ex)
	   {
		   ex.printStackTrace();
	   }
	   finally
	   {
		   disConnection();
	   }
   }
   public void remainData()
   {
	   try
	   {
		   getConnection();
		   String sql="SELECT * FROM 재고";
		   ps=conn.prepareStatement(sql);
		   // 결과값 받기
		   ResultSet rs=ps.executeQuery();
		   while(rs.next())
		   {
			   System.out.println(rs.getInt(1)+"  "
					   +rs.getInt(2)+"  "
					   +rs.getInt(3));
		   }
	   }catch(Exception ex)
	   {
		   ex.printStackTrace();
	   }
	   finally
	   {
		   disConnection();
	   }
   }
   public static void main(String[] args) {
	   TriggerDAO dao=new TriggerDAO();
	   dao.inputInsert(100, 3, 1500);
	   dao.remainData();
}
}
