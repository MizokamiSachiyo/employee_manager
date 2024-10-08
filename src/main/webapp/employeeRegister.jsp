<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="model.entity.SectionBean" %>
<%@ page import="model.entity.LanguageBean" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>従業員登録</title>
<style>
.main {
    text-align: center;
}
</style>
</head>
<body>
    <%@ include file="header.jsp" %>
    <div class="main">
        <main>
            <h2>従業員登録フォーム</h2>
            <form action="employeeRegister" method="post">
                氏名（姓）<input type="text" name="lastName" placeholder="例：山田" required><br />
                氏名（名）<input type="text" name="firstName" placeholder="例：太郎" required><br />
                氏名（姓）かな<input type="text" name="lastNameKana" placeholder="例：やまだ" required><br />
                氏名（名）かな<input type="text" name="firstNameKana" placeholder="例：たろう" required><br />
                性別<input type="radio" name="gender" value="男">男<input type="radio" name="gender" value="女">女<br />
                生年月日<input type="text" name="birthday" placeholder="例：19910105" required><br />
                電話番号<input type="text" name="phoneNumber" placeholder="例：08012345678" required><br />
                部署<select name="sectionCode">
                    <%
				    List<SectionBean> sectionList = (List<SectionBean>) request.getAttribute("sectionList");
				    if (sectionList != null) {
				        for (SectionBean section : sectionList) {
				    %>
				    <option value="<%= section.getSectionCode() %>"><%= section.getSectionName() %></option>
				    <%
				        }
				    }
				    %>
                </select><br />
                経験言語<select name="languageCode">
                    <%
				    List<LanguageBean> languageList = (List<LanguageBean>) request.getAttribute("languageList");
				    if (languageList != null) {
				        for (LanguageBean language : languageList) {
				    %>
				    <option value="<%= language.getLanguageCode() %>"><%= language.getLanguageName() %></option>
				    <%
				        }
				    }
				    %>
                </select><br />
                入社日<input type="text" name="hireDate" placeholder="例：20220401" required><br />
                <input type="submit" name="button" value="従業員登録確定">
                <input type="reset" value="クリア"><br />
            </form>
            <form action="menu" method="post">
                <input type="submit" name="button" value="メニュー画面へ">
            </form>
        </main>
    </div>
</body>
</html>
