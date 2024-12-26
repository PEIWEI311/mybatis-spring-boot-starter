package szg.middleware.mybatis.boot.mybatis;

public class SqlSessionFactoryBuilder {

    public SqlSessionFactory build(Configuration configuration) {
        return new DefaultSqlSessionFactory(configuration);
    }
}

