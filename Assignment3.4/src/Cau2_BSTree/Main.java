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
public class Main {
     public static void main(String[] args) {
        BSTree tree = new BSTree();
//f1
//          tree.add(new Castor("B",9,4));
//          tree.add(new Castor("C",4,3));
//          tree.add(new Castor("D",8,6));
//          tree.add(new Castor("E",2,5));
//          tree.add(new Castor("F",6,7));
//          tree.BreathFirstOder();
//          System.out.println("");
//          tree.inOrder();
//F2
//          tree.add(new Castor("C",3,6));
//          tree.add(new Castor("E",2,8));
//          tree.add(new Castor("G",8,7));
//          tree.add(new Castor("D",7,2));
//          tree.add(new Castor("F",4,5));
//          tree.add(new Castor("H",6,3));
//          tree.add(new Castor("I",5,4));
//          tree.postOrder();
//          System.out.println("");
//          tree.f2();
//f3
          tree.add(new Castor("C",5,2));
          tree.add(new Castor("D",2,1));
          tree.add(new Castor("E",6,5));
          tree.add(new Castor("F",1,3));
          tree.add(new Castor("G",4,6));
          tree.add(new Castor("H",3,4));
          tree.BreathFirstOder();
          System.out.println("");
          tree.f3();
          tree.BreathFirstOder();
//f4
//          tree.add(new Castor("C",5,2));
//          tree.add(new Castor("D",2,1));
//          tree.add(new Castor("E",6,5));
//          tree.add(new Castor("F",1,3));
//          tree.add(new Castor("G",4,6));
//          tree.add(new Castor("H",3,4));
//          tree.BreathFirstOder();
//          System.out.println("");
//          tree.f4();
//          tree.BreathFirstOder();
     }
}
