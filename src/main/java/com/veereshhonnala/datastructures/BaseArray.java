package com.veereshhonnala.datastructures;

import java.util.function.Consumer;

public interface BaseArray<T> {

    int add(T element);

    int add(int index, T element);

    int addFirst(T element);

    int addLast(T element);

    T remove(T element);

    T remove(int index);

    T removeLast();

    T removeFirst();

    int indexOf(T element);

    DoubleLinkedArray.Node<T> getFirstNode();

    DoubleLinkedArray.Node<T> getLastNode();


    default void forEach(Consumer consumer) {
        DoubleLinkedArray.Node<T> node = this.getFirstNode();
        while (node != null) {
            consumer.accept(node.getElement());
            node = node.getNext();
        }
    }

    default void descendingForEach(Consumer consumer) {
        DoubleLinkedArray.Node<T> node = this.getLastNode();
        while (node != null) {
            consumer.accept(node.getElement());
            node = node.getPrev();
        }
    }
}