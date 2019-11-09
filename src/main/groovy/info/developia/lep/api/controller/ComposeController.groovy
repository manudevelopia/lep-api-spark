package info.developia.lep.api.controller

import com.google.gson.Gson
import com.google.inject.Inject
import groovy.transform.CompileStatic
import info.developia.lep.api.service.ComposeService
import spark.Request
import spark.Response

@CompileStatic
class ComposeController {
    private final ComposeService composeService

    @Inject
    ComposeController(ComposeService composeService) {
        this.composeService = composeService
    }

    def getAll(Request req, Response res) {
        def composes = composeService.getAll()
        res.type("application/json");
        new Gson().toJson(composes)
    }
}
