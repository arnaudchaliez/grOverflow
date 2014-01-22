package gameoverflow

class User {

    enum TypeUser {
        NORMAL,
        MODERATOR,
        ADMINISTRATOR
    }

    String lastname
    String firstname
    String pseudo
    String mail
    Date dateRegistration
    int score
    TypeUser type

    static constraints = {
        lastname(blank: false)
        firstname(blank: false)
        pseudo(blank:false, size: 3..15)
        dateRegistration(blank:false)
    }
}
