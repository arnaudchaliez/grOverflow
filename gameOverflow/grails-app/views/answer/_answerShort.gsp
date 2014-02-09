    <td>
        <div class="answer-title">
            <span>
                <g:link controller="question" action="show" id="${answer?.question?.id}">${answer?.question?.title}</g:link>
            </span>
            <span class="question-tag">
                <g:each in="${answer?.question?.tags}" var="currentTag">
                    <g:render template="/tag/tag" collection="${currentTag}" var="tag" />
                </g:each>
            </span>
        </div>
    </td>
    <div class="question-right">
        <td>
            <span class="number">
                <strong>${answer?.votes?.size()}</strong>
                <g:message code="score.label" default="Score" />
            </span>
        </td>
    </div>


