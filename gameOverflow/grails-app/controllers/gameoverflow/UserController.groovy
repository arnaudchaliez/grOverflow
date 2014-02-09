package gameoverflow

import org.springframework.security.access.annotation.Secured

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class UserController {

    def userService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    @Secured('permitAll')
    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond User.list(params), model:[userInstanceCount: User.count()]
    }

    @Secured('permitAll')
    def show(User userInstance) {

        def listQuestions   = userService.listQuestionsUser(userInstance)
        def listAnswers     = userService.listAnswersUser(userInstance)
        def listTags        = userService.listTagsUser(userInstance)
        def listBadges      = userService.listBadgesUser(userInstance)

        respond userInstance, model:[listQuestions: listQuestions, listAnswers: listAnswers, listBadges: listBadges, listTags: listTags]
    }

    @Secured('permitAll')
    def create() {
        respond new User(params)
    }

    @Secured('permitAll')
    def save(User inUser) {
        processAction(inUser, 'insert')
    }

    @Transactional
    def update(User inUser) {
        processAction(inUser, 'update')
    }

    @Transactional
    def delete(User inUser) {
        processAction(inUser, 'delete')
    }

    @Secured('permitAll')
    @Transactional
    protected void processAction(User inUser, String inAction)
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

        if (inUser == null) {
            notFound()
            return
        }

        if (inAction != 'delete') {
            if ( userService.registerUser(inUser)!=0 ) {
                respond inUser.errors, view:strview
            }
        }
        else
        {
            userService.deleteUser(inUser)
        }

        request.withFormat {
            form {
                flash.message = message(code: strcode, args: [message(code: 'user.label', default: 'User'), inUser.id])

                if (inAction != 'delete')
                    redirect inUser
                else
                    redirect action:"index", method:"GET"
            }
            '*' { respond inUser, [status: httpStatus] }
        }


    }

    protected void notFound() {
        request.withFormat {
            form {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'user.label', default: 'User'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}