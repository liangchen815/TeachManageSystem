<%@page session="true" pageEncoding="utf-8" contentType="text/html; charset=utf-8" %>
<%@page import="java.io.*,javax.servlet.*,javax.servlet.http.*,finance.*,java.util.*" %>

<jsp:include page="tplh.html"/>
  <div id="header1">
    <h1><br />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
      <span class="wy">查询历史工资</span></h1>
  </div>
  <div class="clear"></div>
  <div id="main"> <hr />
    <%
		ServletContext ctx = this.getServletContext();
		String server = ctx.getInitParameter("server");
		String dbname = ctx.getInitParameter("dbname");
		String user = ctx.getInitParameter("user");
		String pwd = ctx.getInitParameter("pwd");

		String date = request.getParameter("date");
		Salary rs = new Salary();
		if(date != null)
		{
			SalaryDAOImpl dao = new SalaryDAOImpl();
			dao.getConn(server,dbname,user,pwd);
			rs = dao.findByDate(date);
		}
	%>
    <div align="center">
    <FONT size="5" face="微软雅黑">  请选择要查询的时间段:</FONT></div>
    <p>&nbsp;</p>
  <div><table width="848" border="0">
  <tr>
  <td width="137">&nbsp;</td>
    <td width="45">From:</td>
    <td width="95">
    <select name="salary_year1" id="select1">
              <option value="">----</option>
              <option value="2000">2000</option>
              <option value="2001">2001</option>
              <option value="2002">2002</option>
              <option value="2003">2003</option>
              <option value="2004">2004</option>
              <option value="2005">2005</option>
              <option value="2006">2006</option>
              <option value="2007">2007</option>
              <option value="2008">2008</option>
              <option value="2009">2009</option>
              <option value="2010">2010</option>
              <option value="2011">2011</option>
              <option value="2012">2012</option>
    </select> 年</td>
    <td width="105">
    <form id="form1" method="post" action="">
      <p>
        <label for="month1"></label>
        <select name="month" id="month1">
          <option value="">--</option>
          <option value="12">12</option>
          <option value="11">11</option>
          <option value="10">10</option>
          <option value="9">9</option>
          <option value="8">8</option>
          <option value="7">7</option>
          <option value="6">6</option>
          <option value="5">5</option>
          <option value="4">4</option>
          <option value="3">3</option>
          <option value="2">2</option>
          <option value="1">1</option>
          </select>月</p>
    </form></td>
    <td width="31">To：</td>
    <td width="102">
      <select name="salary_year2" id="select2">
      <option value="">----</option>
      <option value="2000">2000</option>
      <option value="2001">2001</option>
      <option value="2002">2002</option>
      <option value="2003">2003</option>
      <option value="2004">2004</option>
      <option value="2005">2005</option>
      <option value="2006">2006</option>
      <option value="2007">2007</option>
      <option value="2008">2008</option>
      <option value="2009">2009</option>
      <option value="2010">2010</option>
      <option value="2011">2011</option>
      <option value="2012">2012</option>
    </select>
      年</td>
    <td width="217">
      <select name="month2" id="month2">
      <option value="">--</option>
      <option value="12">12</option>
      <option value="11">11</option>
      <option value="10">10</option>
      <option value="9">9</option>
      <option value="8">8</option>
      <option value="7">7</option>
      <option value="6">6</option>
      <option value="5">5</option>
      <option value="4">4</option>
      <option value="3">3</option>
      <option value="2">2</option>
      <option value="1">1</option>
    </select>
      月</td>
    <td width="46"><input type="button" name="select" 
               id="button1" value="查询" /></td>
    <td width="32">&nbsp;</td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td><form id="form2" method="post" action="">
      <p>&nbsp;</p>
    </form></td>
  </tr>
</table>
    <table width="870" height="271" border="1">
      <caption id="table1">
        <br />
        <br /> 历 史 工 资 表 单  <br />
        <br />
      </caption>
      
      <tr>
        <th width="100" scope="col">职工号</th>
        <th width="100" scope="col">等级</th>
        <th width="100" scope="col">基本工资</th>
        <th width="100" scope="col">奖金</th>
        <th width="100" scope="col">补助</th>
         <th width="100" scope="col">总工资</th>
        <th width="250" scope="col">工资变动备注</th>
        <th width="100" scope="col">日期</th>
      </tr>
      <tr align = "center">
      <td><%=rs.getTno()==null?"":rs.getTno()%></td>
      <td><%=rs.getRank()==null?"":rs.getRank()%></td>
      <td><%=rs.getBasicSalary()==null?"":rs.getBasicSalary()%></td>
      <td><%=rs.getBonus()==null?"":rs.getBonus()%></td>
      <td><%=rs.getAllowance()==null?"":rs.getAllowance()%></td>
      <td><%=rs.getSalarySum()==null?"":rs.getSalarySum()%></td>
      <td><%=rs.getPs()==null?"":rs.getPs()%></td>
      <td><%=rs.getDate()==null?"":rs.getDate()%></td>
	  </tr>
      
      
      
    </table>
    <table width="848" border="0">
      <tr>
        <td width="0" height="37">&nbsp;</td>
        <td width="2">&nbsp;</td>
        <td width="168">&nbsp;</td>
        <td width="190">&nbsp;</td>
        <td width="109">&nbsp;</td>
        <td width="109">&nbsp;</td>
        <td width="109">&nbsp;</td>
        <td width="108">&nbsp;</td>
        <td width="15">&nbsp;</td>
      </tr>
      <tr>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
        <td><input type="button" name="button3" id="button3" onclick="window.location.href('S_update.jsp')" value="修改记录" /></td>
        <td><form id="form3" method="post" action="">
          <p>
            <input type="button" name="button2" id="button2" onclick="window.location.href('S_add.jsp')" value="增加记录" />
          </p>
        </form></td>
        <td><input type="button" name="button4" id="button4" value="删除记录" /></td>
        <td><form id="form4" method="post" action="">
          <p>
            <input type="button" name="button5" id="button5" value="汇总" />
          </p>
        </form></td>
      </tr>
    </table>
    <p>&nbsp;</p>
  </div>
</div>
  
 <jsp:include page="tplf.html"/>