public class SinglyLinkedListTest<T> {
    // Instance vars
    private Node<T> head;

    // Constructor
    public SinglyLinkedListTest() {
        this.head = null;
    }

    // Add methods
    public void addToFront(T data) {
        // Create new node; Change its next; Change this.head
        Node<T> newNode = new Node<T>(data);
        newNode.next = this.head;
        this.head = newNode;
    }

    public void addToBack(T data) {
        // Create new node; consider 2 cases
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
    }

    // Remove methods
    /**
     * Checks if head is null first
     */
    public void removeFromFront() {
        if (this.head != null) {
            this.head = this.head.getNext();
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
                Node<T> currentNode = this.head;
                while (currentNode.getNext().getNext() != null) {
                    currentNode = currentNode.getNext();
                }
                currentNode.setNext(null);
            }
        }
    }

    // To string method
    public String toString() {
        String return_string = "";
        Node<T> currentNode = this.head;

        // Traverse thru the list
        while (currentNode != null) {
            return_string += currentNode.toString() + " ";
            currentNode = currentNode.getNext();
        }

        return return_string;
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
}
