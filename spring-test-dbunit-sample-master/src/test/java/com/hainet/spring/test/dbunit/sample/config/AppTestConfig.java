package com.hainet.spring.test.dbunit.sample.config;

import com.github.springtestdbunit.bean.DatabaseConfigBean;
import com.github.springtestdbunit.bean.DatabaseDataSourceConnectionFactoryBean;
import org.dbunit.ext.h2.H2DataTypeFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class AppTestConfig {

    @Autowired
    private DataSource dataSource;

    // DatatypeFactoryを設定して下記の警告を回避する。
    // DbUnitTestExecutionListenerの記述に従ってBean名はdbUnitDatabaseConnectionと命名する。
    // Potential problem found: The configured data type factory 'class org.dbunit.dataset.datatype.DefaultDataTypeFactory'
    // might cause problems with the current database 'H2' (e.g. some datatypes may not be supported properly).
    // In rare cases you might see this message because the list of supported database products is incomplete (list=[derby]).
    // If so please request a java-class update via the forums.
    // If you are using your own IDataTypeFactory extending DefaultDataTypeFactory,
    // ensure that you override getValidDbProducts() to specify the supported database products.
    @Bean
    public DatabaseDataSourceConnectionFactoryBean dbUnitDatabaseConnection() {
        final DatabaseConfigBean databaseConfig = new DatabaseConfigBean();
        databaseConfig.setDatatypeFactory(new H2DataTypeFactory());

        final DatabaseDataSourceConnectionFactoryBean databaseDataSourceConnectionFactory =
                new DatabaseDataSourceConnectionFactoryBean(dataSource);
        databaseDataSourceConnectionFactory.setDatabaseConfig(databaseConfig);

        return databaseDataSourceConnectionFactory;
    }
}
