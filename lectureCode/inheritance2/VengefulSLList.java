public class VengefulSLList<Item> extends SLList<Item> {

    SLList<Item> deleteItem;

    public VengefulSLList(Item x) {
        super(x);
        deleteItem = new SLList<Item>();
    }

    @Override
    public Item removeLast() {
        Item x = super.removeLast();
        deleteItem.addLast(x);
        return x;
    }

    /**
     * 打印通过调用removeLast所有被删除的项
     */
    public void printLostItems() {
        deleteItem.print();
    }

    public static void main(String[] args) {
        VengefulSLList<Integer> vs1 = new VengefulSLList<Integer>(0);
        SLList<Integer> s1 = vs1;
        s1.addLast(50);
        s1.removeLast();


        vs1.addLast(1);
        vs1.addLast(5);
        vs1.addLast(10);
        vs1.addLast(13);

        vs1.removeLast();
        vs1.removeLast();

        System.out.print("The fallen are: ");
        vs1.printLostItems();
    }

}
