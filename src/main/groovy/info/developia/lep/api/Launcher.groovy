package info.developia.lep.api

import com.google.inject.Guice
import com.google.inject.Injector
import groovy.transform.CompileStatic
import info.developia.lep.api.controller.ComposeController
import info.developia.lep.api.repository.ComposeRepository
import info.developia.lep.api.service.ComposeService

import static spark.Spark.get

@CompileStatic
class Launcher {
    static void main(String[] args) {
        Injector injector = Guice.createInjector()
        ComposeController composeController = injector.getInstance(ComposeController)
        ComposeService composeService = injector.getInstance(ComposeService)
        ComposeRepository composeRepository = injector.getInstance(ComposeRepository)

        get("/composes/all", { req, res -> composeController.getAll(req, res) })
    }
}
