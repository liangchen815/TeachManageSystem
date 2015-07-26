<%@page session="true" pageEncoding="utf-8" contentType="text/html; charset=utf-8" %>
<%@page import="java.io.*,javax.servlet.*,javax.servlet.http.*" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">

<head>
	<title>Finance</title>
	<meta http-equiv="content-type" content="text/html;charset=utf-8" />
	<link rel="stylesheet" type="text/css" href="css/finance.css" />
	<script type="text/javascript" src="./js/finance.js"></script>
	<script type="text/javascript" src="./js/jquery.js"></script>
	<script type="text/javascript" src="./js/stunt.js"></script>
</head>

<body>
  <div id="wrapper">
  
  
  <div id="header">
  <h1 class="title">财务管理系统</h1>
  </div>
  
  <marquee direction="right" scrollamount="2" scrolldelay="50">哈哈哈哈哈哈！！！</marquee>
<div id="navigator">
    <ul class="navigatorBar">
      
      <li class="navigatorList">
        <a href="index.jsp" class="listTitle">首页</a>
        
      </li>
      
      <li class="navigatorList">
        <a class="listTitle">学费</a>
        <ul class="slideDownList">
          <li><a href="debtApply.jsp">助学贷款申请</a></li>
          <li><a href="daoyuan.jsp">助学贷款审批</a></li>
          <li><a href="apply.jsp">勤工助学申请</a></li>
          <li><a href="daoyuan1.jsp">勤工助学审批</a></li>
        </ul>
      </li>
      
      <li class="navigatorList">
        <a class="listTitle">工资</a>
        <ul class="slideDownList">
          <li><a href="Salary1.jsp">工资管理</a></li>
          <li><a href="salary2.jsp">工资表查询</a></li>
        </ul>
      </li>
      
      <li class="navigatorList">
        <a class="listTitle">报销</a>
        <ul class="slideDownList">
          <li><a href="ExpenseAccount.jsp">报销登记</a></li>
          <li><a href="applicationList">报销单列表</a></li>
          <li><a href="ApprovalList.jsp">审批列表</a></li>
        </ul>
      </li>
      
      <li class="navigatorList">
        <a class="listTitle">经费</a>
        <ul class="slideDownList">
          <li><a href="funding1.jsp">经费申请</a></li>
          <li><a href="funding2.jsp">历史明细</a></li>
        </ul>
      </li>
      
      <li class="navigatorList">
        <a class="listTitle">预算</a>
        <ul class="slideDownList">
          <li><a href="journalSheet.jsp">报表查询 </a></li>
          <li><a href="appendTables.jsp">报表录入</a></li>
          <li><a href="budgeting.jsp">本年预算</a></li>
          <li><a href="BudgetAdjustment.jsp">预算调整</a></li>
          <li><a href="departmentalBudget.jsp">部门预算申报</a></li>
        </ul>
      </li>
      
    </ul>
  
  </div>
    
  <div class="clear"></div>
  
  <div id="main">
  	<table>
  		<tr>
    		<td>
    		<iframe width="900" height="690" src="ApprovalList.jsp"></iframe>
    		</td>
    	</tr>
    </table>
  </div>
  
  
  
 <div class="delimiter"></div> 
<div id="footer">
  <div id="links">
    <ul>
      <li><a href="#">友情链接</a></li>
      <li><a href="#">友情链接</a></li>
      <li><a href="#">友情链接</a></li>
      <li><a href="#">友情链接</a></li>
      <li>...</li>
    </ul>
  </div>
  
  <div id="contact">
	<h3 class="titleFooter">联系我们</h3>
	<p>请您提出宝贵的意见及建议.</p>				
	<ul class="contacts">
	    <li class="textShadow">财务处</li>
		<li class="textShadow">+86 152 0155 7374</li>
		<li class="textShadow">magicyuli@gmail.com</li>
	</ul>
  </div>
			
  <div class="clear"></div>
  <div class="bottom fixed">
	<p>Copyright &copy; 2012 SIFE P2P项目组 <a href="#">备案：京</a> | <a href="#">使用须知</a> | <a href="#">隐私协议</a></p>			
  </div>

</div>

</div>
</body>
</html>
	