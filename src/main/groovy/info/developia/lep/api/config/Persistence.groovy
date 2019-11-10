package info.developia.lep.api.config

import com.google.inject.Singleton
import info.developia.lep.api.mapper.ComposeMapper
import org.apache.ibatis.datasource.pooled.PooledDataSource
import org.apache.ibatis.mapping.Environment
import org.apache.ibatis.session.Configuration
import org.apache.ibatis.session.SqlSessionFactory
import org.apache.ibatis.session.SqlSessionFactoryBuilder
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory

import javax.sql.DataSource

@Singleton
class Persistence {

    SqlSessionFactory getSqlSessionFactory() {
        DataSource dataSource =
                new PooledDataSource("org.postgresql.Driver",
                "jdbc:postgresql://localhost:5432/LEP_DB", "lep_admin", "lep_password")
        Environment environment = new Environment("Development", new JdbcTransactionFactory(), dataSource);

        Configuration configuration = new Configuration(environment);
        configuration.addMapper(ComposeMapper.class);
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        return builder.build(configuration)
    }

}
