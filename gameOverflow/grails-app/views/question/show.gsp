<%@ page import="gameoverflow.Question" %>
<%@ page import="gameoverflow.Answer" %>

<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'question.label', default: 'Question')}" />
		<title>${question?.title}</title>
	</head>
	<body>
		<div id="show-question" role="main">
			<h1>${question?.title}</h1>
			<g:if test="${flash.message}">
			    <div class="message" role="status">${flash.message}</div>
			</g:if>

            <div id="show-question-content row">
                <div class="col-xs-8">
                    <div class="well">
                        <!-- TODO SECURITY !! , sanitizer ?  -->
                        ${raw(question?.content)}
                    </div>
                    <g:form url="[resource:question, action:'delete']" method="DELETE">
                        <fieldset class="buttons">
                            <g:link class="edit" action="edit" resource="${question}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
                            <g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
                        </fieldset>
                    </g:form>
                </div>
                <div class="col-xs-4">
                    <span class="show-question-up glyphicon glyphicon-arrow-up"></span>
                    <span id="show-question-score">
                        ${question?.score}
                    </span>
                    <span class="show-question-down glyphicon glyphicon-arrow-down"></span>
                    <g:render template="../user/userThumbnail" collection="${question.author}" />
                </div>
            </div>

		</div>
	</body>
</html>
