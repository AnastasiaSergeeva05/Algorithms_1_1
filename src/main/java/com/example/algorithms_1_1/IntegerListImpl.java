package com.example.algorithms_1_1;

import java.util.Arrays;
import java.util.Objects;

public class IntegerListImpl implements IntegetList {


       private  Integer[] storage;
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
        growIfNeedod();
        storage[size++] = item;
        return item;
    }


    @Override
    public Integer add(int index, Integer item) {
        growIfNeedod();
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

    private void growIfNeedod() {
        if (size == storage.length) {
            grow();
        }

    }


    private void valideteImdex(int index) {
        if (index < 0 || index > size) {
            throw new invalIndexException();
        }
    }


    private void sort(Integer[] arr) {
      quickSort(arr,0,arr.length-1);
    }

    private void quickSort(Integer[] arr, int begin, int end){
        if (begin < end) {
            int partitionIndex = partition(arr, begin, end);

            quickSort(arr, begin, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, end);
        }
    }

    private int partition(Integer[] arr, int begin, int end) {
        int pivot = arr[end];
        int i = (begin - 1);

        for (int j = begin; j < end; j++) {
            if (arr[j] <= pivot) {
                i++;

                swapElements(arr, i, j);
            }
        }

        swapElements(arr, i + 1, end);
        return i + 1;
    }

    private void swapElements(Integer[] arr, int i1, int i2) {
        int temp = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = temp;

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
 public void grow(){
        storage = Arrays.copyOf(storage,size +size/2);
 }
}
