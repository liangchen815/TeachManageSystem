package finance;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import finance.*;

public class DetailApplicationServlet1 extends HttpServlet
{
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		String no=request.getParameter("ApplicationNo");
		try
		{
			response.setContentType("text/html");
			PrintWriter out=response.getWriter();
			out.println("<script type='text/javascript' src='1.js'></script>");
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
			out.println("<form action='modify' method='get'>"
					+"<input name='ApplicationNo' value='"+no+"' type='hidden' />");
			out.println("申请编号："+a.getApplicationNo());
			out.println("审核编号："+d+"<br/>");
			out.println("申请日期:"+a.getDate());
			out.println("审核日期:"+dateString+"<br/>");
			out.println("教师编号:"+a.getTno()+"<br/>");
			out.println("事务:<br/>");
			out.println("办公品:<input name='OfficeSupplies' disabled value='"
					+a.getOfficeSupplies()+"'/>");
			out.println("版面费:<input name='PageExpense' disabled value='"
					+a.getPageExpense()+"'/><br/>");
			out.println("材料费:<input name='MaterialExpense' disabled value='"
					+a.getMaterialExpense()+"'/>");
			out.println("通讯费:<input name='CommunicationExpense' disabled value='"
					+a.getCommunicationExpense()+"'/><br/>");
			out.println("设备费:<input name='EquipmentExpense' disabled value='"
					+a.getEquipmentExpense()+"'/>");
			out.println("会议费:<input name='ConferenceExpense' disabled value='"
					+a.getConferenceExpense()+"'/><br/>");
			out.println("资料费:<input name='InformationExpense' disabled value='"
					+a.getInformationExpense()+"'/>");
			out.println("培训费:<input name='TrainingExpense' disabled value='"
					+a.getTrainingExpense()+"'/><br/>");
			out.println("交通费:<input name='TravellingExpense' disabled value='"
					+a.getTravellingExpense()+"'/>");
			out.println("停过费:<input name='PorkingExpense' disabled value='"
					+a.getPorkingExpense()+"'/><br/>");
			out.println("招待费:<input name='EntertainmentExpense' disabled value='"
					+a.getEntertainmentExpense()+"'/>");
			out.println("燃料费:<input name='FuelExpense' disabled value='"
					+a.getFuelExpense()+"'/><br/>");
			out.println("邮寄费:<input name='PostExpense' disabled value='"
					+a.getPostExpense()+"'/>");
			out.println("维修费:<input name='UpkeepExpense' disabled value='"
					+a.getUpkeepExpense()+"'/><br/>");
			out.println("印刷费:<input name='PrintingExpense' disabled value='"
					+a.getPrintingExpense()+"'/><br/>");
			out.println("发票张数:<input name='Number' disabled value='"
					+a.getNumber()+"'/><br/>");
			out.println("报销金额:<input name='Cost' disabled value='"
					+a.getCost()+"'/><br/>");
			out.println("备注:<input name='Comment' disabled value='"
					+a.getComment()+"'/><br/><br/><br/>");
			out.println("<input type='button'value='返回主页' onclick=\""+"window.location="+"'index.jsp'\"/>");
			out.println("</form>");
			out.close();
		} catch (Exception e)
		{
			e.printStackTrace();
			throw new ServletException(e);
		}
	}

}
