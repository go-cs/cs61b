public class C extends B {

    public int y = x + 1;

        public void m2() {
            System.out.println("Cm2-> " + super.x);
        }

//        public void m4() {
//            System.out.println("Cm4-> " + super.super.x);//不能用super.super
//        }

        public void m5() {
            System.out.println("Cm5-> " + y);
        }




}
