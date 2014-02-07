<g:link controller="message" action="vote" id="${idMessage}" params='[type:  "${ types.UP }", idQuestion: "${idMessage}", message: "${typeMessage}" ]'>
    <span class="show-question-up glyphicon glyphicon-arrow-up"></span>
</g:link>
<span id="show-question-score">
    ${score}
</span>
<g:link controller="message" action="vote" id="${idMessage}" params='[type:  "${ types.DOWN }", idQuestion: "${idMessage}", message: "${typeMessage}" ]'>
    <span class="show-question-down glyphicon glyphicon-arrow-down"></span>
</g:link>
