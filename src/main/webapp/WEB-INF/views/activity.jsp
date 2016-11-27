<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="false" %>
<html>
<head>
    <title>activity</title>
</head>
<body>
<form:form action="/addActivity" commandName="activity" method="post">
    <input name="exerciseID" type="hidden" value="${exerciseID}">
    <input name="trainingID" type="hidden" value="${trainingID}">

    <form:label path="reps">
        <spring:message text="insert reps"/>
    </form:label>
    <form:input path="reps"/>


    <form:label path="weight">
        <spring:message text="insert weight"/>
    </form:label>
    <form:input path="weight"/>

    <input type="submit" value="add activity">
</form:form>
</body>
</html>
