package com.karatay.hierarchical.heaps;

import java.util.Arrays;
import java.util.PriorityQueue;

public class HeapRunner {
    public static void main(String[] args) {
        int[] numbers = { 5, 3, 8, 4, 1, 2};
        System.out.println(MaxHeap.getKthLargest(numbers, 3));
        System.out.println(getKthLargest(numbers, 3));
        System.out.println(getKthSmallest(numbers, 1));
    }

    private static int getKthLargest(int[] numbers, int k) {
        if (k < 1 || k > numbers.length)
            throw new IllegalArgumentException();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        for (int number : numbers)
            maxHeap.add(number);
        for (int i = 0; i < k - 1; i++)
            maxHeap.poll();

        return maxHeap.peek();
    }

    private static int getKthSmallest(int[] numbers, int k) {
        if (k < 1 || k > numbers.length)
            throw new IllegalArgumentException();
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int number : numbers)
            minHeap.add(number);
        for (int i = 0; i < k - 1; i++)
            minHeap.poll();

        return minHeap.peek();
    }
}
