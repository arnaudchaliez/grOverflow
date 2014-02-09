package gameoverflow

class VoteTagLib {
    static defaultEncodeAs = 'raw'
    def userService

    def voteForm = { attrs, body ->
        if (attrs.idMessage && attrs.typeMessage) {
            User user = userService.getUserConnected();
            Vote.Type voted = null
            if(user) {
                Message msg = Message.get(attrs.idMessage);
                Vote vote = msg.votes.find { v -> v.author == user };
                if(vote)
                    voted = vote.type;
            }
            println( voted );
            out << render(template:"/vote/voteForm", model:[score: body(), idQuestion: attrs.idQuestion, idMessage: attrs.idMessage, types: Vote.Type, typeMessage: attrs.typeMessage, voted: voted] )
        }
        else {
            log.error('taglig vote walled without idMessage')
        }
    }
}
