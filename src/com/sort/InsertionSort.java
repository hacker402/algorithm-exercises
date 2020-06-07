package com.sort;

/**
 * <p>
 *     插入排序
 * </p>
 */
public class InsertionSort {

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
        for (int i = 1; i < length; i++) {
            // 待插入的数据
            int value = array[i];
            // index i之前以排好序
            int j = length - i;
            for (; j >= 0; j--) {
                if (array[j] > value) {
                    // 移动数据
                    array[j + 1] = array[j];
                } else {
                    break;
                }
            }
            // 插入数据
            array[j + 1] = value;
        }
    }
}
