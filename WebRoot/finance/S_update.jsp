<%@page session="true" pageEncoding="utf-8" contentType="text/html; charset=utf-8" %>
<%@page import="java.io.*,javax.servlet.*,javax.servlet.http.*" %>
<%@page import = "finance.*" import="java.sql.SQLException"%>

<jsp:include page="tplh.html"/>
    
    
<div id="main">
	<div id = "d1">
			<div id="d1_head">修改记录</div>
		
			<div id="d1_content">
			<form name="myform" action="/day04/add" method="post">
			<table width="616" height="173">
			
			<tr>
				<td valign="top">
				</br></td>
				<td>职工号:</td>
				<td>
				<input type="text" id="tno" name="tno" />
				<span class="s1" id="tno_msg"></span>
				</td>
			</tr>
			
			
			<tr>
				<td valign="top">
				<br></td>
				<td>等级:</td>
				<td>
				<input type="text" id="rank" name="rank"/>
				<span class='s1' id="rank_msg"></span>
				</td>
			</tr>
		
			<tr>
				<td valign="top">
				<br></td>
				<td>基本工资:</td>
				<td>
				<input type="text" id="basicsalary" name="basicsalary"/>
				<span class='s1' id="basicsalary_msg"></span>
				</td>
			</tr>
			
			<tr>
				<td valign="top">
				<br></td>
				<td>奖金:</td>
				<td>
				<input type="text" id="bonus" name="bonus"/>
				<span class='s1' id="bonus_msg"></span>
				</td>
			</tr>
			
			<tr>
				<td valign="top">
				<br></td>
				<td>补助:</td>
				<td>
				<input type="text" id="allowance" name="allowance"/>
				<span class='s1' id="allowance_msg"></span>
				</td>
			</tr>
			
			<tr>
				<td valign="top">
				<br></td>
				<td>总工资：</td>
				<td>
				<input type="text" id="Sum" name="sum"/>
				<span class='s1' id="sum_msg"></span>
				</td>
			</tr>
			
			<tr>
				<td valign="top">
				<br></td>
				<td>工资变动备注：</td>
				<td>
				<input type="text" id="ps" name="ps"/>
				<span class='s1' id="ps_msg"></span>
				</td>
			</tr>
			
			<tr>
				<td valign="top">
				<br></td>
				<td>日期：</td>
				<td>
				<input type="text" id="date" name="date"/>
				<span class='s1' id="date_msg"></span>
				</td>
			</tr>
		 
			<tr>
				<td valign="top">
				<br></td><td colspan="2">
				<input type="button" value="确认修改"/>
				<input type="reset" value="重置"/>
				<input type="button" onclick="window.location.href('Salary1.jsp')"  value="放弃" />
				</td>
			</tr>
			
			</table>
        </form>
		</div>
    </div>
 </div>
 
  
 <jsp:include page="tplf.html"/>