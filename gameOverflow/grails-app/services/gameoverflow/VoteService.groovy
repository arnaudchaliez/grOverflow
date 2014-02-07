package gameoverflow

import grails.transaction.Transactional


@Transactional
class VoteService {

    def userService

    /**
     * Method that permits to add a vote to a message associated to the connected user.
     * @param inMessageId id of the message to add the vote.
     * @param inType type of the vote (UP, DOWN or VALIDATE)
     */
    def createVote(int inMessageId, String inType) {
        log.info('service vote, createVote called with the question : ' + inMessageId + 'and type :' + inType)

        User user = userService.getUserConnected()
        if (user) {
            Vote vote =  new Vote(
                    date: new Date(),
                    author:user,
                    type: inType,
                    message: Message.get(inMessageId)
            )
            vote.validate()
            if ( !vote.hasErrors() ) {
                vote.save(failOnError: true)
            }
            else {
                log.error('trying to create vote with errors')
            }
        }
    }

    /**
     * Return an EnumSet that contains the possibilities of votes (Type)
     *
     * @param inMessageId id of the message to get the possibilities of vote
     * @return voteTypes EnumSet that contains all the type of the votes that are authorized
     */
    def canUserConnectedVote(long inMessageId) {
        EnumSet voteTypes = EnumSet.of(Vote.Type.UP, Vote.Type.DOWN, Vote.Type.VALIDATE);
        def user = userService.getUserConnected()

        if (user) {
            def query = Vote.where {
                id == inMessageId && author.id == user.id
            }
            def votes = query.findAll()
            println(votes)
            if (votes) {
                log.info('canUserConnectedVote, vote(s) found : ' + votes)

                def votesMessageTypes = EnumSet.noneOf(Vote.Type)
                votes.each() {
                    votesMessageTypes.add(it.type)
                    println('raaa ' + it.type)
                }
                voteTypes = EnumSet.complementOf(votesMessageTypes)

                log.info('types vote authorized : ' + voteTypes)
            }
            /*else {
                log.info('no vote found')
            }*/

        }
        return voteTypes
    }
}
