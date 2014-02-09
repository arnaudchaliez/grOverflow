package gameoverflow

import grails.test.mixin.TestFor
import spock.lang.Specification

@TestFor(QuestionService)
class QuestionServiceTests extends Specification {
    def questionService
    Answer answer
    Question question
    Comment comment
    User user

    def setup() {
        questionService = new QuestionService()
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
        comment = new Comment(
                author: user,
                content: "Hi.",
                date: new Date()
        )
    }

    def cleanup() {
    }

    void testListQuestion() {
        assert questionService.listQuestions().size() > 0
    }

    void testCountAllQuestions() {
        int size = questionService.countAllQuestions()
        assert size > 0
        assert questionService.listQuestions().size() == size
    }

    void testGetQuestion() {
        question.save()
        assert questionService.getQuestion(question.id) == question
    }

    void testListAnswers() {
        question.answers.add(answer);
        question.save()
        def answers = questionService.listAnswers(question)
        assert answers.contains(answer)
    }

    void testAddQuestion() {
        questionService.addQuestion(question)
        assert question.hasErrors() == false
    }
}
