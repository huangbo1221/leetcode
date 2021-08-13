import sorted.algorithm.BubbleSort;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        BubbleSort bubbleSort = new BubbleSort();
        int[] a = {3,7,1,9,55,100,20};
        bubbleSort.bubbleSort(a);
        System.out.println(Arrays.toString(a));
    }
}
