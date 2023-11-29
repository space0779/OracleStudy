<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.sist.dao.*,java.util.*"%>
<%
   // 자바 코딩 영역 => main
   StudentDAO dao=new StudentDAO();
   List<StudentVO> list=dao.stdListData();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.container{
  margin-top: 50px;
}
.row{
  margin: 0px auto;
  width:800px;
}
h1{
   text-align: center;
}
</style>
</head>
<body>
  <div class="container">
    <h1>학생 성적표</h1>
    <div class="row">
     <table class="table">
      <tr>
        <td>
         <a href="insert.jsp" class="btn btn-sm btn-danger">등록</a>
        </td>
      </tr>
     </table>
     <table class="table table-hover">
      <tr class="success">
        <th class="text-center">학번</th>
        <th class="text-center">이름</th>
        <th class="text-center">국어</th>
        <th class="text-center">영어</th>
        <th class="text-center">수학</th>
        <th class="text-center">총점</th>
        <th class="text-center">평균</th>
        <th class="text-center">등수</th>
        <th class="text-center"></th>
      </tr>
      <%
         for(StudentVO vo:list)
         {
      %>
              <tr>
		        <td class="text-center"><%=vo.getHakbun() %></td>
		        <td class="text-center"><%=vo.getName() %></td>
		        <td class="text-center"><%=vo.getKor() %></td>
		        <td class="text-center"><%=vo.getEng() %></td>
		        <td class="text-center"><%=vo.getMath() %></td>
		        <td class="text-center"><%=vo.getTotal() %></td>
		        <td class="text-center"><%=vo.getAvg() %></td>
		        <td class="text-center"><%=vo.getRank() %></td>
		        <td class="text-center">
		         <a href="delete.jsp?hakbun=<%=vo.getHakbun() %>" class="btn btn-sm btn-info">삭제</a>
		        </td>
		      </tr>
      <%
         }
      %>
     </table>
    </div>
  </div>
</body>
</html>