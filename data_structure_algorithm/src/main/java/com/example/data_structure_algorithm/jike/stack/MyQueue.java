package com.example.data_structure_algorithm.jike.stack;

import java.util.Stack;

class MyQueue {
    Stack<Integer> stackA = new Stack<>();
    Stack<Integer> stackB = new Stack<>();

    /** Initialize your data structure here. */
    public MyQueue() {

    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        stackA.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(stackB.empty()){
            while(!stackB.empty()){
                stackB.push(stackA.pop());
            }
        }
        return stackB.pop();
    }

    /** Get the front element. */
    public int peek() {
        if(!this.empty()){
            return this.pop();
        }
        throw new RuntimeException("out of bound");
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stackB.empty() && stackA.empty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */