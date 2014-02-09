package gameoverflow

import grails.test.mixin.TestFor
import spock.lang.Specification

@TestFor(TagService)
class TagServiceTests extends Specification {
    def tagService
    Answer answer
    Question question
    Comment comment
    User user
    Tag tag1
    Tag tag2

    def setup() {
        tagService = new TagService()
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

    void testParseStrTags() {
        def str = "Mario,Luigi,Bowser"
        assert tagService.parseStrTags(str) == ["Mario", "Luigi", "Bowser"]
    }

    void testGetTag() {
        tag1.save()
        assert tagService.getTag(tag1.name) == tag1
    }

    void testGetTagQuestions() {
        question.tags.add(tag1);
        question.save();
        assert tagService.getTagQuestions(tag1).contains(question)
    }

    void testListRecentTags() {
        tag2.save()
        def tags = tagService.listRecentTags(10)

        assert tags.contains(tag1)
        assert tags.contains(tag2)
    }
}
