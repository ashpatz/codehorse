package ash.patz.learning.generics;

/**
 * Created by APatil on 5/20/2017.
 */
public class Box<T> {

    private T t;

    public void set(T t) {
        this.t = t;
    }

    public T get() {
        return t;
    }

    public <U extends Number> void inspect(U u){
        System.out.println("T: " + t.getClass().getName());
        System.out.println("U: " + u.getClass().getName());
    }

    public static void main(String[] args) {

        Box<String> stringBox = new Box<>();
        stringBox.set("hello");

        stringBox.inspect(new Integer(10));

        //This will be a compilation error
//        stringBox.inspect("some text"); // error: this is still String!

    }
}
