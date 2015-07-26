<%@page session="true" pageEncoding="utf-8" contentType="text/html; charset=utf-8" %>
<%@page import="java.io.*,javax.servlet.*,javax.servlet.http.*,finance.*,java.util.*" %>

<jsp:include page="tplh.html"/>
  
  <div id="main">
   
     
     <%
      Calendar c = Calendar.getInstance();
      int y = c.get(Calendar.YEAR);
      int m = c.get(Calendar.MONTH);
      
    %>
    
    <div id="incomeTable">
    <h3>请录入本月收入表</h3>
    <form action="appendTables.jsp" method="get">
      <input name="year" type="hidden" value="<%=y %>" />
      <input name="month" type="hidden" value="<%=m %>" />
      <p>收入<input type="text" name="income" /></p>
      <p>来源<input type="text" name="from" /></p>
      <p><input type="submit" value="提交" /></p>
    </form>
    </div>
    
    <div id="expenseTable">
    <h3>请录入本月支出表</h3>
    <form action="appendTables.jsp" method="get">
      <input name="year" type="hidden" value="<%=y %>" />
      <input name="month" type="hidden" value="<%=m %>" />
      <p>支出<input type="text" name="expense" /></p>
      <p>去向<input type="text" name="for" /></p>
      <p><input type="submit" value="提交" /></p>
    </form>
    </div>
    
    <div id="debtTable">
    <h3>请录入负债记录</h3>
    <form action="appendTables.jsp" method="get">
      <p>请输入起始日期<input type="text" name="syear" />年<input type="text" name="smonth" />月<input type="text" name="sday" />日</p>
      <p>请输入终止日期<input type="text" name="dyear" />年<input type="text" name="dmonth" />月<input type="text" name="dday" />日</p>
      <p>负债人<input type="text" name="debtor" /></p>
      <p>金额<input type="text" name="amount" /></p>
      <p>利率<input type="text" name="interestRate" /></p>
      <p><input type="submit" value="提交" /></p>
    </form>
    </div>
    
    <div id="creditTable">
    <h3>请录入应收记录</h3>
    <form action="appendTables.jsp" method="get">
      <p>请输入起始日期<input type="text" name="syear" />年<input type="text" name="smonth" />月<input type="text" name="sday" />日</p>
      <p>请输入终止日期<input type="text" name="dyear" />年<input type="text" name="dmonth" />月<input type="text" name="dday" />日</p>
      <p>负债人<input type="text" name="lender" /></p>
      <p>金额<input type="text" name="amount" /></p>
      <p>利率<input type="text" name="interestRate" /></p>
      <p><input type="submit" value="提交" /></p>
    </form>
    </div>
    
    <%
      String year = request.getParameter("year");
      String month = request.getParameter("month");
      String from = request.getParameter("from");
      String income = request.getParameter("income");
      String expense = request.getParameter("expense");
      String ffor = request.getParameter("for");
      String debt = request.getParameter("debt");
      String credit = request.getParameter("credit");
      String amount = request.getParameter("amount");
      String interestRate = request.getParameter("interestRate");
      String debtor = request.getParameter("debtor");
      String lender = request.getParameter("lender");
      String syear = request.getParameter("syear");
      String dyear = request.getParameter("dyear");
      String smonth = request.getParameter("smonth");
      String dmonth = request.getParameter("dmonth");
      String sday = request.getParameter("sday");
      String dday = request.getParameter("dday");
      
      if (income != null) {
    	  
    	  IncomeDAO dao = new IncomeDAOImpl();
    	  Income i = new Income();
    	  
    	  i.setYear(year);
    	  i.setMonth(month);
    	  i.setIncome(Double.parseDouble(income));
    	  i.setFrom(from);
    	  
    	  dao.save(i);
    	  
    	  out.println("<script type=text/javascript>alert('录入成功！');</script>");
    	  
      }
      
      if (expense != null) {
    	  
    	  ExpenseDAO dao = new ExpenseDAOImpl();
    	  Expense e = new Expense();
    	  
    	  e.setYear(year);
    	  e.setMonth(month);
    	  e.setExpense(Double.parseDouble(expense));
    	  e.setFor(ffor);
    	  
    	  dao.save(e);
    	  
    	  out.println("<script type=text/javascript>alert('录入成功！');</script>");
    	  
      }
      
      if (debtor != null) {
    	  
    	  DebtDAO dao = new DebtDAOImpl();
    	  Debt d = new Debt();
    	  
    	  String start = syear + "-" + smonth + "-" + sday;
    	  String due = dyear + "-" + dmonth + "-" + dday;
    	  d.setStart(start);
    	  d.setDue(due);
    	  d.setDebtor(debtor);
    	  d.setAmount(Double.parseDouble(amount));
    	  d.setInterestRate(Double.parseDouble(interestRate));
    	  
    	  dao.save(d);
    	  
    	  out.println("<script type=text/javascript>alert('录入成功！');</script>");
    	  
      }
      
      if (lender != null) {
    	  
    	  CreditDAO dao = new CreditDAOImpl();
    	  Credit cr = new Credit();
    	  
    	  String start = syear + "-" + smonth + "-" + sday;
    	  String due = dyear + "-" + dmonth + "-" + dday;
    	  cr.setStart(start);
    	  cr.setDue(due);
    	  cr.setLender(lender);
    	  cr.setAmount(Double.parseDouble(amount));
    	  cr.setInterestRate(Double.parseDouble(interestRate));
    	  
    	  dao.save(cr);
    	  
    	  out.println("<script type=text/javascript>alert('录入成功！');</script>");
    	  
      }
    %>
    
    
  
  
  </div>
  
  
  
<jsp:include page="tplf.html"/>
	