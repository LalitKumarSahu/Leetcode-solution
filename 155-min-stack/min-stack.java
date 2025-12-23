import java.util.Stack;
import java.util.Stack;

class MinStack {

    Stack<int[]> stack;

    public MinStack() {
        stack = new Stack<>();
    }

    public void push(int val) {
        if (stack.isEmpty()) {
            stack.push(new int[]{val, val});
        } else {
            int currentMin = Math.min(val, stack.peek()[1]);
            stack.push(new int[]{val, currentMin});
        }
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek()[0];
    }

    public int getMin() {
        return stack.peek()[1];
    }
}

// class MinStack {

//     Stack<Integer> stack;
//     Stack<Integer> minStack;

//     public MinStack() {
//         stack = new Stack<>();
//         minStack = new Stack<>();
//     }

//     public void push(int val) {
//         stack.push(val);
//         if (minStack.isEmpty() || val <= minStack.peek()) {
//             minStack.push(val);
//         }
//     }

//     public void pop() {
//         if (stack.peek().equals(minStack.peek())) {
//             minStack.pop();
//         }
//         stack.pop();
//     }

//     public int top() {
//         return stack.peek();
//     }

//     public int getMin() {
//         return minStack.peek();
//     }
// }
