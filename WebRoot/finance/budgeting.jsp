<%@page session="true" pageEncoding="utf-8"
	contentType="text/html; charset=utf-8"%>
<%@page
	import="java.io.*,javax.servlet.*,javax.servlet.http.*,finance.*,java.util.*"%>

<jsp:include page="tplh.html" />

<div id="main">

	 <div class="searchBar">
        <h3>请选择您要查询报表的所属时间.</h3>
        <form action="budgeting.jsp" method="get">
          <p>
            <select name="year">
              <option value="2000">2000</option>
              <option value="2001">2001</option>
              <option value="2002">2002</option>
              <option value="2003">2003</option>
              <option value="2004">2004</option>
              <option value="2005">2005</option>
              <option value="2006">2006</option>
              <option value="2007">2007</option>
              <option value="2008">2008</option>
              <option value="2009">2009</option>
              <option value="2010">2010</option>
              <option value="2011">2011</option>
            </select>
            <span>年</span>
            <select name="month">
              <option value="0">年表</option>
              <option value="1">01</option>
              <option value="2">02</option>
              <option value="3">03</option>
              <option value="4">04</option>
              <option value="5">05</option>
              <option value="6">06</option>
              <option value="7">07</option>
              <option value="8">08</option>
              <option value="9">09</option>
              <option value="10">10</option>
              <option value="11">11</option>
              <option value="12">12</option>
            </select>
            <span>月</span>
            <input type="submit" value="提交" />
          </p>
        </form>
      </div>
      
      <%
        String year = request.getParameter("year");
        String month = request.getParameter("month");
        
        if (year != null && month != null) {
        	
        	JournalSheetDAO DAO = new JournalSheetDAOImpl();
        	JournalSheet JS = DAO.findByYM(year , month);
        	
        	if (JS.getYear() != null && !JS.getAnticipated()) {
              
        	  if (JS.getMonth().equals("0")) JS.setMonth("年表");
        	  
          	  out.println("<div class='result'>"
        		  	  +"<div class='year'><span>年</span><span>"+JS.getYear()+"</span></div>"
        		  	  +"<div class='month'><span>月</span><span>"+JS.getMonth()+"</span></div>"
        		  	  +"<div class='income'><span>收入</span><span>"+JS.getIncome()+"</span></div>"
        		  	  +"<div class='expense'><span>支出</span><span>"+JS.getExpense()+"</span></div>"
        		  	  +"<div class='debt'><span>负债</span><span>"+JS.getDebt()+"</span></div>"
        		  	  +"<div class='credit'><span>应收款</span><span>"+JS.getCredit()+"</span></div>"
        		  	  +"<div class='deposit'><span>存款</span><span>"+JS.getDeposit()+"</span></div>"
        			  +"</div>");
          	
        	} else {
        		
        		out.println("<script type=text/javascript>alert('您所查询的报表不存在');</script>");
        		
        	}
        	
        }
        
        
		Calendar c = Calendar.getInstance();
		int y = c.get(Calendar.YEAR);
		String Year = Integer.toString(y);
		String Month = Integer.toString(0);
		DepartmentalBudgetDAO dao = new DepartmentalBudgetDAOImpl();
		List<DepartmentalBudget> dbs = dao.findByYM(Year, Month);

		if (dbs.size() != 0) {

			for (int i = 0; i < dbs.size(); i++) {

				DepartmentalBudget db = dbs.get(i);

				if (!db.getAdjustment()) {

					out.println("<div class='result'>"
							+"<h3>"+db.getDepartment()+"本年预算</h3>"
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

			out.println("<div class='result'>" + "<h3>无部门年预算</h3>"
					+ "</div>");

		}

		String yy = request.getParameter("yy");
		String mm = request.getParameter("mm");
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

				Dao.save(js);

				out.println("<script type=text/javascript>alert('修改成功！');</script>");

			} else {

				out.println("<script type=text/javascript>alert('输入不全！');</script>");

			}

		}
	%>

	<div id="BdgtAdjt">
		<h3>请录入本年预算</h3>
		<form action="budgeting.jsp" method="get">
			<input name="yy" type="hidden" value="<%=y%>" />
			<input name="mm" type="hidden" value="<%=0%>" />
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