
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
        <g:link controller="question" action="show" id="${question.id}">${question?.title}</g:link>
        <div class="badge style2"></div>
    </td>
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


