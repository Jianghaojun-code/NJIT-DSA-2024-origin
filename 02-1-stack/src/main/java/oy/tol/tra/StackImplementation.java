package oy.tol.tra;

public class StackImplementation<E> implements StackInterface<E> {

    private Object[] itemArray;
    private int capacity;
    private int currentIndex = -1;
    private static final int DEFAULT_STACK_SIZE = 10;

    public StackImplementation() throws StackAllocationException {
        this(DEFAULT_STACK_SIZE);
    }

    public StackImplementation(int capacity) throws StackAllocationException {
        if (capacity < 2)
         {
            throw new StackAllocationException("The size must be at least 2.");
        }

        try {
            itemArray = new Object[capacity];
            this.capacity = capacity;
        } catch (Exception e) {
            throw new StackAllocationException("Cannot allocate stack memory.");
        }
    }

    @Override
    public int capacity() {
        return capacity;
    }

    @Override
    public void push(E element) throws StackAllocationException, NullPointerException {
        if (currentIndex + 1 >= capacity) {
            int bigCapacity = capacity * 2;
            try {
                Object[] Array = new Object[bigCapacity];
                for (int i = 0; i < capacity; i++) {
                    Array[i] = itemArray[i];
                }
                itemArray = Array;
                capacity = bigCapacity;
            } catch (Exception e) {
                throw new StackAllocationException("cannot reallocate stack memory.");
            }
        }

        if (element == null) {
            throw new NullPointerException("the stack is empty.");
        }

        currentIndex++;
        itemArray[currentIndex] = element;
    }

    @SuppressWarnings("unchecked")
    @Override
    public E pop() throws StackIsEmptyException {
        if (isEmpty())
         {
            throw new StackIsEmptyException("Cannot pop from an empty stack.");
        }

        E Element = (E) itemArray[currentIndex];
        currentIndex--;

        return Element;
    }

    @SuppressWarnings("unchecked")
    @Override
    public E peek() throws StackIsEmptyException {
        if (isEmpty()) {
            throw new StackIsEmptyException("Cannot peek into an empty stack.");
        }

        return (E) itemArray[currentIndex];
    }

    @Override
    public int size() {
        return currentIndex + 1;
    }

    @Override
    public void clear() {
        currentIndex = -1;
    }

    @Override
    public boolean isEmpty() {
        return currentIndex == -1;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("[");
        for (var index = 0; index <= currentIndex; index++) {
            builder.append(itemArray[index].toString());
            if (index < currentIndex) {
                builder.append(", ");
            }
        }
        builder.append("]");
        return builder.toString();
    }
}