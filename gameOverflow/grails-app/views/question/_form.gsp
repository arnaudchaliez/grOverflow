<%@ page import="gameoverflow.Question" %>

<div class="fieldcontain ${hasErrors(bean: question, field: 'title', 'error')} required">
    <label for="title">
        <g:message code="question.title.label" default="title" />
        <span class="required-indicator">*</span>
    </label>
    <g:textField name="title" required="" value="${question?.title}"/>
</div>

<ckeditor:editor name="content" height="400px" width="80%">
    ${question?.content}
</ckeditor:editor>
