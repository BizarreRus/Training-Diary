<%--<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>--%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="false" %>
<html>
<head>
    <title>Test</title>
</head>
<body>
<h4>Muscle Group Decs => </h4>${muscleGroup.toString()} <br><br>

<a href="/getGroups"><h4>Get groups</h4></a>
<br>
<c:forEach items="${list}" var="grou">
    ${grou.group_name} <br>
</c:forEach><br>

<form:form action="/addGroup" commandName="muscleGroup" method="POST">
    <form:label path="group_name">
        <spring:message text="<h4>insert group by name</h4>"/>
    </form:label>
    <form:input path="group_name"/>
    <button type="submit">Submit</button>
</form:form>


<form:form action="/getGroup" method="GET">
    <h4>Select group by name </h4><input type="text" name="groupName">

    <button type="submit">Submit</button>
</form:form>

<form:form action="/removeGroup" method="GET">
    <h4>Remove group by name </h4><input type="text" name="groupName">

    <button type="submit">Submit</button>
</form:form>
</body>
</html>
