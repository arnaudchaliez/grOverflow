<div class="navbar navbar-default" role="navigation">
    <div class="container">
        <div class="navbar-collapse collapse">

            <div class="row">
                <div class="col-xs-10">
                    <div id="gameOverFlowLogo" role="banner"><a href="/gameOverflow"><img src="${resource(dir: 'images', file: 'logo_title.png')}" alt="GameOverFlow"/></a></div>
                </div>
                <div class="col-xs-2">
                    <sec:ifLoggedIn>
                        <sec:username />

                        <g:link class="btn btn-default" controller='logout'>Logout</g:link>
                    </sec:ifLoggedIn>
                    <sec:ifNotLoggedIn>
                        <g:link class="btn btn-default" controller='login' action='auth'>Login</g:link>
                        <g:link class="btn btn-default" controller='login' action='register'>Register</g:link>
                    </sec:ifNotLoggedIn>
                </div>
            </div>


        </div>
    </div>
</div>