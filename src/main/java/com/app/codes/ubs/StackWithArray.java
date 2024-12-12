package com.app.codes.ubs;

class StackWithArray {
    private int[] stack;
    private int top;
    private int capacity;

    // Constructor to initialize the stack
    public StackWithArray(int size) {
        stack = new int[size];
        capacity = size;
        top = -1;
    }

    // Method to add an element to the stack
    public void push(int value) {
        if (isFull()) {
            System.out.println("Stack is full. Cannot push " + value);
            return;
        }
        stack[++top] = value;
    }

    // Method to remove and return the top element of the stack
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty. Cannot pop.");
            return -1; // or throw an exception
        }
        return stack[top--];
    }

    // Method to return the top element of the stack without removing it
    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty. Cannot peek.");
            return -1; // or throw an exception
        }
        return stack[top];
    }

    // Method to check if the stack is empty
    public boolean isEmpty() {
        return top == -1;
    }

    // Method to check if the stack is full
    public boolean isFull() {
        return top == capacity - 1;
    }

    // Method to get the size of the stack
    public int size() {
        return top + 1;
    }


    public static void main(String[] args) {
        StackWithArray stack = new StackWithArray(5);

        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("Top element is: " + stack.peek());

        System.out.println("Stack size is: " + stack.size());

        System.out.println("Popped element: " + stack.pop());

        System.out.println("Stack size after pop: " + stack.size());
    }
}

