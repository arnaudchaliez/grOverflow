package gameoverflow

class Badge {

    enum Category {
        CONNEXION,
        QUESTION,
        COMMENT,
        ANSWER
    }

    String name
    String description
    String picture
    Category category
    int price = 0

    static constraints = {
        name(blank: false)
        description(blank: false)
    }
}
