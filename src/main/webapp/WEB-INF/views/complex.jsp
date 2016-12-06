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
        <h3>Complex ${comp.complex}  <a href="/deleteComplex/${comp.id}"> delete</a> <a href="/editComplex/${comp.id}">Edit </a> </h3>
        <c:if test="${!empty comp.exercises}">
            Have following exercises:<br>
            <c:forEach items="${comp.exercises}" var="exer">
                ${exer.exercise}<br>
            </c:forEach>
        </c:if>
        <%-- add href's for browse for each complex info --%>
    </c:forEach>
</c:if>

<br><br><br><br>
Add new Complex:
<form:form action="/addComplex" commandName="complex" method="post">
    Insert complex name: <form:input path="complex"/>
    <br>
    Select Exercises:
    <select name="exercisesID" multiple="multiple">
        <c:forEach items="${exercises}" var="exer">
            <option value="${exer.id}">${exer.exercise}</option>
        </c:forEach>
    </select>

    <button type="submit">add complex</button>
</form:form>


<%--<form:form action="/createComplex" method="post" commandName="complex">--%>
    <%--Insert complex name: <form:input path="complex"/>--%>
    <%--<br>--%>
    <%--<form:select multiple="true" path="exercises">--%>
        <%--<form:options items="${exercises}" itemValue="id" itemLabel="exercise" />--%>
    <%--</form:select>--%>
    <%--<button type="submit">Create complex</button>--%>
<%--</form:form>--%>
</body>
</html>
