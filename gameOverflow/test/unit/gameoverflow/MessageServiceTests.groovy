package gameoverflow

import grails.test.mixin.TestFor
import spock.lang.Specification

@TestFor(MessageService)
class MessageServiceTests extends Specification {
    def messageService
    Answer answer
    Question question
    Comment comment
    User user
    Vote vote
    Vote voteNegatif

    def setup() {
        messageService = new MessageService()
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
        vote = new Vote(
                author: user,
                message: answer,
                type: Vote.Type.UP
        )
        voteNegatif = new Vote(
                author: user,
                message: answer,
                type: Vote.Type.DOWN
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

    void testCheckInsertMessage() {
        messageService.checkInsertMessage(answer)
        assert answer.hasErrors() == false
    }

    void testGetScore() {
        assert messageService.getScore(answer) == 0
        answer.votes.add(vote)
        assert messageService.getScore(answer) == 1
        answer.votes.add(voteNegatif)
        assert messageService.getScore(answer) == 0
    }

    void testGetMessage() {
        answer.validate()
        answer.save()
        assert messageService.getMessage(answer.id) == answer
    }

    void testAddComment() {
        assert answer.comments.size() == 0
        messageService.addComment(answer, comment)
        assert answer.comments.size() == 1
    }

    void testDeleteMessage() {
        int id = answer.id
        assert messageService.getMessage(id) == answer
        messageService.deleteMessage(answer)
        assert messageService.getMessage(id) == null
    }
}
