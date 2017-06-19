package ash.patz.learning.annotation;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.IOException;
import java.util.List;
import java.util.Set;

/**
 * Created by APatil on 5/24/2017.
 */
public class AnnotationParserTest {

    @Test
    public void testAnnotationParser() throws IOException, ClassNotFoundException {

        // Tests that REST apis from the TestController added in test scope are available
        AnnotationParser annotationParser = new AnnotationParser();
        List<Class> classes = annotationParser.getClasses("ash.patz");
        Set<AnnotationParser.RestApi> restApis = annotationParser.getRestApis(classes);

        AnnotationParser.RestApi expectedRestApi = annotationParser.new RestApi("/v1/tests/{testname}", RequestMethod.DELETE);

        restApis.forEach(restApi -> {
            System.out.println(restApi.getPath() + " :: "+restApi.getMethod());
        });

        Assert.assertTrue("some problem!!", restApis.contains(expectedRestApi));
    }

    //TODO Add a test to get annotations from jar. (Is it required?)
}
