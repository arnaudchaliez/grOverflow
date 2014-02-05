package gameoverflow

import grails.transaction.Transactional

@Transactional
class VoteService {

    def userService

    def createVote(int inQuestionId, String inType) {
        println(inQuestionId)
        Vote vote =  new Vote(
               date: new Date(),
               author:userService.getUserConnected(),
               type: inType,
               message: Message.get(inQuestionId)
        )
        vote.save(failOnError: true)
    }

    def canUserConnectedVote(long inMessageId) {
        int canVote = -1
        def user = userService.getUserConnected()

        if (user) {
            def query = Vote.where {
                id == inMessageId && author.id == user.id
            }
            def vote = query.find()

            println(vote)
        }
        return canVote
    }
}
