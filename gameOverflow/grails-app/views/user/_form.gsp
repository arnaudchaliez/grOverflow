<%@ page import="gameoverflow.User" %>

<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'username', 'error')} required">
    <label for="username">
        <g:message code="username.label" />
        <span class="required-indicator">*</span>
    </label>
    <g:textField name="username" maxlength="15" required="" value="${userInstance?.username}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'lastname', 'error')} required">
	<label for="lastname">
		<g:message code="lastname.label" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="lastname" required="" value="${userInstance?.lastname}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'firstname', 'error')} required">
	<label for="firstname">
		<g:message code="firstname.label" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="firstname" required="" value="${userInstance?.firstname}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'mail', 'error')} required">
    <label for="mail">
        <g:message code="mail.label" />
        <span class="required-indicator">*</span>
    </label>
    <g:textField name="mail" required="" value="${userInstance?.mail}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'birthday', 'error')} required">
	<label for="birthday">
		<g:message code="birthday.label" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="birthday" precision="day"  value="${userInstance?.birthday}"  />
</div>

<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'bio', 'error')}">
    <label for="bio">
        <g:message code="bio.label" />
    </label>
    <g:textArea name="bio" value="${userInstance?.bio}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'country', 'error')}">
    <label for="country">
        <g:message code="country.label" />
    </label>
    <g:textField name="country"  value="${userInstance?.country}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'city', 'error')} ">
    <label for="bio">
        <g:message code="city.label" />
    </label>
    <g:textField name="city" value="${userInstance?.city}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'website', 'error')} ">
    <label for="website">
        <g:message code="website.label" />
    </label>
    <g:textField name="website" value="${userInstance?.website}"/>
</div>
