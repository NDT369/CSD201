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
public class Assignment13 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // TODO code application logic here
//Cách 1: Double LinkedList
        MyDBList list = new MyDBList();
//Cau1
//        list.addLast(new Person("a1", "Thinh", 20));
//        list.addLast(new Person("a2", "Binh", 20));
//        list.addLast(new Person("a3", "Giang", 20));
//        list.addLast(new Person("a4", "minh", 20));
//        list.display();
//        list.addFirst(new Person("a0","An",20));
//        list.addFirst(new Person("a0","Linh",20));
//        list.display();
//------------------------------------------------------------------------------
//Cau2
//        list.addLast(new Person("a1", "Thinh", 20));
//        list.addLast(new Person("a2", "Binh", 20));
//        list.addLast(new Person("a3", "GianG", 20));
//        list.addLast(new Person("a4", "tue", 20));
//        list.display();
//        list.deletePhuam();
//        list.display();
//------------------------------------------------------------------------------
//Cau3
//        list.addLast(new Person("a1", "Thinh", 25));
//        list.addLast(new Person("a2", "Thinh", 20));
//        list.addLast(new Person("a3", "Giang", 30));
//        list.addLast(new Person("a4", "Anh", 10)); 
//        list.display();
//        list.sort();
//        list.display();     
//------------------------------------------------------------------------------       
//Cau4
//        list.addLast(new Person("a1", "Thinh", 25));
//        list.addLast(new Person("a2", "Binh", 20));
//        list.addLast(new Person("a3", "Giang", 30));
//        list.addLast(new Person("a4", "minh", 10));
//        list.maxAge();
//        list.minAge();
//------------------------------------------------------------------------------
//Cau5
//        list.addLast(new Person("a1", "Thinh", 25));
//        list.addLast(new Person("a2", "Binh", 20));
//        list.addLast(new Person("a3", "Giang", 30));
//        list.addLast(new Person("a4", "minh", 10));
//        list.averageAge();

























//******************************************************************************
//Cách 2: SingleLinkedList
        MySingleList list2 = new MySingleList();
//Cau1
//        list2.addLast(new Person("a1", "Thinh", 20));
//        list2.addLast(new Person("a2", "Binh", 20));
//        list2.addLast(new Person("a3", "Giang", 20));
//        list2.addLast(new Person("a4", "minh", 20));
//        list2.display();
//        list2.addFirst(new Person("1","A",20));
//        list2.display();

//Cau2
        list2.addLast(new Person("a1", "Thinh", 20));
        list2.addLast(new Person("a2", "Binh", 20));
        list2.addLast(new Person("a3", "Gia", 20));
        list2.addLast(new Person("a4", "tuE", 20));
        list2.deletePhuam();
        list2.display();

//Cau3
//        list2.addLast(new Person("a1", "Thinh", 25));
//        list2.addLast(new Person("a2", "Thinh", 20));
//        list2.addLast(new Person("a3", "Giang", 30));
//        list2.addLast(new Person("a4", "Anh", 10)); 
//        list2.display();
//        list2.sort();
//        list2.display();
//Cau4
//        list2.addLast(new Person("a1", "Thinh", 25));
//        list2.addLast(new Person("a2", "Binh", 20));
//        list2.addLast(new Person("a3", "Giang", 30));
//        list2.addLast(new Person("a4", "minh", 10));
//        list2.maxAge();
//        list2.minAge();
//Cau5
//        list.addLast(new Person("a1", "Thinh", 25));
//        list.addLast(new Person("a2", "Binh", 20));
//        list.addLast(new Person("a3", "Giang", 30));
//        list.addLast(new Person("a4", "minh", 10));
//        list.averageAge();
    }

}
