<%@page session="true" pageEncoding="utf-8" contentType="text/html; charset=utf-8" %>
<%@page import="java.io.*,javax.servlet.*,javax.servlet.http.*" %>

<jsp:include page="tplh.html"/>
  
  <div id="main">
  <p align="center" style="font-size: 56px; font-weight: bold;">经费管理系统</p>
  <p  style="font-size: 56px; font-weight: bold;">&nbsp;</p>
<p align="center" style="font-size:40px">项目经费通知单</p>
<p>&nbsp;</p>
<form action="" onsubmit="">
<table width="712" border="10" cellpadding="3" align="center">
  <tr>
    <th width="273" scope="row">项目编号</th>
    <td width="449"><input type="text" name="a1" id="a1" style="font-size:30px"/></td>
  </tr>
  <tr>
    <th scope="row">项目名称</th>
    <td><input type="text" name="a2" id="a2"style="font-size:30px"/></td>
  </tr>
  <tr>
    <th scope="row">教师编号</th>
    <td><input type="text" name="a3" id="a3"style="font-size:30px"/></td>
  </tr>
  <tr>
    <th scope="row">实际经费</th>
    <td><input type="text" name="a4" id="a4"style="font-size:30px"/></td>
  </tr>
  <tr>
    <th scope="row">项目结束年份</th>
    <td><input type="text" name="a5" id="a5"style="font-size:30px"/></td>
  </tr>
  <tr>
    <th scope="row">项目结束月份</th>
    <td><input type="text" name="a6" id="a6"style="font-size:30px"/></td>
  </tr>
</table>
<p>&nbsp;</p>
<p>&nbsp;</p>
<table width="289" border="0" cellpadding="3" align="center" height="105">
  <tr>
    <td width="136" align="center"><input name="a" type="submit" value="申请" style="height:60px; width:80px; font-size:30px"/></td>
    <td width="135" align="center"><input name="b" type="reset" value="重置" style="height:60px; width:80px; font-size:30px"/></td>
    <td width="135" align="center"><input name="b" type="button" value="返回" style="height:60px; width:80px; font-size:30px"/></td>
  </tr>
</table>
</form>
<%
  
%>  
  </div>
  
<jsp:include page="tplf.html"/>
	