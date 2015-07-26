<%@page session="true" pageEncoding="utf-8" contentType="text/html; charset=utf-8" %>
<%@page import="java.io.*,javax.servlet.*,javax.servlet.http.*" %>
<%@page import = "finance.*" import="java.sql.SQLException"%>
<%@page import="java.util.List"%>
<%@ page import="java.util.Date"%>
<%@ page import="java.text.*"%>
<%@ page import="java.text.DateFormat"%>



<jsp:include page="tplh.html" />

	<script>
		var ApplicationNo=document.getElementById("ApplicationNo");
		var Tno=document.getElementById("Tno");
		var ExpenseAccount=document.getElementById("ExpenseAccount");
		var Cost=document.getElementById("Cost");
		var OfficeSupplies=document.getElementById("OfficeSupplies");
		var MaterialExpense=document.getElementById("MaterialExpense");
		var EquipmentExpense=document.getElementById("EquipmentExpense");
		var InformationExpense=document.getElementById("InformationExpense");
		var TravellingExpense=document.getElementById("TravellingExpense");
		var EntertainmentExpense=document.getElementById("EntertainmentExpense");
		var PostExpense=document.getElementById("PostExpense");
		var PrintingExpense=document.getElementById("PrintingExpense");
		var PageExpense=document.getElementById("PageExpense");
		var CommunicationExpense=document.getElementById("CommunicationExpense");
		var ConferenceExpense=document.getElementById("ConferenceExpense");
		var TrainingExpense=document.getElementById("TrainingExpense");
		var PorkingExpense=document.getElementById("PorkingExpense");
		var FuelExpense=document.getElementById("FuelExpense");
		var UpkeepExpense=document.getElementById("UpkeepExpense");
		var Number=document.getElementById("Number");
		function check()
		{
			
		/*	if(ApplicationNo.value!='' && Tname.value!='' && Tno.value!='' && Transaction.value!='' && Cost.value!='' && Comment.value!='')
   			{*/
   				alert("哈哈哈哈哈");
   				window.document.f.action="submit";
   				window.document.f.submit();	
   		/*	}
   			else
   			{
   				alert("请重新检查数据是否正确！！！");
   			} */
		}
		function add(c)
		{
			t = document.getElementById("Cost").value;
			document.getElementById("Cost").value =( t*1 + c*1)+"";
		}
		function subtract()
		{
			t = document.getElementById("Cost").value;
			document.getElementById("qq").value =( 5000-t*1)+"";
		}
	</script>
<div id="wzl">
<form name="f" action="" method="post">
  		<p id="form2">报销单</p>
  		<table id="form1">
  			<tr>
  				<td>
  					申请编号：
  					<%
  						ReimburseDao dao=new ReimburseDao();
  						String a=dao.MaxNo();
  						out.println(a);
  					 %>
  				</td>
  				<td>
  					申请日期：
					<%! DateFormat df = new SimpleDateFormat("yyyy-MM-dd");%>
					<%! private String test = df.format(new Date());%>   
					<%= df.format(new Date())%>
  				</td>
  			</tr>
  			<tr>
  				<td>
  					<%
  						String role="";
  						String Tname="";
  						String Tno="";
  						try
  						{
  							String role1=(String)session.getAttribute("role");
  							String Tname1=(String)session.getAttribute("username");
  							String Tno1=(String)session.getAttribute("userid");
  							if(role1=="teacher")
  	  						{
  	  							role=role1;
  	  							Tname=Tname1;
  	  							Tno=Tno1;
  	  						}else{
  	  							Tname="默认";
  	  							Tno="8888";
  	  						}
  						}catch(NumberFormatException ex){}
  					
  					%>
  					申请教师：<input type="text" name="Tname" id="Tname" readonly value=<%=Tname %>>
  				</td>
  				<td>
  					教师编号：<input type="text" name="Tno" id="Tno" readonly value=<%=Tno %>>
  				</td>
  			</tr>
  			<tr>
  				<td>
  				事务     (单位：元)
  				</td>
  				<td>
  					报销账号：
  					<%
  						//获取老师的报销账号，需连接芳芳的数据表
  						
  					%>
  					<select name="ExpenseAccount" id="ExpenseAccount">
  						<option>
  							20010001
  						</option>
  						<option>
  							20010002
  						</option>
  						<option>
  							20010003
  						</option>
  					</select>
  					剩余5000元
  				</td>
  			</tr>
  			<tr align="center">
  				<td>
  					办公费：<input name="OfficeSupplies" id="OfficeSupplies" value="0.00" onblur="add(this.value),subtract()"/>&nbsp;
  					版面费：<input name="PageExpense" id="PageExpense" value="0.00" onblur="add(this.value),subtract()"/>
  				</td>
  			</tr>
  			<tr align="center">
  				<td>
  					材料费：<input name="MaterialExpense" id="MaterialExpense" value="0.00" onblur="add(this.value),subtract()"/>&nbsp;
  					通讯费：<input name="CommunicationExpense" id="CommunicationExpense" value="0.00" onblur="add(this.value),subtract()"/>
  				</td>
  			</tr>
  			<tr align="center">
  				<td>
  					设备费：<input name="EquipmentExpense" id="EquipmentExpense" value="0.00" onblur="add(this.value),subtract()"/>&nbsp;
  					会议费：<input name="ConferenceExpense" id="ConferenceExpense" value="0.00" onblur="add(this.value),subtract()"/>
  				</td>
  			</tr>
  			<tr align="center">
  				<td>
  					资料费：<input name="InformationExpense" id="InformationExpense" value="0.00" onblur="add(this.value),subtract()"/>&nbsp;
  					培训费：<input name="TrainingExpense" id="TrainingExpense" value="0.00" onblur="add(this.value),subtract()"/>
  				</td>
  			</tr>
  			<tr align="center">
  				<td>
  					交通费：<input name="TravellingExpense" id="TravellingExpense" value="0.00" onblur="add(this.value),subtract()"/>&nbsp;
  					停车费：<input name="PorkingExpense" id="PorkingExpense" value="0.00" onblur="add(this.value),subtract()"/>
  				</td>
  			</tr>
  			<tr align="center">
  				<td>
  					招待费：<input name="EntertainmentExpense" id="EntertainmentExpense" value="0.00" onblur="add(this.value),subtract()"/>&nbsp;
  					燃料费：<input name="FuelExpense" id="FuelExpense" value="0.00" onblur="add(this.value),subtract()"/>
  				</td>
  			</tr>
  			<tr align="center">
  				<td>
  					邮寄费：<input name="PostExpense" id="PostExpense" value="0.00" onblur="add(this.value),subtract()"/>&nbsp;
  					维修费：<input name="UpkeepExpense" id="UpkeepExpense" value="0.00" onblur="add(this.value),subtract()"/>
  				</td>
  			</tr>
  			<tr align="right">
  				<td>
  					印刷费：<input name="PrintingExpense" id="PrintingExpense" value="0.00" onblur="add(this.value),subtract()"/>&nbsp;
  				</td>
  			</tr>
  			<tr>
  				<td>
  					发票张数：<input name="Number" id="Number"/>
  				</td>
  			</tr>
  			<tr>
  				<td>
  					报销金额：<input type="text" name="Cost" id="Cost" value="0.00"  readonly/>
  				</td>
  			</tr>
  			<tr>
  				<td>
  					剩余金额：<input type="text" name="qq" id="qq" value="5000"  readonly/>
  				</td>
  			</tr>
  			<tr>
  				<td>备注:</td>
  			</tr>
  			<tr>
  				<td>
  					<textarea name="Comment" id="Comment" cols="45" rows="5"></textarea>
  				</td>
  			</tr>
  			<tr>
				<td>
					<input type="button" value="提交" onclick="check();"/>
					<input type="reset" value="重置"/>
					<input type="button" value="返回上一层" onclick="window.location='index.jsp';"/>
				</td>
			</tr>
  		</table>
</form>
</div>
<jsp:include page="tplf.html"/>
