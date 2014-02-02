package gameoverflow

class Badge {

    String name
    String description

    static constraints = {
        name(blank: false)
        description(blank: false)
    }
}
