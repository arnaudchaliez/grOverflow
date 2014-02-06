
<div id="user-thumbnailMini">
        <avatar:gravatar email="${user?.mail}" alt="My Avatar" cssClass="avatar" size="25" />
        <div class="caption">
            <g:link controller="user" action="show" id="${user.id}" >
                <h5>${user?.username}</h5>
            </g:link>

            <span class="score">
                Score
                <strong>${user?.score}</strong>
            </span>
        </div>
</div>