package gameoverflow

import grails.transaction.Transactional
import org.springframework.security.core.context.SecurityContextHolder
import security.Role
import security.UserRole

@Transactional
class UserService {

    def springSecurityService

    def getUser(int inId) {
        return User.get(inId)
    }

    def getUserByUsername(String inUsername) {
        return User.get(inUsername)
    }

    def getUserConnected()
    {
        User user = null
        if (springSecurityService.isLoggedIn())
            user = User.get(springSecurityService.principal.id)

        return user
    }

}
