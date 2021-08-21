import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

public class ArrayMap<K, V> implements Map61B<K,V> {

    private K[] keys;
    private V[] values;
    int size;

    public ArrayMap() {
        keys = (K[]) new Object[100];
        values = (V[]) new Object[100];
        size = 0;
    }

    /**
     * 如果存在，返回关键字的索引；否则，返回-1
     */
    private int keyIndex(K key) {
        for (int i = 0; i < size; i++) {
            if (keys[i].equals(key)) {
                return i;
            }
        }
        return -1;
    }
    /**检查ArrayMap中是否包含关键字key*/
    public boolean containsKey(K key) {
        int index = keyIndex(key);
        if (index > -1) {
            return true;
        } else {
            return false;
        }
    }
    /**把关键字和值联系到一起*/
    public void put(K key,V value) {
        int index = keyIndex(key);
        if (index == -1) {
            keys[size] = key;
            values[size] = value;
            size += 1;
            return;//没有return就会报错
        }
        values[index] = value;
    }
    /**如果关键字存在返回相应的值*/
    public V get(K key) {
        int index = keyIndex(key);
        return values[index];
    }
    /**返回关键字的个数*/
    public int size() {
        return size;
    }
    /**返回关键字所在列表*/
    public List<K> keys() {
        List<K> keyList = new ArrayList<K>();
        for (int i = 0; i < size; i++) {//此处一定要用size，用KeyList.length会出错的
            keyList.add(keys[i]);
        }
        return keyList;
    }

    @Test
    public void test() {
        ArrayMap<Integer,Integer> am = new ArrayMap<>();
        am.put(2,5);
        int expected = 5;
        assertEquals((Integer) expected,am.get(2));
    }

    public static void main(String[] args) {
        ArrayMap<String,Integer> m = new ArrayMap<String, Integer>();
        m.put("horse",3);
        m.put("fish",9);
        m.put("house",10);
    }

}
