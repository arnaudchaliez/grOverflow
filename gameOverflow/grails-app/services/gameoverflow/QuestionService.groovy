package gameoverflow

import gameoverflow.Question
import grails.transaction.Transactional

@Transactional
class QuestionService {

    def listQuestions(int number) {
        def questions = Question.list()

        return questions
    }

    def listRecentQuestions(int number) {
        return Question.list(sort: date, order: "desc", max:number)
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

    def updateScore(int inId, int inScore) {
        def question = Question.get(inId)
        question.score += inScore
    }

}
