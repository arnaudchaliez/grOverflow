package gameoverflow

class VoteTagLib {
    static defaultEncodeAs = 'raw'

    def voteForm = { attrs, body ->
        if (attrs.idMessage) {
            out << render(template:"/vote/voteForm", model:[score: body(), idMessage: attrs.idMessage, types: Vote.Type], typeMessage: attrs.type)
        }
        else {
            log.error('taglig vote walled without idMessage')
        }
    }
}
