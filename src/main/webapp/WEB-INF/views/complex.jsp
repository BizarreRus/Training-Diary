<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>complexes</title>
</head>
<body>
<h1>List of Yours Complexes: </h1>
<c:if test="${empty complexList}">
    <h3>You don't have any complexes yet</h3>
</c:if>
<c:if test="${!empty complexList}">
    <c:forEach items="${complexList}" var="comp">
        <h3>Complex ${comp.complex_name} have following exercises:</h3>
        <c:forEach items="${comp.exercises}" var="compExer">
            ${compExer.exercise_name} <br>
        </c:forEach>
        <%-- add href's for browse for each complex info --%>
    </c:forEach>
</c:if>

<%-- add on the bottom "create complex" button. Donno yet how to add it at right location. better, if realize it with jQuery --%>
<br><br><br><br>
Add new Complex:
<form:form action="/addComplex" commandName="complex" method="post">
    Insert complex name: <form:input path="complex_name"/>
    <br>
    Select Exercises:
    <select name="exercisesID" multiple="multiple">
        <c:forEach items="${exercises}" var="exer">
            <option value="${exer.id}">${exer.exercise_name}</option>
        </c:forEach>
    </select>

    <button type="submit">Create complex</button>
</form:form>

</body>
</html>
