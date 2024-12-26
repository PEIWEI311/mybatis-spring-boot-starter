package szg.middleware.mybatis.boot.spring;

import org.mybatis.spring.mapper.MapperScannerConfigurer;

/**
 * 自定义 Mapper 扫描器，用于扩展和替代原有的 MapperScannerConfigurer。
 */
public class CustomMapperScannerConfigurer extends MapperScannerConfigurer {

    public CustomMapperScannerConfigurer() {
        System.out.println("Custom Mapper Scanner Configurer Loaded");
    }

    // 可在此添加扩展功能，如额外的配置选项
}

