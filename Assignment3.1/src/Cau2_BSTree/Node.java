/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cau2_BSTree;

/**
 *
 * @author DUC THINH
 */
public class Node {

    Car value;
    Node left, right;

    public Node() {

    }
    public Node(Car value, Node left, Node right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }
    
    public Node(Car value) {
        this.value = value;
        left = null;
        right = null;
    }

    public Node(String name, int price) {
        value = new Car(name, price);
        left = null;
        right = null;
    }
}
