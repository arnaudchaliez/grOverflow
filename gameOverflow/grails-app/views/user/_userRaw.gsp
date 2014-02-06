<span>
    <avatar:gravatar email="${user.mail}" alt="My Avatar" cssClass="avatar" size="20" />
</span>
<span class="title">
    <g:link controller="user" action="show" id="${user.id}" >
        ${user.username}
    </g:link>
</span>
<span id="user-raw-score">
    <g:message code="score.label" />
    <strong>${user.score}</strong>
</span>
