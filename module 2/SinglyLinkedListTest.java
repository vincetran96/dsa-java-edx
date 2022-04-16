public class SinglyLinkedListTest<T> {
    // Instance vars
    private Node<T> head;
    private int size;

    // Constructor
    public SinglyLinkedListTest() {
        this.head = null;
        this.size = 0;
    }

    // Getters, setters
    public int getSize() {
        return this.size;
    }

    // Add methods
    public void addToFront(T data) {
        // Check illegal input cases
        if (data == null) {
            throw new IllegalArgumentException("Null data cannot be added");
        }
        
        // Create new node; change its next;
        // change this.head; increase size
        Node<T> newNode = new Node<T>(data);
        newNode.next = this.head;
        this.head = newNode;
        this.size++;
    }

    public void addToBack(T data) {
        // Check illegal input cases
        if (data == null) {
            throw new IllegalArgumentException("Null data cannot be added");
        }
        
        // Create new node; consider 2 cases; increase size
        Node<T> newNode = new Node<T>(data);

        if (this.head == null) {
            this.head = newNode;
        }
        else {
            Node<T> currentNode = this.head;
            // Traverse thru the list
            while (currentNode.getNext() != null) {
                currentNode = currentNode.getNext();
            }
            currentNode.setNext(newNode);
        }
        this.size++;
    }

    /**
     * Check for illgal input first
     */
    public void addAtIndex(T data, int index) {
        // Check illegal input cases
        if (data == null) {
            throw new IllegalArgumentException("Null data cannot be added");
        }
        else if (index < 0 || index > this.getSize()) {
            throw new IllegalArgumentException("Index is out of bounds");
        }

        // Traverse thru list to add
        Node<T> newNode = new Node<T>(data);
        // Special case if index == 0
        if (index == 0) {
            newNode.setNext(this.head);
            this.head = newNode;
        }
        else{
            Node<T> currentNode = this.head;
            for (int i = 1; i < index; i++) {
                currentNode = currentNode.getNext();
            }
            newNode.setNext(currentNode.getNext());
            currentNode.setNext(newNode);
        }
        this.size++;
    }

    // Remove methods
    /**
     * Check if head is null first
     */
    public void removeFromFront() {
        if (this.head == null) {
            throw new ArrayIndexOutOfBoundsException("Cannot remove data from empty list");
        }
        
        this.head = this.head.getNext();
        this.size--;
    }

    /**
     * Only traverse to the *penultimate* element
     */
    public void removeFromBack() {
        if (this.head == null) {
            throw new ArrayIndexOutOfBoundsException("Cannot remove data from empty list");
        }
        
        if (this.head.getNext() == null) {
            this.head = null;
        }
        else {
            Node<T> currentNode = this.head;
            while (currentNode.getNext().getNext() != null) {
                currentNode = currentNode.getNext();
            }
            currentNode.setNext(null);
        }
        this.size--;
    }

    /**
     * Check for illegal input first
     */
    public void removeAtIndex(int index) {
        // Check illegal input cases
        if (index < 0 || index > this.getSize()) {
            throw new IllegalArgumentException("Index is out of bounds");
        }
        else if (this.head == null) {
            throw new ArrayIndexOutOfBoundsException("Cannot remove data from empty list");
        }

        if (index == 0) {
            this.head = this.head.getNext();
        }
        else {
            Node<T> currentNode = this.head;
            for (int i = 1; i < index; i++) {
                currentNode = currentNode.getNext();
            }
            currentNode.setNext(currentNode.getNext().getNext());
        }
        this.size--;
    }

    // To string method, use comma as a separator
    public String toString() {
        String listAsString = "";
        Node<T> currentNode = this.head;

        // Traverse thru the list
        while (currentNode != null) {
            listAsString += currentNode.toString() + ", ";
            currentNode = currentNode.getNext();
        }

        return listAsString;
    }
    
    /**
     * Generic container for type T
     */
    private static class Node<T> {
        private T data;
        private Node<T> next;

        // Constructor
        private Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }
        private Node(T data) {
            this(data, null);
        }
        
        // Getters and setters
        private Node<T> getNext() {
            return this.next;
        }

        private void setNext(Node<T> node) {
            this.next = node;
        }

        // To string method
        public String toString() {
            return this.data.toString();
        }
    }

    public static void main(String[] args) {
        // Add to front
        System.out.println("Add to front:");
        SinglyLinkedListTest<Integer> a0 = new SinglyLinkedListTest<>();
        a0.addToFront(1);
        a0.addToFront(2);
        a0.addToFront(3);
        System.out.println("a0: " + a0.toString());
        System.out.println("Add to front with null data, catch exception:");
        try {
            a0.addToFront(null);
        }
        catch (IllegalArgumentException exc) {
            System.out.println("Caught illegal arg exception");
        }

        // Add to back
        System.out.println("Add to back:");
        SinglyLinkedListTest<Integer> a1 = new SinglyLinkedListTest<>();
        a1.addToBack(-1);
        a1.addToBack(-2);
        a1.addToBack(-3);
        System.out.println("a1: " + a1.toString());
        System.out.println("Add to back with null data, catch exception:");
        try {
            a1.addToBack(null);
        }
        catch (IllegalArgumentException exc) {
            System.out.println("Caught illegal arg exception");
        }

        // Remove from front
        // Empty and regular list
        System.out.println("Remove from front for empty list, catch exception:");
        SinglyLinkedListTest<Integer> r0 = new SinglyLinkedListTest<>();
        try {
            r0.removeFromFront();
        }
        catch (ArrayIndexOutOfBoundsException exc) {
            System.out.println("Caught index OOB exception");
        }
        System.out.println("r0: " + r0.toString());
        System.out.println(r0.getSize());

        System.out.println("Remove from front for regular list:");
        a0.removeFromFront();
        System.out.println("a0: " + a0.toString());
        System.out.println(a0.getSize());

        // Remove from back
        // Empty and regular list
        System.out.println("Remove from back for empty list, catch exception:");
        SinglyLinkedListTest<Integer> r1 = new SinglyLinkedListTest<>();
        try {
            r1.removeFromBack();
        }
        catch (ArrayIndexOutOfBoundsException exc) {
            System.out.println("Caught index OOB exception");
        }
        System.out.println("r1: " + r1.toString());
        System.out.println(r1.getSize());

        System.out.println("Remove from back for regular list, catch exception:");
        a1.removeFromBack();
        System.out.println("a1: " + a1.toString());
        System.out.println(a1.getSize());

        // Add at index
        // Empty and regular list
        System.out.println("Add at index, catch exception:");
        try {
            r0.addAtIndex(1, 1);
        }
        catch (IllegalArgumentException exc) {
            System.out.println("Caught illegal arg exception");
        }
        System.out.println("Add at index with null data, catch exception:");
        try {
            r0.addAtIndex(null, 0);
        }
        catch (IllegalArgumentException exc) {
            System.out.println("Caught illegal arg exception");
        }
        System.out.println("Add at index for empty list:");
        r0.addAtIndex(1, 0);
        System.out.println("r0: " + r0.toString());
        System.out.println(r0.getSize());

        System.out.println("Add at index for regular list:");
        a1.addAtIndex(-4, 1);
        System.out.println("a1: " + a1.toString());
        System.out.println(a1.getSize());

        // Remove at index
        // Empty list and regular list
        System.out.println("Remove at index, catch exception:");
        try {
            r1.removeAtIndex(3);
        }
        catch (IllegalArgumentException exc) {
            System.out.println("Caught illegal arg exception");
        }
        try {
            r1.removeAtIndex(0);
        }
        catch (ArrayIndexOutOfBoundsException exc) {
            System.out.println("Caught index OOB exception");
        }

        System.out.println("Remove at index for regular list:");
        a0.removeAtIndex(1);
        System.out.println("a0: " + a0.toString());
        System.out.println(a0.getSize());
    }
}
