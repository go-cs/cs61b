import java.sql.SQLOutput;

public class Dog {

    public void bark() {
        System.out.println("bark");
    }

    public void barkMany(int N) {
        for (int i = 0; i < N; i++) {
            bark();
        }
    }

}
