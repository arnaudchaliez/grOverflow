package gameoverflow

class Question extends Message {

    int views
    String title

    static hasMany = [answers: Answer, tags: Tag]
    static searchable = true

    static constraints = {
        title(title: false)
        views(defaultValue: "0")
    }
}
