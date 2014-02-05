package gameoverflow

import gameoverflow.Question
import grails.transaction.Transactional
import org.springframework.security.core.context.SecurityContextHolder

@Transactional
class QuestionService {

    def userService
    def tagService
    def grailsApplication

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

    /**
     * return the recent questions.
     * @param number limit the questions returned
    */
    def listRecentQuestions(int inMax) {
        return Question.list(sort: "date", order: "desc", max:inMax)
    }

    /**
     * return the unanswered questions.
     * @param number limit the questions returned
     */
    def listUnansweredQuestions(int inMax) {

        def noAnswers = Question.withCriteria(max: inMax) {
            isEmpty("answers")
        }

        return noAnswers
    }

    /**
     * return the popular questions.
     * @param number limit the questions returned
     */
    def listPopularQuestions(int inMax) {
        return Question.list(sort: "score", order: "desc", max:inMax)
    }

    /**
     * return the question associated to the id.
     * @param number id of the question to return
     */
    def getQuestion(int inId) {
        return Question.get(inId)
    }

    /**
     * return the list of the answers associated to question.
     * @param Question question to get answers
     */
    def listAnswers(Question inQuestion) {
        def answers = inQuestion.answers.toList()

        return answers
    }

    /**
     * return the list of the tags associated to question.
     * @param Question question to get tags
     */
    def listTags(Question inQuestion) {
        def tags = inQuestion.tags.toList()

        return tags
    }


    /**
     * return the array of the tags associated to question.
     * @param Question question to get tags
     */
    def stringTagsName(Question inQuestion) {
        def names = inQuestion.tags*.name
        def namesStr = names.toString()
        return namesStr.substring(1,namesStr.length()-1)
    }

    /**
     * method called by the action show of the controller Question.
     * @param Question question which is shown
     */
    def viewQuestion(Question inQuestion) {
        if (inQuestion.author != userService.getUserConnected())
            inQuestion.views++
    }

    /**
     * add an answer to the question in parameter and validate it.
     * @param Question question to add the answer
     * @param Answer answer to the question
     */
    def addAnswer(Question inQuestion, Answer inAnswer) {

        inAnswer.question = inQuestion
        inAnswer.validate()
    }

    /**
     * add tags to th question from a string (tag1[, tag2[, tag 3] ...]) .
     * @param Question question to add the tags
     * @param String tags to parse
     */
    def addStringTags(Question inQuestion, String inTags) {
        def tagsStr = tagService.parseStrTags(inTags)
        for (tagStr in tagsStr) {
            def tag = tagService.getTag(tagStr)
            inQuestion.addToTags(tag)
            tag.addToQuestions(inQuestion)
        }
    }

    //TODO remove
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

    def updateScore(int inId, Vote.Type inType) {
        def question = Question.get(inId)
        int weight = grailsApplication.config.gameoverflow.question.vote.weight
        if (inType == Vote.Type.DOWN)
            weight *= -1

        question.score += weight
    }
}
