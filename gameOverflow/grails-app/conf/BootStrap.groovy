import gameoverflow.Badge
import gameoverflow.Comment
import gameoverflow.User
import gameoverflow.Question
import gameoverflow.Tag
import gameoverflow.Answer

import security.*

class BootStrap {
    def questionService
    def userService

    def init = { servletContext ->
        def roleAdmin = new Role(authority: 'ROLE_ADMIN').save(failOnError:true)
        def roleUser = new Role(authority: 'ROLE_USER').save(failOnError:true)

        def userAdmin = new User(username: 'admin', dateRegistration: new Date(), birthday: new Date(), bio: ':)', password: 'admin', lastname: 'admin', firstname: 'admin', mail: 'arnaudchlz@gmail.com', enabled: true)
        userAdmin.save(failOnError:true)
        def userKinoko = new User(username: 'Kinoko', dateRegistration: new Date(), birthday: new Date(), bio: ':)', password: 'kinoko', lastname: 'Chaliez', firstname: 'Arnaud', mail: 'arnaudchlzd@gmail.com', enabled: true)
        userKinoko.save(failOnError:true)
        def userBondika = new User(username: 'Bondika', dateRegistration: new Date(), birthday: new Date(), password: 'bondika', lastname: 'Bouny', firstname: 'Jérémy', mail: 'jbouny@gmail.com', enabled: true)
        userBondika.save(failOnError:true)

        UserRole.create(userAdmin, roleAdmin)
        UserRole.create(userKinoko, roleUser)
        UserRole.create(userBondika, roleUser)

        Tag t1 = new Tag(
                name: 'Playstation',
               // description: 'The PlayStation, officially abbreviated as PS, at the time referred to as PSX (not to be confused with the PSX console) and also more commonly known as PS1 is a 32-bit video game console first released by Sony Computer Entertainment in Japan on December 3, 1994 with Western releases in September 1995.',
                author: userBondika,
                date: new Date(),
                category: 'console'
                )
        t1.save(failOnError:true)

        Tag t2 = new Tag(
                name: 'SNES',
               // description: 'The Super Nintendo Entertainment System (also known as the Super NES, SNES or Super Nintendo) is a 16-bit video game console developed by Nintendo that was released in 1990 in Japan, 1991 in North America, 1992 in Europe and Australasia (Oceania), and South America in 1993.',
                author: userKinoko,
                date: new Date(),
                category: 'console'
        )
        t2.save(failOnError:true)

        Tag t3 = new Tag(
                name: 'Mario',
               // description: 'Mario (Japanese: マリオ Hepburn: Mario?) is a fictional character in the Mario video game franchise by Nintendo, created by Japanese video game designer Shigeru Miyamoto.',
                author: userKinoko,
                date: new Date(),
                category: 'videogame'
        )
        t3.save(failOnError:true)

        Question q1 = new Question(
                author: userAdmin,
                date: new Date(),
                title: 'Why mario was not release on Playstation ? ',
                content: '<p> troll :) </p>'
        )
        q1.addToTags(t3)
        q1.addToTags(t1)

        q1.save(failOnError: true)

        Question q2 = new Question(
                author: userBondika,
                date: new Date(),
                title: 'How did we defeat Bowser ?',
                content: '<p>i\'m too bad ...</p>'
        )
        q2.addToTags(t2)
        q2.addToTags(t3)

        q2.save(failOnError: true)

        Answer a1 = new Answer(
                author: userKinoko,
                date: new Date(),
                question: q2,
                content: 'catch his nail !'
        )
        a1.save(failOnError: true)

        Comment c1 = new Comment(
                author: userBondika,
                date: new Date(),
                message: a1,
                content: 'Thanks you\'re so smart !'
        )
        c1.save(failOnError: true)


        /** badges */

        Badge b1 = new Badge(
            category: Badge.Category.SHOP,
            name: "CakeLie",
            description: "The cake is a lie",
            picture: 'cakePortal.jpg',
            price: 9999999
        )
        b1.save(failOnError: true)

        Badge b2 = new Badge(
                category: Badge.Category.SHOP,
                name: "Navi",
                description: "Hey listen !",
                picture: 'naviZelda.jpg',
                price: 10
        )
        b2.save(failOnError: true)

        userKinoko.addToBadges(b1)
        userKinoko.save()
    }
    def destroy = {
    }
}
