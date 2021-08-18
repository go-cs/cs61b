public class D {

    public static void main (String[] args) {
        //B a0 = new A();//B 是 A的子类
        //a0.m1();//由于上一句语句错误，a0不能初始化
        //a0.m2(16);//由于上一句语句错误，a0不能初始化

        A b0 = new B();
        System.out.println(b0.x);//5
        b0.m1();//Am1-> 5
        b0.m2();//Bm2-> 5
//        //b0.m2(61);//b0的静态类型中没有m2(int y)这个函数
//
        B b1 = new B();
        b1.m2(61);//Bm2y-> 61
        b1.m3();//Bm3-> called
        A c0 = new C();
        c0.m2();//Cm2-> 5

//        //C c1 = new C();
        A a1 = (A) c0;
        C c2 = (C) a1;
        c2.m3();//Bm3-> called?C中的函数有m3()因为是C extends B
//        //c2.m4();//c2中没有m4()函数
        c2.m5();//Cm5-> 6
        ((C) c0).m3();//Bm3-> called
        //(C) c0.m3();//OT RUNTIME ERROR 这将导致方法返回的结果，因此它返回void编译时错误
        b0.update();
        b0.m1();//Am1-> 99
    }

}
