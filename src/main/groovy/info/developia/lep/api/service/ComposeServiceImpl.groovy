package info.developia.lep.api.service

import com.google.inject.Inject
import info.developia.lep.api.repository.ComposeRepository

class ComposeServiceImpl implements ComposeService {
    ComposeRepository composeRepository

    @Inject
    ComposeServiceImpl(ComposeRepository composeRepository) {
        this.composeRepository = composeRepository
    }

    @Override
    def getAll() {
        composeRepository.getAll()
    }
}
