    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linkedlist;

import static sun.nio.ch.IOStatus.check;

/**
 *
 * @author DUC THINH
 */
public class MyList {

    Node head, tail;
    int size;

    public MyList() {
        head = tail = null;
        size = 0;
    }

    boolean isEmpty() {
        return head == null;
    }

    void display() {
        Node cur = head;
        while (cur != null) {
            System.out.print(cur.value + " ");
            cur = cur.next;
        }
        System.out.println("");
    }

    void addLast(int value) {
        Node node = new Node(value);
        if (isEmpty()) {
            head = tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
        size++;
    }

    void addFirst(int value) {
        Node node = new Node(value);
        if (isEmpty()) {
            head = tail = node;
        } else {
            node.next = head;
            head = node;
        }
        size++;
    }

    int findIndex() {
        int index = 0;
        Node cu = head;
        while (cu != null) {
            if (check(cu.value)) {
                return index;
            }
            cu = cu.next;
            index++;
        }
        return 0;
    }

    void addIndex(int value, int index) {
        if (index <= 0) {
            addFirst(value);
            return;
        }
        if (index >= size) {
            addLast(value);
            return;
        }
        int count = 0;
        Node cu = head;
        while (cu != null && count != index - 1) {
            count++;
            cu = cu.next;
        }
        if (cu == null) {
            return;
        } else {
            Node node = new Node(value);
            node.next = cu.next;
            cu.next = node;
            size++;
        }
    }

    int deleteFirt() {   // có trả về giá trị vừa xóa
        if (isEmpty()) {
            return -999;
        }
        int value = head.value;
        head = head.next;
        return value;
    }

    void deleteFirt1() {   //không trả về giá trị vừa xóa
        if (isEmpty()) {
            return;
        }
        int value = head.value;
        head = head.next;
    }

    int deleteLast() { // có giả về giá trị vừa xóa
        if (isEmpty()) {
            return -999;
        }
        Node cu = head;
        while (cu.next.next != null) {
            cu = cu.next;
        }
        cu.next = null;
        tail = cu;
        size--;
        return 0; // ??????????
    }

    void deleteLast1() { // có giả về giá trị vừa xóa
        if (isEmpty()) {
            return;
        }
        Node cu = head;
        while (cu.next.next != null) {
            cu = cu.next;
        }
        cu.next = null;
        tail = cu;
        size--;
    }

    void deleteIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }
        if (index == 0) {
            deleteFirt1();
            return;
        }
        if (index == size - 1) {
            deleteLast1();
            return;
        }
        int count = 0;
        Node cu = head;
        while (count != index - 1) {
            cu = cu.next;
            count++;
        }
        int value = cu.next.value;
        cu.next = cu.next.next;
        size--;

    }

    int firstPrime() {
        int index = 0;
        Node cur = head;
        while (cur != null) {
            if (checkprime(cur.value) == true) {
                return index;
            }
            index++;
            cur = cur.next;
        }
        return -1;
    }

    boolean checkprime(int value) {
        if (value <= 1) {
           return false;
       }
       for (int i = 2; i <= Math.sqrt(value); i++) {
           if (value % i == 0) {
               return false;
           }
       }
       return true;
        
    }

}
