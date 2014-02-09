package gameoverflow

import grails.transaction.Transactional


@Transactional
class VoteService {

    def userService

    def insertVote(Vote inVote) {
        if( inVote.type == Vote.Type.DOWN )
            inVote.message.score--
        else if( inVote.type == Vote.Type.UP )
            inVote.message.score++

        inVote.validate()

        inVote.message.validate()
        if ( !inVote.hasErrors() ) {
            inVote.save(failOnError: true)
        } else {
            println("Fail when creating new vote")
            inVote.errors.allErrors.each {
                println it
            }
        }
    }

    def deleteVote(Vote inVote) {
        if( inVote.type == Vote.Type.DOWN )
            inVote.message.score++
        else if( inVote.type == Vote.Type.UP )
            inVote.message.score--

        inVote.message.validate()
        inVote.delete()
    }

    def updateVote(Vote inVote, Vote.Type inVoteType) {
        if(inVote.type == inVoteType)
            deleteVote(inVote)
        else
        {
            if( inVoteType == Vote.Type.UP )
                inVote.message.score+=2
            else if( inVoteType == Vote.Type.DOWN )
                inVote.message.score-=2

            inVote.type = inVoteType
            inVote.date = new Date()

            inVote.message.validate()
            inVote.validate()
        }
    }

    /**
     * Method that permits to add a vote to a message associated to the connected user.
     * @param inMessageId id of the message to add the vote.
     * @param inType type of the vote (UP, DOWN or VALIDATE)
     */
    def createVote(int inMessageId, Vote.Type inVoteType) {
        log.info('service vote, createVote called with the question : ' + inMessageId + 'and type :' + inVoteType)

        User user = userService.getUserConnected()
        Message message = Message.get(inMessageId)
        if(user && message) {
            Vote vote = Vote.findByAuthorAndMessage(user, message)
            if( vote != null ) {
                updateVote(vote, inVoteType)
            } else {
                vote =  new Vote(
                        date: new Date(),
                        author: user,
                        type: inVoteType,
                        message: message
                )
                insertVote(vote)
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
