package cms

class BootStrap {

    def init = { servletContext ->
        log.info('Init BootStrap')
        def superRole = new Role(authority: 'ROLE_ADMIN').save(failOnError: true)
        def superUser = new User(username: 'me', password: 'password').save(failOnError: true)

        UserRole.create superUser, superRole

        UserRole.withSession {
            it.flush()
            it.clear()
        }
        log.info('...End BootStrap')
    }
    def destroy = {
    }
}
