package finance;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import finance.*;

public class LoadApplicationServlet extends HttpServlet
{
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		String no=request.getParameter("ApplicationNo");
		try
		{
			ReimburseDao dao=new ReimburseDao();
			Application a=dao.findByNo(no);
			response.setContentType("text/html");
			PrintWriter out=response.getWriter();
				out.println("<form action='modify?ApplicationNo="
						+no+"'method='post'>");
				out.println("申请编号："+no+"<br/>");
				out.println("申请日期:<input name='Date' value='"
						+a.getDate()+"'/><br/>");
				out.println("教师编号:<input name='Tno' value='"
						+a.getTno()+"'/><br/>");
				out.println("事务:<input name='Transaction' value='"
						+a.getTransaction()+"'/><br/>");
				out.println("报销金额:<input name='Cost' value='"
						+a.getCost()+"'/><br/>");
				out.println("备注:<input name='Comment' value='"
						+a.getComment()+"'/><br/>");
				out.println(
						"<input type='submit'"+
						"value='确定修改'/>");
				out.println("<input type='reset'"+
						"value='取消修改'/>");
				out.println("</form>");
				out.close();
		} catch (Exception e)
		{
			e.printStackTrace();
			throw new ServletException(e);
		}
	}

}
