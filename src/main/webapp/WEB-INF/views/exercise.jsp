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
    Exercise name: ${currExec.exercise}
    Muscle group: ${currExec.muscleGroup}  <a href="/removeExerciseById/${currExec.id}">delete</a>.
    <a href="/editExercise/${currExec.id}">edit</a><br>
</c:forEach>
<br>
<br>
Add new Exercise:
<form:form action="/createExercise" commandName="exercise" method="post">
    Insert exercise name: <form:input path="exercise"/>
    <br>
    Select Group:
    <form:select path="muscleGroup">
            <form:options items="${groupList}" itemValue="id" itemLabel="muscleGroup"/>
    </form:select>
    <br/>
    <br/>*
    <br/>

    <button type="submit">Add</button>
</form:form>

<h2><a href="/complex">Go to complex test page </a></h2>

</body>
</html>
