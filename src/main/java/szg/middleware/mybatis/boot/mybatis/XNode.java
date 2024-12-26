package szg.middleware.mybatis.boot.mybatis;

import java.util.Map;

public class XNode {

    private String id;
    private String sql;
    private Map<Integer, String> parameterMappings;

    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getSql() { return sql; }
    public void setSql(String sql) { this.sql = sql; }

    public Map<Integer, String> getParameterMappings() { return parameterMappings; }
    public void setParameterMappings(Map<Integer, String> parameterMappings) {
        this.parameterMappings = parameterMappings;
    }
}

