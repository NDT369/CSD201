/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cau1_LinkedList;

/**
 *
 * @author DUC THINH
 */
public class Node {

    Castor info;
    Node next;

    public Node() {
    }

    public Node(Castor info, Node next) {
        this.info = info;
        this.next = next;
    }

    public Node(Castor info) {
        this.info = info;
        this.next = null;
    }
    
    

}
