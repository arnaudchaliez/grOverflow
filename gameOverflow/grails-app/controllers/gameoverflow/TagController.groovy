package gameoverflow

import grails.converters.JSON
import grails.converters.XML
import grails.plugin.springsecurity.annotation.Secured

class TagController {

    def tagService
    def questionService
    def userService

    @Secured('permitAll')
    def index() {
        int max = grailsApplication.config.gameoverflow.tag.popularMax
        def tagsList = tagService.listPopularTags(max)

        [tagsList: tagsList, maxTags:max]
    }

    @Secured('permitAll')
    def popularTags() {
        int max = grailsApplication.config.gameoverflow.tag.popularMax
        def tagsList = tagService.listPopularTags(max)

        withFormat {
            html tagsList: tagsList
            json { render tagsList as JSON }
            xml { render tagsList as XML }
        }
    }

    @Secured('permitAll')
    def show() {
        Tag tag = tagService.getTag(params.getAt("id"))

        int maxQuestions = grailsApplication.config.gameoverflow.question.index.max
        int topUsers     = grailsApplication.config.gameoverflow.user.index.max

        def listQuestions = tagService.getTagQuestions(tag)
        def listTopUsers  = userService.listTopUsers(topUsers)

        def user = userService.userConnected

        [tag: tag, listQuestions: listQuestions, listTopUsers: listTopUsers, idUser: user?.id]
    }
}
