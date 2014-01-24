package gameoverflow

import grails.transaction.Transactional
import security.Role
import security.UserRole

@Transactional
class UserService {

    def getUser(int inId) {
        return User.get(inId)
    }

    def sayHello(int inId) {

        List<User> users = User.getAll();
        User user = User.get(inId)
        if (user)
            return  "Hello " + user.username
        else return users.get(0).id
    }
}
