package gameoverflow

import commands.VoteCommand
import grails.plugin.springsecurity.annotation.Secured
import grails.transaction.Transactional

class MessageController {

    def voteService
    def questionService
    def messageService

    @Transactional
    @Secured(['ROLE_ADMIN', 'ROLE_USER'] )
    def vote() {
        VoteCommand cmd = new VoteCommand()
        bindData(cmd, params)
        if(!cmd.hasErrors()) {
            voteService.createVote( cmd.id, cmd.typeVote );
        }
        else {
            log.error('action vote called with an id or a vote type null ')
        }

        redirect(controller:'question', action:'show', id: cmd.idQuestion)
    }

    @Secured(['ROLE_ADMIN', 'ROLE_USER'] )
    @Transactional
    def comment() {
        Message message = messageService.getMessage(Integer.parseInt(params.messageId))
        processAction(inAnswer, 'insert', question)
    }
}
