
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
                <!-- BEST ANSWER SELECTION -->
                <g:if test="${answer.bestAnswer || canSelectBest}">
                    <div class="best_answer">
                        <g:if test="canSelectBest">
                            <g:link controller="question" action="bestAnswer" id="${answer.id}" params='[idQuestion: "${question.id}" ]'>
                                <div class="best-${answer.bestAnswer}">
                                </div>
                            </g:link>
                        </g:if>
                        <g:else>
                            <div class="best-${answer.bestAnswer}">
                            </div>
                        </g:else>
                    </div>
                </g:if>

                <!-- VOTE -->
                <g:voteForm idMessage="${answer.id}" idQuestion="${question.id}" typeMessage="answer">
                    ${answer?.score}
                </g:voteForm>

                <!-- ANSWER CONTENT -->
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
<li>
    <div class="hidden" id="show-question-commentform-${answer.id}">
        <g:form role="form" url="[controller:'comment', action:'save']" >
            <div class="form-group">
                <g:render class="form-control" template="/comment/form" />
            </div>

            <g:hiddenField name="messageId" value="${answer.id}" />
            <g:hiddenField name="questionId" value="${question.id}" />
        </g:form>
    </div>
</li>

<g:each in="${answer.comments}"  var="currentComment">
    <g:render template="/comment/commentBloc" collection="${currentComment}" var="comment" />
</g:each>
