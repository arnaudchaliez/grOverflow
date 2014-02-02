<%@ page import="gameoverflow.Answer" %>

<div class="fieldcontain ${hasErrors(bean: answer, field: 'title', 'error')} required">

    <ckeditor:editor name="content" height="400px" width="80%">
        ${answer?.content}
    </ckeditor:editor>

</div>


