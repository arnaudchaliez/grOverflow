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
}
