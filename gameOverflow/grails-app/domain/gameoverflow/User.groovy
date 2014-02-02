package gameoverflow

import security.*

class User {

    transient springSecurityService

    /** general informations */
    String lastname
    String firstname
    String username
    String mail
    String bio=""
    Date dateRegistration

    int score
    List<Badge> badges = null

    /** security informations */
    String password
    boolean enabled = true
    boolean accountExpired
    boolean accountLocked
    boolean passwordExpired

    static constraints = {
        lastname(blank: false)
        firstname(blank: false)
        username(blank: false, size: 3..15, unique: true)
        password (blank: false)
        dateRegistration(blank: false)
    }

    //increase performances, see spring documentation
    static mapping = {
        username column: '`username`'
        password column: '`password`'
    }

    Set<Role> getAuthorities() {
        UserRole.findAllByUser(this).collect { it.role } as Set
    }

    def beforeInsert() {
        encodePassword()
    }

    def beforeUpdate() {
        if (isDirty('password')) {
            encodePassword()
        }
    }

    protected void encodePassword() {
        password = springSecurityService.encodePassword(password)
    }
}
