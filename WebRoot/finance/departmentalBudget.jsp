<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@page import="java.io.*,javax.servlet.*,javax.servlet.http.*,finance.*,java.util.*" %>

<jsp:include page="tplh.html"/>
  
<div id="main">
    
    <%
      Calendar c = Calendar.getInstance();
      int y = c.get(Calendar.YEAR);
      int m = c.get(Calendar.MONTH);
      
    %>
    <div id="dptmBdgtYear">
    <h3>请录入本年预算</h3>
    <form action="departmentalBudget.jsp" method="get">
      <input name="year" type="hidden" value="<%=y %>" />
      <input name="month" type="hidden" value="<%=0 %>" />
      <P>部门<input type="text" name="department" /></P>
      <p>收入<input type="text" name="income" /></p>
      <p>支出<input type="text" name="expense" /></p>
      <p>负债<input type="text" name="debt" /></p>
      <p>应收<input type="text" name="credit" /></p>
      <input name="adjustment" type="hidden" value="<%=0 %>" />
      <p><input type="submit" value="提交" /></p>
    </form>
    
    </div>
    
    <div id="dptmBdgtAdjtmnt">
    <h3>请录入本月预算调整</h3>
    <form action="departmentalBudget.jsp" method="get">
      <input name="year" type="hidden" value="<%=y %>" />
      <input name="month" type="hidden" value="<%=m %>" />
      <P>部门<input type="text" name="department" /></P>
      <p>收入<input type="text" name="income" /></p>
      <p>支出<input type="text" name="expense" /></p>
      <p>负债<input type="text" name="debt" /></p>
      <p>应收<input type="text" name="credit" /></p>
      <input name="adjustment" type="hidden" value="<%=1 %>" />
      <p><input type="submit" value="提交" /></p>
    </form>
    
    </div>
    
    <%
      String year = request.getParameter("year");
      String month = request.getParameter("month");
      String department = request.getParameter("department");
      String income = request.getParameter("income");
      String expense = request.getParameter("expense");
      String debt = request.getParameter("debt");
      String credit = request.getParameter("credit");
      String adjustment = request.getParameter("adjustment");
      
      DepartmentalBudgetDAO dao = new DepartmentalBudgetDAOImpl();
      DepartmentalBudget t = new DepartmentalBudget();
      
      
      if (adjustment != null) {
    	  
    	  boolean ad;
    	  
    	  if (adjustment.equals("0"))ad = false; else ad = true;
      
      
      
      t = dao.findByYM(year , month , department , ad);
      
      if (t.getDepartment() == null) {
    	  
          DepartmentalBudget db = new DepartmentalBudget();
      
          if (year != null && month != null) {
    	  
              db.setAdjustment(ad);
              db.setCredit(Double.parseDouble(credit));
              db.setDebt(Double.parseDouble(debt));
              db.setDepartment(department);
              db.setExpense(Double.parseDouble(expense));
              db.setIncome(Double.parseDouble(income));
              db.setMonth(month);
              db.setYear(year);
      
              dao.save(db);
      
              out.println("<script type=text/javascript>alert('录入成功！');</script>");
      
          }
          
      } else {
    	  
    	  out.println("<script type=text/javascript>alert('该预算已存在！');</script>");
    	  
      }
      
      }
    %>
  
  
</div>
  
<jsp:include page="tplf.html"/>
	