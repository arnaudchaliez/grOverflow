package gameoverflow

import grails.transaction.Transactional

@Transactional
class BadgeService {

    /**
     * return the badges with SHOP category.
     * @param number limit the badges returned
     */
    def listBadgesShop(int inMax) {
        def badges = Badge.findAllByCategory(Badge.Category.SHOP)
        return badges.toList()
    }

}
