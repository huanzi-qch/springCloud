package cn.huanzi.qch.config.configserver;

import org.springframework.boot.env.PropertiesPropertySourceLoader;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * 解决中文乱码问题
 * 参考：https://blog.csdn.net/sinat_38843093/article/details/79960777
 */
public class MyPropertiesHandler extends PropertiesPropertySourceLoader {

    @Override
    public String[] getFileExtensions() {
        return new String[]{"properties", "xml"};
    }

    @Override
    public List<PropertySource<?>> load(String name, Resource resource) throws IOException {
        ArrayList<PropertySource<?>> list = new ArrayList<>();
        Properties properties = getProperties(resource);
        if (!properties.isEmpty()) {
            list.add(new PropertiesPropertySource(name, properties));
        }
        return list;
    }

    private Properties getProperties(Resource resource) throws IOException {
        Properties properties = new Properties();
        InputStream inputStream = resource.getInputStream();
        properties.load(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
        inputStream.close();
        return properties;
    }
}
