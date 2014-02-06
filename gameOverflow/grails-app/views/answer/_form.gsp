<%@ page import="gameoverflow.Answer" %>

<div class="fieldcontain ${hasErrors(bean: answer, field: 'title', 'error')} required">

    <ckeditor:editor id="answerCKEditor" name="content" height="200px" width="100%">
        ${answer?.content}
    </ckeditor:editor>

</div>


