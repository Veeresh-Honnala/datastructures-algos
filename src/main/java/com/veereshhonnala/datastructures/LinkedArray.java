package com.veereshhonnala.datastructures;

import java.util.LinkedList;

class LinkedArray<T> {
    private int size;
    private Node head;
    private Node trail;

    public int size() {
        return size;
    }

    public T addFirst(final T data) {
        if (head == null) {
            head = trail = new Node<T>(data);
        } else {
            Node<T> node = new Node<T>(data);
            node.setNext(head);
            head = node;
        }
        size++;
        return data;
    }

    public T addLast(final T data) {
        if (trail == null)
            head = trail = new Node(data);
        else {
            Node last = head;
            while (last.getNext() != null) {
                last = last.getNext();
            }
            Node<T> node = new Node<T>(data);
            last.setNext(node);
            trail = node;
        }
        size++;
        return data;
    }

    public int remove(T data) {
        int counter = 0;
        if (this.head != null) {
            if (this.head.getData() == data) {
                if (head.getData() == trail.getData())
                    this.head = this.trail = null;
                else
                    this.head = this.head.getNext();
            } else {
                Node<T> previousNode = this.head;
                Node<T> currentNode = this.head.getNext();
                while (currentNode != null) {
                    if (currentNode.getData() == data) {

                        previousNode.setNext(currentNode.getNext());
                        if (trail.getData() == data) {
                            if (currentNode.getNext() != null)
                                trail = currentNode.getNext();
                            else
                                trail = previousNode;
                        }

                        return counter;

                    } else {
                        previousNode = currentNode;
                        currentNode = currentNode.getNext();
                        counter++;
                    }


                }
            }
        }
        return -1;

    }

    public void print() {
        if (head != null) {
            Node temp = head;
            while (temp != null && temp.getData() != null) {
                System.out.println(temp.getData());
                temp = temp.getNext();
            }
        }
    }


    static class Node<T> {
        private T data;
        private Node<T> next;

        Node(final T data) {
            this.data = data;
        }

        Node(final T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }


        public T getData() {
            return data;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> node) {
            this.next = node;
        }

        public void setData(final T data) {
            this.data = data;
        }

    }


    public static void main(String args[]) {

        System.out.println("====================================Add first");
        datastructures.LinkedArray<Integer> arr1 = new datastructures.LinkedArray<>();
        arr1.addFirst(1);
        arr1.addFirst(2);
        arr1.addFirst(3);
        arr1.addFirst(4);
        arr1.print();
        System.out.println("====================================Add last");
        datastructures.LinkedArray<Integer> arr2 = new datastructures.LinkedArray<>();
        arr2.addLast(1);
        arr2.addLast(2);
        arr2.print();

        System.out.println("====================================remove first");
        datastructures.LinkedArray<Integer> arr3 = new datastructures.LinkedArray<>();
        arr3.remove(1);

        System.out.println("====================================remove first");
        datastructures.LinkedArray<Integer> arr4 = new datastructures.LinkedArray<>();
        arr4.addLast(1);
        arr4.remove(1);
        arr4.print();

        System.out.println("=======================================remove middle");
        datastructures.LinkedArray<Integer> arr5 = new datastructures.LinkedArray<>();
        arr5.addLast(1);
        arr5.addLast(2);
        arr5.addLast(3);
        arr5.remove(2);
        arr5.print();

        System.out.println("=======================================remove last");
        datastructures.LinkedArray<Integer> arr6 = new datastructures.LinkedArray<>();
        arr6.addLast(1);
        arr6.addLast(2);
        arr6.addLast(3);
        arr6.remove(3);
        arr6.print();

        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(2);
        linkedList.add(5);
        linkedList.add(-1);
        linkedList.add(100);
        linkedList.stream().forEach(val -> System.out.print(val + "  "));
        System.out.println();
        linkedList.stream().forEachOrdered(val -> System.out.print(val + "  "));
        System.out.println();
        linkedList.descendingIterator().forEachRemaining(val -> System.out.print(val + "  "));
    }

}