<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="false" %>

<html lang="ru">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>Training Diary App</title>

    <link href="../../bootstrap-3.3.7-dist/css/app.css" rel="stylesheet" type="text/css">
    <!-- Bootstrap -->
    <link href="../../bootstrap-3.3.7-dist/css/bootstrap.css" rel="stylesheet" type="text/css">


    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<!--  navbar -->
<nav class="navbar navbar-default navbar-fixed-top">
    <div class="container">
        <a href="#Project" class="navbar-brand my-font">Training Diary App</a>
        <ul class="nav navbar-nav navbar-right">
            <li><a href="#profile">
                <span class="glyphicon glyphicon-user my-height"> Profile</span>
            </a></li>
            <li><a href="#logout">
                <span class="glyphicon glyphicon-log-out my-height"> Logout</span>
            </a></li>
        </ul>
    </div>
</nav>

<!--   content -->
<div class="jumbotron my-jumbotron">
    <div class="container">
        <div class="row content">
            <div class="col-sm-2 sidenav nav-side">
                <ul class="nav nav-pills nav-stacked pill-color">
                    <li><a href=/trainings>Trainings</a></li>
                    <li><a href="/complexes">Complexes</a></li>
                    <li><a href="/exercises">Exercises</a></li>
                    <li class="active"><a href="/muscleGroups">Muscle Groups</a></li>
                </ul>
            </div>

            <div class="col-sm-8">
                <h2 style="text-align: center;">Muscle Groups list</h2>
                <table class="table table-striped table-hover">
                    <thead>
                    <tr role="row">
                        <th style="width: 625px;">Muscle group</th>
                        <th style="width: 98px;">
                            <button type="button" class="btn btn-xs btn-primary" data-toggle="modal"
                                    data-target="#createGroup">
                                Create
                            </button>
                        </th>
                    </thead>
                    <tbody>
                    <c:if test="${!empty groupList}">
                        <c:forEach items="${groupList}" var="tempGroup">
                            <tr role="row">
                                <td>
                                    <a id="groupLink${tempGroup.id}"
                                       href="#editGroup"
                                       data-toggle="modal"
                                       data-name="${tempGroup.muscleGroup}"
                                       data-id="${tempGroup.id}"
                                       class="open-EditGroup href-color">${tempGroup.muscleGroup}
                                </td>
                                <td><a href="/deleteMuscleGroup${tempGroup.id}" class="btn btn-xs btn-danger">Delete</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </c:if>
                    <c:if test="${empty groupList}">
                        <td valign="top" colspan="3" class="text-center">No data available in table</td>
                    </c:if>

                    </tbody>
                </table>
                Showing <c:out value="${empty groupList ? 0 : fn:length(groupList)}"/> entries
            </div>
        </div>
    </div>
</div>


<!--  footer -->
<footer class="footer my-font">
    <div class="container">
        <p class="text-muted text-center">© 2016 Ruslan Borulchenko. All rights reserved.</p>
    </div>
</footer>

<!--   modal-form window 4 edit group -->
<div class="modal fade" id="editGroup">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button class="close" type="button" data-dismiss="modal">
                    &times;
                </button>
                <h3 style="text-align: center;" class="modal-title">Edit muscle group</h3>
            </div>
            <div class="modal-body">
                <form:form class="form-horizontal" action="/createMuscleGroup" method="POST" commandName="muscleGroup">
                    <form:hidden path="id" id="groupId"/>
                    <div class="form-group">
                        <form:label cssClass="control-label col-sm-3" path="muscleGroup">
                            <spring:message text="Muscle group:"/>
                        </form:label>
                        <div class="col-sm-8">
                            <form:input id="groupName" cssClass="form-control" type="text" path="muscleGroup"
                                        placeholder="Insert muscle group name"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <div class=" col-sm-12">
                            <button type="submit" class="btn btn-primary btn-block">
                                Edit
                            </button>
                        </div>
                    </div>
                </form:form>
            </div>
        </div>
    </div>
</div>


<!--   modal-form window 4 create group -->
<div class="modal fade" id="createGroup">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button class="close" type="button" data-dismiss="modal">
                    &times;
                </button>
                <h3 style="text-align: center;" class="modal-title">Create muscle group</h3>
            </div>
            <div class="modal-body">
                <form:form class="form-horizontal" action="/createMuscleGroup" method="POST" commandName="muscleGroup">
                    <div class="form-group">
                        <form:label cssClass="control-label col-sm-3" path="muscleGroup">
                            <spring:message text="Muscle group:"/>
                        </form:label>
                        <div class="col-sm-8">
                            <form:input cssClass="form-control" type="text" path="muscleGroup"
                                        placeholder="Insert muscle group name"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <div class=" col-sm-12">
                            <button type="submit" class="btn btn-primary btn-block">
                                Create
                            </button>
                        </div>
                    </div>
                </form:form>
            </div>
        </div>
    </div>
</div>


<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="../../bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<script src="../../bootstrap-3.3.7-dist/js/app.js"></script>
</body>
</html>