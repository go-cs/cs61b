public class ArrayList {
    
    /**在数组arr的第position处插入元素item */
    public static int[] insert(int[] arr, int item,int position) {
        /**int size = arr.length;
        int[] b = new int[size+1];
        System.arraycopy(arr, 0, b, 0, size);
        arr = b;
        //resize(arr,arr.length+1);
        if(position > arr.length-1){
            
            arr[size] = item;
        }
        for (int i = size; i > position; i--) {
            arr[i] = arr[i-1];
        }
        arr[position] = item;

        return arr;*/
        //非破坏性
        int[] result = new int[arr.length+1];
        position = Math.min(arr.length, position);
        for(int i = 0;i < position;i++){
            result[i] = arr[i];
        }
        result[position] = item;
        for(int i = position;i < arr.length;i++){
            result[i+1] = arr[i];
        }
        return result;
    }
    /**数组元素逆序 */
    public static void reverse(int[] arr){
        int temp;
        for(int i=0;i<arr.length/2;i++){
            temp = arr[i];
            arr[i]=arr[arr.length-i-1];
            arr[arr.length-i-1]=temp;
        }
    }
    public static int[] replicate(int[] arr){
        int total = 0;
        for(int item : arr){
            total += item;
        }
        int[] result = new int[total];
        int i = 0;
        for(int item : arr){
            for(int counter = 0; counter < item; counter++){
                result[i] = item;
                i++;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        int[] x = new int[]{5,9,14,15};
        insert(x,6,2);
        reverse(x);
        System.out.print(x+" ");
    }
}
