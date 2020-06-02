package com.veereshhonnala.datastructures;

import java.util.LinkedList;

//TODO: stack implementation
public class StackArray<T> {
    private LinkedList<T> stack;

    public StackArray() {
        this.stack = new LinkedList<T>();
    }

    public int size() {
        return stack.size();
    }

    public T pop() {
        T node = null;
        if (size() > 0) node = stack.removeLast();
        return node;
    }

    public void push(T data) {
        stack.addLast(data);
    }

    public T peek() {
        return stack.peekLast();
    }


    public static void main(String arr[]) {
        System.out.println("======================================");
        datastructures.StackArray<Integer> stack = new datastructures.StackArray<>();
        System.out.println(stack.size());
        stack.push(1);
        stack.push(2);
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.peek());
    }
}
