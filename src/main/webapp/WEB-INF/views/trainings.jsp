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
        <a id="note" href="#Project" class="navbar-brand my-font">Training Diary App</a>
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
                    <li class="active"><a href=/trainings>Trainings</a></li>
                    <li><a href="/exercises">Exercises</a></li>
                    <li><a href="/complexes">Complexes</a></li>
                </ul>
            </div>

            <div class="col-sm-8">
                <h2 style="text-align: center;">Trainings list</h2>

                <div class="container">
                    <div class="row training-accordion-padding">
                        <div class="col-xs-4 col-md-3">
                            <h4>Date:</h4>
                        </div>
                        <div class="col-xs-6 col-md-7">
                            <h4>Description:</h4>
                        </div>
                        <div class="col-xs-2 training-create-btn-padding">
                            <button type="button" class="btn btn-xs btn-primary" data-toggle="modal"
                                    data-target="#modal-1">
                                Create
                            </button>
                        </div>
                    </div>
                </div>

                <div class="container">
                    <div class="panel-group" id="accordion">
                        <c:forEach items="${trainingList}" var="tempTraining">
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    <h4 class="panel-title">
                                        <div class="row">
                                            <div class="col-xs-4 col-md-3">
                                                <a class="href-color" data-toggle="collapse" data-parent="#accordion"
                                                   href="#collapse${tempTraining.id}">${tempTraining.trainingDate}</a>
                                            </div>
                                            <div class="col-xs-6 col-md-7">
                                                <a class="href-color" data-toggle="collapse" data-parent="#accordion"
                                                   href="#collapse${tempTraining.id}">${tempTraining.description}</a>
                                            </div>
                                            <div class="col-xs-2">
                                                <a class="btn btn-xs btn-danger"
                                                   href="/deleteTraining${tempTraining.id}">Delete</a>
                                            </div>
                                        </div>
                                    </h4>
                                </div>
                                <div id="collapse${tempTraining.id}" class="panel-collapse collapse">
                                    <div class="panel-body">
                                        <div class="row">
                                            <c:forEach items="${tempTraining.exercises}" var="tempExercise">
                                                <div class="col-xs-6 col-sm-4 col-md-3">
                                                    <div class="thumbnail">
                                                        <table class="table table-striped table-hover table-condensed">
                                                            <thead>
                                                            <tr role="row">
                                                                <td style="font-weight: 500">${tempExercise.exercise}</td>
                                                            </tr>
                                                            </thead>
                                                            <tbody>
                                                            <tr role="row">
                                                                <td class="activity-size">Reps:</td>

                                                                <c:if test="${!empty activityList && !empty tempTraining.activities
                                                                && !empty tempExercise.activities}">
                                                                    <c:forEach items="${activityList}" var="activity">
                                                                        <c:if test="${activity.exercise.id == tempExercise.id
                                                                        && activity.training.id == tempTraining.id}">
                                                                            <td class="activity-size">${activity.reps}</td>
                                                                        </c:if>
                                                                    </c:forEach>
                                                                </c:if>
                                                            </tr>

                                                            <tr role="row">
                                                                <td class="activity-size">Weight:</td>

                                                                <c:if test="${!empty activityList && !empty tempTraining.activities
                                                                && !empty tempExercise.activities}">
                                                                    <c:forEach items="${activityList}" var="activity">
                                                                        <c:if test="${activity.exercise.id == tempExercise.id
                                                                        && activity.training.id == tempTraining.id}">
                                                                            <td class="activity-size">${activity.weight}</td>
                                                                        </c:if>
                                                                    </c:forEach>
                                                                </c:if>
                                                            </tr>
                                                            <tr role="row">
                                                                <td><a href="#addActivity" data-toggle="modal"
                                                                       data-id="${tempTraining.id}"
                                                                       class="center-block btn btn-xs btn-primary open-AddActivity"
                                                                >Add activity</a></td>
                                                            </tr>
                                                            </tbody>
                                                        </table>
                                                    </div>
                                                </div>
                                            </c:forEach>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                </div>

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

<!--   modal-form window 4 create trainings -->
<div class="modal fade" id="modal-1">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button class="close" type="button" data-dismiss="modal">
                    &times;
                </button>
                <h3 style="text-align: center;" class="modal-title">Create training</h3>

            </div>
            <div class="modal-body">
                <form:form class="form-horizontal" action="/createTraining" method="POST" commandName="training">
                    <div class="form-group">
                        <form:label cssClass="control-label col-sm-3" path="trainingDate">
                            <spring:message text="Date:"/>
                        </form:label>
                        <div class="col-sm-8">
                            <input type="date" class="form-control" name="trainingDay">
                        </div>
                    </div>

                    <div class="form-group">
                        <form:label cssClass="control-label col-sm-3" path="description">
                            <spring:message text="Description:"/>
                        </form:label>
                        <div class="col-sm-8">
                            <form:input cssClass="form-control" path="description" type="text"
                                        placeholder="Add comment"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <form:label cssClass="control-label col-sm-3" path="exercises">
                            <spring:message text="Add exercises:"/>
                        </form:label>

                        <div class="tabs">
                            <ul class="nav nav-tabs">
                                <li class="active col-sm-4 text-center"><a href="#tab-1" data-toggle="tab">From Complex
                                    List</a></li>
                                <li class="col-sm-4 text-center"><a href="#tab-2" data-toggle="tab">From Exercise
                                    List</a></li>
                            </ul>
                            <div class="tab-content">
                                <div class="tab-pane fade in active" id="tab-1">
                                    <div class="col-sm-8 col-sm-offset-3">
                                        <br/>
                                        <select class="form-control" name="complexId">
                                            <option value="0">Choose here</option>
                                            <c:forEach items="${complexList}" var="complex">
                                                <option value="${complex.id}">${complex.complex}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </div>

                                <div class="tab-pane fade" id="tab-2">
                                    <div class="col-sm-8 col-sm-offset-3">
                                        <br/>
                                        <select class="form-control" name="exercisesId" multiple="multiple">
                                            <c:forEach items="${exerciseList}" var="exercise">
                                                <option value="${exercise.id}">${exercise.exercise}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="form-group">
                        <div class=" col-sm-12">
                            <button type="submit" class="btn btn-primary btn-block">Create</button>
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