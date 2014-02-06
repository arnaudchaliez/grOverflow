package gameoverflow

import grails.transaction.Transactional
import jline.internal.Log

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

    /**
     * return the message associated to the id.
     * @param number id of the question to return
     */
    def getMessage(int inId) {
        return Message.get(inId)
    }

    def addComment(Message inMessage, Comment inComment) {
        inComment.message = inMessage
        checkInsertMessage(inComment)

        if (inComment.hasErrors()) {
            Log.error('error creating comment, comment still have errors :')
            Log.error(inComment)
            return -1
        } else {
            inComment.save(failOnError: true)
        }

        return 0
    }

    def deleteMessage(Message inMessage) {
        inMessage.delete(failOnError: true, flush:true)
    }

}
