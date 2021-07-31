/**双向链表实现增删改查
 * 循环哨兵拓扑
 * */
public class LinkedListDeque<T> {

    private TNode sentinel;
    private int size;
    private class TNode {//为啥此处要用private
        private T item;
        private TNode prev;
        private TNode next;
        private TNode(T i, TNode p, TNode n) {
            item = i;
            prev = p;
            next = n;
        }
    }
    /**创建一个空链表双端循环队列*/
    public LinkedListDeque() {
        sentinel = new TNode( null, null, null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
    }

    /**构造函数LinkedListDeque的副本*/
    /**
    public LinkedListDeque(LinkedListDeque other) {
        sentinel = new TNode( null, null, null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;

        for (int i = 0; i < other.size(); i += 1) {
            addLast((T) other.get(i));
        }
    }*/
    /**在列表前添加一项*/
    public void addFirst(T x) {
        sentinel.next = new TNode( x,  sentinel, sentinel.next);
        sentinel.next.next.prev = sentinel.next;
        //双向链表,上一句修改了next，这一句要修改prev
        size += 1;
    }
    /**在列表后添加一项*/
    public void addLast(T x) {
        sentinel.prev = new TNode(x, sentinel.prev, sentinel);
        sentinel.prev.prev.next = sentinel.prev; //双向循环链表，
        size += 1;

    }
    /**判断列表是否为空*/
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }
    /**返回双端队列的项数*/
    public int size() {

        return size;
    }
    /**打印双端队列中的项*/
    public void printDeque() {
        TNode p = sentinel;
        while (p.next != sentinel) {
            System.out.print(p.item + " ");
            p = p.next;
        }
        System.out.println();
    }
    /**删除列表的第一项
     * 返回item*/
    public T removeFirst() {
        T toRemove = sentinel.next.item;
        sentinel.next.next.prev = sentinel;
        sentinel.next = sentinel.next.next;
        if (!isEmpty()) {
            size -= 1;
        }
        return toRemove;
    }
    /**删除列表最后一项*/
    public T removeLast() {
        T toRemove = sentinel.prev.item;
        sentinel.prev.prev.next = sentinel;
        sentinel.prev = sentinel.prev.prev;
        if (!isEmpty()) {
            size -= 1;
        }
        return toRemove;

    }
    /**返回列表的第index项
     * 迭代
     * 0是队头*/
    public T get(int index) {
//        if (sentinel.next == sentinel) {
//            return null;
//        }
//        TNode p = sentinel;
//        int num = size;
//        while (p.next != sentinel && num > 0) {
//            p = p.next;
//            num -= 1;
//        }
//        return p.item;
        TNode toGet = sentinel.next;
        for (int i = 0; i < index; i++) {
            toGet = toGet.next;

        }
        return toGet.item;
    }
    /**返回列表的第index项
     * 递归*/
    private T getRecursive(int index, TNode curr) {
        if (index == 0) {
            return curr.item;
        }
        return getRecursive(index - 1, curr.next);
    }

    public T getRecursive(int index) {
        return getRecursive(index, sentinel.next);
    }


}
