import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestArrayDequeGold {
    //StudentArrayDeque<Integer> stu1 = new StudentArrayDeque<>();


    @Test
    public void testArrayDequeSize() {
        StudentArrayDeque<Integer> sad1 = new StudentArrayDeque<>();
        for (int i = 0; i < 10; i += 1) {
            double numberBetweenZeroAndOne = StdRandom.uniform();

            if (numberBetweenZeroAndOne < 0.5) {
                sad1.addLast(i);
            } else {
                sad1.addFirst(i);
            }
        }
        sad1.removeFirst();
        ArrayDequeSolution<Integer> stu1 = new ArrayDequeSolution<>();
        for (int i = 0; i < 10; i++) {
            stu1.addFirst(StdRandom.uniform(1, 10));
        }
        assertEquals(sad1.size(), 9);
        assertEquals("oh noooo!\n this is bad!\n " + sad1.get(1) + "!" +
                " is not equal " + stu1.get(1) + "!", sad1.get(1), stu1.get(1));
    }


}
