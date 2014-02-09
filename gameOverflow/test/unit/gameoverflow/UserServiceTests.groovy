package gameoverflow

import grails.test.mixin.TestFor
import spock.lang.Specification

@TestFor(TagService)
class UserServiceTests extends Specification {
    def userService
    Answer answer
    Question question
    Comment comment
    User user
    Tag tag1
    Tag tag2

    def setup() {
        userService = new UserServiceTests()
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
        tag1 = new Tag(
                name: "Mario",
                author: user,
                date: new Date()
        )
        tag2 = new Tag(
                name: "Luigi",
                author: user,
                date: new Date()
        )
    }

    void testGetUser() {
        user.save()
        assert userService.getUser(user.id) == user
    }

    void testGetUserByUserName() {
        user.save()
        assert userService.getUserByUsername(user.username) == user
    }

    void testListQuestionsUser() {
        question.author = user
        question.save()

        def questions = userService.listQuestionsUser(user)
        assert questions.contains(question)
    }

    void testListAnswersUser() {
        answer.author = user
        answer.save()

        def answers = userService.listAnswersUser(user)
        assert answers.contains(answer)
    }

    void testListTagsUser() {
        tag1.author = user
        tag1.save()

        def tags = userService.listTagsUser(user)
        assert tags.contains(tag1)
    }
}
