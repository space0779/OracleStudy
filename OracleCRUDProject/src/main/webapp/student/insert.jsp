<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
  width:350px;
}
h1{
   text-align: center;
}
</style>
</head>
<body>
  <div class="container">
    <h1>성적 등록</h1>
    <div class="row">
     <form method=post action="insert_ok.jsp">
      <table class="table">
        <tr>
          <th width=30% class="text-center">이름</th>
          <td width=70%>
           <input type=text name=name size=15>
          </td>
        </tr>
        <tr>
          <th width=30% class="text-center">국어</th>
          <td width=70%>
           <input type=text name=kor size=15>
          </td>
        </tr>
        <tr>
          <th width=30% class="text-center">영어</th>
          <td width=70%>
           <input type=text name=eng size=15>
          </td>
        </tr>
        <tr>
          <th width=30% class="text-center">수학</th>
          <td width=70%>
           <input type=text name=math size=15>
          </td>
        </tr>
        <tr>
          <td colspan="2" class="text-center">
            <button class="btn btn-sm btn-primary">전송</button>
            <input type=button class="btn btn-sm btn-primary"
             value="취소" onclick="javascript:history.back()">
          </td>
        </tr>
      </table>
      </form>
    </div>
  </div>
</body>
</html>