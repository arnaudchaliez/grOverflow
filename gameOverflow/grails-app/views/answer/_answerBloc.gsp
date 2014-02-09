
<li class="comment">
    <div class="message-body answer-body">
        <div class="comment-avatar">
            <div class="avatar">
                <avatar:gravatar email="${answer?.author?.mail}" alt="My Avatar" size="100" />
            </div>
        </div>
        <div class="comment-text clearfix">
            <div style="clear:both"></div>
            <div>
                <g:voteForm idMessage="${answer.id}" idQuestion="${question.id}" typeMessage="answer">
                    ${answer?.score}
                </g:voteForm>
                <div class="col-xs-offset-0">
                    <div class="comment-author">${answer?.author?.username}</div>
                    <div class="comment-entry">
                        <!-- TODO SECURITY !! , sanitizer ?  -->
                        ${raw(answer?.content)}
                    </div>
                </div>
            </div>
        </div>
        <div class="comment-footer">
            <div id='show-question-commentlink-${answer.id}' class="show-question-commentlink">
                <g:message code="comment.add.label" />
            </div>
        </div>
    </div>
</li>
