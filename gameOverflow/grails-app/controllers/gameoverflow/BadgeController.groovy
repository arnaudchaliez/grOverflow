package gameoverflow

import grails.plugin.springsecurity.annotation.Secured

class BadgeController {

    def badgeService
    def userService

    @Secured(['ROLE_ADMIN', 'ROLE_USER'] )
    def shop() {
        def listBadges = badgeService.listBadgesShop(100)
        println(listBadges)
        [badges: listBadges]
    }

    @Secured(['ROLE_ADMIN', 'ROLE_USER'] )
    def buy(Badge inBadge) {
        def strcode = ""
        if (inBadge) {
            User user = userService.getUserConnected()

            if (user.gold >= inBadge.price) {
                user.addToBadges(inBadge)
                user.gold -= inBadge.price
                user.save(failOnError: true)
            }
            else {
                log.info('user ' + user.username + ' cannot buy badge ' + inBadge.name)
                strcode='shop.buy.cannot'
            }
        }
        else {
            log.error('buy called with a null object')
            strcode='method.call.nullobject'
        }

        request.withFormat {

            form {
                flash.message = message(code: strcode)
                redirect action:"shop", method:"GET"
            }
            '*' { respond inBadge, [status: httpStatus] }
        }

    }

}
