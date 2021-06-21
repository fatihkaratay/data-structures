package com.karatay.hierarchical.heaps;

public class Heap {
    private int[] items = new int[10];
    private int size;

    public void insert(int value) {
        if (isFull()) throw new IllegalStateException();
        items[size++] = value;

        bubbleUp();
    }

    public boolean isFull() {
        return size == items.length;
    }

    private void bubbleUp() {
        int index = size - 1;
        while (index > 0 && items[index] > items[parent(index)]) {
            swap(items[index], items[parent(index)]);
            index = parent(index);
        }
    }

    private void swap(int first, int second) {
        int temp = items[first];
        items[first] = items[second];
        items[second] = temp;
    }

    private int parent(int index) {
        return (index - 1) / 2;
    }
}
