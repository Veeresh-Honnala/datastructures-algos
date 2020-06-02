package com.veereshhonnala.datastructures;

import java.util.Random;
import java.util.function.Consumer;

//TODO: implement BinaryTree ds
public class BinaryTree<T extends Comparable> {
    private int size;
    private Node<T> head;

    public BinaryTree() {
        size = 0;
    }

    public int size() {
        return size;
    }

    private datastructures.BinaryTree.Node<T> createNode(T element) {
        return new datastructures.BinaryTree.Node<T>(element);
    }

    public int add(T element) {
        if (element == null) throw new IllegalArgumentException("element must not null");
        datastructures.BinaryTree.Node<T> newNode = createNode(element);
        if (head == null)
            head = newNode;
        else {
            datastructures.BinaryTree.Node<T> node = head;
            while (node != null) {
                if (element.compareTo(node.element()) > 1) {
                    if (node.right() != null)
                        node = node.right();
                    else {
                        node.right(newNode);
                        ++size;
                        break;
                    }
                } else if (element.compareTo(node.element) < 0) {
                    if (node.left() != null)
                        node = node.left();
                    else {
                        node.left(newNode);
                        ++size;
                        break;
                    }
                } else {
                    break;
                }
            }
        }

        return size;
    }


    public T remove(T element) {
        return element;
    }


    void forEachPreOrder(Consumer consumer) {
        preOrder(head, consumer);
    }

    private void preOrder(datastructures.BinaryTree.Node<T> node, Consumer consumer) {
        consumer.accept(node.element());
        if (node.left() != null)
            preOrder(node.left(), consumer);

        if (node.right() != null)
            preOrder(node.right(), consumer);
    }

    void forEachPostOder() {

    }

    void forEachInOrder() {

    }

    void forEachLevelOrder() {

    }

    static class Node<T extends Comparable> {
        private T element;
        private Node<T> left;
        private Node<T> right;

        public Node(T element) {
            this.element = element;
        }

        public Node(T element, datastructures.BinaryTree.Node<T> left) {
            this.left = left;
            this.element = element;
        }

        public Node(T element, datastructures.BinaryTree.Node<T> left, datastructures.BinaryTree.Node<T> right) {
            this.left = left;
            this.right = right;
            this.element = element;
        }

        public void left(datastructures.BinaryTree.Node<T> node) {
            this.left = node;
        }

        public datastructures.BinaryTree.Node<T> left() {
            return this.left;
        }

        public void right(datastructures.BinaryTree.Node<T> node) {
            this.right = node;
        }

        public datastructures.BinaryTree.Node<T> right() {
            return right;
        }

        public void element(T element) {
            this.element = element;
        }

        public T element() {
            return element;
        }
    }

    public static void main(String args[]) {
        Random random = new Random();
        datastructures.BinaryTree<Integer> b1 = new datastructures.BinaryTree();
        for (int i = 0; i < 10; i++)
            b1.add(random.nextInt(50));

        b1.forEachPreOrder(val -> System.out.print(val + " "));

        int bitmask = 0x000F;
        int val = 0x2222;
        // prints "2"
        System.out.println();
        System.out.println(val);
        System.out.println(bitmask);
        System.out.println(val & bitmask);
    }
}
