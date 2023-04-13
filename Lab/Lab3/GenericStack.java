import java.util.ArrayList;
public class GenericStack<T> {
    private ArrayList<T> stack;

//    Empty Constructor
    public GenericStack(){
        stack = new ArrayList<>();
    }

    public int getSize(){
        return stack.size();
    }

    public T peek(){
        return stack.get(stack.size()-1);
    }

    public T pop(){
        return stack.remove(stack.size()-1);
    }

    public void push(T element){
        stack.add(element);
    }

    public boolean isEmpty(){
        return getSize() == 0;
    }
}