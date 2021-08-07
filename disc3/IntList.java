public class IntList {

    public int first;
    public IntList rest;

    public IntList(int f, IntList r) {
        this.first = f;
        this.rest = r;
    }

    /**
     * 打印列表
     */
    public static void printList(IntList p) {

        while (p != null) {
            System.out.print(p.first + " ");
            p = p.rest;
        }
    }

    /**
     * 移除连续列表(有序)中重复的元素 破坏性
     */
    public static void removeDuplicates(IntList p) {
        if (p == null) {
            return;
        }
        IntList current = p.rest;
        IntList previous = p;
        while (current.rest != null) {
            if (current.first == previous.first) {
                previous.rest = current.rest;// 重复移除current
                //current = current.rest;

            } else {
                //current = current.rest;
                previous = previous.rest;
            }
            current = current.rest;
        }
    }

    public static void main(String[] args) {
        IntList L = new IntList(3, null);
        L = new IntList(2, L);
        L = new IntList(2, L);
        L = new IntList(2, L);
        L = new IntList(1, L);
        printList(L);
        System.out.println();
        removeDuplicates(L);
        printList(L);

    }

    /**
     * 间隔数值取值
     */
    public void skippify() {
        IntList p = this;
        int n = 1;
        while (p != null) {
            IntList next = p.rest;
            for (int i = 0; i < n; i++) {
                if (next == null) {
                    break;
                }
                next = next.rest;
            }
            p.rest = next;// 去除列表中的那些间隔掉的项
            p = p.rest;
            n++;
        }
    }
}
