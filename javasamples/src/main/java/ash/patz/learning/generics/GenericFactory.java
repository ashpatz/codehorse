package ash.patz.learning.generics;

/**
 * Created by APatil on 5/20/2017.
 */
public class GenericFactory<T> {

    public <T> T createInstance(Class<T> classType) throws IllegalAccessException, InstantiationException {
        return classType.newInstance();
    }
}
