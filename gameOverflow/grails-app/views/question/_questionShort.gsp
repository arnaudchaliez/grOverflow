
    <td>${question?.answers?.count()}</td>
    <td>${question?.views}</td>
    <td>
        <g:link action="show" id="${question.id}">${question?.title}</g:link></td>
    </td>
    <td>${question?.score}</td>
    <td><g:formatDate date="${question?.date}" /></td>

