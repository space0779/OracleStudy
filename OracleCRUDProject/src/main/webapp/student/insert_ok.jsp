<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.sist.dao.*"%>
<%
     // 한글 변환 
     request.setCharacterEncoding("UTF-8");
     String name=request.getParameter("name");
     String kor=request.getParameter("kor");
     String eng=request.getParameter("eng");
     String math=request.getParameter("math");
     StudentVO vo=new StudentVO();
     vo.setName(name);
     vo.setKor(Integer.parseInt(kor));
     vo.setEng(Integer.parseInt(eng));
     vo.setMath(Integer.parseInt(math));
     
     StudentDAO dao=new StudentDAO();
     dao.stdInsert(vo);
     
     // 이동 
     response.sendRedirect("list.jsp");
%>