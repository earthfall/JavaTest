package com.ds;

import java.io.File;
import java.lang.invoke.MethodHandles;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

class Resources {

    private Resources() {
    }

    static <T> URL getResourceUrl(Class<T> clasz, String fileName) {
        return clasz.getClassLoader().getResource(fileName);
    }

    static <T> Path getResourcePath(Class<T> clasz, String fileName) throws URISyntaxException {
        return Paths.get(getResourceUrl(clasz, fileName).toURI());
    }

    static <T> File getResourceFile(Class<T> clasz, String fileName) throws URISyntaxException {
        return getResourcePath(clasz, fileName).toFile();
    }

    static <T> File getResourceFile(String fileName) throws URISyntaxException {
        return getResourceFile(lookup(), fileName);
    }

    private static Class<?> lookup() {
        return MethodHandles.lookup().lookupClass();
    }
}
