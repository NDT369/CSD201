/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment1.pkg3;

/**
 *
 * @author DUC THINH
 */
public class Node {
    Person person;
    Node next, pre;

    public Node() {
    }

    public Node(Person person, Node next, Node pre) {
        this.person = person;
        this.next = next;
        this.pre = pre;
    }
    
    public Node(Person person){
        this.person = person;
        next = null;
        pre = null;
    }
    
}
