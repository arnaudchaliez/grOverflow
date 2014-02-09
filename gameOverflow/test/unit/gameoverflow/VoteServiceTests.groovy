package gameoverflow
import grails.test.mixin.TestFor
import spock.lang.Specification

@TestFor(TagService)
class VoteServiceTests extends Specification {
    def voteService
    Answer answer
    Question question
    Comment comment
    User user
    Vote voteUp
    Vote voteDown

    def setup() {
        voteService = new VoteServiceTests()
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
        voteUp = new Vote(
                type: Vote.type.UP,
                author: user,
                date: new Date()
        )
        voteDown = new Vote(
                type: Vote.type.DOWN,
                author: user,
                date: new Date()
        )
    }

    void testInsertVote() {
        voteService.insertVote(voteUp)
        assert voteUp.hasErrors() == false
    }
}
