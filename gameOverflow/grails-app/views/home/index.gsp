<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main"/>
		<title>Welcome to GameOverFlow</title>
	</head>
	<body>
		<div id="page-body" role="main">

            <div class="row">
                <div class="col-xs-2">
                    <g:link controller="question">
                        <button type="button" class="btn btn-primary btn-lg btn-block">Questions</button>
                    </g:link>
                </div>
                <div class="col-xs-2">
                    <button type="button" class="btn btn-primary btn-lg btn-block">Profil</button>
                </div>
                <div class="col-xs-2 col-md-offset-2">
                    <g:link controller="question" action="create">
                        <button type="button" class="btn btn-primary btn-lg btn-block">New question</button>
                    </g:link>
                </div>
                <div class="col-xs-4">
                    <div class="pull-right" id="gameOverFlowLogo" role="banner">
                        <a href="/gameOverflow"><img src="${resource(dir: 'images', file: 'logo_gameoverflow.png')}" alt="GameOverFlow"/></a>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="col-xs-8">
                    <div class="panel panel-default">
                        <div class="panel-heading">Recent questions</div>

                        <ul class="list-group">
                            <g:each in="${listRecentQuestions}" var="currentQuestion">
                                <li class="list-group-item">
                                    <g:render template="/question/questionShort" collection="${currentQuestion}" />
                                </li>
                            </g:each>
                        </ul>
                    </div>
                </div>
                <div class="col-xs-4">
                    <div class="panel panel-default">
                        <div class="panel-heading">Available Controllers</div>

                        <ul class="list-group">
                            <g:each var="c" in="${grailsApplication.controllerClasses.sort { it.fullName } }">
                                <li class="list-group-item"><g:link controller="${c.logicalPropertyName}">${c.fullName}</g:link></li>
                            </g:each>
                        </ul>
                    </div>
                </div>
            </div>

		</div>
	</body>
</html>
