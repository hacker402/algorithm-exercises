package com.stack;

import java.util.Stack;

/**
 * # 232
 * https://leetcode-cn.com/problems/implement-queue-using-stacks/
 * 用栈实现队列
 *
 * 队列是FIFO，栈是FILO，要想使用栈实现队列，就要创建2个栈
 * 一个用来输入，一个用来反转输入的元素来输出
 *
 * 当queue push的时候，push到inStack
 * 当queue进行pop或者peek的时候，直接操作outStack，如果outStack为空，则将inStack元素push到outStack中
 */
class MyQueue {

    Stack<Integer> inStack = new Stack<>();
    Stack<Integer> outStack = new Stack<>();

    /** Initialize your data structure here. */
    public MyQueue() {

    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        // 压入输入栈
        inStack.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (outStack.empty()) {
            // 输出栈是空，将inStack元素押入outStack
            while (!inStack.empty()) {
                outStack.push(inStack.pop());
            }
        }
        return outStack.pop();

    }

    /** Get the front element. */
    public int peek() {
        if (outStack.empty()) {
            // 输出栈是空，将inStack元素押入outStack
            while (!inStack.empty()) {
                outStack.push(inStack.pop());
            }
        }
        return outStack.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return inStack.empty() && outStack.empty();
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