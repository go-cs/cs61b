import org.junit.Test;
import static org.junit.Assert.*;

public class TestSort{
    /**测试Sort类里的sort方法 */
    @Test
    public void testSort(){

        String[] input = {"i", "have", "an", "egg"};
        String[] excepted = {"an", "egg", "have", "i"};
        Sort.sort(input);
        assertArrayEquals(excepted, input);

    }
    @Test
    public void testFindSmallest(){
        String[] input = {"i", "have", "an", "egg"};
        int excepted = 2;

        int actual = Sort.findSmallest(input,0);
        assertEquals(excepted, actual);

        String[] input2 = {"there", "are", "many", "pigs"};
        int excepted2 = 1;

        int actual2 = Sort.findSmallest(input2,1);
        assertEquals(excepted2, actual2);

    }
    @Test
    public void testSwap() {
        String[] input = {"i", "have", "an", "egg"};
        int a = 0;
        int b = 2;
        String[] excepted = {"an", "have", "i", "egg"};
        Sort.swap(input, a, b);
        assertArrayEquals(excepted, input);
    }

}