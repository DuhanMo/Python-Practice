import java.util.ArrayList;
import java.util.List;

public class MyStack<T> {

    private List<T> stack = new ArrayList<>();

    public void push(T item) {
        stack.add(item);
    }

    public T pop() {
        if (stack.isEmpty()) {
            return null;
        }
        return stack.remove(stack.size()-1);
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }
}
