package gameoverflow

class Tag {

    static int Total = 0

    String name
    String category = "general"
    String description = ""
    int number = 0
    User author
    Date date

    static hasMany = [questions: Question]
    static belongsTo = [Question]

    static constraints = {
    }
}
