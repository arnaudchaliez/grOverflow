package gameoverflow

class Comment extends Message {

    Boolean commentAuthorize = false

    static hasOne = [message: Message]

    static constraints = {
    }

    static mapping = {
        sort date: "asc"
    }
}
