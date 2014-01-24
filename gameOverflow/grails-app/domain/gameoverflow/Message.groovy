package gameoverflow

import org.springframework.security.core.context.SecurityContextHolder;
import gameoverflow.User

abstract class Message {

    String content
    int score
    User author
    Date date

    List<Message> messages

    static constraints = {
        content(blank: false, length: 2..2000)
        score(defaultValue: "0")
        author(blank: false)
        date(blank: false)
    }
}
