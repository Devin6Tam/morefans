package com.morefans.mybatis.config;

import org.apache.ibatis.io.VFS;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @author tanxw
 * @date 2019/07/03
 */
public class SpringBootVFS extends VFS{
    public SpringBootVFS() {
    }

    @Override
    public boolean isValid() {
        return true;
    }

    @Override
    protected List<String> list(URL url, String path) throws IOException {
        ClassLoader cl = this.getClass().getClassLoader();
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver(cl);
        Resource[] resources = resolver.getResources("classpath*:" + path + "/**/*.class");
        List resources1 = Arrays.asList(resources);
        List<String> resourcePaths = new ArrayList();
        Iterator var8 = resources1.iterator();

        while(var8.hasNext()) {
            Resource resource = (Resource)var8.next();
            resourcePaths.add(preserveSubpackageName(resource.getURI(), path));
        }

        return resourcePaths;
    }

    private static String preserveSubpackageName(URI uri, String rootPath) {
        String uriStr = uri.toString();
        int start = uriStr.indexOf(rootPath);
        return uriStr.substring(start, uriStr.length());
    }
}
