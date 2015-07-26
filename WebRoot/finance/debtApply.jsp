<%@page session="true" pageEncoding="utf-8" contentType="text/html; charset=utf-8" %>
<%@page import="java.io.*,javax.servlet.*,javax.servlet.http.*" %>


<jsp:include page="tplh.html"/>
  
  <div id="main">
  <h3>助学贷款申请</h3>
  <form action="waiting.jsp">
<table width="59%" height="550" border="2"cellpadding="0"  cellspacing="0" caption="学生贷款申请">
  <tr>
    <th width="24" scope="row">申请人信息</th>
    <td width="10" height="159" nowrap="nowrap" bgcolor="#FFFFFF" >申请人姓名</td>
    <td width="70"><input type="text" name="name" id="name" size="10"/></td>
    <td width="23">性别</td>
    <td width="10"><input type="radio" name="sex" id="sex" check="checked"/>
      男
      <input type="radio" name="sex"/>
      女 </td>
    <td width="23">出生日期</td>
    <td width="82"><input type="text" id="bir"name="birthday" size="10"/></td>
    <td width="23">身份证号码</td>
    <td width="137" height="159"><input type="text" name="idno" id="idno" 
    size="20"/></td>
  </tr>
  <tr>
    <th scope="row">基本情况</th>
    <td height="60" width="106" nowrap="nowrap" bgcolor="#FFFFFF">学历 </td>
    <td><input type="text" name="level" id="level" size="8"/></td>
    <td>联系方式</td>
    <td><input type="text" name="phoneno" id="phoneno" size= "12"/></td>
    <td>入学时间</td>
    <td><input type="text" name="date" id="date" 
    size="10"/></td>
    <td>毕业时间</td>
    <td><input type="text" name="gdate" id="gdate" size="10"/></td>
  </tr>
  <tr>
    <th scope=" 4 cols">申请原因</th>
    <td height="130" nowrap="nowrap" bgcolor="#FFFFFF"><textarea name="raason" cols="40" rowa="20"></textarea></td>
  </tr>
  <tr>
    <th height="163" scope="cols">贷款情况</th>
    <td width="297" height="10" nowrap="nowrap" bgcolor="#FFFFFF">贷款金额（小写）</td>
    <td><input type="text" name="money" id="money" size="6"/></td>
    <td>贷款种类</td>
    <td><input type="radio" name="loantype"  id="lt" check="checked"/>
      中央财政贴息国家助学贷款
      <input type="radio" name="loantype"  id="lt" />
      地方财政贴息国家助学贷款</td>
    <td>还款方式</td>
    <td><input type="radio" name="paytype" id="pt"check="checked"/>
      等额本息还款法
      <input type="radio" name="paytype" id="pt"/>
      等额本金还款法</td>
      </tr>
      <tr><td>	<input type="submit" value="提交"/> </td>
      <td>
      <input type="reset" value="重置"/></td>
      </tr>
      </table>
      </form>
  </div>
  
  
<jsp:include page="tplf.html"/>
	