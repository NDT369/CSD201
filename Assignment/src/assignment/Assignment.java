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
public class Assignment {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ListCar list = new ListCar();
//Cau 1:
        list.addLast(new Car("A", 20.0));
        list.addLast(new Car("C", 18.0));
        list.addLast(new Car("D", 15.0));
        list.addLast(new Car("E", 25.0));
        list.display();
//        list.addLastCondition(new Car("B", 40.0)); 
//        list.addLastCondition(new Car("H", 120.0));
        list.addIndex(new Car("K",30), 2);
        list.display();

//Cau 2:        
//        list.addIndex(new Car("F",30,16), list.findIndex(new Car("F",30,16)));  
//        list.display();
//Cau 3:
//        list.addLast(new Car("A", 5));
//        list.addLast(new Car("C", 8));
//        list.addLast(new Car("D", 3));
//        list.addLast(new Car("E", 7));
//        list.addLast(new Car("K", 4));
//        list.addLast(new Car("J", 9));
//        list.addLast(new Car("F", 4));
//        list.addLast(new Car("G", 6));
//        list.addLast(new Car("H", 4));
//        list.addLast(new Car("M", 12));
//        list.display();
//        list.bubbleSort();
//        list.interchangeSort();
//        list.selectionSort();
//        list.display();
// Cau4:
//        list.addLast(new Car("A", 20.0));
//        list.addLast(new Car("C", 19.0));
//        list.addLast(new Car("D", 30.0));
//        list.addLast(new Car("F", 23.0));
//        list.addLast(new Car("E", 25.0));
//        list.display();
//        list.interchange();
//        list.display();
// Cau5:
//        list.addLast(new Car("A", 20.0));
//        list.addLast(new Car("C", 19.0));
//        list.addLast(new Car("D", 30.0));
//        list.addLast(new Car("F", 23.0));
//        list.addLast(new Car("E", 25.0));
//        list.display();
//        list.deleteIndex(0);
//        list.display();
// Cau6:
//        list.addLast(new Car("A", 20.0));
//        list.addLast(new Car("C", 19.0));
//        list.addLast(new Car("D", 13.0));
//        list.addLast(new Car("F", 23.0));
//        list.addLast(new Car("E", 25.0));
//        list.display();
//        list.deletePrime();
//        list.display();
// Cau7:
//        list.addLast(new Car("A", 20.0));
//        list.addLast(new Car("C", 19.0));
//        list.addLast(new Car("D", 30.0));
//        list.addLast(new Car("F", 23.0));
//        list.addLast(new Car("E", 25.0));
//        list.display();
//        list.deleteMaxPrice();
//        list.display();
//        list.addFirstMaxPrice();
//        list.display();
//        list.addLastMaxPrice();
//        list.display();
//        list.f7();
    }

}
