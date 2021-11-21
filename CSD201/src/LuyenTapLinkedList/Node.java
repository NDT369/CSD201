/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LuyenTapLinkedList;

/**
 *
 * @author DUC THINH
 */
public class Node {

    public Person infor;
    public Node next;

    public Node() {
    }

    public Node(Person infor) {
        this.infor = infor;
        this.next = null;
    }
}
