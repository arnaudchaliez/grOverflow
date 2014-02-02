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
}
