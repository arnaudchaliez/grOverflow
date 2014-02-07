package gameoverflow

class BadgeController {

    def badgeService

    def index() {
    }

    def shop() {
        def badges = badgeService.listBadgesShop(100)
        [badges: badges]
    }

}
