/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linkedlist;

/**
 *
 * @author DUC THINH
 */
public class UsingMyList {
    public static void main(String [] args){
        MyList my = new MyList();
        my.addLast(3);
        my.addLast(6);
        my.addLast(5);
        my.addLast(7);
        my.addLast(2);
//        my.display();
//        my.addLast(9);
//        my.addFirst(10);
//        my.addFirst(20);
//        my.addFirst(30);
//        my.addFirst();
//        my.addIndex(56,3);
        my.addIndex(8,my.firstPrime()+1);
        my.display();
        
    }
}
