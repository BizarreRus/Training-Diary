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
<h3>List of exercises:</h3>
<c:forEach items="${exercises}" var="currExec">
    ${currExec.exercise_name} <a href="/removeExerciseById/${currExec.id}">delete</a>.
</c:forEach>
<br>
<br>
Add new Exercise:
<form:form action="/addExercise" commandName="exercise" method="post">
    Insert exercise name: <form:input path="exercise_name"/>
    <br>
    Select Group:
    <select name="groupName">
        <option value="Default">Default</option>
        <c:forEach items="${groupNames}" var="gName">
            <option value="${gName}">${gName}</option>
        </c:forEach>
    </select>

    <button type="submit">Add</button>
</form:form>

<h2><a href="/complex">Go to complex test page </a></h2>

</body>
</html>
