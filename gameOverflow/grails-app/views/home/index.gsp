<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main"/>
		<title><g:message code="general.welcome" default="Welcome to GameOverFlow" /></title>
	</head>
	<body>
		<div id="page-body" role="main">

            <div class="row">
                <div class="col-xs-2">
                    <g:link controller="question">
                        <button type="button" class="btn btn-primary btn-lg btn-block"><g:message code="questions.label" default="Questions" /></button>
                    </g:link>
                </div>
                <div class="col-xs-2">
                    <sec:ifLoggedIn>
                        <g:link controller="user" action="show" id="${idUser}">
                            <button type="button" class="btn btn-primary btn-lg btn-block"><g:message code="profil.label" default="Profil" /></button>
                        </g:link>
                    </sec:ifLoggedIn>
                </div>
                <div class="col-xs-2 col-md-offset-2">
                    <g:link controller="question" action="create">
                        <button type="button" class="btn btn-primary btn-lg btn-block"><g:message code="question.new" default="New question" /></button>
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
                    <div id="index-questions" class="panel panel-default">
                        <div id="index-questions-title" class="panel-heading">
                            <g:message code="questions.recent" default="Recent questions" />
                        </div>

                        <div id="index-questions-content">
                            <ul>
                                <g:each in="${listRecentQuestions}" var="currentQuestion">
                                    <li>
                                        <g:render template="/question/questionShort" collection="${currentQuestion}" var="question" />
                                    </li>
                                </g:each>
                            </ul>
                        </div>
                    </div>
                </div>
                <div class="col-xs-4">
                    <div id="index-highscore" class="panel panel-default">
                        <div id="index-highscore-title" class="panel-heading">
                            <g:message code="highscore.title" />
                        </div>

                        <div id="index-highscore-content" class="panel-body">
                            <ul>
                                <g:each in="${listTopUsers}" status="i" var="currentUser">
                                    <li>
                                        <span id="user-raw">
                                            <span>${i+1}.</span>
                                            <g:render template="/user/userRaw" collection="${currentUser}" var="user" />
                                        </span>
                                    </li>
                                </g:each>
                            </ul>
                         </div>
                    </div>
                </div>
            </div>

		</div>
	</body>
</html>
