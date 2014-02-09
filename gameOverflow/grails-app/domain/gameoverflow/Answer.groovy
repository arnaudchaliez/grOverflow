package gameoverflow

class Answer extends Message {

    static hasOne = [question:Question]

    static constraints = {
    }

    boolean bestAnswer = false

    static mapping = {
        sort score: "desc"
    }
}
