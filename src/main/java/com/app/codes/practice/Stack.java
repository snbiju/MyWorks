package com.app.codes.practice;

class Stack {
    private int[] stackArray;
    private int top;
    private int maxSize;

    // Constructor to initialize the stack
    public Stack(int size) {
        this.maxSize = size;
        this.stackArray = new int[maxSize];
        this.top = -1;  // Indicates an empty stack
    }

    // Push method to add an element to the stack
    public void push(int value) {
        if (isFull()) {
            System.out.println("Stack is full. Cannot push " + value);
        } else {
            stackArray[++top] = value;
            System.out.println(value + " pushed to stack");
        }
    }

    // Pop method to remove and return the top element from the stack
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty. Cannot pop.");
            return -1;
        } else {
            return stackArray[top--];
        }
    }

    // Peek method to view the top element without removing it
    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty. Nothing to peek.");
            return -1;
        } else {
            return stackArray[top];
        }
    }

    // Method to check if the stack is empty
    public boolean isEmpty() {
        return (top == -1);
    }

    // Method to check if the stack is full
    public boolean isFull() {
        return (top == maxSize - 1);
    }

    // Method to display the elements of the stack
    public void display() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
        } else {
            System.out.println("Stack elements:");
            for (int i = 0; i <= top; i++) {
                System.out.print(stackArray[i] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Stack stack = new Stack(5);

        stack.push(10);
        stack.push(20);
        stack.push(30);

        stack.display();

        System.out.println("Top element is: " + stack.peek());

        System.out.println("Popped element is: " + stack.pop());

        stack.display();

        System.out.println("Top element after pop is: " + stack.peek());

        stack.push(40);
        stack.push(50);
        stack.push(60);

        stack.display();

        stack.push(70); // Should show that stack is full
    }
}

