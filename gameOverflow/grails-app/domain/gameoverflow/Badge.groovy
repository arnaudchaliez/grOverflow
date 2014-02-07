package gameoverflow

class Badge {

    enum Category {
        CONNEXION,
        QUESTION,
        COMMENT,
        ANSWER,
        SHOP
    }

    String name
    String description
    String picture
    Category category
    int price = 0

    static hasMany = User

    static constraints = {
        name(blank: false)
        description(blank: false)
    }
}
