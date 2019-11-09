package info.developia.lep.api

import com.google.inject.AbstractModule
import info.developia.lep.api.repository.ComposeRepository
import info.developia.lep.api.repository.ComposeRepositoryImpl
import info.developia.lep.api.service.ComposeService
import info.developia.lep.api.service.ComposeServiceImpl

class Module extends AbstractModule {
    @Override
    protected void configure() {
        bind(ComposeService).to(ComposeServiceImpl).asEagerSingleton()
        bind(ComposeRepository).to(ComposeRepositoryImpl).asEagerSingleton()
    }
}
