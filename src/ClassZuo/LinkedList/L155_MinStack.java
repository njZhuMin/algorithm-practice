package ClassZuo.LinkedList;

//Design a stack that supports push, pop, top, and retrieving the minimum element in constant time O(1).
//
//
// push(x) -- Push element x onto stack.
// pop() -- Removes the element on top of the stack.
// top() -- Get the top element.
// getMin() -- Retrieve the minimum element in the stack.
//
//
//
// Example 1:
//
//
//Input
//["MinStack","push","push","push","getMin","pop","top","getMin"]
//[[],[-2],[0],[-3],[],[],[],[]]
//
//Output
//[null,null,null,null,-3,null,0,-2]
//
//Explanation
//MinStack minStack = new MinStack();
//minStack.push(-2);
//minStack.push(0);
//minStack.push(-3);
//minStack.getMin(); // return -3
//minStack.pop();
//minStack.top();    // return 0
//minStack.getMin(); // return -2
//
//
//
// Constraints:
//
//
// Methods pop, top and getMin operations will always be called on non-empty sta
//cks.
//
// Related Topics 栈 设计
// 👍 805 👎 0

import java.util.Stack;

public class L155_MinStack {

}

class MinStackAtPush {
    private Stack<Integer> dataStack;
    private Stack<Integer> minStack;

    public MinStackAtPush() {
        this.dataStack = new Stack<>();
        this.minStack = new Stack<>();
    }

    public void push(int x) {
        dataStack.push(x);

        // 压入较小值
        if (minStack.isEmpty()) {
            minStack.push(x);
        } else if (x < minStack.peek()) {
            minStack.push(x);
        } else {
            minStack.push(minStack.peek());
        }
    }

    public void pop() {
        dataStack.pop();
        // 同时弹出最小值栈
        minStack.pop();
    }

    public int top() {
        return dataStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}

class MinStackAtPop {
    private Stack<Integer> dataStack;
    private Stack<Integer> minStack;

    public MinStackAtPop() {
        this.dataStack = new Stack<>();
        this.minStack = new Stack<>();
    }

    public void push(int x) {
        dataStack.push(x);

        // 只在压入值比最小值栈栈顶更小时入栈
        if (minStack.isEmpty()) {
            minStack.push(x);
        } else if (x <= minStack.peek()) {
            // 注意这里是小于等于，相等的条件用于弹出数据
            minStack.push(x);
        }
    }

    public void pop() {
        int popValue = dataStack.pop();
        // 弹出的数等于最小值栈栈顶时，同时弹出最小值栈
        if (popValue == minStack.peek()) {
            minStack.pop();
        }
    }

    public int top() {
        return dataStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}