package gameoverflow

class Question extends Message {

    int views
    String title

    List<Tag> tags
    List<Answer> answers = null

    static constraints = {
        title(title: false)
        views(defaultValue: "0")
    }
}
