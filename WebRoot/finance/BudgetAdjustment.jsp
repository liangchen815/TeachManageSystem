<%@page session="true" pageEncoding="utf-8"
	contentType="text/html; charset=utf-8"%>
<%@page
	import="java.io.*,javax.servlet.*,javax.servlet.http.*,finance.*,java.util.*"%>

<jsp:include page="tplh.html" />

<div id="main">

	<%
		Calendar c = Calendar.getInstance();
		int y = c.get(Calendar.YEAR);
		int m = c.get(Calendar.MONTH);
		String year = Integer.toString(y);
		String month = Integer.toString(m);
		DepartmentalBudgetDAO dao = new DepartmentalBudgetDAOImpl();
		List<DepartmentalBudget> dbs = dao.findByYM(year, month);

		if (dbs.size() != 0) {

			for (int i = 0; i < dbs.size(); i++) {

				DepartmentalBudget db = dbs.get(i);

				if (db.getAdjustment()) {

					out.println("<div class='result'>"
							+"<h3>"+db.getDepartment()+"本月预算调整</h3>"
							+ "<div class='year'><span>年</span><span>"
							+ db.getYear() + "</span></div>"
							+ "<div class='month'><span>月</span><span>"
							+ db.getMonth() + "</span></div>"
							+ "<div class='month'><span>部门</span><span>"
							+ db.getDepartment() + "</span></div>"
							+ "<div class='income'><span>收入</span><span>"
							+ db.getIncome() + "</span></div>"
							+ "<div class='expense'><span>支出</span><span>"
							+ db.getExpense() + "</span></div>"
							+ "<div class='debt'><span>负债</span><span>"
							+ db.getDebt() + "</span></div>"
							+ "<div class='credit'><span>应收款</span><span>"
							+ db.getCredit() + "</span></div>" + "</div>");

				}
			}

		} else {

			out.println("<div class='result'>" + "<h3>本月无预算调整</h3>"
					+ "</div>");

		}

		String yy = request.getParameter("year");
		String mm = request.getParameter("month");
		String anticipated = request.getParameter("anticipated");
		String income = request.getParameter("income");
		String expense = request.getParameter("expense");
		String debt = request.getParameter("debt");
		String credit = request.getParameter("credit");
		String deposit = request.getParameter("deposit");

		JournalSheetDAO Dao = new JournalSheetDAOImpl();

		if (anticipated != null) {

			boolean an;
			if (anticipated.equals("0"))
				an = false;
			else
				an = true;

			JournalSheet js = new JournalSheet();

			if (year != null && month != null && deposit != null) {

				js.setAnticipated(an);
				js.setCredit(Double.parseDouble(credit));
				js.setDebt(Double.parseDouble(debt));
				js.setDeposit(Double.parseDouble(deposit));
				js.setExpense(Double.parseDouble(expense));
				js.setIncome(Double.parseDouble(income));
				js.setMonth(month);
				js.setYear(year);

				Dao.update(js);

				out.println("<script type=text/javascript>alert('修改成功！');</script>");

			} else {

				out.println("<script type=text/javascript>alert('输入不全！');</script>");

			}

		}
	%>

	<div id="BdgtAdjt">
		<h3>请录入本年调整后预算</h3>
		<form action="departmentalBudget.jsp" method="get">
			<input name="year" type="hidden" value="<%=y%>" />
			<input name="month" type="hidden" value="<%=0%>" />
			<p>收入<input type="text" name="income" /></p>
			<p>支出<input type="text" name="expense" />
			<p>负债<input type="text" name="debt" /></p>
			<p>应收<input type="text" name="credit" />
			<P>存款<input type="text" name="deposit" /></P>
			<input name="anticipated" type="hidden" value="<%=1%>" />
			<p><input type="submit" value="提交" /></p>
		</form>

	</div>



</div>


<dbp:include page="tplf.html" />