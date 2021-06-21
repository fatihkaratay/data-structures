package com.karatay.hierarchical.heaps;

public class Heap {
    private int[] items = new int[10];
    private int size;

    public void insert(int value) {
        if (isFull()) throw new IllegalStateException();
        items[size++] = value;

        bubbleUp();
    }

    public void remove() {
        if (isEmpty()) throw new IllegalStateException();
        items[0] = items[--size];

        int index = 0;
        while (index <= size && !isValidParent(index)) {
            int largerChildIndex = largerChildIndex(index);
            swap(index, largerChildIndex);
            index = largerChildIndex;
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private int largerChildIndex(int index) {
        return (leftIndex(index) > rightIndex(index)) ?
                leftIndex(index) :
                rightIndex(index);
    }

    private boolean isValidParent(int index) {
        return  items[index] >= leftChild(index) &&
                items[index] >= rightChild(index);
    }

    private int rightChild(int index) {
        return items[rightIndex(index)];
    }

    private int leftChild(int index) {
        return items[leftIndex(index)];
    }

    private int leftIndex(int index) {
        return index * 2 + 1;
    }
    private int rightIndex(int index) {
        return index * 2 + 2;
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
