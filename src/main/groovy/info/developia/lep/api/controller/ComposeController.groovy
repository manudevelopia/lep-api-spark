package info.developia.lep.api.controller

import info.developia.lep.api.service.ComposeService

class ComposeController {
    static def getAll(req, res) {
        ComposeService.getAll()
    }
}
