package gameoverflow

import grails.transaction.Transactional
import jline.internal.Log

@Transactional
class AnswerService {

    def messageService

    def getAnswers() {
        return Answer.list()
    }


    /**
     * add an answer to the question in parameter and validate it.
     * @param Question question to add the answer
     * @param Answer answer to the question
     */
    def addAnswer(Question inQuestion, Answer inAnswer) {
        inAnswer.question = inQuestion
        messageService.checkInsertMessage(inAnswer)

        if (inAnswer.hasErrors()) {
            Log.error('error creating answer, answer still have errors :')
            Log.error(inAnswer)
            return -1
        } else {
            inAnswer.save(failOnError: true)
        }

        return 0
    }
}
