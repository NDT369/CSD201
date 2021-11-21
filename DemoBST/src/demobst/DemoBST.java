/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demobst;

/**
 *
 * @author DUC THINH
 */
public class DemoBST {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        MyTree tree = new MyTree();
//        tree.add(new Car("A", 5));
//        tree.add(new Car("C", 2));
//        tree.add(new Car("E", 4));
//        tree.add(new Car("G", 3));
//        tree.add(new Car("D", 6));
//        tree.add(new Car("F", 7));
//        tree.preOrder();
//        System.out.println("");
//        tree.inOrder();
//        System.out.println("");
//        tree.postOrder();


//1. check nếu xOwner.charA(0)=”B” hay xPrice>100 thì do nothing, ngược lại thì insert new car với owner=xOwner, price=xPrice vảo tree
//        tree.add(new Car("A", 5));
//        tree.add(new Car("C", 2));
//        tree.add(new Car("E", 4));
//        tree.add(new Car("G", 3));
//        tree.add(new Car("D", 6));
//        tree.add(new Car("F", 7));
//        tree.preOrder();
//        System.out.println("");
//        tree.inOrder();
//        tree.insert("B", 30);
//        tree.insert("C", 300);
//        tree.insert("C", 30);
//        System.out.println("");
//        tree.preOrder();

//2. Thực hiện PreOrder từ root nhưng display f2 các nodes có giá trong khoảng [3.5] ( thực hiện bằng cách copy hàm preOrder() thành hàm preorder2() và sửa nó
//        tree.add(new Car("C", 6));
//        tree.add(new Car("D", 2));
//        tree.add(new Car("F", 4));
//        tree.add(new Car("H", 3));
//        tree.add(new Car("I", 5));
//        tree.add(new Car("E", 8));
//        tree.add(new Car("G", 7));
//        tree.preOrder();
//        System.out.println();
//        tree.preOrder2();
// 

// 3. Thực hiện Breadth-First từ root và delete by copying node đầu tiên có 2 con và giá <7
//    tree.add(new Car("C",8));
//    tree.add(new Car("D",4));
//    tree.add(new Car("E",12));
//    tree.add(new Car("F",2));
//    tree.add(new Car("G",6));
//    tree.add(new Car("H",10));
//    tree.add(new Car("I",14));
//    tree.add(new Car("J",1));
//    tree.add(new Car("K",3));
//    tree.add(new Car("M",5));
//    tree.add(new Car("N",7));
//    tree.add(new Car("A",9));
//    tree.add(new Car("V",11));
//    tree.add(new Car("X",13));
//    tree.add(new Car("Z",16));  
//    tree.f3();

//4, Thực hiện Breadth-First từ  root và tìm node p có con trái và giá nhỏ hơn 7. 
//Quay p sang phải với con trái của nó
    tree.add(new Car("C",8));
    tree.add(new Car("D",6));
    tree.add(new Car("E",9));
    tree.add(new Car("F",2));
    tree.add(new Car("G",7));
    tree.add(new Car("H",1));
    tree.add(new Car("I",3));
    tree.add(new Car("J",5));
    tree.add(new Car("K",4));
    tree.f4();
    }

}
