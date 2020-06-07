package com.stack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * #225
 * 队列实现栈
 * https://leetcode-cn.com/problems/implement-stack-using-queues/
 *
 * 使用inQueue记录stack push的数据
 * 当进行pop或者top时，将inQueue所有元素add到tempQueue中，只保留最后一个元素
 * 操作结束将tempQueue数据add到inQueue中
 *
 */
class MyStack {

    Queue<Integer> inQueue = new LinkedList<>();
    Queue<Integer> tempQueue = new LinkedList<>();

    /** Initialize your data structure here. */
    public MyStack() {

    }

    /** Push element x onto stack. */
    public void push(int x) {
        inQueue.add(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        // 只保留inQeuue最后一个元素，将其它元素移除
        while (inQueue.size() > 1) {
            tempQueue.add(inQueue.remove());
        }
        int last = inQueue.remove();
        inQueue = tempQueue;
        tempQueue = new LinkedList<>();
        return last;
    }

    /** Get the top element. */
    public int top() {
        while (inQueue.size() > 1) {
            tempQueue.add(inQueue.remove());
        }
        int last = inQueue.remove();
        tempQueue.add(last);
        inQueue = tempQueue;
        tempQueue = new LinkedList<>();
        return last;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return inQueue.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */