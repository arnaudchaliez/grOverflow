
<div id="user-thumbnail" class="thumbnail col-md-4">
    <avatar:gravatar email="${user?.mail}" alt="My Avatar" cssClass="myCss" size="50"/>
    <div class="caption">
        <h3>${user?.username}</h3>
        <span>${user?.score}</span>
    </div>
</div>