package gameoverflow

class Answer extends Message {

    static hasOne = [question:Question]

    static constraints = {
    }
}
