import org.junit.Test;
import static org.junit.Assert.*;
public class TestAnimal {
    public static void main(String[] args) {
        Animal a = new Animal("Pluto",10);
        Cat c = new Cat("Garfield",6);
        Dog d = new Dog("Fido",4);

        a.greet();
        c.greet();
        d.greet();
        a = c;
        ((Cat) a).greet();
        a.greet();
        a = new Dog("Spot", 10);
        d = (Dog)a;
    }
//    @Test
//    public void testAnimal() {
//        String expected = "Animal Pluto says Huh?";
//        assertEquals(expected,a.greet());
//    }

}
