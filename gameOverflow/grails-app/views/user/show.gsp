
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
		<div id="show-user" class="content scaffold-show" role="main">
            <div id="show-user-title">
                <h1><g:message code="user.profil.title" args="[userInstance?.username]" /></h1>
            </div>
            <div class="boxed">

                <div id="show-user-content">
                    <div class="col-sm-3">
                        <avatar:gravatar email="${userInstance?.mail}" alt="My Avatar" cssClass="avatar" size="100" />
                    </div>
                    <div class="col-sm-9">
                        <ol class="property-list user">

                            <g:if test="${userInstance?.lastname}">
                                <li class="fieldcontain">
                                    <span id="lastname-label" class="property-label"><g:message code="user.lastname.label" default="Lastname" /></span>

                                    <span class="property-value" aria-labelledby="lastname-label"><g:fieldValue bean="${userInstance}" field="lastname"/></span>
                                </li>
                            </g:if>

                            <g:if test="${userInstance?.firstname}">
                                <li class="fieldcontain">
                                    <span id="firstname-label" class="property-label"><g:message code="user.firstname.label" default="Firstname" /></span>

                                    <span class="property-value" aria-labelledby="firstname-label"><g:fieldValue bean="${userInstance}" field="firstname"/></span>
                                </li>
                            </g:if>

                            <g:if test="${userInstance?.username}">
                                <li class="fieldcontain">
                                    <span id="username-label" class="property-label"><g:message code="user.username.label" default="username" /></span>

                                    <span class="property-value" aria-labelledby="username-label"><g:fieldValue bean="${userInstance}" field="username"/></span>
                                </li>
                            </g:if>

                            <g:if test="${userInstance?.dateRegistration}">
                                <li class="fieldcontain">
                                    <span id="dateRegistration-label" class="property-label"><g:message code="user.registerDate.label" default="Register date" /></span>

                                    <span class="property-value" aria-labelledby="dateRegistration-label"><g:formatDate date="${userInstance?.dateRegistration}" /></span>
                                </li>
                            </g:if>

                            <g:if test="${userInstance?.score}">
                                <li class="fieldcontain">
                                    <span id="score-label" class="property-label"><g:message code="score.label" default="Score" /></span>

                                    <span class="property-value" aria-labelledby="score-label"><g:fieldValue bean="${userInstance}" field="score"/></span>
                                </li>
                            </g:if>
                        </ol>

                    </div>

                </div>
            </div>



		</div>
	</body>
</html>
