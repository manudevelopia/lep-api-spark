package info.developia.lep.api.repository

import info.developia.lep.api.model.Compose

class ComposeRepositoryImpl implements ComposeRepository {

    def composes = [
        new Compose(ncas: "ncas", nce: "nce", name: "name", description: "description")
    ]

    @Override
    def getAll() {
        return composes
    }
}
