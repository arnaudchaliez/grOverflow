package gameoverflow

abstract class Message {

    String content
    Date date

    int score = 0

    Boolean commentAuthorize = false

    static hasMany = [votes: Vote, comments: Comment]

    static belongsTo = [author: User]

    static constraints = {
        content(blank: false, length: 2..2000)
        author(blank: false)
        date(blank: false)
    }

    static mapping = {
        comments sort: "date", order: "asc"
    }

}
