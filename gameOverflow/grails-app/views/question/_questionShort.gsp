
    <td class="col-sm-2">
        <span class="number">
            <strong>${question?.answers?.size()}</strong>
            <g:message code="answers.label" default="Answers" />
        </span>
    </td>
    <td>
        <span class="number">
        <strong>${question?.views}</strong>
        <g:message code="views.label" default="Views" />
        </span>
    </td>
    <td>
        <div class="question-title">
            <span>
                <g:link controller="question" action="show" id="${question.id}">${question?.title}</g:link>
            </span>
            <span class="question-tag">
                <g:each in="${question?.tags}" var="currentTag">
                    <g:render template="/tag/tag" collection="${currentTag}" var="tag" />
                </g:each>
            </span>
        </div>
    </td>
    <div class="question-right">
        <td>
            <span class="number">
                <strong>${question?.votes?.size()}</strong>
                <g:message code="score.label" default="Score" />
            </span>
        </td>
        <td>
            <g:render template="/user/userThumbnailMini" collection="${question?.author}" />
            <!-- <g:formatDate date="${question?.date}" />-->
        </td>
    </div>


