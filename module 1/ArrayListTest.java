public class ArrayListTest<T extends Object> {
    // Instance vars
    private int size;
    private T[] backingArray;

    // Static vars
    public static final int DEFAULT_CAPACITY = 9;
    
    // Constructors
    public ArrayListTest() {
        this(DEFAULT_CAPACITY);
    }
    
    /**
        * Creates the object
        * @param capacity : an integer
    */
    public ArrayListTest(int capacity) {
        this.size = 0;
        this.backingArray = (T[]) new Object[capacity];
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

    // Grow
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

    // Add methods
    /**
        * Adds stuff to front
        * @param data : object of type T
    */
    public void addToFront(T data) {
        if (this.getSize() == this.getCapacity()) {
            this.grow();
        }
        for (int i = this.getSize(); i >= 1; i--) {
            this.backingArray[i] = this.backingArray[i-1];
        }
        this.backingArray[0] = data;
        this.size++;
    }

    // Main
    public static void main(String[] args) {
        ArrayListTest<Integer> arrayList = new ArrayListTest<Integer>(3);
        System.out.println("Size: " + arrayList.getSize());
        System.out.println("Capacity: " + arrayList.getCapacity());
        arrayList.addToFront(1);
        System.out.println("Size: " + arrayList.getSize());
        System.out.println("Capacity: " + arrayList.getCapacity());
        arrayList.addToFront(5);
        arrayList.addToFront(6);
        System.out.println("Size: " + arrayList.getSize());
        System.out.println("Capacity: " + arrayList.getCapacity());
        arrayList.addToFront(8);
        System.out.println("Size: " + arrayList.getSize());
        System.out.println("Capacity: " + arrayList.getCapacity());
        System.out.println("Printing elements:");
        for (int i = 0; i < arrayList.getSize(); i++) {
            System.out.println(arrayList.get(i));
        }
    }
}