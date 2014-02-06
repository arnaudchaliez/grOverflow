<%@ page import="gameoverflow.Comment" %>

<div class="fieldcontain ${hasErrors(bean: comment, field: 'title', 'error')} required">

    <label for="content">
        <g:message code="content.label" />
        <span class="required-indicator">*</span>
    </label>
    <g:textField name="content" value="${comment?.content}" maxlength="300" required="true" />

</div>


