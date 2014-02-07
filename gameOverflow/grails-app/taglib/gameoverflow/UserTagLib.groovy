package gameoverflow

class UserTagLib {
    static defaultEncodeAs = 'raw'

    def userService

    /*def isOwner = { attrs, body ->
        def loggedInUser = userService.userConnected
        def owner = attrs?.owner

        if(loggedInUser?.id == owner?.id) {
            out << body()
        }
    }

    def getUserMail = { attrs, body ->
        def loggedInUser = userService.userConnected

        if(loggedInUser) {
            out << loggedInUser.mail
        }
    }*/

    def renderUser = { attrs, body ->
        def user = userService.userConnected

        if(user) {
            out << render(template:"/user/userThumbnailNav", model:[user: user])
        }
    }

}
