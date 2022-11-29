package com.example.algorithms_1_1;

import java.util.Arrays;
import java.util.Objects;

public class IntegerListImpl implements IntegetList {


       private final Integer[] storage;
    private int size;

    public IntegerListImpl() {
        storage = new Integer[10];
    }

    public IntegerListImpl(int initSize) {
        storage = new Integer[initSize];
    }

    public IntegerListImpl(Integer[] storage, int size) {
        this.storage = storage;
        this.size = size;
    }

    public Integer[] getStorage() {
        return storage;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public Integer add(Integer item) {
        validateItem(item);
        valideteSize();
        storage[size++] = item;
        return item;
    }


    @Override
    public Integer add(int index, Integer item) {
        valideteSize();
        validateItem(item);
        valideteImdex(index);

        if (index == size) {
            storage[size++] = item;
            return item;
        }
        System.arraycopy(storage, index, storage, index + 1, size - index);
        storage[index] = item;
        size++;
        return null;

    }

    @Override
    public Integer set(int index, Integer item) {
        validateItem(item);
        valideteImdex(index);
        storage[index] = item;
        return item;
    }

    @Override
    public Integer remove(Integer item) {

        validateItem(item);

        int index = indexOf(item);
        if (index == -1) {
            throw new ElementNotFoundException();
        }
        if (index != size) {
            System.arraycopy(storage, index + 1, storage, index, size - index);
        }
        size--;
        return item;


    }

    @Override
    public Integer remove(int index) {

        valideteImdex(index);
        Integer item = storage[index];
        return remove(item);
    }

    @Override
    public boolean contains(Integer item) {
        Integer[] storageCopy = toArray();
        sort(storageCopy);
        return binarySearch(storageCopy, item);
    }

    @Override
    public int indexOf(Integer item) {

        for (int i = 0; i < size; i++) {
            if (storage[i].equals(item)) {
                return i;
            }
        }

        return -1;
    }

    @Override
    public int lastIndexOf(Integer item) {
        for (int i = 0; i >= size; i--) {
            if (storage[i].equals(item)) {
                return i;
            }

        }
        return -1;
    }

    @Override
    public Integer get(int index) {
        valideteImdex(index);
        return storage[index];
    }

    @Override
    public boolean equals(IntegetList otherList) {
        return Arrays.equals(this.toArray(), otherList.toArray());
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        size = 0;

    }


    @Override
    public Integer[] toArray() {
        return Arrays.copyOf(storage, size);
    }


    private void validateItem(Integer item) {
        if (item == null) {
            throw new NullItemException();
        }
    }

    private void valideteSize() {
        if (size == storage.length) {
            throw new StrorageIsFullExpcetion();
        }

    }


    private void valideteImdex(int index) {
        if (index < 0 || index > size) {
            throw new invalIndexException();
        }
    }


    private void sort(Integer[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i;
            while (j > 0 && arr[j - 1] >= temp) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = temp;
        }
    }

    private boolean binarySearch(Integer[] arr, Integer item) {
        int min = 0;
        int max = arr.length - 1;
        while (min <= max) {
            int mid = (min + max) / 2;
            if (Objects.equals(item, arr[mid])) {
                return true;
            }
            if (item < arr[mid]) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return false;
    }

}
