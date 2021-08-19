import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestArrayDequeGold {

//    @Test
//    public void testArrayDequeSize() {
//        StudentArrayDeque<Integer> sad = new StudentArrayDeque<>();
//        ArrayDequeSolution<Integer> ads = new ArrayDequeSolution<>();
//        for (int i = 0; i < 10; i++) {
//            int random = StdRandom.uniform(1,10);
//            sad.addFirst(random);
//            ads.addFirst(random);
//        }
//        for (int i = 0; i < 10; i++) {
//            int excepted = sad.get(i);
//            int actual = ads.get(i);
//            assertEquals("Oh noooo!\n This is bad:\n " + excepted + "!" +
//                    " is not equal to " + actual + "!", excepted, actual);
//        }
//
//    }

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
        int expected = ads.removeFirst();
        int actual = ads.removeFirst();
        assertEquals("removeFirst()",expected, actual);
        //removeLast
        expected = sad.removeLast();
        actual = ads.removeLast();
        assertEquals(expected, actual);
    }


}