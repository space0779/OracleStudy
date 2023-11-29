<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="com.sist.dao.*,java.util.*"%>
<%
    //int curpage=1;
    String strPage=request.getParameter("page");
    if(strPage==null)
    	strPage="1";
    int curpage=Integer.parseInt(strPage);
    MovieDAO dao=new MovieDAO();
    int totalpage=dao.movieTotalPage();
    List<MovieVO> list=dao.movieListData(curpage);
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
  width:960px;
}
h1{
   text-align: center;
}
</style>
</head>
<body>
  <div class="container">
    <div class="row">
     <%
        for(MovieVO vo:list)
        {
     %>
           <div class="col-md-3">
		    <div class="thumbnail">
		      <a href="detail.jsp?mno=<%=vo.getMno()%>">
		        <img src="<%=vo.getPoster() %>" alt="Lights" style="width:320px;height: 350px">
		        <div class="caption">
		          <p><%=vo.getTitle() %></p>
		        </div>
		      </a>
		    </div>
		  </div>
     <%
        }
     %>
    </div>
    <div style="height: 20px"></div>
    <div class="row">
      <div class="text-center">
       <a href="list.jsp?page=<%=curpage>1?curpage-1:curpage %>" class="btn btn-sm btn-danger">����</a>
       <%=curpage %> page / <%=totalpage %> pages
       <a href="list.jsp?page=<%=curpage<totalpage?curpage+1:curpage %>" class="btn btn-sm btn-danger">����</a>
      </div>
    </div>
  </div>
</body>
</html>