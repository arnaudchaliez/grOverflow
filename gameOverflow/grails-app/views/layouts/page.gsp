<g:applyLayout name="main">
    <head>
        <title><g:message code="general.welcome" default="Welcome to GameOverFlow" /></title>
        <title><g:layoutTitle/></title>
        <g:layoutHead/>
    </head>
    <body>
    <div id="page-body" role="main">

        <div class="row">
            <div class="col-xs-2">
                <g:link controller="question">
                    <button type="button" class="btn btn-primary btn-lg btn-block"><g:message code="questions.label" default="Questions" /></button>
                </g:link>
            </div>
            <div class="col-xs-2">
                <sec:ifLoggedIn>
                    <g:link controller="user" action="show" id="${idUser}">
                        <button type="button" class="btn btn-primary btn-lg btn-block"><g:message code="profil.label" default="Profil" /></button>
                    </g:link>
                </sec:ifLoggedIn>
            </div>
            <div class="col-xs-2 col-md-offset-2">
                <g:link controller="question" action="create">
                    <button type="button" class="btn btn-primary btn-lg btn-block"><g:message code="question.new" default="New question" /></button>
                </g:link>
            </div>
            <div class="col-xs-4">
                <div class="pull-right" id="gameOverFlowLogo" role="banner">
                    <a href="/gameOverflow"><img src="${resource(dir: 'images', file: 'logo_gameoverflow.png')}" alt="GameOverFlow"/></a>
                </div>
            </div>
        </div>

        <div id="gocontent">
            <g:pageProperty name="page.gocontent"/>
        </div>
    </div>
    </body>
</g:applyLayout>