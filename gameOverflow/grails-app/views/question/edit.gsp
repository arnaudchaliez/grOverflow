<%@ page import="gameoverflow.Question" %>

<g:applyLayout name="page">
    <head>
        <g:set var="entityName" value="${message(code: 'question.label', default: 'Question')}" />
        <r:require modules="bootstrapInput, typeahead"/>

        <title><g:message code="default.edit.label" args="[entityName]" /></title>
        <ckeditor:resources />
    </head>

    <content tag="gocontent">
        <div id="edit-question" class="content scaffold-edit" role="main">
            <h1><g:message code="default.edit.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
                <div class="message" role="status">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${question}">
                <ul class="errors" role="alert">
                <g:eachError bean="${question}" var="error">
                    <li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
                </g:eachError>
                </ul>
            </g:hasErrors>
            <g:form url="[resource:question, action:'update']" method="PUT" >
                <g:hiddenField name="version" value="${question?.version}" />
                <fieldset class="form">
                <g:render template="form"/>
                </fieldset>
                <fieldset class="buttons">
                <g:actionSubmit class="save" action="update" value="${message(code: 'default.button.update.label', default: 'Update')}" />
                </fieldset>
            </g:form>
        </div>
    </content>
</g:applyLayout>
