package ash.patz.learning.datastructures.stacksqueues;

public class MultiStack {

    private int noOfStacks;
    private int stackCapacity;
    private int [] holder;
    private int [] stackSizes;

    public MultiStack (int noOfStacks, int stackCapacity) throws Exception {
        this.noOfStacks = noOfStacks;
        this.stackCapacity = stackCapacity;
        holder = new int [noOfStacks * stackCapacity];
        stackSizes = new int [noOfStacks - 1];
    }

    public void push(int value, int stackNumber) throws Exception {
        if(isFull(stackNumber)) { throw new Exception("Stack Full");}
        int stackIndex = (stackNumber - 1);
        int destinationIndex = getTopIndex(stackNumber);
        holder[++destinationIndex] = value;
        stackSizes[stackIndex]++;
    }

    public int peek (int stackNumber) throws Exception {
        if(isEmpty(stackNumber)) { throw new Exception("Stack Empty");}
        int destinationIndex = getTopIndex(stackNumber);
        return holder[destinationIndex];
    }

    public int pop(int stackNumber) throws Exception {
        int stackIndex = (stackNumber - 1);
        int destinationIndex = getTopIndex(stackNumber);
        int value = holder[destinationIndex];
        holder[destinationIndex] = 0;
        stackSizes[stackIndex]--;
        return value;
    }

    private int getTopIndex(int stackNumber) throws Exception {
        if(stackNumber > this.noOfStacks) { throw new Exception("Invalid stack number");}
        int stackIndex = (stackNumber - 1);
        return stackIndex * stackCapacity + stackSizes[stackIndex];
    }

    private boolean isEmpty(int stackNumber) {
        return stackSizes[stackNumber - 1] == 0;
    }

    private boolean isFull(int stackNumber) {
        return stackSizes[stackNumber - 1] == this.stackCapacity;
    }
}
