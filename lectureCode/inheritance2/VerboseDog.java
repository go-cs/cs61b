public class VerboseDog extends Dog {

    @Override
    public void barkMany(int N) {
        System.out.println("As a dog, I say: ");
        for (int i = 0; i < N; i++) {
            bark();
        }
    }

    public static void main(String[] args) {
        VerboseDog vd = new VerboseDog();
        vd.barkMany(3);
    }
}
