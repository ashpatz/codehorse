package ash.patz.learning.annotation;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by APatil on 5/24/2017.
 */
public class AnnotationParser {

    /**
     * Scans all classes accessible from the context class loader which belong to the given package and subpackages.
     *
     * @param packageName The base package
     * @return The classes
     * @throws ClassNotFoundException
     * @throws IOException
     */
    public List<Class> getClasses(String packageName)
            throws ClassNotFoundException, IOException {
        List<Class> classList = new ArrayList<>();
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        String path = packageName.replace('.', '/');
        Collections.list(classLoader.getResources(path)).stream()
                .map(resource -> new File(resource.getFile()))
                .collect(Collectors.toList())
                .stream()
                .map(directory -> findClasses(directory, packageName))
                .forEach(classList::addAll);
        return classList;
    }

    /**
     * Recursive method used to find all classes in a given directory and subdirs.
     *
     * @param directory   The base directory
     * @param packageName The package name for classes found inside the base directory
     * @return The classes
     */
    private List<Class> findClasses(File directory, String packageName) {
        List<Class> classes = new ArrayList<>();
        if (!directory.exists()) {
            return classes;
        }

        Arrays.stream(directory.listFiles())
                .forEach(file -> {
                    if (file.isDirectory() && !file.getName().contains(".")) {
                        classes.addAll(findClasses(file, packageName + "." + file.getName()));
                    } else if (file.getName().endsWith(".class")) {
                        try {
                            classes.add(Class.forName(packageName + '.' + file.getName().substring(0, file.getName().length() - 6)));
                        } catch (ClassNotFoundException e) {
                            //TODO log the exception
                        }
                    }
                });
        return classes;
    }

    /**
     * Extracts details of rest apis inside
     *
     * @param classes The classes fro which to extract the REST Apis
     */
    public Set<RestApi> getRestApis(List<Class> classes) {
        Set<RestApi> restApis = new TreeSet<>();

        classes.stream()
                .forEach(individualClass -> {

                    //Get the class level path, if any.
                    StringBuilder basePath = new StringBuilder("");
                    Arrays.stream(individualClass.getAnnotationsByType(RequestMapping.class))
                            .findFirst()
                            .ifPresent(annotation -> {
                                Arrays.stream(((RequestMapping) annotation).value())
                                        .findFirst()
                                        .ifPresent(value -> {
                                            basePath.append(value);
                                        });
                            });

                    //Iterate over methods
                    Arrays.stream(individualClass.getMethods())
                            .forEach(method -> {
                                Arrays.stream(method.getAnnotationsByType(RequestMapping.class))
                                        .findFirst()
                                        .ifPresent(annotation -> {

                                            //Get the http method for each class method
                                            StringBuilder apiPath = new StringBuilder(basePath.toString());
                                            Arrays.stream(annotation.method())
                                                    .findFirst()
                                                    .ifPresent(httpMethod -> {

                                                        // Get class method level path, if any
                                                        Arrays.stream(annotation.value())
                                                                .findFirst()
                                                                .ifPresent(subPath -> {
                                                                    if (apiPath.length() > 0) {
                                                                        apiPath.append('/');
                                                                    }
                                                                    apiPath.append(subPath);
                                                                });
                                                        restApis.add(new RestApi(apiPath.toString(), httpMethod));
                                                    });

                                        });
                            });

                });
        return restApis;
    }


    public class RestApi implements Comparable<RestApi> {

        private String path;
        private RequestMethod method;

        public RestApi(String path, RequestMethod method) {
            this.path = path;
            this.method = method;
        }

        public String getPath() {
            return path;
        }

        public RequestMethod getMethod() {
            return method;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            RestApi restApi = (RestApi) o;

            if (path != null ? !path.equals(restApi.path) : restApi.path != null) return false;
            return method == restApi.method;

        }

        @Override
        public int hashCode() {
            int result = path != null ? path.hashCode() : 0;
            result = 31 * result + (method != null ? method.hashCode() : 0);
            return result;
        }

        /**
         * Sorts the entries according to path and method
         *
         * @param o
         * @return
         */
        @Override
        public int compareTo(RestApi o) {
            if (this.path.equals(o.getPath())) {
                return this.getMethod().compareTo(o.getMethod());
            } else {
                return this.path.compareTo(o.getPath());
            }
        }
    }

}
