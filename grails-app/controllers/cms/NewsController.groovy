package cms

import grails.plugin.springsecurity.annotation.Secured

class NewsController {

    @Secured('permitAll')
    def index() { }

    @Secured('permitAll')
    def show() { }

    @Secured('permitAll')
    def create() { }
}
