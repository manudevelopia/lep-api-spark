package info.developia.lep.api.service

import com.google.inject.Inject
import info.developia.lep.api.repository.ComposeRepository

class ComposeService {
    ComposeRepository composeRepository

    @Inject
    ComposeService(ComposeRepository composeRepository) {
        this.composeRepository = composeRepository
    }

    def getAll(){
        composeRepository.getAll()
    }
}
