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
    Castor info;
    Node left, right;

    public Node() {

    }
    public Node(Castor info, Node left, Node right) {
        this.info = info;
        this.left = left;
        this.right = right;
    }
    
    public Node(Castor info) {
        this.info = info;
        left = null;
        right = null;
    }

    public Node(String name, int depth,int type) {
        info = new Castor(name, depth,type);
        left = null;
        right = null;
    }
}
