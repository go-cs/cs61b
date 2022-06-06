/**
 * Class for doing Radix sort
 *
 * @author Akhil Batra, Alexander Hwang
 */
public class RadixSort {
    /**
     * Does LSD radix sort on the passed in array with the following restrictions:
     * The array can only have ASCII Strings (sequence of 1 byte characters)
     * The sorting is stable and non-destructive
     * The Strings can be variable length (all Strings are not constrained to 1 length)
     *
     * @param asciis String[] that needs to be sorted
     * @return String[] the sorted array
     */
    public static String[] sort(String[] asciis) {
        // TODO: Implement LSD Sort
        int maxStringLength = Integer.MIN_VALUE;
        for (String s : asciis) {
            maxStringLength = maxStringLength > s.length() ? maxStringLength : s.length();
        }
        String[] sorted = asciis;
        for (int i = 0; i < maxStringLength; i++) {
            sortHelperLSD(sorted, i);
        }
        return sorted;
    }

    /**
     * LSD helper method that performs a destructive counting sort the array of
     * Strings based off characters at a specific index.
     *
     * @param asciis Input array of Strings
     * @param index  The position to sort the Strings on.
     */
    private static void sortHelperLSD(String[] asciis, int index) {
        // Optional LSD helper method for required LSD radix sort
        int R = 256;
        int N = asciis.length;
        String[] aux = new String[N];
        int[] count = new int[R + 1];
        for (int i = 0; i < N; i++) {
            int size = asciis[i].length();
            count[asciis[i].charAt(size - 1 - index) + 1]++;
        }
        for (int r = 0; r < R; r++) {
            count[r + 1] += count[r];
        }
        for (int i = 0; i < N; i++) {
            aux[count[asciis[i].charAt(asciis[i].length() - 1 - index)]++] = asciis[i];
        }
        for (int i = 0; i < N; i++) {
            asciis[i] = aux[i];
        }

    }

    /**
     * MSD radix sort helper function that recursively calls itself to achieve the sorted array.
     * Destructive method that changes the passed in array, asciis.
     *
     * @param asciis String[] to be sorted
     * @param start  int for where to start sorting in this method (includes String at start)
     * @param end    int for where to end sorting in this method (does not include String at end)
     * @param index  the index of the character the method is currently sorting on
     **/
    private static void sortHelperMSD(String[] asciis, int start, int end, int index) {
        // Optional MSD helper method for optional MSD radix sort
        return;
    }

    public static void main(String[] args) {
        String[] asciis = {"4PGC938", "2IYE230", "3CIO720", "2RLA629", "2RLA629"};
        String[] sorted = sort(asciis);
        //System.out.println(sorted);
        for (String s : sorted) {
            System.out.print(s + ",");
        }
    }
}
