<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="finance.*,java.text.SimpleDateFormat,java.sql.SQLException" %>
<%@page import="java.util.List"%>
<%@page import="java.io.*,javax.servlet.*,javax.servlet.http.*" %>

<jsp:include page="tplh.html"/>
  	<p  align="center" class="title">报销单</p>
  	<div align="center">
    <table  align="right" border='1' width='100%' cellpadding='0' cellspacing='1'>
    	<%
    		response.setContentType("text/html");
    		String no=request.getParameter("ApplicationNo");
			ReimburseDao dao=new ReimburseDao();
			Application a=dao.findByNo(no);
			Approval b=dao.findByAppNo(no);
    	 %>
    	 <form action="modify" method="post">
			申请编号：<%=a.getApplicationNo()%>
			审核编号：<%=b.getApprovalNo()%><br/>
			申请日期:<%=a.getDate()%>
			审核日期:<%=b.getDate()%><br/>
			教师编号:<%=a.getTno()%>
			教师姓名:默认
			报销账号：<%=a.getExpenseAccount() %><br/><br/>
			办公品:
			<input name='OfficeSupplies' disabled value=<%=a.getOfficeSupplies()%>>
			版面费:
			<input name='PageExpense' disabled value=<%=a.getPageExpense()%>><br/>
			材料费:
			<input name='MaterialExpense' disabled value=<%=a.getMaterialExpense()%>>
			通讯费:
			<input name='CommunicationExpense' disabled value=<%=a.getCommunicationExpense()%>><br/>
			设备费:
			<input name='EquipmentExpense' disabled value=<%=a.getEquipmentExpense()%>>
			会议费:
			<input name='ConferenceExpense' disabled value=<%=a.getConferenceExpense()%>><br/>
			资料费:
			<input name='InformationExpense' disabled value=<%=a.getInformationExpense()%>>
			培训费:
			<input name='TrainingExpense' disabled value=<%=a.getTrainingExpense()%>><br/>
			交通费:
			<input name='TravellingExpense' disabled value=<%=a.getTravellingExpense()%>>
			停过费:
			<input name='PorkingExpense' disabled value=<%=a.getPorkingExpense()%>><br/>
			招待费:
			<input name='EntertainmentExpense' disabled value=<%=a.getEntertainmentExpense()%>>
			燃料费:
			<input name='FuelExpense' disabled value=<%=a.getFuelExpense()%>><br/>
			邮寄费:
			<input name='PostExpense' disabled value=<%=a.getPostExpense()%>>
			维修费:
			<input name='UpkeepExpense' disabled value=<%=a.getUpkeepExpense()%>><br/>
			印刷费:
			<input name='PrintingExpense' disabled value=<%=a.getPrintingExpense()%>><br/><br/>
			发票张数:
			<input name='Number' disabled value=<%=a.getNumber()%>><br/>
			报销金额:
			<input name='Cost' disabled value=<%=a.getCost()%>><br/>
			备注:
			<input name='Comment' disabled value=<%=a.getComment()%>><br/>
			<input type='button'value='返回主页' onclick="window.location='index.jsp'">
			</form>
    </table>
	</div>

<jsp:include page="tplf.html"/>