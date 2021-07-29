public class Alist<Glorp> {
    private Glorp[] arr;
    private int size;
    /**创建一个空数组 */
    public Alist(){
        arr = (Glorp[]) new Object[100];
        size = 0;

    }
    /**调整数组的容量 */
    public void resize(int capacity){
       Glorp[] b = (Glorp[])new Object[capacity];
       System.arraycopy(arr, 0, b, 0, size);
       arr = b;
    }
    /**在数组后边插入X */
    public void addLast(Glorp x){
        if(size == arr.length){
            resize(size*2);
        }
        arr[size] = x;
        size += 1;
    }
    /**返回数组最后一项 */
    public Glorp getLast(){
        return arr[size-1];
    }
    /**得到数组中的第index项，从0开始编号 */
    public Glorp get(int index){
        return arr[index];
    }
    /**数组中的项数 */
    public int size(){
        return size;
    }
    /**删除数组最后一项
     * 返回删除的值
     */
    public Glorp removeLast(){
        Glorp elem = getLast();
        arr[size-1] = null;
        size -= 1;
        return elem;
    }
    
}
