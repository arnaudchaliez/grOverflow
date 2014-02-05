<g:if test="${user != null}">

    <div id="user-thumbnail" class="profile boxed_double">
        <div class="clearfix">
            <avatar:gravatar email="${user.mail}" alt="My Avatar" cssClass="avatar" size="100" />
            <div class="caption">
                <g:link controller="user" action="show" id="${user.id}" >
                    <h4>${user.username}</h4>
                </g:link>
                <span class="subtitle">${user.bio}</span>
                <span class="number">
                    <strong>${user.score}</strong>
                    <g:message code="score.label" />
                </span>
            </div>
        </div>
    </div>

</g:if>