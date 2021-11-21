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
public class Queue {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        ArrayQueue queue = new ArrayQueue();
        PriorityQueue priQueue = new PriorityQueue();
//        queue.enqueue(2);
//        queue.enqueue(5);
//        queue.enqueue(9);
//        queue.enqueue(6);
//        queue.enqueue(1);
//        queue.enqueue(8);
//        queue.enqueue(10);
//        queue.enqueue(15);
//        queue.enqueue(21);
//        queue.enqueue(4);
//        System.out.println(queue.deQueue());
//        queue.display();
        
        
        priQueue.enqueue(1);
        priQueue.enqueue(7);
        priQueue.enqueue(3);
        priQueue.enqueue(8);
        priQueue.enqueue(2);
        priQueue.enqueue(11);
        System.out.println("Enqueue max: ");
        priQueue.display();
        
        Object d = priQueue.deQueue();
        System.out.println("Dequeue max: " + d);
        priQueue.display();
//        
        Object f = priQueue.front();
        System.out.println("Front max: " + f);
        priQueue.display();
        
    }
    
}
