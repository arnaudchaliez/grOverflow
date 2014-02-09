package gameoverflow

import grails.plugin.springsecurity.annotation.Secured
import grails.transaction.Transactional
import jline.internal.Log

import static org.springframework.http.HttpStatus.CREATED
import static org.springframework.http.HttpStatus.NOT_FOUND
import static org.springframework.http.HttpStatus.NO_CONTENT
import static org.springframework.http.HttpStatus.OK

class CommentController {

    def MessageService
    def QuestionService

    @Secured(['ROLE_ADMIN', 'ROLE_USER'] )
    def edit(Comment inComment) {
        [comment: inComment]
    }

    @Secured(['ROLE_ADMIN', 'ROLE_USER'] )
    def create() {
        respond new Comment(params)
    }

    @Secured(['ROLE_ADMIN', 'ROLE_USER'] )
    @Transactional
    def save(Comment inComment) {
        Message message = messageService.getMessage(Integer.parseInt(params.messageId))
        Question question = questionService.getQuestion(Integer.parseInt(params.questionId))

        processAction(inComment, 'insert', question,  message)
    }

    @Secured(['ROLE_ADMIN', 'ROLE_USER'] )
    @Transactional
    def update(Comment inComment) {
        Message message = messageService.getMessage(Integer.parseInt(params.messageId))
        Question question = questionService.getQuestion(Integer.parseInt(params.questionId))

        processAction(inComment, 'update', question)
    }

    @Secured(['ROLE_ADMIN', 'ROLE_USER'] )
    @Transactional
    def delete(Comment inComment) {
        Message message = messageService.getMessage(Integer.parseInt(params.messageId))
        Question question = questionService.getQuestion(Integer.parseInt(params.questionId))

        processAction(inComment, 'delete', question)
    }

    protected void notFound() {
        request.withFormat {
            form {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'comment.label', default: 'Comment'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }

    protected void processAction(Comment inComment, String inAction, Question inQuestion, Message inMessage = null)
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

        if (inComment == null) {
            Log.error('error creating comment, processAction (' + inAction + ') object is null')
            notFound()
            return
        }

        if (inAction != 'delete') {
            if ( messageService.addComment(inMessage, inComment)==-1 ) {
                respond inComment.errors, view:strview
            }
        }
        else
        {
            messageService.deleteMessage(inComment)
        }

        request.withFormat {

            form {
                flash.message = message(code: strcode, args: [message(code: 'comment.label', default: 'Comment'), inComment.id])

                if (inAction != 'delete')
                    redirect inQuestion
                else
                    redirect action:"index", method:"GET"
            }
            '*' { respond inComment, [status: httpStatus] }
        }

    }

}
