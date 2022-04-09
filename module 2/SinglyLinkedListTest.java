public class SinglyLinkedListTest {
    // Instance vars
    private Node head;

    // Add methods
    public void addToFront(int data) {
        // Create new node; Change its next; Change this.head
        Node newNode = Node(data);
        newNode.next = this.head;
        this.head = newNode;
    }

    public void addToBack(int data) {
        // Create new node; consider 2 cases
        Node newNode = Node(data);
        
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
    
    private static class Node {
        private int data;
        private Node next;

        // Constructor
        private Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
        private Node(int data) {
            this(data, null);
        }

        // To string method
        public String toString() {
            return Integer.toString();
        }
    }
}
