package szg.middleware.mybatis.boot.mybatis;

import java.sql.Connection;
import java.sql.DriverManager;

public class DefaultSqlSessionFactory implements SqlSessionFactory {

    private final Configuration configuration;

    public DefaultSqlSessionFactory(Configuration configuration) {
        this.configuration = configuration;
    }

    @Override
    public SqlSession openSession() {
        try {
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/mydb", "root", "secret");
            return new DefaultSqlSession(connection);
        } catch (Exception e) {
            throw new RuntimeException("Error creating SqlSession", e);
        }
    }
}

