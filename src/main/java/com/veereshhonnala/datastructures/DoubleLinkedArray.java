package com.veereshhonnala.datastructures;

//TODO:need to implement;
public class DoubleLinkedArray<T> implements BaseArray<T> {
    int size;
    Node<T> first;
    Node<T> last;


    public DoubleLinkedArray() {
        size = 0;
    }

    @Override
    public datastructures.DoubleLinkedArray.Node<T> getFirstNode() {
        return first;
    }

    @Override
    public datastructures.DoubleLinkedArray.Node<T> getLastNode() {
        return last;
    }

    int size() {
        return this.size;
    }

    @Override
    public int add(T element) {
        return addFirst(element);
    }

    @Override
    public int add(int index, T element) {
        if (0 > index || index > size) throw new IllegalArgumentException("invalid index " + index + " size " + size);
        int counter = 0;
        datastructures.DoubleLinkedArray.Node<T> node = first;
        if (index == 0) {
            return addFirst(element);
        } else if (index == size) {
            return addLast(element);
        } else {
            while (node != null) {
                if (counter++ == index) {
                    datastructures.DoubleLinkedArray.Node<T> newNode = createNewNode(element);
                    newNode.setNext(node);
                    node.getPrev().setNext(newNode);
                    node.setPrev(newNode);
                    ++size;
                    return index;
                } else {
                    node = node.getNext();
                }
            }
        }
        return -1;
    }

    @Override
    public int addFirst(T element) {
        if (first == null)
            first = last = createNewNode(element);
        else {
            datastructures.DoubleLinkedArray.Node<T> node = createNewNode(element);
            node.setNext(first);
            first.setPrev(node);
            first = node;
        }
        return ++size;
    }

    @Override
    public int addLast(T element) {
        if (last == null)
            this.first = this.last = createNewNode(element);
        else {
            datastructures.DoubleLinkedArray.Node<T> node = createNewNode(element);
            node.setPrev(last);
            last.setNext(node);
            last = node;
        }
        return ++size;
    }

    private datastructures.DoubleLinkedArray.Node<T> createNewNode(T element) {
        return new datastructures.DoubleLinkedArray.Node<T>(element);
    }

    @Override
    public T remove(T element) {
        return remove(indexOf(element));
    }

    @Override
    public T remove(int index) {
        int lastIndex = size - 1;
        if (0 > index || index > lastIndex) throw new IllegalArgumentException("invalid index " + index);

        if (index == 0) {
            return removeFirst();
        } else if (index == lastIndex) {
            return removeLast();
        } else {
            int m = (int) size / 2;
            datastructures.DoubleLinkedArray.Node<T> node = null;
            if (index > m) {
                node = last;
                for (int i = lastIndex; i > m; i--) {
                    if (i == index)
                        break;
                    node = node.getPrev();
                }
            } else {
                node = first;
                for (int i = 0; i <= m; i++) {
                    if (i == index)
                        break;
                    node = node.getNext();
                }
            }
            return unlinkNode(node);
        }
    }

    private T unlinkNode(datastructures.DoubleLinkedArray.Node<T> node) {
        T element = node.getElement();
        node.getPrev().setNext(node.getNext());
        node.getNext().setPrev(node.getPrev());
        node = null;
        return element;
    }

    @Override
    public T removeLast() {
        if (null != last) {
            T element = last.getElement();
            if (last.getPrev() == null && first.getNext() == null) {
                last = first = null;
            } else {
                last = last.getPrev();
                last.setNext(null);
            }
            return element;
        }
        return null;
    }

    @Override
    public T removeFirst() {
        if (first != null) {
            T element = first.getElement();
            if (first.getNext() == null && last.getPrev() == null) {
                first = last = null;
                return element;
            } else {
                first = first.getNext();
                first.setPrev(null);
                return element;
            }
        }
        return null;
    }

    @Override
    public int indexOf(T element) {
        int counter = 0;
        datastructures.DoubleLinkedArray.Node<T> node = first;
        while (node != null) {
            if (node.getElement() == element) {
                return counter;
            } else {
                node = node.getNext();
                ++counter;
            }
        }

        return -1;
    }


    static class Node<T> {
        private T element;
        private Node<T> next;
        private Node<T> prev;

        public Node(T element) {
            this.element = element;
        }

        public T getElement() {
            return element;
        }

        public void setElement(T element) {
            this.element = element;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> node) {
            this.next = node;
        }

        public Node<T> getPrev() {
            return this.prev;
        }

        public void setPrev(Node<T> node) {
            this.prev = node;
        }

    }

    public static void main(String arr[]) {
//        System.out.println("-------------------------> add first");
//        DoubleLinkedArray<Integer> ar1 = new DoubleLinkedArray<>();
//        ar1.addFirst(1);
//        ar1.addFirst(3);
//        ar1.forEach(val -> System.out.print(val + " "));
//        System.out.println();
//        ar1.add(1, 2);
//        ar1.add(3, 3);
//        ar1.forEach(val -> System.out.print(val + " "));
//        System.out.println(ar1.indexOf(3));
//        System.out.println(ar1.indexOf(2));

//        System.out.println(ar1.removeFirst());
//        System.out.println(ar1.removeFirst());
//        System.out.println(ar1.removeFirst());

//        System.out.println();
//        System.out.println("-------------------------> add first zero");
//        DoubleLinkedArray<Integer> ar2 = new DoubleLinkedArray<>();
//        ar2.forEach(System.out::print);

//        System.out.println();
//        System.out.println("-------------------------> add last");
//        DoubleLinkedArray<Integer> ar3 = new DoubleLinkedArray<>();
//        ar3.addLast(1);
//        ar3.addLast(2);
//        ar3.forEach(val -> System.out.print(val + " "));

//        System.out.println();
//        System.out.println("-------------------------> add last zero");
//        DoubleLinkedArray<Integer> ar4 = new DoubleLinkedArray<>();
//        ar4.forEach(val -> System.out.print(val + " "));


//        System.out.println("-------------------------> remove indexed position");
//        DoubleLinkedArray<Integer> ar5 = new DoubleLinkedArray<>();
//        for (int i = 0; i < 10; i++)
//            ar5.addLast(i);
//        ar5.forEach(val -> System.out.print(val + " "));
//        System.out.println(" -------------" + ar5.size());
//        ar5.remove(10); //max edge case
//        ar5.remove(-1); //min edge case
//        ar5.remove(0);
//        ar5.remove(9);
//        System.out.println(ar5.remove(5));
//        System.out.println(ar5.remove(6));
//        ar5.forEach(val -> System.out.print(val + " "));

//        System.out.println("-------------------------> remove Object");
//        DoubleLinkedArray<Integer> ar6 = new DoubleLinkedArray<>();
//        for (int i = 0; i < 10; i++)
//            ar6.addLast(i);
//        ar6.forEach(val -> System.out.print(val + " "));
//        System.out.println(" ------------->" + ar6.size());
//        ar6.remove(Integer.valueOf(5));
//        ar6.forEach(val -> System.out.print(val + " ");

        //util linked list

//        LinkedList<Integer> linkedList = new LinkedList();
//        for (int i = 0; i < 10; i++)
//            linkedList.offer(i);
//
//        linkedList.forEach(val -> System.out.print(val + " "));
//        System.out.print(linkedList.peek() + " ");

    }
}
