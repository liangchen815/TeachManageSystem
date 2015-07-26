<%@ page language="java" contentType="text/html;charset=UTF-8"%>

<jsp:include page="tplh.html" />

<div id="wzl">
<div>
	<h4>
		勤工助学申请表
	</h4>
</div>
<div>
	<form action="apply" method="post" name="apply_form">
		姓名：
		<input type="text" name="name" />
		<br />
		性别：
		<input type="text" name="gender" />
		<br />
		民族：
		<input type="text" name="nation" />
		<br />
		出生年月：
		<input type="text" name="birthday" />
		<br />
		学号：
		<input type="text" name="number" />
		<br />
		电话号码：
		<input type="text" name="phone_number" />
		<br />
		邮箱：
		<input type="text" name="email" />
		<br />
		原因描述：
		<textarea name="description"></textarea>
		<br />
		申请岗位：
		<input type="radio" name="apply_type" value="查勤签到" checked />
		查勤签到&nbsp;&nbsp;&nbsp;
		<input type="radio" name="apply_type" value="摆放自行车" />
		摆放自行车
		<br />
		时间：
		<input type="text" name="work_time" />
		<input type="submit" value="提交" />
		<input type="reset" value="重置" />
	</form>
</div>
</div>

<jsp:include page="tplf.html"/>
