package cms

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString
import grails.compiler.GrailsCompileStatic

@GrailsCompileStatic
@EqualsAndHashCode(includes='username')
@ToString(includes='username', includeNames=true, includePackage=false)
class User implements Serializable {

    private static final long serialVersionUID = 1

    String rut
    String nombre
    String paterno
    String materno
    String username
    String password
    String email
    boolean enabled = true
    boolean accountExpired
    boolean accountLocked
    boolean passwordExpired

    Set<Role> getAuthorities() {
        (UserRole.findAllByUser(this) as List<UserRole>)*.role as Set<Role>
    }

    static constraints = {
        rut unique: true
        nombre nullable: true, blank: true
        paterno nullable: true, blank: true
        materno nullable: true, blank: true
        password nullable: false, blank: false, password: true
        username nullable: false, blank: false, unique: true
        email nullable: true, blank: true, unique: true
    }

    //static mapping = {
	//    rut column: '`rut`'
    //}
}
