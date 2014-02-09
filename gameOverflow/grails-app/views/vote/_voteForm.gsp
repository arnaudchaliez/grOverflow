<div class="message_vote">
    <div class="vote-${voted}">
        <g:link controller="message" action="vote" id="${idMessage}" params='[typeVote: "${ types.UP }", typeMessage: "${typeMessage}", idQuestion: "${idQuestion}" ]'>
            <span class="show-question-up arrow-up arrow"></span>
        </g:link>
        <span class="score">
            ${score}
        </span>
        <g:link controller="message" action="vote" id="${idMessage}" params='[typeVote: "${ types.DOWN }", typeMessage: "${typeMessage}", idQuestion: "${idQuestion}" ]'>
            <span class="show-question-down arrow-down arrow"></span>
        </g:link>
    </div>
</div>
