<%@ page import="gameoverflow.Question" %>

<div class="fieldcontain ${hasErrors(bean: question, field: 'title', 'error')} required">
    <label for="title">
        <g:message code="title.label" default="title" />
        <span class="required-indicator">*</span>
    </label>
    <g:textField name="title" class="form-control" required="" value="${question?.title}"/>
</div>

<ckeditor:editor name="content" height="400px" width="100%">
    ${question?.content}
</ckeditor:editor>

<input name="tags" id='tagsInput' type="text" data-role="tagsinput" value="${tags}" placeholder="Add tags (press enter)" />

<g:javascript>

    $('#tagsInput').tagsinput();
    $('#tagsInput').tagsinput('input').typeahead({
        prefetch: '/gameOverflow/tag/popularTags?format=json',
        valueKey: 'name',
        limit: 5,
        template: function(datum) {
            return '<p class="tag-category">' + datum.category + '</p>'
                + '<p class="tag-name">' + datum.name + '</p>'
                + '<p class="tag-description">' + datum.description + '</p>';}
    }).bind('typeahead:selected', $.proxy(function (obj, datum) {
                this.tagsinput('add', datum.name);
                this.tagsinput('input').typeahead('setQuery', '');
        }, $('#tagsInput')));
</g:javascript>

