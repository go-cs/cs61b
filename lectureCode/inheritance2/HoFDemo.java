public class HoFDemo {

    /**展示tenx*/
    public static int do_twice(IntUnaryFunction f, int x){
        return f.tenX(f.tenX(x));
    }

    public static void main(String[] args) {
        System.out.println(do_twice(new TenX(),2));
    }

}
