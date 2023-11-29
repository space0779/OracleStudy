<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="java.util.*,com.sist.dao.*"%>
<%
   // 값을 받는다 
   EmpDAO dao=new EmpDAO();
   ArrayList<EmpVO> list=dao.empListData();
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
   width: 600px;
}
h1{
   text-align: center;
}
</style>
</head>
<body>
  <div class="container">
    <h1>사원 정보</h1>
    <div class="row">
      <table class="table">
        <tr>
          <th class="text-center">사번</th>
          <th class="text-center">이름</th>
          <th class="text-center">직위</th>
          <th class="text-center">입사일</th>
          <th class="text-center">급여</th>
        </tr>
        <%
           for(EmpVO vo:list)
           {
        %>
              <tr>
                <td class="text-center"><%=vo.getEmpno() %></td>
                <td class="text-center"><%=vo.getEname() %></td>
                <td class="text-center"><%=vo.getJob() %></td>
                <td class="text-center"><%=vo.getHiredate() %></td>
                <td class="text-center"><%=vo.getSal() %></td>
              </tr>
        <%   
           }
        %>
      </table>
    </div>
  </div>
</body>
</html>