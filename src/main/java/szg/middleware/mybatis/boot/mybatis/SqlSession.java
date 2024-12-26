package szg.middleware.mybatis.boot.mybatis;

public interface SqlSession {
    <T> T selectOne(String statement, Object parameter);
    <T> T selectOne(String statement);
    <T> T insert(String statement, Object parameter);
    void close();
}

