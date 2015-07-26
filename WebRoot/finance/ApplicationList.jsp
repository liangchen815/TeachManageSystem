<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="finance.*"%>
<jsp:include page='tplh.html' />
<div id='wzl'>
  	<p  align="center" class="title">报销申请列表</p>
    <table align='center' border='1' width='100%' cellpadding='0' cellspacing='0'>
    	<tr>
    		<td>申请编号</td>
			<td>申请日期</td>
			<td>教师编号</td>
			<td>发票张数</td>
			<td>报销金额</td>
			<td>审核情况</td>
			<td>操作</td>
		</tr>
		<%
			ReimburseDao dao=new ReimburseDao();
			List<Application> applications=dao.getApplications();
			for (int i = 0; i < applications.size(); i++)
			{
				Application a=new Application();
				a=applications.get(i);
				String str;
				if (a.getExamine().equals("已审核"))
					str = "<a href='DetailApplication.jsp?ApplicationNo="
						+a.getApplicationNo()+"'>详情</a>";
				else {
					str = "<a href='DetailApplication1.jsp?ApplicationNo="
						+a.getApplicationNo()+"'>审核</a>";
				}
				out.println("<tr><td>"
						+a.getApplicationNo()+"</td><td>"
						+a.getDate()+"</td><td>"
						+a.getTno()+"</td><td>"
						+a.getNumber()+"</td><td>"
						+a.getCost()+"</td><td>"
						+a.getExamine()+"</td><td>"
						+str+
							"</td></tr>");
			}
		 %>
		 </table>
	</div>
<jsp:include page='tplf.html'/>
