<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                <span class="glyphicon glyphicon-user"> Profile</span>
            </a></li>
            <li><a href="#logout">
                <span class="glyphicon glyphicon-log-out"> Logout</span>
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
                    <li class="active"><a href=#training>Trainings</a></li>
                    <li><a href="#exercise">Exercises</a></li>
                    <li><a href="#complex">Complexes</a></li>
                </ul>
            </div>

            <div class="col-sm-8">
                <h2 style="text-align: center;">Trainings list</h2>
                <table class="table table-striped table-hover">
                    <thead>
                    <tr role="row">
                        <th style="width: 175px;">Date</th>
                        <th style="width: 450px;">Description</th>
                        <th style="width: 98px;">
                            <button type="button" class="btn btn-xs btn-primary" data-toggle="modal"
                                    data-target="#modal-1">
                                Create
                            </button>
                        </th>
                    </thead>
                    <tbody>

                    <c:if test="${!empty trainingList}">
                        <c:forEach items="trainingList" var="training">
                            <tr role="row">
                                <td>${training.trainingDate}</td>
                                <td>${training.description}</td>
                                <td><a href="#deleteRowN" class="btn btn-xs btn-danger">Delete</a></td>
                            </tr>
                        </c:forEach>
                    </c:if>
                    <c:if test="${empty trainingList}">
                    </c:if>
                    <td valign="top" colspan="3" class="text-center">No data available in table</td>
                    </tbody>
                </table>
                <c:if test="${!empty trainingList}">
                    <div>Showing ${trainingList.size} entries</div>
                </c:if>
            </div>
        </div>
    </div>
</div>


<!--  footer -->
<footer class="footer my-font">
    <div class="container">
        <p class="text-muted text-center">© 2016  Ruslan Borulchenko. All rights reserved.</p>
    </div>
</footer>

<!--   modal window -->
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
                <!--                  SHOULD FININSH IT, WHEN ADD THIS PIACE TO PROJECT! -->


                <form class="form-horizontal" action="#createTraining">
                    <div class="form-group">
                        <label class="control-label col-sm-2" for="date">Date:</label>
                        <div class="col-sm-10">
                            <input type="date" class="form-control" id="date">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-2" for="desc">Description:</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="desc" placeholder="Some comment">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-offset-2 col-sm-10">
                            <button type="submit" class="btn btn-primary btn-block">Create</button>
                        </div>
                    </div>
                </form>

            </div>
        </div>
    </div>
</div>


<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="../../bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</body>
</html>