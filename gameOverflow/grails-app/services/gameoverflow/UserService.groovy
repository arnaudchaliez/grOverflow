package gameoverflow

import grails.transaction.Transactional
import jline.internal.Log
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

    /**
     * return the top users.
     * @param number limit the users returned
     */
    def listTopUsers(int inMax) {
        def users = User.findAllByMailIsNotNull(sort: "score", order: "desc", max: inMax)
        return users.toList()
    }

    /**
     * return the questions associated to the user.
     * @param User user to get the questions
     */
    def listQuestionsUser(User user) {
        return Question.findAllByAuthor(user);
    }

    /**
     * return the answers associated to the user.
     * @param User user to get the questions
     */
    def listAnswersUser(User user) {
        return Answer.findAllByAuthor(user);
    }

    /**
     * return the tags associated to the user.
     * @param User user to get the questions
     */
    def listTagsUser(User user) {
        return Tag.findAllByAuthor(user);
    }

    def listBadgesUser(User user) {
        return user.getBadges()
    }

    def getUserConnected()
    {
        User user = null
        if (springSecurityService.isLoggedIn())
            user = User.get(springSecurityService.principal.id)

        return user
    }

    def updateScore(User inUser, int inWeight) {
       inUser.score += inWeight
       inUser.gold += 10 * inWeight
    }

    def registerUser(User inUser) {
        inUser.dateRegistration = new Date()
        inUser.validate()
        if (inUser.hasErrors()) {
            log.error('error registering user, user still have errors :')
            log.error(inUser)
            return -1
        } else {
            def role = Role.findByAuthority('ROLE_USER')

            if (role) {
                inUser.save(failOnError: true)

                UserRole.create(inUser, role)
            }
            else {
                log.error('error registering user, role ROLE_USER not found.')
                return -2
            }
        }

        return 0
    }
}
