<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="false" %>
<html>
<head>
    <title>exercises</title>
</head>
<body>
<c:forEach items="${exercises}" var="currExec">
    <h4>${currExec.exercise_name}</h4>
</c:forEach>
<br>
Add new Exercise:
<form:form action="/addExercise" commandName="exercise" method="post">
    Insert exercise name: <form:input path="exercise_name"/>
    <br>
    Select Group:
    <select name="groupName">
        <c:forEach items="${groupNames}" var="gName">
            <option value="${gName}">${gName}</option>
        </c:forEach>
    </select>

    <button type="submit">Add</button>
</form:form>

</body>
</html>
