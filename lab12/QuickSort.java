import edu.princeton.cs.algs4.Queue;

public class QuickSort {
    /**
     * Returns a new queue that contains the given queues catenated together.
     * <p>
     * The items in q2 will be catenated after all of the items in q1.
     */
    private static <Item extends Comparable> Queue<Item> catenate(Queue<Item> q1, Queue<Item> q2) {
        Queue<Item> catenated = new Queue<Item>();
        for (Item item : q1) {
            catenated.enqueue(item);
        }
        for (Item item : q2) {
            catenated.enqueue(item);
        }
        return catenated;
    }

    /**
     * Returns a random item from the given queue.
     */
    private static <Item extends Comparable> Item getRandomItem(Queue<Item> items) {
        int pivotIndex = (int) (Math.random() * items.size());
        Item pivot = null;
        // Walk through the queue to find the item at the given index.
        for (Item item : items) {
            if (pivotIndex == 0) {
                pivot = item;
                break;
            }
            pivotIndex--;
        }
        return pivot;
    }

    /**
     * Partitions the given unsorted queue by pivoting on the given item.
     *
     * @param unsorted A Queue of unsorted items
     * @param pivot    The item to pivot on
     * @param less     An empty Queue. When the function completes, this queue will contain
     *                 all of the items in unsorted that are less than the given pivot.
     * @param equal    An empty Queue. When the function completes, this queue will contain
     *                 all of the items in unsorted that are equal to the given pivot.
     * @param greater  An empty Queue. When the function completes, this queue will contain
     *                 all of the items in unsorted that are greater than the given pivot.
     */
    private static <Item extends Comparable> void partition(
            Queue<Item> unsorted, Item pivot,
            Queue<Item> less, Queue<Item> equal, Queue<Item> greater) {
        // Your code here!

        for (Item i : unsorted) {
            int cmp = i.compareTo(pivot);
            if (cmp == 0) {
                equal.enqueue(i);
            } else if (cmp < 0) {
                less.enqueue(i);
            } else {
                greater.enqueue(i);
            }
        }
    }

    /**
     * Returns a Queue that contains the given items sorted from least to greatest.
     */
    public static <Item extends Comparable> Queue<Item> quickSort(
            Queue<Item> items) {
        // Your code here!
        if (items.size() <= 1) {
            return items;
        }
        Item pivot = getRandomItem(items);
        Queue<Item> equal = new Queue<>();
        Queue<Item> less = new Queue<>();
        Queue<Item> greater = new Queue<>();
        partition(items, pivot, less, equal, greater);
        Queue<Item> leftStore = quickSort(less);
        Queue<Item> rightStore = quickSort(greater);
        Queue<Item> ans = catenate(leftStore, equal);
        ans = catenate(ans, rightStore);
        return ans;
    }

    public static void main(String[] args) {
        Queue<Integer> q1 = new Queue<Integer>();
        q1.enqueue(6);
        q1.enqueue(8);
        q1.enqueue(3);
        q1.enqueue(1);
        q1.enqueue(2);
        q1.enqueue(7);
        q1.enqueue(4);
        System.out.println(quickSort(q1));

        Queue<String> q2 = new Queue<String>();
        q2.enqueue("Alice");
        q2.enqueue("Tom");
        q2.enqueue("Mike");
        q2.enqueue("Bob");
        q2.enqueue("Hug");
        q2.enqueue("David");
        q2.enqueue("Kang");
        System.out.println(quickSort(q2));
    }
}
