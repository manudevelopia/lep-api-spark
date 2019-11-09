package info.developia.lep.api.service

import info.developia.lep.api.repository.ComposeRepository
import spock.lang.Specification

class ComposeServiceTest extends Specification {

    ComposeRepository composeRepository
    ComposeService composeService

    def setup() {
        composeRepository = Mock()
        composeService = new ComposeServiceImpl(composeRepository)
    }

    def "Should return all composes"(){
        given:
        composeRepository.getAll() >> "<h2>Hello world!!</h2>"
        when:
        def result = composeService.getAll()
        then:
        result == "<h2>Hello world!!</h2>"
    }

}
