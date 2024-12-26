package szg.middleware.mybatis.boot.spring;

import org.springframework.beans.factory.FactoryBean;

public class MapperFactoryBean<T> implements FactoryBean<T> {

    private final Class<T> mapperInterface;

    public MapperFactoryBean(Class<T> mapperInterface) {
        this.mapperInterface = mapperInterface;
    }

    @Override
    public T getObject() {
        // 生成动态代理对象
        return null;
    }

    @Override
    public Class<?> getObjectType() {
        return mapperInterface;
    }
}

