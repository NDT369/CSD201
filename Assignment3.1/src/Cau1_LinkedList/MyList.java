/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cau1_LinkedList;

import java.util.ArrayList;

/**
 *
 * @author DUC THINH
 */
public class MyList {

    Node head;
    Node tail;
    int size;

    public MyList() {
        head = tail = null;
        size = 0;
    }

    public boolean isEmpty() {
        return (head == null);
    }

    public void addLast(Car car) {
        if (car.price > 100 || car.name.startsWith("B")) {
            return;
        }
        Node node = new Node(car);
        if (isEmpty()) {
            head = tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
        size++;
    }

    public void addFirst(Car car) {
        Node node = new Node(car);
        if (isEmpty()) {
            head = tail = node;
        } else {
            node.next = head;
            head = node;
        }
        size++;
    }

    public void display() {
        Node cur = head;
        while (cur != null) {
            System.out.print(cur.infor);
            cur = cur.next;
        }
        System.out.println("");
    }

    public void deleteFirst() {
        if (isEmpty()) {
            return;
        } else {
            head = head.next;
            size--;

        }
    }

    public void deleteLast() {
        if (isEmpty()) {
            return;
        }
        if (head.next == null) {
            head = null;
            size = 0;
            return;
        }
        Node cur = head;
        while (cur.next.next != null) {
            cur = cur.next;
        }
        cur.next = null;
        tail = cur;
        size--;
    }

    public int findIndex() {
        Node cur = head;
        int i = 0;
        while (cur != null) {
            if (cur.infor.price == 5) {
                break;
            }
            cur = cur.next;
            i++;
        }
        return i;
    }

    public void deleteIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }
        if (index == 0) {
            deleteFirst();
            return;
        }
        if (index == size - 1) {
            deleteLast();
            return;
        }
        int count = 0;
        Node cur = head;
        while (count != index - 1) {
            count++;
            cur = cur.next;
        }
//        int value = cur.next.value;
        cur.next = cur.next.next;
        size--;
//        return value;
    }

    public void f3() {
        int index = findIndex();
        deleteIndex(index);
    }

    public Node get(int k) {
        Node node = head;
        int count = 0;
        while (node != null && count < k) {
            count++;
            node = node.next;
        }
        return node;
    }

//    public void f4() {
//        for (int i = 0; i < size; i++) {
//            for (int j = i+1; j < size; j++) {
//                if(get(i).infor.price > get(j).infor.price){
//                    Car temp = get(i).infor;
//                    get(i).infor = get(j).infor;
//                    get(j).infor = temp;
//                }
//            }
//        }
//    }
    public void f4() {
        Node cur = head;
        ArrayList<Car> list = new ArrayList<>();
        while (cur != null) {                             
            list.add(cur.infor);
            cur = cur.next;
        }
        // Duyệt qua từng phần tử của mảng
        for (int i = 0; i < list.size()-1; i++) {
            for (int j = i+1; j < list.size(); j++) {
                if(list.get(i).price > list.get(j).price){
                    Car temp = list.get(i);
                    list.set(i, list.get(j));
                    list.set(j, temp);
                }
            }
        }

        cur = head;
        int i = 0;
        while (cur != null) {
            cur.infor = list.get(i);
            i++;
            cur = cur.next;
        }
    }

}
