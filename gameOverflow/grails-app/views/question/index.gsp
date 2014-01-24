<%@ page import="gameoverflow.Question" %>

<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'question.title', default: 'Question')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
        <g:javascript>
            $('#tabQuestionMenu a').click(function (e) {
                e.preventDefault()
                $(this).tab('show')
            })
        </g:javascript>

    </head>
	<body>
        <div> ${questionListCount} Questions </div>
		<div id="list-question" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>

            <!-- Nav tabs -->
            <ul class="nav nav-tabs" id="tabQuestionMenu">
                <li class="active">
                    <a href="#recent" data-toggle="tab">Recent</a>
                </li>
                <li>
                    <a href="#popular" data-toggle="tab">Popular</a>
                </li>
                <li>
                    <a href="#unanswered" data-toggle="tab">Unanswered</a>
                </li>
            </ul>

            <!-- Tab panes -->
            <div class="tab-content">
                <div class="tab-pane active" id="recent">
                    <table>
                        <thead>
                        <tr>
                            <g:sortableColumn property="answers" title="${message(code: 'question.answers.label', default: 'answers')}" />

                            <g:sortableColumn property="views" title="${message(code: 'question.views.label', default: 'views')}" />

                            <g:sortableColumn property="title" title="${message(code: 'question.title.label', default: 'title')}" />

                            <g:sortableColumn property="score" title="${message(code: 'question.score.label', default: 'score')}" />

                            <g:sortableColumn property="date" title="${message(code: 'question.date.label', default: 'date')}" />

                        </tr>
                        </thead>
                        <tbody>
                        <g:each in="${listRecentQuestions}" status="i" var="currentQuestion">
                            <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
                                <g:render template="questionShort" collection="${currentQuestion}" />
                            </tr>
                        </g:each>
                        </tbody>
                    </table>
                    <div class="pagination">
                        <g:paginate total="${questionListCount ?: 0}" />
                    </div>
                </div>
                <div class="tab-pane" id="popular">

                </div>
                <div class="tab-pane" id="messages">

                </div>
            </div>

		</div>
	</body>
</html>


