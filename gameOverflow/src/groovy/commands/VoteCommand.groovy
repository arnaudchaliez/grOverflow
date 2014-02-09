package commands

@grails.validation.Validateable
class VoteCommand {
    int id
    int idQuestion
    String typeMessage
    gameoverflow.Vote.Type typeVote

    static constraints = {
        id(blank: false)
        idQuestion(blank: false)
        typeMessage(blank: false)
        typeVote(blank: false)
    }
}
