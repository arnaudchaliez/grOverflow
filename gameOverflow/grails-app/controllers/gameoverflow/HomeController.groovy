package gameoverflow

import grails.plugin.springsecurity.annotation.Secured

class HomeController {

    def questionService
    def userService

    @Secured('permitAll')
    def index() {
        int maxQuestions = grailsApplication.config.gameoverflow.question.index.max
        int topUsers     = grailsApplication.config.gameoverflow.user.index.max

        def listRecentQuestions = questionService.listRecentQuestions(maxQuestions)
        def listTopUsers        = userService.listTopUsers(topUsers)

        def user = userService.userConnected;

        [listRecentQuestions: listRecentQuestions, listTopUsers: listTopUsers, idUser: user?.id]
    }
}
