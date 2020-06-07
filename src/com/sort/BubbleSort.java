package com.sort;

/**
 * <p>
 *     冒泡排序
 * </p>
 * @author qingweiqu
 */
public class BubbleSort {

    /**
     * @param array 待排序数组
     */
    public void sort(int[] array) {
        if (array == null) {
            return;
        }
        int length = array.length;
        if (length < 0) {
            return;
        }
        for (int i = 0; i < length; i++) {
            // 前天退出冒泡排序标志
            boolean flag = false;
            for (int j = 0; j < length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    // 交换数据
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    // 交换过数据
                    flag = true;
                }
            }
            // 没有数据交换 则退出排序
            if (!flag) {
                break;
            }
        }
        
    }
}
