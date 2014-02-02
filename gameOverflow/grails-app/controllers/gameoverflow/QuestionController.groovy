package gameoverflow

import grails.transaction.Transactional
import grails.plugin.springsecurity.annotation.Secured
import static org.springframework.http.HttpStatus.*

class QuestionController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def questionService
    def messageService
    def tagService

    @Secured('permitAll')
    def index() {
        int max = grailsApplication.config.gameoverflow.question.max
        def listRecentQuestions = questionService.listRecentQuestions(max)
        def listUnansweredQuestions = questionService.listUnansweredQuestions(max)
        def listPopularQuestions = questionService.listPopularQuestions(max)
        int questionsCount = questionService.countAllQuestions()

        [listRecentQuestions: listRecentQuestions, listPopularQuestions: listPopularQuestions, listUnansweredQuestions: listUnansweredQuestions, questionListCount: questionsCount]
    }

    @Secured('permitAll')
    def show(Question inQuestion) {
        questionService.viewQuestion(inQuestion)

        [tags: questionService.listTags(inQuestion), answers: questionService.listAnswers(inQuestion), question: inQuestion]
    }

    @Secured(['ROLE_ADMIN', 'ROLE_USER'] )
    def edit(Question inQuestion) {
        [question: inQuestion, tags: questionService.stringTagsName(inQuestion)]
    }

    @Secured(['ROLE_ADMIN', 'ROLE_USER'] )
    def create() {
        respond new Question(params)
    }

    @Secured(['ROLE_ADMIN', 'ROLE_USER'] )
    @Transactional
    def save(Question inQuestion) {
        if(params.tags) {
            questionService.addStringTags(inQuestion, params.tags)
        }
        processAction(inQuestion, 'insert')
    }

    @Transactional
    def update(Question inQuestion) {
        if(params.tags) {
            questionService.addStringTags(inQuestion, params.tags)
        }
        processAction(inQuestion, 'update')
    }

    @Secured(['ROLE_ADMIN', 'ROLE_USER'] )
    @Transactional
    def delete(Question inQuestion) {
        processAction(inQuestion, 'delete')
    }

    protected void notFound() {
        request.withFormat {
            form {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'question.label', default: 'Question'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }

    protected void processAction(Question inQuestion, String inAction)
    {

        //message code associated with the action
        String strcode = ''
        //view associated with the action
        String strview = ''
        switch(inAction)
        {
            case 'insert':
                strview = 'create'
                strcode = 'default.created.message'
                def httpStatus = CREATED
                break
            case 'update':
                strview = 'edit'
                strcode = 'default.updated.message'
                def httpStatus = OK
                break
            case 'delete':
                strcode = 'default.deleted.message'
                def httpStatus = NO_CONTENT
                break
        }

        if (inQuestion == null) {
            notFound()
            return
        }

        if (inAction != 'delete') {
            inQuestion = messageService.checkInsertMessage(inQuestion)

            if (inQuestion.hasErrors()) {
                respond inQuestion.errors, view:strview
                return
            }

            inQuestion.save(failOnError: true, flush:true)
        }
        else
        {
            inQuestion.delete(failOnError: true, flush:true)
        }

        request.withFormat {

            form {
                flash.message = message(code: strcode, args: [message(code: 'question.label', default: 'Question'), inQuestion.id])

                if (inAction != 'delete')
                    redirect inQuestion
                else
                    redirect action:"index", method:"GET"
            }
            '*' { respond inQuestion, [status: httpStatus] }
        }

    }


}