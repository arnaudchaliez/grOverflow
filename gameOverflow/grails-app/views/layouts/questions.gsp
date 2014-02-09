<g:applyLayout name="page">
    <head>
        <title><g:layoutTitle/></title>
        <g:layoutHead/>
    </head>

    <content tag="gocontent">
        <div class="row">
            <div class="col-xs-8">
                <div id="index-questions" class="panel panel-default">
                    <g:pageProperty name="page.index-questions"/>
                </div>
            </div>
            <div class="col-xs-4">
                <div id="index-highscore" class="panel panel-default">
                    <div id="index-highscore-title" class="panel-heading">
                        <g:message code="highscore.title" />
                    </div>

                    <div id="index-highscore-content" class="panel-body">
                        <ul>
                            <g:each in="${listTopUsers}" status="i" var="currentUser">
                                <li>
                                    <span id="user-raw">
                                        <span>${i+1}.</span>
                                        <g:render template="/user/userRaw" collection="${currentUser}" var="user" />
                                    </span>
                                </li>
                            </g:each>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </content>
</g:applyLayout>