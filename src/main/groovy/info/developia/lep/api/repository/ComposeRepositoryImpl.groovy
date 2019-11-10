package info.developia.lep.api.repository

import com.google.inject.Inject
import info.developia.lep.api.mapper.ComposeMapper

class ComposeRepositoryImpl implements ComposeRepository {
    ComposeMapper composeMapper

    @Inject
    ComposeRepositoryImpl(ComposeMapper composeMapper) {
        this.composeMapper = composeMapper
    }

    @Override
    def getAll() {
        return composeMapper.getAll()
    }
}
