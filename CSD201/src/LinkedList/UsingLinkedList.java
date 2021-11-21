/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LinkedList;

/**
 *
 * @author DUC THINH
 */
public class UsingLinkedList {
        public static void main(String[] args) {
        // TODO code application logic here
        SinglyLinkedList linkList = new SinglyLinkedList();
        linkList.addLast(2);
        linkList.addLast(0);
        linkList.addLast(7);
        linkList.addLast(3);
        linkList.addLast(6);
        linkList.addLast(8);
        linkList.addLast(9);
        linkList.display();
        linkList.reverse();
        linkList.display();      
    }
    
}
