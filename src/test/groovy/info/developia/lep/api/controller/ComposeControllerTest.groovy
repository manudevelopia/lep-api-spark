package info.developia.lep.api.controller

import info.developia.lep.api.service.ComposeService
import spock.lang.Specification

class ComposeControllerTest extends Specification {
    ComposeController composeController
    ComposeService composeService

    def setup() {
        composeService = Mock()
        composeController = new ComposeController(composeService)
    }

    def "test get All"() {
        given:
        composeService.getAll() >> "<h2>Hello world!!</h2>"
        when:
        def result = composeController.getAll("req", "res")
        then:
        result == "<h2>Hello world!!</h2>"
    }
}
