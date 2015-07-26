<%@page session="true" pageEncoding="utf-8" contentType="text/html; charset=utf-8" %>
<%@page import="java.io.*,javax.servlet.*,javax.servlet.http.*" %>
<%@page import = "finance.*" import="java.sql.SQLException"%>
<%@page import="java.util.List"%>

<jsp:include page="tplh.html"/>
  	<p  align="center" class="title">报销审批列表</p>
    <table  align="center" border='1' width='100%' cellpadding='0' cellspacing='1'>
    	<tr>
    		<td>报销申请编号</td>
    		<td>报销审批编号</td>
    		<td>审批日期</td>
    		<td>审批人</td>
    		<td>备注</td>
    		<td>操作</td>
    	</tr>
    	<tr>
    		<%
    		ReimburseDao dao=new ReimburseDao();
			List<Approval> approvals=dao.getApprovals();
    		for (int i = 0; i < approvals.size(); i++)
			{
				Approval a=new Approval();
				a=approvals.get(i);
				out.println("<tr><td>"
						+a.getApplicationNo()+"</td><td>"
						+a.getApprovalNo()+"</td><td>"
						+a.getDate()+"</td><td>"
						+a.getApprover()+"</td><td>"
						+a.getComment()+"</td><td>"+
						"<a href='DetailApplication.jsp?ApplicationNo="
							+a.getApplicationNo()+"'>详情</a>"+
							"</a></td></tr>");
			}
    		 %>
    	</tr>
    </table>


<jsp:include page="tplf.html"/>
