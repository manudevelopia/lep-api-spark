package info.developia.lep.api

import com.google.inject.Guice
import com.google.inject.Injector
import groovy.transform.CompileStatic
import info.developia.lep.api.config.Persistence
import info.developia.lep.api.controller.ComposeController
import info.developia.lep.api.mapper.ComposeMapper
import info.developia.lep.api.model.Compose
import info.developia.lep.api.repository.ComposeRepository
import info.developia.lep.api.repository.ComposeRepositoryImpl
import info.developia.lep.api.service.ComposeService
import info.developia.lep.api.service.ComposeServiceImpl
import org.apache.ibatis.session.SqlSession

import static spark.Spark.get

@CompileStatic
class Launcher {
    static void main(String[] args) {
        Injector injector = Guice.createInjector(new Module())

        ComposeController composeController = injector.getInstance(ComposeController)
        ComposeService composeService = injector.getInstance(ComposeServiceImpl)
        ComposeRepository composeRepository = injector.getInstance(ComposeRepositoryImpl)

        SqlSession session = new Persistence().getSqlSessionFactory().openSession()

        ComposeMapper mapper= session.getMapper(ComposeMapper)

        List<Compose> result = mapper.getAll()
        mapper.addOne(new Compose(nce: "nce9", ncas: "ncas9", name: "name9"))
        List<Compose> result2 = mapper.getAll()

        get("/composes/all", { req, res -> composeController.getAll(req, res) })
    }
}
