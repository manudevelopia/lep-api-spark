package info.developia.lep.api

import com.google.inject.Guice
import com.google.inject.Injector
import groovy.transform.CompileStatic
import info.developia.lep.api.controller.ComposeController
import info.developia.lep.api.repository.ComposeRepository
import info.developia.lep.api.repository.ComposeRepositoryImpl
import info.developia.lep.api.service.ComposeService
import info.developia.lep.api.service.ComposeServiceImpl

import static spark.Spark.get

@CompileStatic
class Launcher {
    static void main(String[] args) {
        Injector injector = Guice.createInjector(new Module())
        ComposeController composeController = injector.getInstance(ComposeController)
        ComposeService composeService = injector.getInstance(ComposeServiceImpl)
        ComposeRepository composeRepository = injector.getInstance(ComposeRepositoryImpl)

        get("/composes/all", { req, res -> composeController.getAll(req, res) })
    }
}
