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
        // Create new node; change its next;
        // change this.head; increase size
        Node<T> newNode = new Node<T>(data);
        newNode.next = this.head;
        this.head = newNode;
        this.size++;
    }

    public void addToBack(T data) {
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

    public void addAtIndex(T data, int index) {
        // Check illegal input cases
        if (data == null) {
            throw new IllegalArgumentException("Null data cannot be added");
        }
        else if (index < 0 || index > this.getSize()) {
            throw new IllegalArgumentException("Index is out of bounds");
        }

        // Check if list empty; traverse thru to add
        Node<T> newNode = new Node<T>(data);
        
        if (this.head == null) {
            this.head = newNode;
        }
        else {
            Node<T> currentNode = this.head;
            // Special case if index == 0
            if (index == 0) {
                newNode.setNext(currentNode);
            }
            else{
                for (int i = 1; i < index; i++) {
                    currentNode = currentNode.getNext();
                }
                newNode.setNext(currentNode.getNext());
                currentNode.setNext(newNode);
            }
        }
        this.size++;
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

    public static void main(String[] args) {
        int l = 1;
        for (int i = 1; i < l; i++) {
            System.out.println("???");
        }
    }
}
