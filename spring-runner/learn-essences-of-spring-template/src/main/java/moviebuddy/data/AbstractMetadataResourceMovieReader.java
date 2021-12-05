package moviebuddy.data;

import moviebuddy.ApplicationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.FileNotFoundException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;

public abstract class AbstractMetadataResourceMovieReader implements ResourceLoaderAware {
    private final Logger log = LoggerFactory.getLogger(getClass());
    private String metadata;
    private ResourceLoader resourceLoader;

    public String getMetadata() {
        return metadata;
    }

    @Value("${movie.metadata}")
    public void setMetadata(String metadata) {
        this.metadata = Objects.requireNonNull(metadata , "metadata is required value");
    }

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    public Resource getMetadataResource() {
        return resourceLoader.getResource(getMetadata());
    }

    @PostConstruct
    public void afterPropertiesSet() throws Exception {
        URL metadataUrl = getMetadataUrl();

        Resource resource = getMetadataResource();
        if (!resource.exists()) {
            throw new FileNotFoundException(metadata);
        }

        if (!resource.isReadable()) {
            throw new ApplicationException(String.format("cannot read to metadata. [%s]", metadata));
        }

        log.info(resource + " is ready.");
    }

    private URL getMetadataUrl() {
        String location = getMetadata();
        if (location.startsWith("file:")) {

        } else if (location.startsWith("http:")) {

        }

        return ClassLoader.getSystemResource(location);
    }

    @PreDestroy
    public void destroy() throws Exception {

    }
}
