
<div id="user-thumbnail" class="profile boxed_double">
    <div class="clearfix">
        <avatar:gravatar email="${user?.mail}" alt="My Avatar" cssClass="avatar" size="100" />
        <div class="caption">
            <h4>${user?.username}</h4>
            <span class="subtitle">${user?.bio}</span>
            <span class="number">
                <strong>${user?.score}</strong>
                <g:message code="score.label" />
            </span>
        </div>
    </div>
</div>