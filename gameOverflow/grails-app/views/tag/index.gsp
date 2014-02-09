<g:applyLayout name="page">
    <head>
        <title><g:message code="tag.title" /></title>
    </head>

    <content tag="gocontent">
        <div class="panel panel-default" role="main">
            <div class="panel-heading">
                <g:message code="tag.title" />
            </div>
            <div class="panel-content clearfix">
                <g:each in="${tagsList}" status="i" var="tag">
                    <div class="col-xs-2">
                        <div>
                        <g:render template="/tag/tag" collection="${tag}" var="tag" /> x ${tag.questions.size()}
                        </div>
                        <div>
                            ${tag.description}
                        </div>
                    </div>
                </g:each>
            </div>
        </div>
    </content>
</g:applyLayout>