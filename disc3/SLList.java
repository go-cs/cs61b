public class SLList{
    private class IntNode {
        public int item;
        public IntNode next;
        public IntNode(int item, IntNode next) {
            this.item = item;
            this.next = next;
        }
    }

    private IntNode first;
    private int size;
    public SLList(int x){
        first = new IntNode(x, null);
        size = 1;
    }
    /**在第一个元素前添加一项x */
    public void addFirst(int x) {
        first = new IntNode(x, first);
        size+=1;
    }

    public void addLast(int x){
        IntNode p = first;
        while(p.next != null){
            p = p.next;
        }
        p.next = new IntNode(x, null);
        size+=1;
    }
    /**在第position处插入元素item */
    public void insert(int item, int position){
        /*if(position > size){
            addLast(item);
        }
        IntNode q = first;//列表中的第一个结点
        for(int i = 0; i < position-1;i ++){
            q = q.next;
        }
        IntNode p = new IntNode(item, q.next);
        q.next = p;
        size+=1;*/
        if(first == null || position == 0){
            addFirst(item);
            return;
        }
        IntNode currentNode = first;
        while(position > 1&&currentNode.next != null){
            position--;
            currentNode = currentNode.next;
        }
        IntNode newNode = new IntNode(item, currentNode.next);
        currentNode.next = newNode;
    }
    /**逆转列表 
     * 递归
    */
    /**public IntNode reverse(IntNode head){
        if(head == null || head.next == null){
            return head;
        }
        IntNode temp = head.next;
        IntNode newHead = reverse(head.next);
        temp.next = head;
        head.next = null;
        return newHead;        
    }*/
    public void reverse(){
        first = reverseRecursiveHelper(first);
    }

    private IntNode reverseRecursiveHelper(IntNode front){
        if(front == null || front.next == null){
            return front;
        }else{
            IntNode reversed = reverseRecursiveHelper(front.next);
            front.next.next = front;
            front.next = null;
            return reversed;
        }
    }
    /**逆转列表 
     * 迭代
    */
    /**public IntNode reverseList(IntNode node){
        IntNode pre = null;
        IntNode next = null;
        while (node != null) {
            next = node.next;
            node.next = pre;
            pre = node;
            node = next;
        }  
        return pre;   
    }*/
    public void reverse2(){

        IntNode frontOfReversed = null;
        IntNode nextNodeToAdd = first;
        while (nextNodeToAdd != null) {
            IntNode remainderOfOriginal = nextNodeToAdd.next;
            nextNodeToAdd.next = frontOfReversed;
            frontOfReversed = nextNodeToAdd;
            nextNodeToAdd = remainderOfOriginal;
            
        }
        first = frontOfReversed;
    }

    public static void main(String[] args){
        SLList L = new SLList(2);
        L.addFirst(6);
        L.addFirst(5);
        L.insert(10, 1);
        L.reverse();
    }
}