package com.veereshhonnala.datastructures;

public interface QueueInterface<T> {

    int offer(T element);

    T poll(T element);

    T peekLast();

    int offerFirst(T element);

    int offerLast(T element);

    boolean contains(T element);

    T element();
}
