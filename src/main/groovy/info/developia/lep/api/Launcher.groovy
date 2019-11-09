package info.developia.lep.api

import groovy.transform.CompileStatic
import info.developia.lep.api.controller.ComposeController

import static spark.Spark.get

@CompileStatic
class Launcher {
    static void main(String[] args) {
        get("/composes/all", { req, res -> ComposeController.getAll(req, res) })
    }
}
