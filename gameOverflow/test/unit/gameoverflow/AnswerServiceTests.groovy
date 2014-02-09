package gameoverflow

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.services.ServiceUnitTestMixin} for usage instructions
 */
@TestFor(AnswerService)
class AnswerServiceTests extends Specification {

    def answerService
    def answer
    def question
    def user

    def setup() {
        answerService = new AnswerService()
        user = new User(
                username: "toto",
                password: "toto"
        )
        question = new Question(
                author: user,
                title: "How to unit test?",
                date: new Date(),
                content: "Hi, I would like to know how to unit test an application."
        )
        answer = new Answer(
                message: "RTFM.",
                date: new Date(),
                author: user
        )
    }

    def cleanup() {
    }

    void testAddAnswers() {
        def errorCode = answerService.addAnswer(question, answer)

        assert errorCode == 0
        assert answer.question == question
    }

    void testGetAnswers() {
        def answers = answerService.addAnswer(question, answer)
        assert answers.size() > 0
    }
}
