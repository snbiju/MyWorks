package com.app.test.practice.linkedlist_custom;


import java.util.HashMap;
import java.util.Map;

public class LinkedList {
    private Node head;

    public LinkedList() {
    }

    public void insert(int data){
        Node newNode = new Node(data);
        if(this.head == null){
            head = newNode;
        }else {
            Node currentNode = head;
            while(currentNode.getNextNode() != null){
                currentNode = currentNode.getNextNode();
            }
            currentNode.setNextNode(newNode);
        }
    }

    public void insertAt(int index, int data){
        Node nodeToBeInserted = new Node(data);
        Node node = head;
        for(int i = 0; i< index -1; i++){
            node = node.getNextNode();
        }
        nodeToBeInserted.setNextNode(node.getNextNode());
        node.setNextNode(nodeToBeInserted);
    }

    public void deleteNodeAt(int index){
        Node node = head;
        for(int i = 0; i< index -1; i++){
            node = node.getNextNode();
        }
        node.setNextNode(node.getNextNode().getNextNode());
    }

    public void display(){
        if(head != null){
            Node currentNode = head;
            while(currentNode.getNextNode() != null){
                System.out.println(currentNode.getData());
                currentNode = currentNode.getNextNode();
            }
            System.out.println(currentNode.getData());
        }
    }
    public Node reverse(){
        Node previous = null;
        Node current = head;
        Node next;
        while (current != null){
            next = current.getNextNode();
            current.setNextNode(previous);
            previous = current;
            current = next;
        }
        return previous;
    }

    public boolean checkLoop(){
        boolean loopExists = false;
        Map<Node, Integer> map = new HashMap<>();
        Node tempNode = head;
        while (tempNode != null){
            if(map.get(tempNode) == null){
                map.put(tempNode, 1);
            }else {
                map.put(tempNode, 2);
                loopExists = true;
                break;
            }
            tempNode = tempNode.getNextNode();
        }
        return loopExists;
    }

    public static boolean findLoop(Node head) {
        Node slow = head;
        Node fast = head;

        while (fast.getNextNode() != null && fast.getNextNode().getNextNode() != null) {
            slow = slow.getNextNode();
            fast = fast.getNextNode().getNextNode();
        }

        if(slow == fast){
            return true;
        }
        return false;
    }

    public static void main(String [] args){
        LinkedList linkedList = new LinkedList();
        linkedList.insert(5);
        linkedList.insert(10);
        linkedList.insert(15);
        linkedList.insert(20);
        linkedList.insert(25);
        linkedList.insert(10);
        linkedList.insert(30);
        linkedList.display();

        Node head = new Node(5);
        head.nextNode= new Node(10);
        head.nextNode.nextNode = new Node(10);
        head.nextNode.nextNode.nextNode=new Node(20);
        head.nextNode.nextNode.nextNode.nextNode= new Node(25);




         linkedList.insertAt(2, 100);
        System.out.println("********");
        linkedList.display();
        System.out.println("********");
        linkedList.deleteNodeAt(2);
        linkedList.display();
        System.out.println("********");

        System.out.println(findLoop(head));
        System.out.println(linkedList.checkLoop());

    }
}
class Node {

     int data;
     Node nextNode;

    public Node(int data){
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getNextNode() {
        return nextNode;
    }

    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }
}