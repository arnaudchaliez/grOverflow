<g:applyLayout name="page">
    <head>
        <title><g:if env="development">Grails Runtime Exception</g:if><g:else>Error</g:else></title>
        <g:if env="development"><link rel="stylesheet" href="${resource(dir: 'css', file: 'errors.css')}" type="text/css"></g:if>
    </head>

    <content tag="gocontent">
        <g:if env="development">
            <g:renderException exception="${exception}" />
        </g:if>
        <g:else>
            <ul class="errors">
                <li>An error has occurred</li>
            </ul>
        </g:else>
    </content>
</g:applyLayout>