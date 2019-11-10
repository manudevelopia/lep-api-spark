package info.developia.lep.api

import com.google.inject.Guice
import com.google.inject.Injector
import groovy.transform.CompileStatic
import info.developia.lep.api.config.BeanModule
import info.developia.lep.api.config.PersistenceModule
import info.developia.lep.api.controller.ComposeController
import org.mybatis.guice.datasource.helper.JdbcHelper

import static spark.Spark.get

@CompileStatic
class Launcher {
    static void main(String[] args) {
        Injector injector = Guice.createInjector(new BeanModule(), JdbcHelper.PostgreSQL, new PersistenceModule())

        ComposeController composeController = injector.getInstance(ComposeController)

        get("/composes/all", { req, res -> composeController.getAll(req, res) })
    }
}
