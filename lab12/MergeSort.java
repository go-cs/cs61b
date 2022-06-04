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
        /**
         Queue<Queue<Item>> ans = new Queue<Queue<Item>>();
         while (!items.isEmpty()) {
         Queue<Item> q = new Queue<Item>();
         q.enqueue(items.dequeue());
         ans.enqueue(q);
         }
         return ans;
         */
        Queue<Queue<Item>> ans = new Queue<>();
        for (Item i : items) {
            Queue<Item> q = new Queue<>();
            q.enqueue(i);
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
        /**
         Queue<Item> q = new Queue<Item>();
         while (!q1.isEmpty() && !q2.isEmpty()) {
         q.enqueue(getMin(q1, q2));
         }

         while (!q1.isEmpty()) {
         q.enqueue(q1.dequeue());
         }
         while (!q2.isEmpty()) {
         q.enqueue(q2.dequeue());
         }
         return q;
         */
        Queue<Item> q = new Queue<>();
        while (!q1.isEmpty() || !q2.isEmpty()) {
            q.enqueue(getMin(q1, q2));
        }
        return q;
    }

    /**
     * Returns a Queue that contains the given items sorted from least to greatest.
     */
    public static <Item extends Comparable> Queue<Item> mergeSort(
            Queue<Item> items) {
        // Your code here!
        /**
         int n = items.size();
         if (n == 0) {
         return items;
         }
         Queue<Queue<Item>> singleQueue = makeSingleItemQueues(items);
         Queue<Queue<Item>> tempQueue = new Queue<Queue<Item>>();
         Queue<Item> q = new Queue<>();
         for (int i = 1; i < n; i *= 2) {
         for (int j = 0; j < n - i; j += i + i) {
         //Queue<Item> qitem = singleQueue.peek();
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
         */
        if (items.size() <= 1) {
            return items;
        }
        Queue<Item> left = new Queue<>();
        Queue<Item> right = new Queue<>();
        int mid = items.size() / 2;
        for (Item i : items) {
            if (mid > 0) {
                left.enqueue(i);
            } else {
                right.enqueue(i);
            }
            mid--;
        }
        Queue<Item> leftStore = mergeSort(left);
        Queue<Item> rightStore = mergeSort(right);
        Queue<Item> ans = mergeSortedQueues(leftStore, rightStore);
        return ans;
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
}
