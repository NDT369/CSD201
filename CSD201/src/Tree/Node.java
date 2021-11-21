/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tree;

/**
 *
 * @author DUC THINH
 */
public class Node {

    Car info;
    Node left, right;

    public Node() {

    }

    public Node(Car info) {
        this.info = info;
        left = null;
        right = null;
    }

    public Node(String name, int price) {
        info = new Car(name, price);
        left = null;
        right = null;
    }
}
