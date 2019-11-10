package info.developia.lep.api.config

import com.google.inject.name.Names
import info.developia.lep.api.mapper.ComposeMapper
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory
import org.mybatis.guice.MyBatisModule
import org.mybatis.guice.datasource.builtin.PooledDataSourceProvider
import org.mybatis.guice.datasource.helper.JdbcHelper

class PersistenceModule extends MyBatisModule {
    @Override
    protected void initialize() {
        install(JdbcHelper.PostgreSQL);

        bindDataSourceProviderType(PooledDataSourceProvider);
        bindTransactionFactoryType(JdbcTransactionFactory);
        addMapperClass(ComposeMapper);

        Names.bindProperties(binder(), getConfiguration());
    }

    static def getConfiguration() {
        Properties myBatisProperties = new Properties();
        myBatisProperties.setProperty("mybatis.environment.id", "test");
        myBatisProperties.setProperty("JDBC.schema", "LEP_DB");
        myBatisProperties.setProperty("JDBC.username", "lep_admin");
        myBatisProperties.setProperty("JDBC.password", "lep_password");
        myBatisProperties.setProperty("JDBC.host", "localhost");

        return myBatisProperties
    }
}
