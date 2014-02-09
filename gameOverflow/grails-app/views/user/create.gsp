
<g:applyLayout name="page">
    <head>
        <title><g:message code="user.create.title" /></title>
    </head>

    <content tag="gocontent">
		<div id="create-user" class="content scaffold-create" role="main">
			<h1>
                <g:message code="user.create.title" />
            </h1>

            <g:if test="${flash.message}">
			    <div class="message" role="status">${flash.message}</div>
			</g:if>

			<g:hasErrors bean="${userInstance}">
                <ul class="errors" role="alert">
                    <g:eachError bean="${userInstance}" var="error">
                    <li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
                    </g:eachError>
                </ul>
			</g:hasErrors>

			<g:form class="form-horizontal col-md-6 col-md-offset-3" role="form" url="[resource:userInstance, action:'save']" >
					<g:render template="form"/>

                    <div class="row">
                        <div class="col-md-3">
                        </div>
                        <div class="col-md-9">
                            <g:submitButton name="create" class="btn btn-default btn-lg save" value="${message(code: 'default.button.create.label', default: 'Create')}" />
                        </div>
                    </div>
			</g:form>
		</div>
    </content>
</g:applyLayout>
