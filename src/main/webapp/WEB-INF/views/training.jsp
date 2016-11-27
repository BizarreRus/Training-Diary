<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="false" %>

<html>
<head>
    <title>training</title>
</head>
<body>
Your's training list:<br>
<c:if test="${!empty trainingList}">
    <c:forEach items="${trainingList}" var="training">
        ID: ${training.id}.  DATE: ${training.trainingDate}  <a href="/deleteTraining/${training.id}">delete</a>
        <a href="/editTraining/${training.id}">edit</a> <br>
        <c:if test="${!empty training.exercises}">
            EXERCISES LIST:<br>
            <c:forEach items="${training.exercises}" var="exer">
                ${exer.exercise}      <a href="/activity/trainingID/${training.id}/exerciseID/${exer.id}">add activity</a>
                <c:if test="${!empty exer.activities}">
                    reps/weight:
                    <c:forEach items="${exer.activities}" var="activity">
                        ${activity.reps}/${activity.weight}.
                    </c:forEach>
                </c:if>
                <br>
            </c:forEach>
        </c:if><br>
    </c:forEach>
</c:if>

<form:form action="/addTraining" method="post">
    Insert training date:
    <input type="date" name="trainingDay">
    <br>
    <br>
    Select from list:
    <select name="exercisesID" multiple="multiple">
        <c:forEach items="${exercises}" var="exer">
            <option value="${exer.id}">${exer.exercise}</option>
        </c:forEach>
    </select>
    <br>
    <br>
    Or select from complex:
    <select name="complexID">
        <option value="0">Choose here</option>
        <c:forEach items="${complexList}" var="comp">
            <option value="${comp.id}">${comp.complex}</option>
        </c:forEach>
    </select>

    <button type="submit">create training</button>
</form:form>


</body>
</html>
