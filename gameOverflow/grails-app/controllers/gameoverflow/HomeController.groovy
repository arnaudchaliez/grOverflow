package gameoverflow

import grails.plugin.springsecurity.annotation.Secured

class HomeController {

    def questionService

    @Secured('permitAll')
    def index() {
        int max = grailsApplication.config.gameoverflow.question.max
        def listRecentQuestions = questionService.listRecentQuestions(max)

        [listRecentQuestions: listRecentQuestions]
    }
}
