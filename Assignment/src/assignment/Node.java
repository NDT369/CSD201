/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment;

/**
 *
 * @author DUC THINH
 */
public class Node {

    Car car;
    Node next;

    public Node() {
    }

    public Node(Car car, Node next) {
        this.car = car;
        this.next = next;
    }

    public Node(Car car) {
        this.car = car;
        next = null;
    }
}
