package szg.middleware.mybatis.boot.mybatis;

import java.sql.Connection;

public class DefaultSqlSession implements SqlSession {

    private final Connection connection;

    public DefaultSqlSession(Connection connection) {
        this.connection = connection;
    }

    @Override
    public <T> T selectOne(String statement, Object parameter) {
        // 简化查询逻辑，真实场景需要 ResultSet 转换
        System.out.println("Executing selectOne: " + statement);
        return null;
    }

    @Override
    public <T> T selectOne(String statement) {
        return selectOne(statement, null);
    }

    @Override
    public <T> T insert(String statement, Object parameter) {
        System.out.println("Executing insert: " + statement);
        return null;
    }

    @Override
    public void close() {
        try {
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

