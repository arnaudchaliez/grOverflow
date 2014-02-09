<g:applyLayout name="questions">
    <head>
        <title><%=tag.name %></title>
    </head>

    <content tag="index-questions">
        <div id="index-questions-title" class="panel-heading">
            <%=tag.name %>
        </div>

        <div id="index-questions-content">
            <ul>
                <g:each in="${listQuestions}" var="currentQuestion">
                    <li>
                        <g:render template="/question/questionShort" collection="${currentQuestion}" var="question" />
                    </li>
                </g:each>
            </ul>
        </div>
    </content>
</g:applyLayout>