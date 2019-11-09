package info.developia.lep.api.repository

class ComposeRepositoryImpl implements ComposeRepository {
    @Override
    def getAll() {
        return "<h2>Hello world!!</h2>".toUpperCase()
    }
}
