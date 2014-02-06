
<li class="comment comment-right">
    <div class="comment-body">
        <div class="comment-avatar">
            <div class="avatar">
                <avatar:gravatar email="${comment?.author?.mail}" alt="My Avatar" size="100" />
            </div>
        </div>
        <div class="comment-text">
            <div class="comment-author">${comment?.author?.username}</div>
            <div class="comment-entry">
                <!-- TODO SECURITY !! , sanitizer ?  -->
                ${comment?.content}
            </div>
        </div>
    </div>
</li>