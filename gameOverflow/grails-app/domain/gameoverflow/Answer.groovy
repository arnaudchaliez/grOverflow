package gameoverflow

class Answer extends Message {

    int score = 0

    static hasOne = [question:Question]

    static constraints = {
    }
}
