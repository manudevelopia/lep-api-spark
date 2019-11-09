package info.developia.lep.api.controller

import spock.lang.*

class ComposeControllerTest extends Specification {

    def "test get All"() {
        when:
        def result = ComposeController.getAll("req", "res")

        then:
        result == "<h2>Hello world!!</h2>"
    }
}
