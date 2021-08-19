import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestArrayDequeGold {
    //StudentArrayDeque<Integer> stu1 = new StudentArrayDeque<>();


    @Test
    public void testArrayDequeSize() {
        StudentArrayDeque<Integer> sad1 = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> stu1 = new ArrayDequeSolution<>();
        for (int i = 0; i < 10; i += 1) {
            double numberBetweenZeroAndOne = StdRandom.uniform();

            if (numberBetweenZeroAndOne < 0.5) {
                sad1.addLast(i);
            } else {
                sad1.addFirst(i);
            }
        }
        sad1.removeFirst();
        assertEquals("oh nooo!\n This is bad!\n the length is "+
                sad1.size()+" is not equal to "+ 10+ "!",sad1.size(), 10);
        for (int i = 0; i < 10; i++) {
            stu1.addFirst(StdRandom.uniform(1, 10));
        }

        assertEquals("oh noooo!\n this is bad!\n " + sad1.get(1) + "!" +
                " is not equal " + stu1.get(1) + "!", sad1.get(1), stu1.get(1));
    }

    @Test
    public void test2() {
        StudentArrayDeque<Integer> sad = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> ads = new ArrayDequeSolution<>();
        int random = StdRandom.uniform(1, 50);

        //addFirst
        sad.addFirst(random);
        ads.addFirst(random);
        assertEquals("addFirst+(" + random + ")", ads.get(0), sad.get(0));
        //addLast
        random = StdRandom.uniform(1, 5);
        sad.addLast(random);
        ads.addLast(random);
        assertEquals("addLast+(" + random + ")", sad.get(1), ads.get(1));
        //removeFirst
        int expected = sad.removeFirst();
        int actual = ads.removeFirst();
        assertEquals(expected, actual);
        //removeLast
        expected = sad.removeLast();
        actual = ads.removeLast();
        assertEquals(expected, actual);
    }


}
