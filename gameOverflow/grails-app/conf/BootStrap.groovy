import gameoverflow.User
import gameoverflow.Question

class BootStrap {
    def questionService
    def userService

    def init = { servletContext ->
        //create users
        User kinoko = userService.createUser("Chaliez", "Arnaud", "Kinoko", "truc@gmail.com")
        User bondika = userService.createUser("Bouny", "Jérémy", "Bondika", "bondika@truc.com")

        Question q1 = questionService.addQuestion("essai", "Does it work ?", kinoko)
        Question q2 = questionService.addQuestion("essai2", "Maybe ?", bondika)
    }
    def destroy = {
    }
}
