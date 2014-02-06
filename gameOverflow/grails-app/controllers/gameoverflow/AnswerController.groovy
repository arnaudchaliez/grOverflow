package gameoverflow

import grails.plugin.springsecurity.annotation.Secured
import grails.transaction.Transactional
import jline.internal.Log

import static org.springframework.http.HttpStatus.CREATED
import static org.springframework.http.HttpStatus.NOT_FOUND
import static org.springframework.http.HttpStatus.NO_CONTENT
import static org.springframework.http.HttpStatus.OK

class AnswerController {

    def messageService
    def questionService
    def answerService

    def index() {}

    @Secured(['ROLE_ADMIN', 'ROLE_USER'] )
    def edit(Answer inAnswer) {
        [answer: inAnswer]
    }

    @Secured(['ROLE_ADMIN', 'ROLE_USER'] )
    def create() {
        respond new Answer(params)
    }

    @Secured(['ROLE_ADMIN', 'ROLE_USER'] )
    @Transactional
    def save(Answer inAnswer) {
        Question question = questionService.getQuestion(Integer.parseInt(params.questionId))
        processAction(inAnswer, 'insert', question)
    }

    @Secured(['ROLE_ADMIN', 'ROLE_USER'] )
    @Transactional
    def update(Answer inAnswer) {
        Question question = questionService.getQuestion(Integer.parseInt(params.questionId))
        processAction(inAnswer, 'update')
    }

    @Secured(['ROLE_ADMIN', 'ROLE_USER'] )
    @Transactional
    def delete(Answer inAnswer) {
        Question question = questionService.getQuestion(Integer.parseInt(params.questionId))
        processAction(inAnswer, 'delete')
    }

    protected void notFound() {
        request.withFormat {
            form {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'answer.label', default: 'Answer'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }

    protected void processAction(Answer inAnswer, String inAction, Question inQuestion = null)
    {

        //message code associated with the action
        String strcode = ''
        //view associated with the action
        String strview = ''
        switch(inAction)
        {
            case 'insert':
                strview = 'index'
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

        if (inAnswer == null) {
            Log.error('error creating answer, processAction (' + inAction + ') object is null')
            notFound()
            return
        }

        if (inAction != 'delete') {
            if ( answerService.addAnswer(inQuestion, inAnswer)==-1 ) {
                respond inAnswer.errors, view:strview
            }
        }
        else
        {
            messageService.deleteAnswer(inAnswer)
        }

        request.withFormat {

            form {
                flash.message = message(code: strcode, args: [message(code: 'answer.label', default: 'Answer'), inAnswer.id])

                if (inAction != 'delete')
                    redirect inQuestion
                else
                    redirect action:"index", method:"GET"
            }
            '*' { respond inAnswer, [status: httpStatus] }
        }

    }



}
