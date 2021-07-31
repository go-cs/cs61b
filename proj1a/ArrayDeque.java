public class ArrayDeque<T> {
    private T[] items;
    private int size;
    private int nextFirst;
    private int nextLast;
    /**创建一个空数组双端队列*/
    public ArrayDeque() {
        items = (T[]) new Object[8];
        nextFirst = 0;
        nextLast = 1; //为啥初值是1
        size = 0;
    }
    /**队满返回false*/
    private boolean isFull() {
        if (size == items.length){
            return true;
        }
        return false;
    }
    /**是否缩小队列*/
    private boolean isSparse() {
        if(items.length >= 16 && size < (items.length / 4)){
            return true;
        }
        return false;
    }
    /**数组添加一个*/
    private int plusOne(int index) {
        return (index + 1) % items.length;
    }
    /**数组减小*/
    private int minusOne(int index) {
        return (index - 1 + items.length) % items.length;
    }
    /**重新改变队列的大小*/
    private void resize(int capacity) {
        T[] newDeque = (T[]) new Object[capacity];
        int oldIndex = plusOne(nextFirst); //原始数据中的第一项索引
        for (int newIndex = 0; newIndex < size; newIndex++) {
            newDeque[newIndex] = items[oldIndex];
            oldIndex = plusOne(oldIndex);
        }
        items = newDeque;
        nextFirst = capacity - 1; //新队列是从0号索引开始的
        nextLast = size;
    }
    /**扩展队列*/
    private void upSize() {
        resize(size * 2);
    }
    /**缩小队列*/
    private void downSize() {
        resize(items.length / 2);
    }
    /**在双端队列前面添加一项*/
    public void addFirst(T item) {
        if (isFull()) {
            upSize();
        }

        items[nextFirst] = item;
        nextFirst = minusOne(nextFirst);
        size += 1;

    }
    /**在双端队列后边添加一项*/
    public void addLast(T item) {
        if(isFull()) {
            upSize();
        }

        items[nextLast] = item;
        nextLast = plusOne(nextLast);
        size += 1;

    }
    /**判断双端队列是否为空*/
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }
    /**双端队列中的项数*/
    public int size() {
        return size;
    }
    /**从头到尾打印双端队列中的项*/
    public void printDeque() {
        for (int i = plusOne(nextFirst); i != nextFirst; i = plusOne(i)) {
            System.out.print(items[i] + " ");
        }
        System.out.println();
    }
    /**删除并返回双端队列前面的项*/
    public T removeFirst() {
        if (isSparse()) {
            downSize();
        }
        nextFirst = plusOne(nextFirst);
        T toRemove = items[nextFirst];
        items[nextFirst] = null;
        if (!isEmpty()) {
            size -= 1;
        }
        return toRemove;
    }
    /**删除并返回双端队列后边的项*/
    public T removeLast() {

        if (isSparse()) {
            downSize();
        }
        nextLast = minusOne(nextLast);
        T toRemove = items[nextLast];
        items[nextLast] = null;
        if (!isEmpty()) {
            size -= 1;
        }
        return toRemove;
    }
    /**获取给定索引出的项*/
    public T get(int index) {
        if (index >= size) {
            return null;
        }
        int start = plusOne(nextFirst);
        return items[(start + index) % items.length];
    }
    /**创建副本*/
    public ArrayDeque(ArrayDeque other) {
        items = (T[]) new Object[other.size];
        nextFirst = other.nextFirst;
        nextLast = other.nextLast;
        size = other.size;

        System.arraycopy(other.items, 0, items, 0, other.size);
    }


}
