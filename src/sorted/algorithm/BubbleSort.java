/**
 * 冒泡排序 + 小的优化点
 */
package sorted.algorithm;

public class BubbleSort {

    public static void bubbleSort(int[] array) {
        if (array == null || array.length < 2) {
            return;
        }

        // 可以针对冒泡排序做一定的优化，如果发现某次遍历过程中，所有的数已经时排好序了
        // 就不应该再受外层的控制，反复循环。如下flag标记位的设置
        for (int i = 0; i < array.length - 1; ++i) {
            boolean flag = false;
            for (int j = 0; j < array.length - i - 1; ++j) {
                if (array[j] > array[j + 1]) {
                    int tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                    flag = true;
                }
            }
            // flag为false，证明在里层循环的时候，发现前面一个数已经永远小于后面的数了
            // 没有再遍历下去的必要
            if (!flag) {
                break;
            }
        }
    }

}
