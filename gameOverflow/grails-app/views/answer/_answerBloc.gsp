
<li class="comment">
    <div class="comment-body">
        <div class="comment-avatar">
            <div class="avatar">
                <avatar:gravatar email="${answer?.author?.mail}" alt="My Avatar" size="100" />
            </div>
        </div>
        <div class="comment-text">
            <div class="comment-author">${answer?.author?.username}</div>
            <div class="comment-entry">
                <!-- TODO SECURITY !! , sanitizer ?  -->
                ${raw(answer?.content)}
            </div>
        </div>
    </div>
</li>