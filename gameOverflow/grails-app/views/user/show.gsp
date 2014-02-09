
<g:applyLayout name="page">
    <head>
        <title><g:message code="user.profil.title" args="[userInstance?.username]" /></title>
    </head>

    <content tag="gocontent">
        <g:if test="${flash.message}">
            <div class="message" role="status">${flash.message}</div>
        </g:if>
        <div id="show-user" role="main">
            <div class="boxed">
                <div id="show-user-title">
                    <div class="shadow"></div>
                    <div class="ribbon">
                        <span>${userInstance?.username}</span>
                    </div>
                </div>

                <div id="show-user-content" class="clearfix">
                    <div class="col-sm-2">
                        <avatar:gravatar email="${userInstance?.mail}" alt="My Avatar" cssClass="avatar" size="100" />
                    </div>
                    <div class="col-sm-9">
                        <div class="row">
                            <div class="col-xs-3"><g:message code="user.lastname.label" /></div>
                            <div class="col-xs-7"><g:fieldValue bean="${userInstance}" field="lastname"/></div>
                        </div>
                        <div class="row">
                            <div class="col-xs-3"><g:message code="user.firstname.label" /></div>
                            <div class="col-xs-7"><g:fieldValue bean="${userInstance}" field="firstname"/></div>
                        </div>
                        <g:if test="${userInstance?.country} != null">
                            <div class="row">
                                <div class="col-xs-3"><g:message code="user.country.label" /></div>
                                <div class="col-xs-7"><g:fieldValue bean="${userInstance}" field="country"/></div>
                            </div>
                        </g:if>
                        <g:if test="${userInstance?.city} != null">
                            <div class="row">
                                <div class="col-xs-3"><g:message code="user.city.label" /></div>
                                <div class="col-xs-7"><g:fieldValue bean="${userInstance}" field="city"/></div>
                            </div>
                        </g:if>
                        <g:if test="${userInstance?.bio} != null">
                            <div class="row">
                                <div class="col-xs-3"><g:message code="user.bio.label" /></div>
                                <div class="col-xs-7"><g:fieldValue bean="${userInstance}" field="bio"/></div>
                            </div>
                        </g:if>
                        <div class="row">
                            <div class="col-xs-3"><g:message code="user.dateRegistration.label" /></div>
                            <div class="col-xs-7"><g:formatDate date="${userInstance?.dateRegistration}" type="datetime" style="MEDIUM" /></div>
                        </div>
                    </div>
                </div>
            </div>

            <div id="index-questions">
                <!-- Nav tabs -->
                <ul class="nav nav-tabs" id="tabQuestionMenu">
                    <li class="active">
                        <a href="#questions" data-toggle="tab"><g:message code="questions.label" /> </a>
                    </li>
                    <li>
                        <a href="#answers" data-toggle="tab"><g:message code="answers.label" /></a>
                    </li>
                    <li>
                        <a href="#tags" data-toggle="tab"><g:message code="tags.label" /></a>
                    </li>
                    <li>
                        <a href="#badges" data-toggle="tab"><g:message code="badges.label" /></a>
                    </li>
                </ul>

                <!-- Tab panes -->
                <div class="tab-content">
                    <div class="tab-pane active" id="questions">
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
                                <g:each in="${listQuestions}" var="currentQuestion">
                                    <tr>
                                        <g:render template="/question/questionShort" collection="${currentQuestion}" var="question" />
                                    </tr>
                                </g:each>
                            </tbody>
                        </table>
                    </div>
                    <div class="tab-pane" id="answers">
                        <table>
                            <thead>
                                <tr>
                                    <g:sortableColumn property="title" title="${message(code: 'question.label', default: 'question')}" />

                                    <g:sortableColumn property="score" title="${message(code: 'score.label', default: 'score')}" />
                                </tr>
                            </thead>
                            <tbody>
                            <g:each in="${listAnswers}" var="currentAnswer">
                                    <tr>
                                        <g:render template="/answer/answerShort" collection="${currentAnswer}" var="answer" />
                                    </tr>
                                </g:each>
                            </tbody>
                        </table>
                    </div>
                    <div class="tab-pane" id="tags">
                        <ol>
                            <g:each in="${listTags}" status="i" var="currentTag">
                                <li>
                                    <g:render template="/tag/tag" collection="${currentTag}" var="tag" />
                                </li>
                            </g:each>
                        </ol>
                    </div>
                    <div class="tab-pane" id="badges">
                        <ol>
                            <g:each in="${listBadges}" status="i" var="currentBadge">
                                <li>
                                    <g:render template="/badge/badgeProfil" collection="${currentBadge}" var="badge" />
                                </li>
                            </g:each>
                        </ol>
                    </div>
                </div>
            </div>

        </div>
    </content>
</g:applyLayout>