import gameoverflow.User
import gameoverflow.Question
import security.*

class BootStrap {
    def questionService
    def userService

    def init = { servletContext ->
        def roleAdmin = new Role(authority: 'ROLE_ADMIN').save(failOnError:true)
        def roleUser = new Role(authority: 'ROLE_USER').save(failOnError:true)

        def userAdmin = new User(username: 'admin', dateRegistration: new Date(), password: 'admin', lastname: 'admin', firstname: 'admin', mail:'arnaudchlz@gmail.com', enabled: true)
        userAdmin.save(failOnError:true)
        def userKinoko = new User(username: 'Kinoko', dateRegistration: new Date(), password: 'kinoko', lastname: 'Chaliez', firstname: 'Arnaud', mail:'arnaudchlz@gmail.com', enabled: true)
        userKinoko.save(failOnError:true)
        def userBondika = new User(username: 'Bondika', dateRegistration: new Date(), password: 'bondika', lastname: 'Bouny', firstname: 'Jérémy', mail:'bondika@truc.com', enabled: true)
        userBondika.save(failOnError:true)

        UserRole.create(userAdmin, roleAdmin)
        UserRole.create(userKinoko, roleUser)
        UserRole.create(userBondika, roleUser)

        Question q1 = questionService.addQuestion("essai", "Does it work ?", userAdmin)
        Question q2 = questionService.addQuestion("essai2", "Maybe ?", userAdmin)
    }
    def destroy = {
    }
}
