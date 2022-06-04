import edu.princeton.cs.algs4.Queue;

public class MergeSort {
    /**
     * Removes and returns the smallest item that is in q1 or q2.
     * <p>
     * The method assumes that both q1 and q2 are in sorted order, with the smallest item first. At
     * most one of q1 or q2 can be empty (but both cannot be empty).
     *
     * @param q1 A Queue in sorted order from least to greatest.
     * @param q2 A Queue in sorted order from least to greatest.
     * @return The smallest item that is in q1 or q2.
     */
    private static <Item extends Comparable> Item getMin(
            Queue<Item> q1, Queue<Item> q2) {
        if (q1.isEmpty()) {
            return q2.dequeue();
        } else if (q2.isEmpty()) {
            return q1.dequeue();
        } else {
            // Peek at the minimum item in each queue (which will be at the front, since the
            // queues are sorted) to determine which is smaller.
            Comparable q1Min = q1.peek();
            Comparable q2Min = q2.peek();
            if (q1Min.compareTo(q2Min) <= 0) {
                // Make sure to call dequeue, so that the minimum item gets removed.
                return q1.dequeue();
            } else {
                return q2.dequeue();
            }
        }
    }

    /**
     * Returns a queue of queues that each contain one item from items.
     */
    private static <Item extends Comparable> Queue<Queue<Item>>
    makeSingleItemQueues(Queue<Item> items) {
        // Your code here!
        Queue<Queue<Item>> ans = new Queue<Queue<Item>>();
        while (!items.isEmpty()) {
            Queue<Item> q = new Queue<Item>();
            q.enqueue(items.dequeue());
            ans.enqueue(q);
        }
        return ans;
    }

    /**
     * Returns a new queue that contains the items in q1 and q2 in sorted order.
     * <p>
     * This method should take time linear in the total number of items in q1 and q2.  After
     * running this method, q1 and q2 will be empty, and all of their items will be in the
     * returned queue.
     *
     * @param q1 A Queue in sorted order from least to greatest.
     * @param q2 A Queue in sorted order from least to greatest.
     * @return A Queue containing all of the q1 and q2 in sorted order, from least to
     * greatest.
     */
    private static <Item extends Comparable> Queue<Item> mergeSortedQueues(
            Queue<Item> q1, Queue<Item> q2) {
        // Your code here!
        Queue<Item> q = new Queue<Item>();
        while (!q1.isEmpty() && !q2.isEmpty()) {
//            Item item1 = q1.peek();
//            Item item2 = q2.peek();
//            int cmp = item1.compareTo(item2);
//            if (cmp < 0) {
//                q.enqueue(item1);
//            } else {
//                q.enqueue(item2);
//            }
            q.enqueue(getMin(q1, q2));
        }

        while (!q1.isEmpty()) {
            q.enqueue(q1.dequeue());
        }
        while (!q2.isEmpty()) {
            q.enqueue(q2.dequeue());
        }
        return q;
    }

    /**
     * Returns a Queue that contains the given items sorted from least to greatest.
     */
    public static <Item extends Comparable> Queue<Item> mergeSort(
            Queue<Item> items) {
        // Your code here!
        int n = items.size();
        Queue<Queue<Item>> singleQueue = makeSingleItemQueues(items);
        Queue<Queue<Item>> tempQueue = new Queue<Queue<Item>>();
        Queue<Item> q = new Queue<>();
        for (int i = 1; i < n; i *= 2) {
            for (int j = 0; j < n - i; j += i + i) {
                Queue<Item> qitem = singleQueue.peek();
                Queue<Item> qq = mergeSortedQueues(singleQueue.dequeue(), singleQueue.dequeue());
                tempQueue.enqueue(qq);

            }
            if (!singleQueue.isEmpty()) {
                tempQueue.enqueue(singleQueue.dequeue());//if n is odd ,add the last
            }
            singleQueue = tempQueue;
        }
        Queue<Item> q1 = tempQueue.dequeue();
        while (!q1.isEmpty()) {
            q.enqueue(q1.dequeue());
        }
        return q;
    }

    public static void main(String[] args) {
        Queue<Integer> items = new Queue<>();
        items.enqueue(4);
        items.enqueue(2);
        items.enqueue(1);
        items.enqueue(5);
        items.enqueue(7);
        items.enqueue(6);
        items.enqueue(3);
        System.out.println(mergeSort(items));
    }

//    @Test
//    public void test1() {
//        Queue<Integer> items = new Queue<Integer>();
//        items.enqueue(4);
//        items.enqueue(2);
//        items.enqueue(1);
//        items.enqueue(5);
//        Queue<Integer> actual = new Queue<Integer>();
//        actual.enqueue(1);
//        actual.enqueue(2);
//        actual.enqueue(4);
//        actual.enqueue(5);
//        assertEquals(mergeSort(items), actual);
//    }
//
//    @Test
//    public void testString() {
//        Queue<String> items = new Queue<String>();
//        items.enqueue("Alice");
//        items.enqueue("Vanessa");
//        items.enqueue("Ethan");
//        Queue<String> actual = new Queue<String>();
//        actual.enqueue("Alice");
//        actual.enqueue("Ethan");
//        actual.enqueue("Vanessa");
//
//        assertEquals(mergeSort(items), actual);
//    }
}
