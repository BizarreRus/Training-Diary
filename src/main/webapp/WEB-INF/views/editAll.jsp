<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>edit</title>
</head>
<body>
<c:if test="${!empty group}">
    <form:form action="/edit" commandName="group">
        <form:hidden path="id"/>

        <form:label path="muscleGroup">
            <spring:message text="Edit group name"/>
        </form:label>
        <form:input path="muscleGroup"/>
        <input type="submit" value="Edit group">
    </form:form>
</c:if>

<c:if test="${!empty exercise}">
    <form:form action="/editExercise" commandName="exercise">
        <form:hidden path="id"/>

        <form:label path="exercise">
            <spring:message text="Edit exercise name"/>
        </form:label>
        <form:input path="exercise"/>
        <input type="submit" value="Edit exercise">
    </form:form>
</c:if>

<c:if test="${!empty complex}">
    <form:form action="/editComplex" commandName="complex">
        <form:hidden path="id"/>

        <form:label path="complex">
            <spring:message text="Edit complex name"/>
        </form:label>
        <form:input path="complex"/>
        <input type="submit" value="Edit complex">
    </form:form>
</c:if>
</body>
</html>
