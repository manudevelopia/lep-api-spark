package info.developia.lep.api.controller

import com.google.inject.Inject
import info.developia.lep.api.service.ComposeService

class ComposeController {
    private final ComposeService composeService

    @Inject
    ComposeController(ComposeService composeService) {
        this.composeService = composeService
    }

    def getAll(req, res) {
        composeService.getAll()
    }
}
