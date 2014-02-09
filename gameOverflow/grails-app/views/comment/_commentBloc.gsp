
<li class="comment comment-right col-xs-offset-1">
    <div class="message-body comment-body">
        <div class="comment-avatar">
            <div class="avatar">
                <avatar:gravatar email="${comment?.author?.mail}" alt="My Avatar" size="100" />
            </div>
        </div>
        <div class="comment-text clearfix">
            <g:voteForm idMessage="${comment.id}" idQuestion="${question.id}" typeMessage="comment">
                ${comment?.score}
            </g:voteForm>
            <div class="message-content">
                <div class="comment-author">${comment?.author?.username}</div>
                <div class="comment-entry">
                    <!-- TODO SECURITY !! , sanitizer ?  -->
                    ${comment?.content}
                </div>
            </div>
        </div>
    </div>
</li>