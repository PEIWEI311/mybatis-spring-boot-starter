package szg.middleware.mybatis.boot.autoconfigure;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * MyBatis 自定义配置类
 */
@ConfigurationProperties(prefix = "mybatis") // 绑定配置文件中的 mybatis 配置项
public class MybatisProperties {

    private String driver;
    private String url;
    private String username;
    private String password;
    private String basePackage;

    // Getters and Setters
    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBasePackage() {
        return basePackage;
    }

    public void setBasePackage(String basePackage) {
        this.basePackage = basePackage;
    }

    @Override
    public String toString() {
        return "MybatisProperties{" +
                "driver='" + driver + '\'' +
                ", url='" + url + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", basePackage='" + basePackage + '\'' +
                '}';
    }
}
