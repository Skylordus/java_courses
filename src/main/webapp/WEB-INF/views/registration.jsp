<%--
  Created by IntelliJ IDEA.
  User: yerlan
  Date: 5/19/17
  Time: 5:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title><spring:message code="register" /></title>
    <link href="<c:url value="/resources/css/styles.css"/>" rel="stylesheet">
</head>
<body>
<h1><spring:message code="register" /></h1>

<form:form method="post" modelAttribute="user" cssClass="box login">
    <fieldset class="boxBody" >
        <form:label path="username"><spring:message code="username" /></form:label>
        <form:input path="username"/>
        <form:errors path="username" cssClass="error"/>
        <br/>
        <br/>
        <form:label path="password"><spring:message code="password" /></form:label>
        <form:input type="password" path="password"/>
        <form:errors path="password" cssClass="error"/>

        <c:if test="${not empty errorMessage}">
            <p class="error">${errorMessage}</p>
        </c:if>
    </fieldset>
    <footer>
        <input type="submit" class="btnLogin" value="<spring:message code="register" />" name="_eventId_create">
        <input type="submit" class="btnLogin" value="<spring:message code="cancel" />" name="_eventId_cancel">
    </footer>
</form:form>

</body>
</html>
