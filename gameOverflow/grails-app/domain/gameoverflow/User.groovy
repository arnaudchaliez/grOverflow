package gameoverflow

import security.*

class User {

    transient springSecurityService

    /** general informations */
    String lastname
    String firstname
    String username
    String mail
    Date dateRegistration

    /** complementar informations */
    String bio = ""
    String website = ""
    String country = ""
    String city = ""
    Date birthday

    int score = 0
    int gold = 0
    List<Badge> badges = null

    static hasMany = [votes: Vote]

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
        birthday(blank: false)
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
