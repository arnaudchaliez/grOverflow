
<%@ page import="gameoverflow.User" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<title><g:message code="user.profil.title" args="[userInstance?.username]" /></title>
	</head>
	<body>
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

                <div id="show-user-content">
                    <div class="col-sm-3">
                        <avatar:gravatar email="${userInstance?.mail}" alt="My Avatar" cssClass="avatar" size="100" />
                    </div>
                    <div class="col-sm-9">
                        <ol class="property-list user">

                            <li class="fieldcontain">
                                <span class="property-label"><g:message code="lastname.label" /></span>

                                <span class="property-value" aria-labelledby="lastname-label"><g:fieldValue bean="${userInstance}" field="lastname"/></span>
                            </li>

                            <li class="fieldcontain">
                                <span class="property-label"><g:message code="firstname.label" /></span>

                                <span class="property-value" aria-labelledby="firstname-label"><g:fieldValue bean="${userInstance}" field="firstname"/></span>
                            </li>

                            <g:if test="${userInstance?.country}">
                                <li class="fieldcontain">
                                    <span class="property-label"><g:message code="country.label" /></span>

                                    <span class="property-value" aria-labelledby="country-label"><g:fieldValue bean="${userInstance}" field="country"/></span>
                                </li>
                            </g:if>

                            <g:if test="${userInstance?.city}">
                                <li class="fieldcontain">
                                    <span class="property-label"><g:message code="city.label" /></span>

                                    <span class="property-value" aria-labelledby="city-label"><g:fieldValue bean="${userInstance}" field="city"/></span>
                                </li>
                            </g:if>

                            <li class="fieldcontain">
                                <span class="property-label"><g:message code="dateRegistration.label" default="Register date" /></span>

                                <span class="property-value" aria-labelledby="dateRegistration-label"><g:formatDate date="${userInstance?.dateRegistration}" /></span>
                            </li>

                            <li class="fieldcontain">
                                <span class="property-label"><g:message code="score.label" default="Score" /></span>

                                <span class="property-value" aria-labelledby="score-label"><g:fieldValue bean="${userInstance}" field="score"/></span>
                            </li>
                        </ol>

                    </div>
                   &nbsp;
                </div>
            </div>

            <!-- Nav tabs -->
            <ul class="nav nav-tabs" id="tabQuestionMenu">
                <li class="active">
                    <a href="#questions" data-toggle="tab"><g:message code="questions.label" /> </a>
                </li>
                <li>
                    <a href="#answers" data-toggle="tab"><g:message code="answers.label" /></a>
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
	</body>
</html>
