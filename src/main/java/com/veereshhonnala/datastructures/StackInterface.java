package com.veereshhonnala.datastructures;

public interface StackInterface<T> {
    int push(T element);

    T pop();

    T peekFirst();
}

