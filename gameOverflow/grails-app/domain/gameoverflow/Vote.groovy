package gameoverflow

class Vote {

    enum Type{
        UP,
        DOWN,
        VALIDATE
    }

    Type type
    String date
    static hasOne = [author: User, message: Message]

    static constraints = {
    }
}
