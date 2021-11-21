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

    Node head, tail;
    int size;

    public MyList() {
        head = tail = null;
        size = 0;
    }

    public boolean isEmpty() {
        return (head == null);
    }

    public void addLast(Castor info) {
        Node node = new Node(info);
        if (isEmpty()) {
            head = tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
        size++;
    }

    public void addLast(String xPlace, int xDepth, int xType) {
        if (xPlace.charAt(0) == 'A') {
            return;
        } else {
            addLast(new Castor(xPlace, xDepth, xType));
        }
    }

    public void display() {
        Node cur = head;
        while (cur != null) {
            System.out.print(cur.info);
            cur = cur.next;
        }
        System.out.println("");
    }

    public void addFirst(Castor info) {
        Node node = new Node(info);
        if (isEmpty()) {
            head = tail = node;
        } else {
            node.next = head;
            head = node;
        }
        size++;
    }

    public void addIndex(Castor castor, int index) {
        if (index <= 0) {
            addFirst(castor);
            return;
        }
        if (index >= size) {
            addLast(castor);
            return;
        }
        int count = 0;
        Node cur = head;
        while (cur != null && count != index - 1) {
            count++;
            cur = cur.next;
        }
        if (cur == null) {
            return;
        } else {
            Node node = new Node(castor);
            node.next = cur.next;
            cur.next = node;
            size++;
        }
    }

    void f2() {
        Castor x = new Castor("Y", 3, 4);
        Castor y = new Castor("X", 1, 2);
        addFirst(x);
        addIndex(y, 3);
    }

// Đổi giá trị của max đầu tiên = "YY"
    void f3() {
        Node cur = head;
        int max = 0;
        Node q = null;
        while (cur != null) {
            if (cur.info.type > max) {
                max = cur.info.type;
                q = cur;
            }
            cur = cur.next;
        }
        Node cu = head;
        int count = 0;
        while (cu != null) {
            if (cu.info.type == q.info.type) {
                count++;
                // Đổi giá trị của max xuất hiện thứ 2
                if (count == 2) {
                    cu.info.place = "YY";
                }
            }
            cu = cu.next;
        }
    }
// Đổi giá trị của số có max lớn thứ 2 thành XX

    void f3_1() {
        Node cur = head;
        int max = 0;
        Node q = null;
        while (cur != null) {
            if (cur.info.type > max) {
                max = cur.info.type;
                q = cur;
            }
            cur = cur.next;
        }
        
        Node cu = head;
        int secondMax = 0;
        Node p = null;
        while (cu != null) {
            if (cu.info.type > secondMax && cu.info.type != q.info.type) {
                secondMax = cu.info.type;
                p = cu;
            }
            cu = cu.next;
        }
       
        Node c = head;
        while(c!=null){
            if(c.info.type == p.info.type){
                c.info.place = "XX";
            }
            c = c.next;
        }
    }

// Sắp xếp từ index = 2 đến index = 5 theo tăng dần của type
    void f4() {
        ArrayList<Castor> list = new ArrayList<>();
        Node cur = head;
        int count = 0;
        while (cur != null) {
            if (count >= 2 && count <= 5) {
                list.add(cur.info);
            }
            count++;
            cur = cur.next;
        }

        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i).type > list.get(j).type) {
                    Castor temp = list.get(i);
                    list.set(i, list.get(j));
                    list.set(j, temp);
                }
            }
        }

        Node cu = head;
        int i = 0;
        int c = 0;
        while (cu != null) {
            if (c >= 2 && c <= 5) {
                cu.info = list.get(i);
                i++;
            }
            c++;
            cu = cu.next;
        }
    }

}
