<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  </head>
  
  <body>
    <p>提交成功，正在审核，请等待通知......</p>
    <br/>
    <input type="button" value="返回到个人主页" onclick="window.location='index.jsp';" />
  </body>
</html>
