package com.karatay.hierarchical.heaps;

public class HeapRunner {
    public static void main(String[] args) {
        int[] numbers = {5, 3, 10, 1, 4, 2};
        Heap heap = new Heap();

        for (int number : numbers)
            heap.insert(number);

        while (!heap.isEmpty())
            System.out.println(heap.remove());

        System.out.println("DONE");
    }
}
