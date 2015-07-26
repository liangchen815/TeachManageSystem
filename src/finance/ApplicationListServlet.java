package finance;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import finance.Application;
import finance.ReimburseDao;

public class ApplicationListServlet extends HttpServlet
{
	/**
	 * 
	 */
//	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		try
		{	
			ReimburseDao dao=new ReimburseDao();
			List<Application> applications=dao.getApplications();
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.println("<jsp:include page='tplh.html' />");
			out.println("<div id='wzl'>");
			out.println("<table align='center' border='1' width='100%' cellpadding='0' cellspacing='0'>");
			out.println(
					"<tr><td>申请编号</td>"+
					"<td>申请日期</td>"+
					"<td>教师编号</td>"+
					"<td>发票张数</td>"+
					"<td>报销金额</td>" +
					"<td>审核情况</td>" +
					"<td>操作</td></tr>");
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
			
			out.println("</table>");
			out.println("<input type='button'value='返回上一层' onclick=\""+"window.location="+"'index.jsp'\"/>");
			out.println("</div><jsp:include page='tplf.html'/>");
			out.close();
		}catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		} 
	}

}
