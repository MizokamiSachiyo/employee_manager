<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="model.entity.EmployeeListBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>従業員一覧画面</title>
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
	<%@ include file="header.jsp"%>
	<div class="main">
		<main>
			<h2>従業員一覧</h2>
			<form action="employeeList" method="post">
				<input type="text" name="searchWord"> <input type="submit"
					value="従業員検索">
			</form>
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
					<%
					List<EmployeeListBean> employeeList = (List<EmployeeListBean>) request.getAttribute("employeeList");
					if (employeeList != null && !employeeList.isEmpty()) {
						for (EmployeeListBean employee : employeeList) {
					%>
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
							<form action="employee-detail" method="post">
								<input type="hidden" name="employeeId"
									value="<%=employee.getEmployeeId()%>"> <input
									type="submit" value="詳細">
							</form>
						</td>
					</tr>
					<%
					}
					} else {
					%>
					<tr>
						<td colspan="10">従業員はいません。</td>
					</tr>
					<%
					}
					%>
				</tbody>
			</table>
			<form action="menu" method="post">
				<input type="submit" name="button" value="メニュー画面へ">
			</form>
		</main>
	</div>
</body>
</html>