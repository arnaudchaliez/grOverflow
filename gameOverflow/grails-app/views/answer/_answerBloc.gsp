
<li class="comment">
    <div class="comment-body">
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
                <div class="col-xs-offset-1"><div class="comment-author">${answer?.author?.username}</div>
                    <div class="comment-entry">
                        <!-- TODO SECURITY !! , sanitizer ?  -->
                        ${raw(answer?.content)}
                    </div>
                    <div class="comment-footer">
                        <div id='show-question-commentlink-${answer.id}'>
                            <g:message code="comment.add" />
                        </div>
                    </div>
                </div>
            </div>

        </div>
    </div>
</li>

<g:javascript>
    $('#show-question-commentlink-${answer.id}').click(

        function() {
            console.log("click - #show-question-commentform-${answer.id}");
            var form = $('#show-question-commentform-${answer.id}');
            if( form.hasClass('hidden') ){
                form.removeClass('hidden');
            }
            else {
                form.addClass('hidden');
            }
        }
    );
</g:javascript>
