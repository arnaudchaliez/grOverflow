package gameoverflow

abstract class Message {

    String content
    int score
    User author
    Date date

    List<Message> messages

    static constraints = {
        content(blank: false)
        score(defaultValue: "0")
        author(blank: false)
        date(blank: false)
    }
}
