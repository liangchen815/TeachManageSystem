<%@page session="true" pageEncoding="utf-8" contentType="text/html; charset=utf-8" %>
<%@page import="java.io.*,javax.servlet.*,javax.servlet.http.*,finance.*,java.util.*" %>

<jsp:include page="tplh.html"/>

<div><h4>导员意见表</h4></div>
<form>
<div>学号
<input type="text" name="sno" id="sno" size="10"/>
</div><br />
<div>姓名<input type="text" name="name" id="name" size="20"/></div>
<div><br />
<div>班级<input type="text" name="class" id="class" size="20"/></div><br />

<div>同意与否<input type="radio" name="proposal" id="pro" check="checked" />是
<input type="radio" name="proposal" id="pro" />否<br />
<div><h1>拒绝原因:</h1></div>
<textarea rows="30" cols="100" ></textarea>
</div>
</div>
</form>


<jsp:include page="tplf.html"/>
