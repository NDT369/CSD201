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
    Car infor;
    Node next;

    public Node() {
    }

    public Node(Car infor, Node next) {
        this.infor = infor;
        this.next = next;
    }
    
    public Node(Car infor) {
        this.infor = infor;
        this.next = null;
    }   
}
