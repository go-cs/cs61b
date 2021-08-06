import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByN {

    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offBy5 = new OffByN(5);

    // Your tests go here.
    //Uncomment this class once you've created your CharacterComparator interface and offBy5 class.
    @Test
    public void testoffBy5(){
        assertTrue(offBy5.equalChars('a', 'f'));
        assertTrue(offBy5.equalChars('f', 'a'));
        //assertTrue(offBy5.equalChars('&', '%'));
    }
    @Test
    public void testoffBy52(){
        assertFalse(offBy5.equalChars('a', 'B'));
        assertFalse(offBy5.equalChars('a', 'e'));
        assertFalse(offBy5.equalChars('a', 'a'));
    }

}
