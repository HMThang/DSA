package Lab6;

public class MyLinkedList {
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
