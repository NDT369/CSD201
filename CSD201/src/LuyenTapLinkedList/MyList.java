/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LuyenTapLinkedList;

import java.util.ArrayList;

/**
 *
 * @author DUC THINH
 */
public class MyList {

    Node head, tail;

    public MyList() {
        head = tail = null;
    }

    public MyList(Node head, Node tail) {
        this.head = head;
        this.tail = tail;
    }

    public boolean isEmpty() {
        return (head == null);
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

    public int size() {
        Node p = head;
        int c = 0;
        while (p != null) {
            c++;
            p = p.next;
        }
        return c;
    }

    void addLast(String xName, int xAge) {
        if (xName.charAt(0) != 'B') {
            Node node = new Node(new Person(xName, xAge));
            if (isEmpty()) {
                head = tail = node;
            } else {
                tail.next = node;
                tail = node;
            }
        }
    }

    void addFirst(String xName, int xAge) {
        if (xName.charAt(0) != 'B') {
            Node node = new Node(new Person(xName, xAge));
            if (isEmpty()) {
                head = tail = node;
            } else {
                node.next = head;
                head = node;
            }
        }
    }
    // Add vào một vị trí bất kì khác

    public void addIndex(Person value, int index) {
        if (index <= 0) {
            addFirst(value.name, value.age);
            return;
        }
        if (index >= size()) {
            addLast(value.name, value.age);
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
            Node node = new Node(value);
            node.next = cur.next;
            cur.next = node;
        }
    }

//insert after position k
    public void addAfterPositionK(int k, Person c) {
        Node p = new Node(c);
        if (k == -1) {
            addFirst(c.name, c.age);
            return;
        }
        int count = 0;
        Node p1 = head;
        while (p1 != null && count < k) {
            p1 = p1.next;
            count++;
        }
        if (p1.next == null && count == k) {
            addLast(c.name, c.age);
            return;
        }
        p.next = p1.next;
        p1.next = p;
    }

    public void display() {
        Node cur = head;
        while (cur != null) {
            if (cur != tail) {
                System.out.print(cur.infor + "");
            } else {
                System.out.print(cur.infor);
            }
            cur = cur.next;
        }
        System.out.println("");
    }

    public void deleteNode(Node q) {
        Node f, p;
        f = null;
        p = head;
        while (p != null) {
            if (p == q) {
                break;
            }
            f = p;
            p = p.next;
        }
        if (p == null) {
            return;
        }
        if (f == null) {
            head = head.next;
            if (head == null) {
                tail = null;
            }
            return;
        }
        f.next = p.next;
        if (f.next == null) {
            tail = f;
        }
    }

    public void deleteFirst() {
        if (isEmpty()) {
            return;
        } else {
            head = head.next;
        }
    }

    public void deleteLast() {
        if (isEmpty()) {
            return;
        }
        if (head.next == null) {
            head = null;
            return;
        }
        Node cur = head;
        while (cur.next.next != null) {
            cur = cur.next;
        }
        cur.next = null;
        tail = cur;
    }

    public void deleteIndex(int index) {
        if (index < 0 || index >= size()) {
            return;
        }
        if (index == 0) {
            deleteFirst();
            return;
        }
        if (index == size() - 1) {
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
//        return value;
    }

    //delete a node after position k
    public void deleteAfterPosK(int k) {
        if (isEmpty()) {
            return;
        }
        //remove head
        if (k == -1) {
            Node p = head;
            head = head.next;
            p.next = null;
        } else {
            Node p = get(k + 1);
            if (p == null) {
                return;
            }
            Node q = get(k);
            //remove p
            q.next = p.next;
            p.next = null;
            if (p == tail) {
                tail = q;
            }
        }
    }

    void appendAnotherList(MyList h) {
        Node p = h.head;
        while (p != null) {
            addLast(p.infor.name, p.infor.age);
            p = p.next;
        }
    }

//get node max
    public Node getMax() {
        if (isEmpty()) {
            return null;
        }
        Node max = head;
        Node p = head;
        while (p != null) {
            if (p.infor.age > max.infor.age) {
                max = p;
            }
            p = p.next;
        }
        return max;
    }
//get node min

    public Node getMin() {
        if (isEmpty()) {
            return null;
        }
        Node min = head;
        Node p = head;
        while (p != null) {
            if (p.infor.age < min.infor.age) {
                min = p;
            }
            p = p.next;
        }
        return min;
    }

//There is a given MyList object  h.  Using addLast method to add to h  all elements having age>4.
    public void f3() {
        MyList h = new MyList();
        Node cur = head;
        while (cur != null) {
            if (cur.infor.age > 4) {
                h.addLast(cur.infor.name, cur.infor.age);
            }
            cur = cur.next;
        }
        head = h.head;
        tail = h.tail;
    }

//delete the first node having age<6.
    public void f4() {
        Node cur = head;
        while (cur != null) {
            if (cur.infor.age < 6) {
                deleteNode(cur);
                break;
            }
            cur = cur.next;
        }
    }

//sort the list ascendingly by name.
    public void f5() {
        for (int i = 0; i < size() - 1; i++) {
            for (int j = i + 1; j < size(); j++) {
                if (get(i).infor.name.compareToIgnoreCase(get(j).infor.name) > 0) {
                    Person temp = get(i).infor;
                    get(i).infor = get(j).infor;
                    get(j).infor = temp;
                }
            }
        }
    }
//reverse the list.

    public void f6() {
        int n = size(), i, j;
        for (i = 0, j = n - 1; i < j; i++, j--) {
            Node pi = get(i);// create a node = getnode index i
            Node pj = get(j);// create a node = getnode index j
            Person temp = pi.infor;// Note: change value of node, not change node
            pi.infor = pj.infor;
            pj.infor = temp;
        }
    }
//append another list to the list.

    public void f7() {
        MyList h = new MyList();
        h.addLast("D4", 19);
        h.addLast("D6", 13);
        h.addLast("D3", 17);
        appendAnotherList(h);
    }
//delete the position i = 3 (The first position is 0).

    public void f8() {
        deleteIndex(3);
    }
//Change the name of the first node having name = “C6” to “CX”.

    public void f9() {
        Node cur = head;
        while (cur != null) {
            if (cur.infor.name.equalsIgnoreCase("C6")) {
                cur.infor.setName("CX");
                break;
            }
            cur = cur.next;
        }
    }

// Sắp xếp 3 phần tử đầu tiên
    public void f10() {
        ArrayList<Person> list = new ArrayList<>();
        Node cur = head;
        int count = 0;
        while (cur != null) {
            list.add(cur.infor);
            cur = cur.next;
        }
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i).age > list.get(j).age) {
                    Person temp = list.get(i);
                    list.set(i, list.get(j));
                    list.set(j, temp);
                }
            }
        }

        Node cu = head;
        int c = 0;
        while (cu != null) {
            cu.infor = list.get(c);
            c++;
            cu = cu.next;
        }
    }

// Đổi chỗ Min và Max đầu tiên
    public void f11() {
        ArrayList<Person> list = new ArrayList<>();
        Node cur = head;
        while (cur != null) {
            list.add(cur.infor);
            cur = cur.next;
        }
        int min = list.get(0).age;
        int max = list.get(0).age;
        int c = 0, k = 0;
        Person maxAge = list.get(0);
        Person minAge = list.get(0);
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).age > max) {
                max = list.get(i).age;
                c = i;
                maxAge = list.get(i);
            }
            if (list.get(i).age < min) {
                min = list.get(i).age;
                k = i;
                minAge = list.get(i);
            }
        }
        Person temp = maxAge;
        list.set(c, minAge);
        list.set(k, temp);

        Node cu = head;
        int i = 0;
        while (cu != null) {
            cu.infor = list.get(i);
            cu = cu.next;
            i++;
        }
    }

//swap min max
    public void swapMinMax() {
        Node min = getMin();
        Node max = getMax();
        Person t = min.infor;
        min.infor = max.infor;
        max.infor = t;
    }

//swap node max second with node min first
    public void swapMax2Min1() {
        Node max = getMax();
        Node min = getMin();
        Node p = head;
        int count = 0;
        while (p != null) {
            if (p.infor.age == max.infor.age) {
                count++;
            }
            if (count == 2) {
                break;
            }
            p = p.next;
        }
        Person temp;
        temp = p.infor;
        p.infor = min.infor;
        min.infor = temp;
    }

//get node max
    public Person getMaxPerson() {
        if (isEmpty()) {
            return null;
        }
        Person max = head.infor;
        Node p = head;
        while (p != null) {
            if (p.infor.age > max.age) {
                max = p.infor;
            }
            p = p.next;
        }
        return max;
    }
    
//delete second biggest
    public void removeSecond() {
        Person firstMax = getMaxPerson();
        if (firstMax == null) {
            return;
        }
        int n = size();
        if (n <= 1) {
            return;
        }
        int imax = 0;
        Node p = head;
        while (p != null && p.infor.age == firstMax.age) {
            imax++;
            p = p.next;
        }
        // Find second max starting from imax
        Person secondMax = (p != null) ? p.infor : null;
        for (int i = imax + 1; i < n; i++) {
            Node pi = get(i);
            if (pi.infor.age > secondMax.age && pi.infor.age != firstMax.age) {
                imax = i;
                secondMax = pi.infor;
            }
        }
        if (imax < n) {
            deleteIndex(imax);
        }
    }

// Kiểm tra số nguyên tố
    boolean checkPrime(double value) {
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
    
// xóa tất cả các số nguyên tố   
    public void deletePrime() {
        Node cur = head;
        while (cur != null) {
            if (checkPrime(cur.infor.age)) {
                deleteNode(cur);
            }
            cur = cur.next;
        }
    }

}
