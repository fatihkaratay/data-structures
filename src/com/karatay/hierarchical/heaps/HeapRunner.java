package com.karatay.hierarchical.heaps;

import java.util.Arrays;

public class HeapRunner {
    public static void main(String[] args) {
       int[] numbers = { 5, 3, 8, 4, 1, 2};
      System.out.println(MaxHeap.getKthLargest(numbers, 6));
    }
}
