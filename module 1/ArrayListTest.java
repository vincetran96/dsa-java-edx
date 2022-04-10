public class ArrayListTest<T extends Object> {
    // Instance vars
    private int size;
    private T[] backingArray;

    // Static vars
    public static final int DEFAULT_CAPACITY = 9;

    // Constructors
    /**
     * Creates the object
     * @param capacity : an integer
     */
    public ArrayListTest(int capacity) {
        this.size = 0;
        this.backingArray = (T[]) new Object[capacity];
    }
    public ArrayListTest() {
        this(DEFAULT_CAPACITY);
    }

    // Getters
    public int getCapacity() {
        return this.backingArray.length;
    }

    public int getSize() {
        return this.size;
    }

    public T get(int index) {
        return this.backingArray[index];
    }

    /**
     * Grows double the capacity
     */
    private void grow() {
        System.out.println("Growing...");
        T[] oldBackingArray = this.backingArray;
        this.backingArray = (T[]) new Object[this.backingArray.length * 2];
        for (int i = 0; i < oldBackingArray.length; i++) {
            this.backingArray[i] = oldBackingArray[i];
        }
    }

    /**
     * Adds stuff to front
     * @param data : object of type T
     */
    public void addToFront(T data) {
        // Check size first
        if (this.getSize() == this.getCapacity()) {
            this.grow();
        }
        // Shift values of elements backwards
        for (int i = this.getSize(); i >= 1; i--) {
            this.backingArray[i] = this.backingArray[i - 1];
        }
        this.backingArray[0] = data;
        this.size++;
    }

    /**
     * Adds stuff to back
     * @param data : object of type T
     */
    public void addToBack(T data) {
        // Check size first
        if (this.getSize() == this.getCapacity()) {
            this.grow();
        }
        this.backingArray[this.getSize()] = data;
        this.size++;
    }

    /**
     * Removes stuff at front;
     * Checks for 2 cases: when array is empty and when not
     */
    public T removeFromFront() {
        if (this.getSize() == 0 ) {
            throw new IndexOutOfBoundsException("Nope");
        }
        else {
            T front_value = this.backingArray[0];

            // Shift values of elements forwards
            for (int i = 0; i < this.getSize(); i++) {
                this.backingArray[i] = this.backingArray[i + 1];
            }
            this.size--;

            return front_value;
        }
    }

    /**
     * Removes stuff at back;
     * Checks for 2 cases: when array is empty and when not
     */
    public T removeFromBack() {
        if (this.getSize() == 0 ) {
            throw new IndexOutOfBoundsException("Nope");
        }
        else {
            T back_value = this.backingArray[this.getSize()-1];

            this.backingArray[this.getSize()-1] = null;
            this.size--;

            return back_value;
        }
    }

    // Main
    public static void main(String[] args) {
        ArrayListTest<Integer> arrayList = new ArrayListTest<Integer>(3);

        // Add
        System.out.println("Initial size: " + arrayList.getSize());
        System.out.println("Initial capacity: " + arrayList.getCapacity());
        arrayList.addToFront(1);
        arrayList.addToFront(5);
        arrayList.addToFront(6);
        arrayList.addToFront(8);
        arrayList.addToBack(12);
        System.out.println("Size: " + arrayList.getSize());
        System.out.println("Capacity: " + arrayList.getCapacity());
        System.out.println("Printing elements after adding:");
        for (int i = 0; i < arrayList.getSize(); i++) {
            System.out.println(arrayList.get(i));
        }
        System.out.println();

        // Remove
        Integer front0 = arrayList.removeFromFront();
        System.out.println("Size: " + arrayList.getSize());
        System.out.println("Capacity: " + arrayList.getCapacity());
        System.out.println("Printing elements after removing:");
        for (int i = 0; i < arrayList.getSize(); i++) {
            System.out.println(arrayList.get(i));
        }
        System.out.println("Printing ALL elements after removing:");
        for (int i = 0; i < arrayList.getCapacity(); i++) {
            System.out.println(arrayList.get(i));
        }
        int currentSize = arrayList.getSize();
        for (int i = 0; i < currentSize; i++) {
            arrayList.removeFromFront();
        }
        System.out.println("Size: " + arrayList.getSize());
        System.out.println("Capacity: " + arrayList.getCapacity());
        System.out.println(
                "Printing ALL elements after removing all remaining elements:");
        for (int i = 0; i < arrayList.getCapacity(); i++) {
            System.out.println(arrayList.get(i));
        }
        
        // Test removing empty array
        try {
            arrayList.removeFromFront();
        }
        catch (IndexOutOfBoundsException exc) {
            System.out.println("Exception caught: " + exc.getMessage());
        }
        try {
            arrayList.removeFromBack();
        }
        catch (IndexOutOfBoundsException exc) {
            System.out.println("Exception caught: " + exc.getMessage());
        }

        arrayList.addToBack(1);
        arrayList.addToBack(5);
        arrayList.removeFromBack();
        System.out.println("Size: " + arrayList.getSize());
        System.out.println("Capacity: " + arrayList.getCapacity());
        System.out.println("Printing elements after removing:");
        for (int i = 0; i < arrayList.getSize(); i++) {
            System.out.println(arrayList.get(i));
        }
    }
}
