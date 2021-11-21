/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package queue;

/**
 *
 * @author DUC THINH
 */
public class MyQueue {
    public Node head,tail;

    public MyQueue() {
        head = tail = null;
    }
    
    public boolean isEmpty(){
        return head == null;
    }
    
    Object front() throws Exception {
        if(isEmpty()) throw new Exception();
        return head.infor;
    }
    
    public void deQueue(){
        if(isEmpty()) {
            return;
        }
        Object x = head.infor;
        head = head.next;
        if(head == null) tail = null;
//        return x;
    }
    
    void enQueue(Object x){
        if(isEmpty()){
            head = tail = new Node(x);
        }else{
            tail.next = new Node(x);
            tail = tail.next;
        }
    }
    
    void display(){
        Node cur = head;
        while(cur != null){
            if(cur == tail) System.out.print(cur.infor+"\n");
            else{
                System.out.print(cur.infor + "<-");
            }
            cur = cur.next;
        }
               
    }
    
}
