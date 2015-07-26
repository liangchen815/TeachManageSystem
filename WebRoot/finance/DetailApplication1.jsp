<%@ page session="true" language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="finance.*,java.text.SimpleDateFormat,java.sql.SQLException" %>
<%@page import="java.util.List"%>
<%@page import="java.io.*,javax.servlet.*,javax.servlet.http.*" %>

<jsp:include page="tplh.html"/>
		<script>
		var ApplicationNo=document.getElementById("ApplicationNo");
		var Tno=document.getElementById("Tno");
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
		function add(c)
		{
			
			t = document.getElementById("Cost").value;
			
			document.getElementById("Cost").value =( t*1 + c*1)+"";
		}
	</script>
  	<p  align="center" class="title">报销单</p>
  	<div align="center">
    <table  align="right" border='1' width='100%' cellpadding='0' cellspacing='1'>
    	<%
    		response.setContentType("text/html");
    		String no=request.getParameter("ApplicationNo");
			ReimburseDao dao=new ReimburseDao();
			Application a=dao.findByNo(no);
			Approval b=new Approval();
			String d=dao.Max();
			b.setApplicationNo(a.getApplicationNo());
			
			Date date=new Date();
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			String dateString = formatter.format(date);
			b.setDate(dateString);
			
			b.setApprover("hhh");
			
			dao.save(b);
    	 %>
    	 <form action="modify">
    	 	<input name='ApplicationNo' value=<%=no%> type='hidden' />
			申请编号：<%=a.getApplicationNo()%>
			审核编号：<%=d%><br/>
			申请日期:<%=a.getDate()%>
			审核日期:<%=dateString%><br/>
			教师编号:<%=a.getTno()%>
			教师姓名:哈哈
			报销账号：<%=a.getExpenseAccount() %><br/><br/>
			办公品:
			<input name='OfficeSupplies' id='OfficeSupplies' onblur='add(this.value)' value=<%=a.getOfficeSupplies()%>>
			版面费:
			<input name='PageExpense' id='PageExpense' onblur='add(this.value)' value=<%=a.getPageExpense()%>><br/>
			材料费:
			<input name='MaterialExpense' id='MaterialExpense' onblur='add(this.value)'  value=<%=a.getMaterialExpense()%>>
			通讯费:
			<input name='CommunicationExpense' id='CommunicationExpense'  onblur='add(this.value)' value=<%=a.getCommunicationExpense()%>><br/>
			设备费:
			<input name='EquipmentExpense' id='EquipmentExpense'  onblur='add(this.value)' value=<%=a.getEquipmentExpense()%>>
			会议费:
			<input name='ConferenceExpense' id='ConferenceExpense'  onblur='add(this.value)' value=<%=a.getConferenceExpense()%>><br/>
			资料费:
			<input name='InformationExpense' id='InformationExpense'   onblur='add(this.value)' value=<%=a.getInformationExpense()%>>
			培训费:
			<input name='TrainingExpense' id='TrainingExpense'  onblur='add(this.value)' value=<%=a.getTrainingExpense()%>><br/>
			交通费:
			<input name='TravellingExpense' id='TravellingExpense'  onblur='add(this.value)' value=<%=a.getTravellingExpense()%>>
			停过费:
			<input name='PorkingExpense' id='PorkingExpense'  onblur='add(this.value)' value=<%=a.getPorkingExpense()%>><br/>
			招待费:
			<input name='EntertainmentExpense' id='EntertainmentExpense'  onblur='adadd(this.value)d()' value=<%=a.getEntertainmentExpense()%>>
			燃料费:
			<input name='FuelExpense' id='FuelExpense'  onblur='add(this.value)' value=<%=a.getFuelExpense()%>><br/>
			邮寄费:
			<input name='PostExpense' id='PostExpense'  onblur='add(this.value)' value=<%=a.getPostExpense()%>>
			维修费:
			<input name='UpkeepExpense' id='UpkeepExpense'  onblur='add(this.value)'  value=<%=a.getUpkeepExpense()%>><br/>
			印刷费:
			<input name='PrintingExpense' id='PrintingExpense' onblur='add(this.value)'  value=<%=a.getPrintingExpense()%>><br/><br/>
			发票张数:
			<input name='Number' value=<%=a.getNumber()%>><br/>
			报销金额:
			<input name='Cost' id='Cost'  value=<%=a.getCost()%>><br/>
			备注:
			<input name='Comment' value=<%=a.getComment()%>><br/>
			<input type='submit' value='审核'>
			<input type='reset' value='取消修改'>
			<input type='button'value='返回上一层' onclick="window.location='ApplicationList.jsp'">
			<input type='button'value='返回主页' onclick="window.location='index.jsp'">
			</form>
    </table>
	</div>
<jsp:include page="tplf.html"/>