<%@ page import="gameoverflow.Question" %>
<g:applyLayout name="page">
    <head>
        <g:set var="entityName" value="${message(code: 'question.label', default: 'Question')}" />
        <title><g:message code="default.list.label" args="[entityName]" /></title>
        <g:javascript>
            $('#tabQuestionMenu a').click(function (e) {
                e.preventDefault()
                $(this).tab('show')
            })
        </g:javascript>
    </head>

    <content tag="gocontent">
        <div> ${questionListCount} <g:message code="question.label" args="[entityName]" /></div>
        <div id="list-question" class="pannel pannel-default" role="main">
            <div class="panel-heading"><g:message code="default.list.label" args="[entityName]" /></h1>
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
                    <table id="questions-table">
                        <g:each in="${listRecentQuestions}" var="currentQuestion">
                            <tr>
                                <g:render template="/question/questionShort" collection="${currentQuestion}" var="question" />
                            </tr>
                        </g:each>
                    </table>
                    <div class="pagination">
                        <g:paginate total="${questionListCount ?: 0}" />
                    </div>
                </div>
                <div class="tab-pane" id="popular">

                </div>
                <div class="tab-pane" id="unanswered">
                    <table>
                        <thead>
                        <tr>
                            <g:sortableColumn property="answers" title="${message(code: 'answers.label', default: 'answers')}" />

                            <g:sortableColumn property="views" title="${message(code: 'views.label', default: 'views')}" />

                            <g:sortableColumn property="title" title="${message(code: 'title.label', default: 'title')}" />

                            <g:sortableColumn property="score" title="${message(code: 'score.label', default: 'score')}" />

                            <g:sortableColumn property="date" title="${message(code: 'date.label', default: 'date')}" />

                        </tr>
                        </thead>
                        <tbody>
                        <g:each in="${listUnansweredQuestions}" status="i" var="currentQuestion">
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
            </div>
        </div>
    </content>
</g:applyLayout>

