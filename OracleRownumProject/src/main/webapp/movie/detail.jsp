<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="com.sist.dao.*"%>
<%
    String mno=request.getParameter("mno");
    MovieDAO dao=new MovieDAO();
    MovieVO vo=dao.movieDetailData(Integer.parseInt(mno));
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.container{
  margin-top: 50px;
}
.row{
  margin: 0px auto;
  width:750px;
}
h3{
   text-align: center;
}
</style>
</head>
<body>
  <div class="container">
    <h3>�󼼺���</h3>
    <div class="row">
      <table class="table">
       <tr>
         <td width=30% class="text-center" rowspan="5">
          <img src="<%=vo.getPoster() %>" style="width: 100%">
         </td>
         <td colspan=2><h3><%=vo.getTitle() %></h3></td>
       </tr>
       <tr>
         <th width=20%>����</th>
         <td width=50%><%=vo.getDirector() %></td>
       </tr>
       <tr>
         <th width=20%>�⿬</th>
         <td width=50%><%=vo.getActor() %></td>
       </tr>
       <tr>
         <th width=20%>�帣</th>
         <td width=50%><%=vo.getGenre() %></td>
       </tr>
       <tr>
         <th width=20%>���</th>
         <td width=50%><%=vo.getGrade() %></td>
       </tr>
      </table>
    </div>
  </div>
</body>
</html>