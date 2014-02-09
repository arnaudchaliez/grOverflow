package gameoverflow

class Answer extends Message {

    static hasOne = [question:Question]

    static constraints = {
        content(blank: false, length: 2..1500)
    }

    boolean bestAnswer = false

    static mapping = {
        sort score: "desc"
    }
}
