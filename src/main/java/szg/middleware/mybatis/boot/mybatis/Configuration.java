package szg.middleware.mybatis.boot.mybatis;

import java.util.HashMap;
import java.util.Map;

public class Configuration {

    private final Map<String, String> mappedStatements = new HashMap<>();

    public void addMappedStatement(String id, String sql) {
        mappedStatements.put(id, sql);
    }

    public String getMappedStatement(String id) {
        return mappedStatements.get(id);
    }
}

