<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="model.entity.EmployeeListBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>従業員詳細</title>
<style>
.main {
	text-align: center;
	width: 100%;
}

table {
	border-collapse: collapse;
	width: 80%;
	margin: 0 auto;
}

th, td {
	border: 3px double gray;
	padding: 3px;
	text-align: center;
}
</style>
</head>
<body>
<body>
	<%@ include file="header.jsp"%>
	<div class="main">
		<main>
			<%
			EmployeeListBean employee = (EmployeeListBean) request.getAttribute("employee");
			if (employee != null) {
			%>
			<h2><%=employee.getLName()%>
				<%=employee.getFName()%>
				さん 詳細
			</h2>
			<table border="1">
				<thead>
					<tr>
						<th>従業員ID</th>
						<th>従業員名（姓）</th>
						<th>従業員名（名）</th>
						<th>性別</th>
						<th>生年月日</th>
						<th>電話番号</th>
						<th>部署</th>
						<th>経験言語</th>
						<th>入社日</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td><%=employee.getEmployeeId()%></td>
						<td><%=employee.getLName()%></td>
						<td><%=employee.getFName()%></td>
						<td><%=employee.getGender()%></td>
						<td><%=employee.getBirthday()%></td>
						<td><%=employee.getPhoneNumber()%></td>
						<td><%=employee.getSectionCode()%></td>
						<td><%=employee.getLanguageCode()%></td>
						<td><%=employee.getHireDate()%></td>
						<td>
							<form action="employee-edit" method="post">
								<input type="hidden" name="employeeId"
									value="<%=employee.getEmployeeId()%>"> <input
									type="submit" name="button" value="編集">
							</form>
						</td>
						<td>
							<form action="employee-delete" method="post">
								<input type="hidden" name="employeeId"
									value="<%=employee.getEmployeeId()%>"> <input
									type="submit" name="button" value="削除">
							</form>
						</td>
					</tr>
					<%
					}
					%>
				</tbody>
			</table>
			<form action="employeeList" method="post">
				<input type="submit" name="button" value="従業員一覧">
			</form>
		</main>
	</div>
</body>
</html>