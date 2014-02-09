
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
                        <div class="row">
                            <div class="col-xs-3"><g:message code="user.country.label" /></div>
                            <div class="col-xs-7"><g:fieldValue bean="${userInstance}" field="country"/></div>
                        </div>
                        <div class="row">
                            <div class="col-xs-3"><g:message code="user.city.label" /></div>
                            <div class="col-xs-7"><g:fieldValue bean="${userInstance}" field="city"/></div>
                        </div>
                        <div class="row">
                            <div class="col-xs-3"><g:message code="user.dateRegistration.label" /></div>
                            <div class="col-xs-7"><g:formatDate date="${userInstance?.dateRegistration}" /></div>
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
                        <ol>
                            <g:each in="${listQuestions}" status="i" var="currentQuestion">
                                <ul>
                                    <g:render template="/question/questionShort" collection="${currentQuestion}" />
                                </ul>
                            </g:each>
                        </ol>
                    </div>
                    <div class="tab-pane" id="answers">
                        <ol>
                            <g:each in="${listAnswers}" status="i" var="currentAnswer">
                                <ul>
                                    ${currentAnswer}
                                </ul>
                            </g:each>
                        </ol>
                    </div>
                    <div class="tab-pane" id="tags">
                        <ol>
                            <g:each in="${listTags}" status="i" var="currentTag">
                                <ul>
                                    ${currentTag}
                                </ul>
                            </g:each>
                        </ol>
                    </div>
                    <div class="tab-pane" id="badges">
                        <ol>
                            <g:each in="${listBadges}" status="i" var="currentBadge">
                                <ul>
                                    ${currentBadge}
                                </ul>
                            </g:each>
                        </ol>
                    </div>
                </div>
            </div>

        </div>
    </content>
</g:applyLayout>