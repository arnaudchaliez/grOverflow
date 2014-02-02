package gameoverflow

import grails.converters.JSON
import grails.transaction.Transactional

@Transactional
class TagService {

    def userService

    /**
     * parse the string of the tags and return an array.
     * @param String tags to parse
     */
    def parseStrTags(String inTags) {
        def tags
        if (!inTags.empty)
        {
            tags = inTags.split(",")
            log.info('parse tags :' + tags)
        }
        return tags
    }

    /**
     * return the tag associated to the name if exists, create it otherwise.
     * @param String name of the tag to get
     */
    def getTag(String inTagStr) {
        Tag tag
        if (!inTagStr.empty) {
            tag = Tag.findByName(inTagStr)
            if (tag == null) {
                tag = new Tag(
                        name: inTagStr,
                        author: userService.getUserConnected(),
                        date: new Date()
                ).save(failOnError: true)
            }
            tag.number++
            Tag.Total++
        }
        return tag
    }

    /**
     * return the recent tags.
     * @param number limit the tags returned
     */
    def listRecentTags(int inMax) {
        return Tag.list(sort: "date", order: "desc", max:inMax)
    }

    /**
     * return a list of popular tags.
     * @param number limit the questions returned
     */
    def listPopularTags(int inMax) {
        return Tag.list(sort: "number", order: "desc", max:inMax)
    }


}
