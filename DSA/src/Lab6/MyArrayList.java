package Lab6;

import java.security.DrbgParameters.Capability;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class MyArrayList<E> {
    public static final int DEFAULT_CAPACITY = 10;
    private E[] elements;
    private int size;

    public MyArrayList() {
        this.elements = (E[]) new Object[DEFAULT_CAPACITY];
    }

    public MyArrayList(int capacity) {
        this.elements = (E[]) new Object[capacity];
    }

    // creates an array of double-size if the array of elements is full

    public void growSize() {
        int newLength = elements.length * 2;
        elements = Arrays.copyOf(elements, newLength);
    }

    // Returns the number of elements in this list.
    public int size() {
        return this.size;
    }

    // Returns whether the list is empty.
    public boolean isEmpty() {
        return size == 0;
    }

    // Returns (but does not remove) the element at index i.
    public E get(int i) throws IndexOutOfBoundsException {
        if (i < 0 || i >= size) {
            throw new IndexOutOfBoundsException();
        }
        return elements[i];
    }

    public E set(int i, E e) throws IndexOutOfBoundsException {
        if (i < 0 || i >= size) {
            throw new IndexOutOfBoundsException();
        }
        elements[i] = e;
        return elements[i];
    }

    // It is used to append the specified element at the end of a list.

    public boolean add(E e) {
        if (size >= elements.length) {
            growSize();
        }
        elements[size] = e;
        size++;
        return true;
    }

    // Inserts element e to be at index i, shifting all subsequent elements later.

    public void add(int i, E e) throws IndexOutOfBoundsException {
        if (i < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (size >= elements.length) {
            growSize();
        }
        for (int j = size + 1; j > i; j--) {
            elements[j] = elements[j - 1];
        }
        elements[i] = e;
        size++;
    }

    // Removes and returns the element at index i, shifting subsequent elements
    // earlier.

    public E remove(int i) throws IndexOutOfBoundsException {
        if (i < 0 || i >= size) {
            throw new IndexOutOfBoundsException();
        }
        for (int j = i; j < elements.length - 1; j++) {
            elements[j] = elements[j + 1];
        }
        size--;
        return elements[i];
    }

    // It is used to clear all elements in the list.
    public void clear() {
        Arrays.fill(elements, 0, size, null);
        size = 0;
    }

    // It is used to return the index in this list of the last occurrence of the
    // specified element, or-1 if the list does not contain this element.

    public int lastIndexOf(Object o) {
        for (int i = size - 1; i >= 0; i--) {
            if (o.equals(elements[i])) {
                return i;
            }
        }
        return -1;
    }

    public E[] toArray() {
        return Arrays.copyOf(elements, size);
    }

    // It is used to return a shallow copy of an ArrayList.
    public MyArrayList<E> clone() {
        MyArrayList<E> cloneList = new MyArrayList<>(elements.length);
        cloneList.size = size;
        cloneList.elements = Arrays.copyOf(elements, size);
        return cloneList;
    }
    // It returns true if the list contains the specified element

    public boolean contains(E o) {
        return indexOf(o) >= 0;
    }

    // It is used to return the index in this list of the first occurrence of the
    // specified element, or-1 if the List does not contain this element.

    public int indexOf(E o) {
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(o)) {
                return i;
            }
        }
        return -1;
    }

    // It is used to remove the first occurrence of the specified element.

    public boolean remove(E e) {
        int index = indexOf(e);
        if (index >= 0) {
            remove(index);
            return true;
        }
        return false;
    }

    // It is used to sort the elements of the list on the basis of specified
    // comparator.
    public void sort(Comparator<E> c) {
        Arrays.sort(elements, 0, size, c);
    }

    public void display() {
        for (int i = 0; i < size(); i++) {
            System.out.println(elements[i]);
        }
    }

    public static void main(String[] args) {
        MyArrayList<Character> myList = new MyArrayList<>();

        // Testing add and size
        for (char c = 'A'; c <= 'Z'; c++) {
            myList.add(c);
        }
        System.out.println("Size after adding characters A-Z: " + myList.size());

        // Testing get
        System.out.println("Element at index 5: " + myList.get(5));

        // Testing set
        System.out.println("Replacing element at index 8: " + myList.set(8, 'X'));
        System.out.println("New element at index 8: " + myList.get(8));

        // Testing add at a specific index
        myList.add(3, 'Y');
        System.out.println("Element at index 3 after adding Y: " + myList.get(3));

        // Testing remove
        System.out.println("Removed element at index 6: " + myList.remove(6));
        System.out.println("Size after removing: " + myList.size());

        // Testing indexOf and lastIndexOf
        System.out.println("Index of element 'X': " + myList.indexOf('X'));
        System.out.println("Last index of element 'X': " + myList.lastIndexOf('X'));

        // Testing contains
        System.out.println("Contains 'Y': " + myList.contains('Y'));
        System.out.println("Contains 'Z': " + myList.contains('Z'));

        // Testing remove by object
        System.out.println("Removed 'Y': " + myList.remove((Character) 'Y'));
        System.out.println("Size after removing 'Y': " + myList.size());

        // Testing clear
        myList.clear();
        System.out.println("Size after clearing the list: " + myList.size());

        // Testing sorting (assuming a custom comparator for characters)
        myList.add('C');
        myList.add('A');
        myList.add('B');
        myList.add('Z');
        System.out.println("Before sorting: " + Arrays.toString(myList.toArray()));
        myList.sort(Character::compare);
        System.out.println("After sorting: " + Arrays.toString(myList.toArray()));
    }

}
