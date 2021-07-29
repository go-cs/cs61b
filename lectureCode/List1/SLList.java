public class SLList{
    private IntNode sentinel;
    //private IntNode last;
    private int size;  

    public class IntNode{
        public int item;
        public IntNode next;
        public IntNode(int i, IntNode n){
            item = i;
            next = n;
        }
    }
    /**创建一个空列表 */
    public SLList() {
        /**第一项是sentinel.next */
        sentinel = new IntNode(63,null);
        size = 0;
    }

    public SLList(int x) {
        sentinel = new IntNode(63,null);
        sentinel.next = new IntNode(x,null);
        size = 1;
    }
    /**在列表前添加一项 */
    public void addFirst(int x){
        sentinel.next = new IntNode(x, sentinel.next);
        size += 1;
    }
    /**返回列表第一项 */
    public int getFirst(){
        return sentinel.next.item;
    }
    /**在列表后添加一项 */
    public void addLast(int x){
        size += 1;
        IntNode p = sentinel;
        while(p.next != null){
            p = p.next;
        }
        p.next = new IntNode(x,null);
        // last.next = new IntNode(x,null);
        // last = last.next;
        // size += 1;
    }
    
    public int size(){
        return size;
    }
    public static void main(String[] args) {
        // IntList L1 = new IntNode(5,null);
        // SLList L2 = new SLList(5);
        SLList L = new SLList();
        L.addFirst(15);
        L.addLast(20);
        System.out.println(L.size());

    }
}