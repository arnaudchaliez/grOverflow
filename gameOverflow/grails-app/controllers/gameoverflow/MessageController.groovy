package gameoverflow

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
}
