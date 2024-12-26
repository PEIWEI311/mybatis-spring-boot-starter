package szg.middleware.mybatis.boot.spring;

import java.io.IOException;

import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.io.Resource;

public class SimpleMetadataReader {

    private final MetadataReader metadataReader;

    public SimpleMetadataReader(MetadataReaderFactory metadataReaderFactory, Resource resource) throws IOException {
        this.metadataReader = metadataReaderFactory.getMetadataReader(resource);
    }

    public String getClassName() {
        return metadataReader.getClassMetadata().getClassName();
    }

    public boolean hasAnnotation(String annotationName) {
        return metadataReader.getAnnotationMetadata().hasAnnotation(annotationName);
    }
}

