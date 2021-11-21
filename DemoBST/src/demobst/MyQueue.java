/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demobst;

/**
 *
 * @author DUC THINH
 */
public class MyQueue {

    NodeQueue head, tail;

    public MyQueue() {
        head = tail = null;
    }

    boolean isEmpty() {
        return head == null;
    }

    void Enqueue(Node value) {   //bản chất là addlast
        NodeQueue node = new NodeQueue(value);
        if (isEmpty()) {
            head = tail = node;
        } else {
            tail.next = node;   // bản chất là addlast
            tail = node;
        }
    }

    Node Dequeue() {     // bản chất là delete first
        if (isEmpty()) {
            return null;
        }
        Node node = head.value;
        head = head.next;
        return node;
    }

}

class NodeQueue {

    Node value;
    NodeQueue next;

    public NodeQueue() {

    }

    public NodeQueue(Node value) {
        this.value = value;
        next = null;
    }
}
