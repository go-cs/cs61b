import java.util.ArrayDeque;
import java.util.LinkedList;

public interface Deque<T> {

    /**导入LinkedListDeque的方法*/


    public void addFirst(T x);

    public void addLast(T x);

    public boolean isEmpty();

    public int size();

    public void printDeque();

    public T removeFirst();

    public T removeLast();

    public T get(int index);

    public T getRecursive(int index);

}

