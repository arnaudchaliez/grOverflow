package gameoverflow

import grails.transaction.Transactional
import grails.plugin.springsecurity.annotation.Secured
import static org.springframework.http.HttpStatus.*

class QuestionController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def questionService
    def userService

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
        [question: inQuestion]
    }

    @Secured(['ROLE_ADMIN'])
    def edit(Question inQuestion) {
        [question: inQuestion]
    }

    @Secured(['ROLE_ADMIN'])
    def create() {
        respond new Question(params)
    }

    @Transactional
    def save(Question inQuestion) {
        processAction(inQuestion, 'insert')
    }

    @Transactional
    def update(Question inQuestion) {
        processAction(inQuestion, 'update')
    }

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
        switch(inAction)
        {
            case 'insert':
                String view = 'create'
                String code = 'default.created.message'
                def httpStatus = CREATED
                break
            case 'update':
                String view = 'edit'
                String code = 'default.updated.message'
                def httpStatus = OK
                break
            case 'delete':
                String code = 'default.deleted.message'
                def httpStatus = NO_CONTENT
                break
        }

        if (inQuestion == null) {
            notFound()
            return
        }

        if (inAction != 'delete')
        {
            inQuestion = questionService.checkInsertQuestion(inQuestion)

            if (inQuestion.hasErrors()) {
                respond inQuestion.errors, view:view
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
                flash.message = message(code: code, args: [message(code: 'question.label', default: 'Question'), inQuestion.id])
                redirect inQuestion
            }
            '*' { respond inQuestion, [status: httpStatus] }
        }

    }


}