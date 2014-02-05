package gameoverflow

class Question extends Message {

    int views
    String title
    int score = 0

    static hasMany = [answers: Answer, tags: Tag]
    static searchable = true

    static constraints = {
        title(title: false)
        views(defaultValue: "0")
    }
}
