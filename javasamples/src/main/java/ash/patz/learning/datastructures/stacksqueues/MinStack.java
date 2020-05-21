package ash.patz.learning.datastructures.stacksqueues;

//https://leetcode.com/problems/min-stack/

public class MinStack {

    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>(100);
        minStack = new Stack<>(100);
    }

    public void push(int x) {
        stack.push(new Integer(x));
        if(minStack.isEmpty()) {
            minStack.push(x);
            return;
        }

        int min = minStack.peek();
        if(x <= min) {
            minStack.push(x);
        }
    }

    public void pop() {
        if(stack.isEmpty()) {
            return;
        }
        int num = stack.pop();

        if(!minStack.isEmpty()) {
            int min = minStack.peek();
            if (min == num) {
                minStack.pop();
            }
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

    class Stack<E> {
        private Object [] holder;
        private int topIndex = -1;

        public Stack (int stackCapacity) {
            holder = new Object[stackCapacity];
        }

        public E pop () {
            E item = null;
            if(topIndex >= 0) {
                item = (E) holder[topIndex];
                holder[topIndex] = null;
                topIndex--;
            }
            return item;
        }

        public E peek () {
            E item = null;
            if(topIndex >= 0) {
                item = (E) holder[topIndex];
            }
            return item;
        }

        public void push(E item) {
            holder[++topIndex] = item;
        }

        public boolean isEmpty() {
            return topIndex == -1;
        }

    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(0);
        minStack.push(1);
        minStack.push(0);
        System.out.println(minStack.getMin());   // 0
        minStack.pop();
        System.out.println(minStack.top());      // 0
        System.out.println(minStack.getMin());   // 0
    }
}
