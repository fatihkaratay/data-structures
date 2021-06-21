package com.karatay.hierarchical.heaps;

public class MaxHeap {
    public static void heapify(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            heapify(numbers, i);
        }

    }

    private static void heapify(int[] numbers, int index) {
        int largerIndex = index;

        int leftIndex = index * 2 + 1;
        if (leftIndex < numbers.length && numbers[leftIndex] > numbers[largerIndex])
            largerIndex = leftIndex;

        int rightIndex = index * 2 + 2;
        if (rightIndex < numbers.length && numbers[rightIndex] > numbers[largerIndex])
            largerIndex = rightIndex;
        if (index == largerIndex)
            return;

        swap(numbers, index, largerIndex);
        heapify(numbers, largerIndex);
    }

    private static void swap(int[] array, int first, int second) {
        int temp = array[first];
        array[first] = array[second];
        array[second] = temp;
    }
}
