package gameoverflow

import grails.transaction.Transactional

@Transactional
class UserService {

    def getUser(int inId) {
        return User.get(inId)
    }

    def createUser(String inLastName, String inFirstName, String inPseudo, String inMail)
    {
        User user = new User(
                lastname: inLastName,
                firstname: inFirstName,
                pseudo: inPseudo,
                mail: inMail,
                dateRegistration: new Date(),
                type: User.TypeUser.NORMAL
        ).save(failOnError: true)
        return user
    }

    def sayHello(int inId) {

        List<User> users = User.getAll();
        User user = User.get(inId)
        if (user)
            return  "Hello " + user.pseudo
        else return users.get(0).id
    }
}
