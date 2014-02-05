package gameoverflow

import grails.transaction.Transactional

@Transactional
class MessageService {

    def userService

    def checkInsertMessage(Message inMessage)
    {
        if (inMessage.date == null) {
            inMessage.date = new Date()
        }
        if (inMessage.author == null) {
            inMessage.author = userService.getUserConnected()
        }

        inMessage.validate()

        return inMessage
    }

    def getScore(Message inMessage)
    {
        int nbPositives, nbNegatives = 0

        for (vote in inMessage.votes) {
            if(vote.type == Vote.Type.UP)
                nbPositives++
            else
                nbNegatives++
        }
        /*def query = Vote.where {
            type == Vote.Type.UP && message.id = inMessage.id
        }
        def count = query.count()
        */
        return nbPositives - nbNegatives
    }
}
