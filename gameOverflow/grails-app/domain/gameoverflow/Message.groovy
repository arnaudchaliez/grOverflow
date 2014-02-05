package gameoverflow

import org.springframework.security.core.context.SecurityContextHolder;
import gameoverflow.User

abstract class Message {

    String content
    Date date

    List<Message> messages

    static hasMany = [votes: Vote]

    static belongsTo = [author: User]

    static constraints = {
        content(blank: false, length: 2..2000)
        author(blank: false)
        date(blank: false)
    }

}
