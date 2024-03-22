package oy.tol.tra;

import java.util.Arrays;

public class QueueImplementation<E> implements QueueInterface<E> {



    private static final int DEFAULT_CAPACITY = 10;
    
    private int size;
    private int capacity;
    private E[] array;

    @SuppressWarnings("unchecked")
    public QueueImplementation(int capacity) {
        this.capacity = capacity > 0 ? capacity : DEFAULT_CAPACITY;
        this.array = (E[]) new Object[this.capacity];
        this.size = 0;
    }

    public QueueImplementation() {
        this(DEFAULT_CAPACITY);
    }

    @Override
    public int capacity() {
        return capacity;
    }
    
    @Override
    public int size() {
        return size;
    }
    
    @Override
    public boolean isEmpty() {
        return size == 0;
    }
    
    @Override
    public void enqueue(E element) {
        if (element == null) {
            throw new NullPointerException("Elements cannot be null");
        }
        if (size == capacity) {
            reallocate();
        }
        array[size++] = element;
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new QueueIsEmptyException("Queue is empty");
        }
        E element = array[0];
        System.arraycopy(array, 1, array, 0, --size);
        return element;
    }

    @Override
    public E element() {
        if (isEmpty()) {
            throw new QueueIsEmptyException("Queue is empty");
        }
        return (E) array[0];
    }


    @Override
    public void clear() {
        Arrays.fill(array, null);
        size = 0;
    }

    @SuppressWarnings("unchecked")
    private void reallocate() {
        capacity = 2*capacity;
        E[] newArray = (E[]) new Object[capacity];
        System.arraycopy(array, 0, newArray, 0, size);
        array = newArray;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            sb.append(array[i]);
            if (i < size - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}