public class SinglyLinkedListTest<T> {
    // Instance vars
    private Node head;

    // Add methods
    public void addToFront(T data) {
        // Create new node; Change its next; Change this.head
        Node<T> newNode = new Node(data);
        newNode.next = this.head;
        this.head = newNode;
    }

    public void addToBack(T data) {
        // Create new node; consider 2 cases
        Node<T> newNode = new Node(data);

        if (this.head == null) {
            this.head = newNode;
        }
        else {
            Node currentNode = this.head;

            // Traverse thru the list
            while (currentNode.next != null) {
                currentNode = currentNode.next;
            }
            currentNode.next = newNode;
        }
    }

    // Remove methods
    /**
     * Checks if head is null first
     */
    public void removeFromFront() {
        if (this.head != null) {
            this.head = this.head.next;
        }
    }

    /**
     * Only traverse to the *penultimate* element
     */
    public void removeFromBack() {
        if (this.head != null) {
            if (this.head.next == null) {
                this.head = null;
            }
            else {
                Node currentNode = this.head;
                while (currentNode.next.next != null) {
                    currentNode = currentNode.next;
                }
                currentNode.next = null;
            }
        }
    }

    // To string method
    public String toString() {
        String return_string = "";
        Node currentNode = this.head;

        // Traverse thru the list
        while (currentNode != null) {
            return_string += currentNode.toString() + " ";
            currentNode = currentNode.next;
        }

        return return_string;
    }
    
    /**
     * Generic container for type T
     */
    private static class Node<T> {
        private T data;
        private Node next;

        // Constructor
        private Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }
        private Node(T data) {
            this(data, null);
        }

        // To string method
        public String toString() {
            return Integer.toString(data);
        }
    }
}
