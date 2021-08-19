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
//    public void test2() {
//        StudentArrayDeque<Integer> sad = new StudentArrayDeque<>();
//        ArrayDequeSolution<Integer> ads = new ArrayDequeSolution<>();
//        int random = StdRandom.uniform(1, 50);
//
//        //addFirst
//        sad.addFirst(random);
//        ads.addFirst(random);
//        assertEquals("addFirst+(" + random + ")", ads.get(0), sad.get(0));
//        //addLast
//        random = StdRandom.uniform(1, 5);
//        sad.addLast(random);
//        ads.addLast(random);
//        assertEquals("addLast+(" + random + ")", sad.get(1), ads.get(1));
//        //removeFirst
//        int expected = ads.removeFirst();
//        int actual = ads.removeFirst();
//        assertEquals("removeFirst()",expected, actual);
//        //removeLast
//        expected = sad.removeLast();
//        actual = ads.removeLast();
//        assertEquals(expected, actual);
//    }
    public void testArratDeque2() {
        ArrayDequeSolution<Integer> ads = new ArrayDequeSolution<>();
        StudentArrayDeque<Integer> sad = new StudentArrayDeque<>();
        int random = StdRandom.uniform(100);
        ads.addFirst(random);
        sad.addFirst(random);
        assertEquals("addFirst("+random+")", ads.get(0), sad.get(0));
        System.out.println("addFirst("+random+")");

        random = StdRandom.uniform(100);
        ads.addLast(random);
        sad.addLast(random);
        assertEquals("addLast("+random+")", ads.get(1), sad.get(1));
        System.out.println("addLast("+random+")");

        int actual = ads.removeFirst();
        int expected = ads.removeFirst();
        assertEquals("removeFirst()", actual, expected);
        System.out.println("removeFirst()");

        actual = ads.removeLast();
        expected = sad.removeLast();
        assertEquals("removeLast()", actual, expected);
        System.out.println("removeLast()");
    }


}