package cms

import grails.plugin.springsecurity.annotation.Secured
import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

@Secured('ROLE_ADMIN')
class UserController {

    UserService userService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max, Long id) {
        params.max = Math.min(max ?: 10, 100)
        //respond userService.list(params), model:[userCount: userService.count()]


        if(params.id!=null){
            respond userService.get(id), model:[userCount: userService.count(), userList:userService.list()]
        }else{
            respond new User(params), model:[userCount: userService.count(), userList: userService.list()]
        }
    }

    def show(Long id) {
        respond userService.get(id)
    }

    def create() {
        respond new User(params)
    }

    def save(User user) {
        if (user == null) {
            notFound()
            return
        }

        try {
            userService.save(user)
        } catch (ValidationException e) {
            respond user.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'user.label', default: 'User'), user.id])
                redirect(controller:"user", action: "index")
            }
            '*' { respond user, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond userService.get(id)
    }

    def update(User user) {
        if (user == null) {
            notFound()
            return
        }

        try {
            userService.save(user)
        } catch (ValidationException e) {
            respond user.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'user.label', default: 'User'), user.id])
                redirect(controller:"user", action: "index")
            }
            '*'{ respond user, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        userService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'user.label', default: 'User'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    def eliminar(){
        def loggedUserInfo = User.findByUsername(sec.username())
        def loggedUserId = loggedUserInfo.id
        def user = User.get(params.id)

        if(user.id != loggedUserId){
            int roleUser = UserRole.countByUser(user)
            if(roleUser>0){
                flash.message = "Error: Este usuario tiene "+roleUser+" asignados, elimine los roles primero."
            } else {
                user.delete(flush:true)
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'user.label', default: 'User'), user.id, user.nombre, user.paterno, user.materno])
            }
        } else {
            flash.message = "Ouch! No puede eliminar su propia cuanta."
        }

        switch (params.r){
            case 'alumnoIndex': redirect(controller: "alumno", action: "index"); break
            default: redirect (controller: "user", action: "index")
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'user.label', default: 'User'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
