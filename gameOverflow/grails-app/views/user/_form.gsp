<%@ page import="gameoverflow.User" %>

<div class="form-group fieldcontain ${hasErrors(bean: userInstance, field: 'username', 'error')} required">
    <label for="username" class="col-md-3 control-label">
        <g:message code="user.username.label" />
        <span class="required-indicator">*</span>
    </label>
    <div class="col-md-9">
        <g:textField class="form-control" name="username" maxlength="15" required="" value="${userInstance?.username}"/>
    </div>
</div>

<div class="form-group fieldcontain ${hasErrors(bean: userInstance, field: 'lastname', 'error')} required">
	<label for="lastname" class="col-md-3 control-label">
		<g:message code="user.lastname.label" />
		<span class="required-indicator">*</span>
	</label>
    <div class="col-md-9">
        <g:textField class="form-control" name="lastname" required="" value="${userInstance?.lastname}"/>
    </div>
</div>

<div class="form-group fieldcontain ${hasErrors(bean: userInstance, field: 'firstname', 'error')} required">
	<label for="firstname" class="col-md-3 control-label">
		<g:message code="user.firstname.label" />
		<span class="required-indicator">*</span>
	</label>
    <div class="col-md-9">
	    <g:textField class="form-control" name="firstname" required="" value="${userInstance?.firstname}"/>
    </div>
</div>

<div class="form-group fieldcontain ${hasErrors(bean: userInstance, field: 'password', 'error')} required">
    <label for="password" class="col-md-3 control-label">
        <g:message code="user.password.label" />
        <span class="required-indicator">*</span>
    </label>
    <div class="col-md-9">
        <g:passwordField  class="form-control" name="password" required="" value="${userInstance?.password}"/>
    </div>
</div>

<div class="form-group fieldcontain ${hasErrors(bean: userInstance, field: 'mail', 'error')} required">
    <label for="mail" class="col-md-3 control-label">
        <g:message code="user.mail.label" />
        <span class="required-indicator">*</span>
    </label>
    <div class="col-md-9">
        <g:textField class="form-control" name="mail" required="" value="${userInstance?.mail}"/>
    </div>
</div>

<div class="form-group fieldcontain ${hasErrors(bean: userInstance, field: 'birthday', 'error')} required">
	<label for="birthday" class="col-md-3 control-label">
		<g:message code="user.birthday.label" />
		<span class="required-indicator">*</span>
	</label>
    <div class="col-md-9">
	    <g:datePicker name="birthday" precision="day"  value="${userInstance?.birthday}"  />
    </div>
</div>

<div class="form-group fieldcontain ${hasErrors(bean: userInstance, field: 'bio', 'error')}">
    <label for="bio" class="col-md-3 control-label">
        <g:message code="user.bio.label" />
    </label>
    <div class="col-md-9">
        <g:textArea class="form-control" name="bio" value="${userInstance?.bio}" />
    </div>
</div>

<div class="form-group fieldcontain ${hasErrors(bean: userInstance, field: 'country', 'error')}">
    <label for="country" class="col-md-3 control-label">
        <g:message code="user.country.label" />
    </label>
    <div class="col-md-9">
        <g:textField class="form-control" name="country"  value="${userInstance?.country}"/>
    </div>
</div>

<div class="form-group fieldcontain ${hasErrors(bean: userInstance, field: 'city', 'error')} ">
    <label for="bio" class="col-md-3 control-label">
        <g:message code="user.city.label" />
    </label>
    <div class="col-md-9">
        <g:textField class="form-control" name="city" value="${userInstance?.city}"/>
    </div>
</div>

<div class="form-group fieldcontain ${hasErrors(bean: userInstance, field: 'website', 'error')} ">
    <label for="website" class="col-md-3 control-label">
        <g:message code="user.website.label" />
    </label>
    <div class="col-md-9">
        <g:textField class="form-control" name="website" value="${userInstance?.website}"/>
    </div>
</div>
