package Lab11;

public class Main {
    public static void main(String[] args) {
        // Create a BST
        BST<Integer> bst = new BST<>();

        // Add elements to the BST
        bst.add(50);
        bst.add(30);
        bst.add(20);
        bst.add(40);
        bst.add(70);
        bst.add(60);
        bst.add(80);

        // Test methods
        System.out.println("Height of the BST: " + bst.height());
        System.out.println("Size of the BST: " + bst.size());
        System.out.println("Does BST contain 40? " + bst.contains(40));
        System.out.println("Minimum element in BST: " + bst.findMin());
        System.out.println("Maximum element in BST: " + bst.findMax());

        System.out.println("Descendants of 30: " + bst.descendants(30));
        System.out.println("Ancestors of 80: " + bst.ancestors(80));

        // Remove an element and test removal
        System.out.println("Removing 30 from BST: " + bst.remove(30));

        // Retest after removal
        System.out.println("Height of the BST: " + bst.height());
        System.out.println("Size of the BST: " + bst.size());
        System.out.println("Does BST contain 30? " + bst.contains(30));
    }
}
