package finance;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ParttimeJobApplyServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = -9210385517630546882L;

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ApplyForm form = new ApplyForm();
		form.setName(request.getParameter("name"));
		form.setGender(request.getParameter("gender"));
		form.setNation(request.getParameter("nation"));
		form.setBirthday(request.getParameter("birthday"));
		form.setNumber(request.getParameter("number"));
		form.setPhoneNumber(request.getParameter("phone_number"));
		form.setEmail(request.getParameter("email"));
		form.setDescription(request.getParameter("description"));
		form.setApplyType(request.getParameter("apply_type"));
		form.setWorkTime(request.getParameter("work_time"));

		ApplyFormUtil.submit(form);

		response.setContentType("text/html; charset=UTF-8");
		response.getWriter().write("申请已提交，请耐心等待...");
		response.getWriter().close();
	}

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
}
