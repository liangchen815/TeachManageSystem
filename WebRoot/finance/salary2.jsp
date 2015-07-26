<%@page session="true" pageEncoding="utf-8" contentType="text/html; charset=utf-8" %>
<%@page import="java.io.*,javax.servlet.*,javax.servlet.http.*,finance.*,java.util.*" %>

<jsp:include page="tplh.html" />

<div id="header1">
	<h1 style="margin: 20px 80px">
		个人工资单
	</h1>
</div>

<div class="clear"></div>
<div id="main">

	<% 
	                 ServletContext ctx = this.getServletContext();
	                 String server = ctx.getInitParameter("server");
	                 String dbname = ctx.getInitParameter("dbname");
	                 String user = ctx.getInitParameter("user");
	                 String pwd = ctx.getInitParameter("pwd");
	    
	                 String year = request.getParameter("year");
	                 String month = request.getParameter("month");
	                 String date = year + "-" + month;
	                 String tno = request.getParameter("tno");
	                 
	                 Salary rs = new Salary();
	                 if (tno != null && date != null) {
	                 SalaryDAOImpl dao = new SalaryDAOImpl();
	                 dao.getConn(server,dbname,user,pwd);
	                 rs = dao.findByTno(tno,date);
	                 }
	                 %>
	                 
	<div align="center">
		请选择要查询的年度月份：
	</div>
	<hr />
    <form action="salary2.jsp">
    <input type="hidden" value="123" name="123" />
	<div align="center">
		<select name="year" style="width: 80px;">
			<option value="选择年份">
				选择年份
			</option>
			<option value="2000">
				2000
			</option>
			<option value="2001">
				2001
			</option>
			<option value="2002">
				2002
			</option>
			<option value="2003">
				2003
			</option>
			<option value="2004">
				2004
			</option>
			<option value="2005">
				2005
			</option>
			<option value="2006">
				2006
			</option>
			<option value="2007">
				2007
			</option>
			<option value="2008">
				2008
			</option>
			<option value="2009">
				2009
			</option>
			<option value="2010">
				2010
			</option>
			<option value="2011">
				2011
			</option>
			<option value="2012">
				2012
			</option>
		</select>
		<font size=2>年</font>

		<select name="month" style="width: 80px;">
			<option value="选择月份">
				选择月份
			</option>
			<option value="1">
				01
			</option>
			<option value="2">
				02
			</option>
			<option value="3">
				03
			</option>
			<option value="4">
				04
			</option>
			<option value="5">
				05
			</option>
			<option value="6">
				06
			</option>
			<option value="7">
				07
			</option>
			<option value="8">
				08
			</option>
			<option value="9">
				09
			</option>
			<option value="10">
				10
			</option>
			<option value="11">
				11
			</option>
			<option value="12">
				12
			</option>
		</select>
		<font size=2>月</font>
		<input type="submit" value="查询" />
	</div>
	<hr />
    </form>
	<table align="center" border="1px" width="80%" bgcolor="#4682B4"
		cellpadding="0" cellspacing="0">
		<thead>
			<tr align="center">
				<td>
					教职工号
				</td>

				<td>
					级别
				</td>
				<td>
					基本工资(元)
				</td>
				<td>
					奖金(元)
				</td>
				<td>
					补助(元)
				</td>
				<td>
					总工资(元)
				</td>
				<td>
					备注
				</td>
			</tr>
			<tr>
				<td><%=rs.getTno() == null?" " : rs.getTno()%></td>
				<td><%=rs.getRank() == null?" " : rs.getRank()%></td>
				<td><%=rs.getBasicSalary() == null?" " : rs.getBasicSalary()%></td>
				<td><%=rs.getBonus() == null?" " : rs.getBonus()%></td>
				<td><%=rs.getAllowance() == null?" " : rs.getAllowance()%></td>
				<td><%=rs.getSalarySum() == null?" " : rs.getSalarySum()%></td>
				<td><%=rs.getPs() == null?" " : rs.getPs()%></td>
			</tr>
		</thead>
		<tbody>

		</tbody>
	</table>
	<br />
	<br />
	<br />
	<br />
	<br />
	<br />
	<br />
	<br />
	<br />
	<br />

	<tr>
		<td>
			<div style="margin: 70px 750px">
				<input type="button" value="打印" onclick="" />
			</div>
		</td>
	</tr>


</div>

<jsp:include page="tplf.html" />

