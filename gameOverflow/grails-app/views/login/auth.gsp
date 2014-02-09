<g:applyLayout name="page">
    <head>
        <title><g:message code="login.label"/></title>
    </head>

    <content tag="gocontent">
        <h1>
            <g:message code="login.label"/>
        </h1>

        <g:if test='${flash.message}'>
            <div class="row">
                <div class="col-md-2">
                </div>
                <div class="col-md-10 text-warning">
                    ${flash.message}
                </div>
            </div>
        </g:if>

        <form action='${postUrl}' method='POST' id='loginForm' class='form-horizontal col-md-4 col-md-offset-4' autocomplete='off'>
            <div class="form-group">
                <g:set var="username_label" value="${message(code: 'user.username.label', default: 'Username')}" />
                <g:textField class="form-control" name="j_username" id="username" placeholder="${username_label}" />
            </div>
            <div class="form-group">
                <g:set var="password_label" value="${message(code: 'user.password.label', default: 'Password')}" />
                <g:passwordField type="password" class="form-control" name="j_password" id="password" placeholder="${password_label}" />
            </div>
            <div class="row">
                <label class="control-label" for='remember_me'><g:message code="login.remember.me.label"/></label>
                <input type='checkbox' name='${rememberMeParameter}' id='remember_me' <g:if test='${hasCookie}'>checked='checked'</g:if>/>
            </div>
            <div class="row">
                <g:submitButton name="create" class="btn btn-default btn-lg save" value="${message(code: 'login.connection.label', default: 'Connection')}" />
            </div>
        </form>
    </content>
</g:applyLayout>