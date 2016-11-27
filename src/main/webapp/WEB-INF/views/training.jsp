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

<form:form action="/addTraining">
    <input type="date" name="trainingDay">
    <button type="submit">create training</button>
</form:form>

</body>
</html>
