package gameoverflow

import grails.plugin.springsecurity.annotation.Secured
import grails.transaction.Transactional

class MessageController {

    def voteService
    def questionService

    def vote() {
        log.info('vote action called')
        log.debug('vote type:' + params.type)

        int id = Integer.parseInt(params.id)
        def vote = voteService.createVote(id, params.type)
        questionService.updateScore(id, vote.type)

        redirect(controller:'question', action:'show', id: params.idQuestion)
    }

    @Secured(['ROLE_ADMIN', 'ROLE_USER'] )
    @Transactional
    def comment(Message inMessage) {
        Message message = messageService.getMessage(Integer.parseInt(params.messageId))
        processAction(inAnswer, 'insert', question)
    }
}
