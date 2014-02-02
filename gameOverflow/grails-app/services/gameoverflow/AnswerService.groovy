package gameoverflow

import grails.transaction.Transactional

@Transactional
class AnswerService {

    def getAnswers() {
        return Answer.list()
    }
}
