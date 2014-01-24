<%@ page import="gameoverflow.User" %>

<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'lastname', 'error')} required">
	<label for="lastname">
		<g:message code="user.lastname.label" default="Lastname" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="lastname" required="" value="${userInstance?.lastname}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'firstname', 'error')} required">
	<label for="firstname">
		<g:message code="user.firstname.label" default="Firstname" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="firstname" required="" value="${userInstance?.firstname}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'username', 'error')} required">
	<label for="username">
		<g:message code="user.username.label" default="Pseudo" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="username" maxlength="15" required="" value="${userInstance?.username}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'dateRegistration', 'error')} required">
	<label for="dateRegistration">
		<g:message code="user.dateRegistration.label" default="Date Inscription" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="dateRegistration" precision="day"  value="${userInstance?.dateRegistration}"  />
</div>

<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'score', 'error')} required">
	<label for="score">
		<g:message code="user.score.label" default="Score" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="score" type="number" value="${userInstance.score}" required=""/>
</div>

