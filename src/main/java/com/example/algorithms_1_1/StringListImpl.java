package com.example.algorithms_1_1;

import java.lang.reflect.Array;
import java.util.Arrays;

public class StringListImpl implements StringList {


    private final String[] storage;
    private int size;

    public StringListImpl() {
        storage = new String[10];
    }

    public StringListImpl(int initSize) {
        storage = new String[initSize];
    }


    @Override
    public String add(String item) {
        validateItem(item);
        valideteSize();
        storage[size++] = item;
        return item;
    }


    @Override
    public String add(int index, String item) {
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
    public String set(int index, String item) {
        validateItem(item);
        valideteImdex(index);
        storage[index] = item;
        return item;
    }

    @Override
    public String remove(String item) {

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
    public String remove(int index) {

        valideteImdex(index);
        String item =storage[index];
        return remove(item);
    }

    @Override
    public boolean contains(String item) {
        return indexOf(item) != -1;
    }

    @Override
    public int indexOf(String item) {

        for (int i = 0; i < size; i++) {
            if (storage[i].equals(item)) {
                return i;
            }
        }

        return -1;
    }

    @Override
    public int lastIndexOf(String item) {
        for (int i = 0; i >= size; i--) {
            if (storage[i].equals(item)) {
                return i;
            }

        }
        return -1;
    }

    @Override
    public String get(int index) {
        valideteImdex(index);
        return storage[index];
    }

    @Override
    public boolean equals(StringList otherList) {
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
    public String[] toArray() {
        return Arrays.copyOf(storage, size);
    }


    private void validateItem(String item) {
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
}
