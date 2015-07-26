package finance;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@SuppressWarnings("serial")
public class LoanApplyServlet extends HttpServlet {
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LoanApplyForm form = new LoanApplyForm();
		form.setName(request.getParameter("name"));
		form.setGender(request.getParameter("gender"));
		form.setBirthday(request.getParameter("birthday"));
		form.setSno(request.getParameter("sno"));
		form.setPhoneNumber(request.getParameter("phonenumber"));
		form.setDescription(request.getParameter("description"));
		form.setL_type(request.getParameter("L_type"));
		form.setAmout(request.getIntHeader("Amout"));
		LoanApplyFormUtil.submit(form);
		
		response.setContentType("text/html; charset=UTF-8");
		response.getWriter().write("申请成功，正在审核中...");
		response.getWriter().close();
	}
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
}



