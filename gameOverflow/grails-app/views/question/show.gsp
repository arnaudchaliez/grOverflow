<%@ page import="gameoverflow.Question" %>
<%@ page import="gameoverflow.Answer" %>

<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'question.label', default: 'Question')}" />

        <title>${question?.title}</title>

        <r:require modules="bootstrapInput"/>
        <ckeditor:resources />
	</head>
	<body>
        <g:if test="${flash.message}">
            <div class="message" role="status">${flash.message}</div>
        </g:if>
		<div id="show-question" role="main">
            <div class="boxed">
                <div id="show-question-title">
                    <div class="shadow"></div>
                    <div class="ribbon">
                        <span>${question?.title}</span>
                    </div>
                </div>
                <div id="show-question-tags">
                    <div>
                        <g:each in="${tags}" status="i" var="currentTag">
                            <span class="tag label label-info">${currentTag.name}</span>
                        </g:each>
                    </div>
                </div>
                <div id="show-question-content">
                        <div class="col-sm-9 well">
                            <!-- TODO SECURITY !! , sanitizer ?  -->
                            ${raw(question?.content)}
                        </div>

                        <div class="col-sm-3">
                            <g:render template="/user/userThumbnail" collection="${question?.author}" />
                        </div>

                        <g:form url="[resource:question, action:'delete']" method="DELETE">
                            <fieldset class="buttons">
                                <g:link class="edit" action="edit" resource="${question}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
                                <g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
                            </fieldset>
                        </g:form>
                        <span class="show-question-up glyphicon glyphicon-arrow-up"></span>
                        <span id="show-question-score">
                            ${question?.score}
                        </span>
                        <span class="show-question-down glyphicon glyphicon-arrow-down"></span>

                </div>
            </div>

            <div id="show-question-answers">
                <div class="clearfix">
                    <div class="title">
                        <strong>${question?.answers?.size()}</strong> <g:message code="answers.label" />
                    </div>
                </div>
                <div id="answers-list">
                        <ol>
                            <g:each in="${answers}" status="i" var="currentAnswer">
                                <g:render template="/answer/answerBloc" collection="${currentAnswer}" />
                            </g:each>
                        </ol>
                </div>
                <div>
                    <div><g:message code="answer.label" /> :</div>
                    <g:form url="[resource: answer, controller:'answer', action:'save']" >
                        <fieldset class="form">
                            <g:render template="/answer/form" />
                        </fieldset>
                        <fieldset class="buttons">
                            <g:submitButton name="create"  class="save" value="${message(code: 'default.button.create.label', default: 'Create')}" />
                        </fieldset>

                        <g:hiddenField name="questionId" value="${question.id}" />
                    </g:form>

                </div>

            </div>
		</div>
	</body>
</html>

