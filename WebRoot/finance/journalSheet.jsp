<%@page session="true" pageEncoding="utf-8" contentType="text/html; charset=utf-8" %>
<%@page import="java.io.*,javax.servlet.*,javax.servlet.http.*,finance.*,java.util.*" %>
  
<jsp:include page="tplh.html"/>
  
<div id="main">
        
      <div class="searchBar">
        <p class="tip">请选择您要查询报表的所属时间.</p>
        <form action="journalSheet.jsp" method="get">
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
        	
        	JournalSheetDAO dao = new JournalSheetDAOImpl();
        	JournalSheet JS = dao.findByYM(year , month);
        	
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
     
      
      %>
  
  
</div>
  
<jsp:include page="tplf.html"/>
  

	