package gameoverflow

import grails.converters.JSON
import grails.converters.XML

class TagController {

    def tagService

    def index() {}

    def popularTags() {
        int max = grailsApplication.config.gameoverflow.tag.popularMax
        def tagsList = tagService.listPopularTags(max)

        withFormat {
            html tagsList: tagsList
            json { render tagsList as JSON }
            xml { render tagsList as XML }
        }
    }
}
