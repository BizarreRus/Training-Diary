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

                    <%--<tr role="row">--%>
                        <%--<c:if test="${!empty trainingList}">--%>
                            <%--<c:forEach items="trainingList" var="training">--%>
                                <%--&lt;%&ndash;<td>${training.trainingDate}</td>&ndash;%&gt;--%>
                                <%--&lt;%&ndash;<td>${training.description}</td>&ndash;%&gt;--%>
                                <%--<td><a href="#deleteRowN" class="btn btn-xs btn-danger">Delete</a></td>--%>
                            <%--</c:forEach>--%>
                        <%--</c:if>--%>
                    <%--</tr>--%>
                    <c:if test="${empty trainingList}">
                        <td valign="top" colspan="3" class="text-center">No data available in table</td>
                    </c:if>

                    </tbody>
                </table>
                <%--<c:if test="${trainingList != null}">--%>
                <%--<div>Showing ${trainingList.size} entries</div>--%>
                <%--</c:if>--%>
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
                            <form:input cssClass="form-control" type="date" path="trainingDate"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <form:label cssClass="control-label col-sm-3" path="description">
                            <spring:message text="Description:"/>
                        </form:label>
                        <div class="col-sm-8">
                            <form:input cssClass="form-control" path="description" type="text"
                                        placeholder="Some comment"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <form:label cssClass="control-label col-sm-3" path="exercises">
                            <spring:message text="Add Exercises:"/>
                        </form:label>

                        <div class="tabs">
                            <ul class="nav nav-tabs">
                                <li class="active col-sm-4 text-center"><a href="#tab-1" data-toggle="tab">From Exercise
                                    List</a></li>
                                <li class="col-sm-4 text-center"><a href="#tab-2" data-toggle="tab">From Complex
                                    List</a></li>
                            </ul>
                            <div class="tab-content">
                                <div class="tab-pane fade in active" id="tab-1">
                                    <div class="col-sm-8 col-sm-offset-3">
                                        <br/>
                                        <form:select cssClass="form-control" multiple="multiple" path="exercises">
                                            <form:options items="${exerciseList}" itemValue="id"
                                                          itemLabel="exercise"/>
                                        </form:select>
                                    </div>
                                </div>

                                <div class="tab-pane fade" id="tab-2">
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
</body>
</html>