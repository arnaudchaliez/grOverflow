<div class="navbar navbar-default" id="layout-navbar" role="navigation">
    <div class="container">
        <div class="navbar-collapse collapse">

            <div class="row">
                <div class="col-xs-10">
                    <div id="gameOverFlowLogo" role="banner"><a href="/gameOverflow"><img src="${resource(dir: 'images', file: 'logo_title.png')}" alt="GameOverFlow"/></a></div>
                </div>
                <div class="col-xs-2">
                    <sec:ifLoggedIn>
                        <sec:username />

                        <g:link class="btn btn-default" controller='logout'><g:message code="logout.label" /></g:link>
                    </sec:ifLoggedIn>
                    <sec:ifNotLoggedIn>
                        <g:link class="btn btn-default" controller='login' action='auth'><g:message code="login.label" /></g:link>
                        <g:link class="btn btn-default" controller='login' action='register'><g:message code="register.label" /></g:link>
                    </sec:ifNotLoggedIn>
                </div>
            </div>


        </div>
    </div>
</div>