package gameoverflow

import gameoverflow.Question
import grails.transaction.Transactional
import org.springframework.security.core.context.SecurityContextHolder

@Transactional
class QuestionService {

    def userService

    /**
     * return all the questions.
    */
    def listQuestions() {
        return Question.list()
    }

    /**
     * return the number of questions.
     */
    def countAllQuestions() {
        return Question.count()
    }

    /** return the recent questions.
     * @param number limit the questions returned
    */
    def listRecentQuestions(int inMax) {
        return Question.list(sort: "date", order: "desc", max:inMax)
    }

    /** return the recent questions.
     * @param number limit the questions returned
     */
    def listUnansweredQuestions(int inMax) {
        //todo
        return Question.list(sort: "score", order: "desc", max:inMax)
    }

    /** return the recent questions.
     * @param number limit the questions returned
     */
    def listPopularQuestions(int inMax) {
        return Question.list(sort: "score", order: "desc", max:inMax)
    }

    def getQuestion(int inId) {
        return Question.get(inId)
    }

    def addQuestion(String inTitle, String inContent, User inAuthor) {

        Question question = new Question(
                title: inTitle,
                content: inContent,
                date: new Date(),
                author: inAuthor,
                answers: null,
                messages: null,
                score: 0,
                tags: null

        ).save(failOnError: true)
        return question
    }

    def checkInsertQuestion(Question inQuestion)
    {

        if (inQuestion.date == null) {
            inQuestion.date = new Date()
        }
        if (inQuestion.author == null) {
            inQuestion.author = userService.getUserConnected()
        }

        inQuestion.validate()

        return inQuestion
    }

    def updateScore(int inId, int inScore) {
        def question = Question.get(inId)
        question.score += inScore
    }

}
