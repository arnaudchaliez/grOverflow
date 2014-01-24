package gameoverflow

import grails.transaction.Transactional
import org.springframework.security.access.annotation.Secured

import static org.springframework.http.HttpStatus.CREATED
import grails.plugin.springsecurity.annotation.Secured

class QuestionController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def questionService
    def userService

    @Secured('permitAll')
    def index() {
        int max = 100
        [listQuestions: questionService.listQuestions(max), questionListCount: Question.count()]
    }

    @Secured('permitAll')
    def show(Question questionInstance) {
        [question:questionInstance]
    }


    @Secured(['ROLE_ADMIN'])
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
                flash.message = message(code: 'default.created.message', args: [message(code: 'questionInstance.title', default: 'Question'), questionInstance.id])
                redirect questionInstance
            }
            '*' { respond questionInstance, [status: CREATED] }
        }
    }


}