package gameoverflow

import grails.transaction.Transactional

import static org.springframework.http.HttpStatus.CREATED

class QuestionController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def questionService
    def userService

    def index() {
        int max = 100
        [listQuestions: questionService.listQuestions(max), questionListCount: Question.count()]
    }

    def show(Question questionInstance) {
        respond questionInstance
    }

    def create() {
        respond new Question(params)
    }

    @Transactional
    def save(Question questionInstance) {
        if (questionInstance == null) {
            notFound()
            return
        }

        if (questionInstance.hasErrors()) {
            respond questionInstance.errors, view:'create'
            return
        }

        questionInstance.save flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.created.message', args: [message(code: 'questionInstance.label', default: 'Question'), questionInstance.id])
                redirect questionInstance
            }
            '*' { respond questionInstance, [status: CREATED] }
        }
    }


}