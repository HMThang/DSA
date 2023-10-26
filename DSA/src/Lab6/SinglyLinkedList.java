package Lab6;

public class SinglyLinkedList<E> {
    private Node<E> head = null;
    private Node<E> tail = null;
    private int size;

    public SinglyLinkedList() {
        super();
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public E first() {
        if (isEmpty()) {
            return null;
        }
        return head.getData();
    }

    public E last() {
        if (isEmpty()) {
            return null;
        }
        return tail.getData();
    }

    public void addFirst(E e) {
        Node<E> newNode = new Node<>(e);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.setNext(head);
            head = newNode;
        }
        size++;
    }

    public void addLast(E e) {
        Node<E> newNode = new Node<>(e);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            tail.setNext(newNode);
            tail = newNode;
        }
        size++;
    }

    public E removeFirst() {
        if (isEmpty()) {
            return null;
        }
        size--;
        E data = head.getData();
        head = head.getNext();
        if (isEmpty()) {
            tail = null;
        }
        return data;
    }

    public E removeLast() {
        if (isEmpty()) {
            return null;
        }
        if (size == 1) {
            head = null;
            tail = null;
        } else {
            Node<E> current = head;
            while (current.getNext() != tail) {
                current = current.getNext();
            }
            current.setNext(null);
            tail = current;
        }
        size--;
        return tail.getData();
    }

    public static void main(String[] args) {
        SinglyLinkedList<Integer> myList = new SinglyLinkedList<>();

        // Testing addFirst and addLast
        for (int i = 1; i <= 10; i++) {
            myList.addFirst(i);
        }

        System.out.println("Size: " + myList.size());
        System.out.println("First: " + myList.first());
        System.out.println("Last: " + myList.last());

        // Testing removeFirst and removeLast
        int removedFirst = myList.removeFirst();
        int removedLast = myList.removeLast();
        System.out.println("Removed First: " + removedFirst);
        System.out.println("Removed Last: " + removedLast);
        System.out.println("Size after remove: " + myList.size());
        System.out.println("First after remove: " + myList.first());
        System.out.println("Last after remove: " + myList.last());

        // Testing isEmpty when the list is not empty
        System.out.println("Is empty " + myList.isEmpty());

        // Removing remaining elements
        while (!myList.isEmpty()) {
            System.out.println("Removed : " + myList.removeFirst());
        }

        // Testing isEmpty when the list is empty
        System.out.println("Is empty " + myList.isEmpty());
    }
}
