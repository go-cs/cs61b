public class Sort {
    /**破坏性的排序数组串 */

    /**返回x中的最小项*/
    public static int findSmallest(String[] x, int start){
        /**Java不允许使用运算符在字符串之间进行比较*/
        int smallestIndex = start;
        for (int i = start; i < x.length; i ++) {
            int cmp = x[i].compareTo(x[smallestIndex]);
            if (cmp < 0) {
                smallestIndex = i;
            }
        }
        return smallestIndex;
    }
    /**交换*/
    public static void swap(String[] x, int a, int b) {
        String temp = x[a];
        x[a] = x[b];
        x[b] = temp;
    }
    public static void sort(String[] x){

         //找最小的元素
        int smallestIndex = findSmallest(x,0);
         //把它移动到前边
        swap(x, 0, smallestIndex);
         //对余下的部分排序
        sort(x,0);//完成原始调用
    }
    /**辅助方法
     * 破坏性的排序，从start开始*/
    private static void sort(String[] x, int start) {
        if (start == x.length) {
            return;
        }
        int smallestIndex = findSmallest(x,start);
        swap(x, start, smallestIndex);
        sort(x, start + 1);
    }
}
