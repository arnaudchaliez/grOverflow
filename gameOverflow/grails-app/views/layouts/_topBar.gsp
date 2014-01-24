<div class="navbar navbar-default" role="navigation">
    <div class="container">
        <div class="navbar-collapse collapse">
            <div id="gameOverFlowLogo" role="banner"><a href="/gameOverflow"><img src="${resource(dir: 'images', file: 'gameoverflow_logo.png')}" alt="GameOverFlow"/></a></div>

            <sec:ifLoggedIn>
                <sec:username />
                <g:link controller='logout' action='auth'>Logout</g:link>
            </sec:ifLoggedIn>
            <sec:ifNotLoggedIn>
                <g:link controller='login' action='auth'>Login</g:link>
            </sec:ifNotLoggedIn>
        </div>
    </div>
</div>