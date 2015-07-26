package lab.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lab.L_labhardmsg;
import lab.L_labhardmsgDao;


public class addHardWareServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor of the object.
	 */
	public addHardWareServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request,response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		L_labhardmsgDao udi = new L_labhardmsgDao();
		L_labhardmsg hardware = new L_labhardmsg();
		hardware.setCpu(request.getParameter("cpu"));
		hardware.setXianka(request.getParameter("xianka"));
		hardware.setXianshiqi(request.getParameter("xianshiqi"));
		hardware.setNeicun(request.getParameter("neicun"));
		hardware.setLabNo(request.getParameter("labNo"));
		hardware.setYingpan(request.getParameter("yingpan"));
		
		ServletContext ctx=this.getServletContext();
		String server=ctx.getInitParameter("server");
		String dbname=ctx.getInitParameter("dbname");
		String user=ctx.getInitParameter("user");
		String pwd=ctx.getInitParameter("pwd");
		
		try {
			udi.getConn(server, dbname, user, pwd);
			if(udi.add(hardware)>0)
				out.println("��ӳɹ�");
			else
				out.println("���ʧ��");
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
	}
}
