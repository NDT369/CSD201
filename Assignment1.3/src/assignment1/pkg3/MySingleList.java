/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment1.pkg3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author DUC THINH
 */
public class MySingleList {

    Node head, tail;
    int size;

    public MySingleList() {
        head = tail = null;
        size = 0;
    }

    boolean isEmpty() {
        return head == null;
    }

    void display() {
        Node cur = head;
        String string = "";
        while (cur != null) {
            string = string + cur.person + ",";
            cur = cur.next;
        }
        if (string.isEmpty()) {
            System.out.println("");
        } else {
            String s = string.substring(0, string.length() - 1);
            System.out.println(s);
            System.out.println("");
        }
    }

    void addFirst(Person person) {
        Node node = new Node(person);
        String ch = person.name.substring(0, 1).toLowerCase();
        if (ch.equals("u") || ch.equals("e") || ch.equals("o") || ch.equals("a") || ch.equals("i")) {
        } else {
            if (isEmpty()) {
                head = tail = node;
            } else {
                node.next = head;
                head = node;
            }
            size++;
        }
    }

    void addLast(Person person) {
        Node node = new Node(person);
        if (isEmpty()) {
            head = tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
        size++;
    }

    void addIndex(Person person, int index) {
        if (index <= 0) {
            addFirst(person);
            return;
        }
        if (index >= size) {
            addLast(person);
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
            Node node = new Node(person);
            node.next = cu.next;
            cu.next = node;
            size++;
        }
    }

    void deleteFirst() {
        if (isEmpty()) {
            return;
        }
        head = head.next;
        size--;
    }

    void deleteLast() {
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
// xoa mot phan tu o vi tri bat ki

    void deleteIndex(int index) {
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
        Node cu = head;
        while (count != index - 1) {
            cu = cu.next;
            count++;
        }
        cu.next = cu.next.next;
        size--;
    }
// xoa ten ma ket thuc bang phu am

    void deletePhuam() {
        Node cur = head;
        int index = 0;
        while (cur != null) {
            String ch = cur.person.name.substring(cur.person.name.length() - 1).toLowerCase();
            if (ch.equals("u") || ch.equals("e") || ch.equals("o") || ch.equals("a") || ch.equals("i")) {
                return;
            } else {
                if (index < 0 || index >= size) {
                    return;
                } else if (index <= 0) {
                    deleteFirst();
                    index--;
                } else if (index >= size - 1) {
                    deleteLast();
                } else {
                    int count = 0;
                    Node cu = head;
                    while (count != index - 1) {
                        cu = cu.next;
                        count++;
                    }
                    cu.next = cu.next.next;
                    size--;
                    index--;
                }

            }
            index++;
            cur = cur.next;
        }
    }
// Tim max age

    void maxAge() {
        Node cur = head;
        int index = 0;
        int index_max = 0;
        Person person = new Person();

        //T??m index max v?? age max
        int max = head.person.age;
        while (cur != null) {
            if (cur.person.age > max) {
                max = cur.person.age;
                index_max = index;
                person = cur.person;
            }
            index++;
            cur = cur.next;
        }
        // x??a ph???n t??? ??? v??? tr?? index max
        deleteIndex(index_max);
        display();
        // cho max l??n ?????u
        addFirst(person);
        display();
        //cho max xu???ng cu???i
        deleteFirst();
        addLast(person);
        display();
    }
// T??m min age

    void minAge() {
        Node cur = head;
        int index = 0;
        int index_min = 0;
        Person person = new Person();

        //T??m index min v?? age min
        int min = head.person.age;
        while (cur != null) {
            if (cur.person.age < min) {
                min = cur.person.age;
                index_min = index;
                person = cur.person;
            }
            index++;
            cur = cur.next;
        }
        // x??a ph???n t??? ??? v??? tr?? index min
        deleteIndex(index_min);
        display();
        // cho min l??n ?????u
        addFirst(person);
        display();
        //cho min xu???ng cu???i
        deleteFirst();
        addLast(person);
        display();
    }
// T??nh tu???i trung b??nh

    void averageAge() {
        Node cur = head;
        int sum = 0;
        int count = 0;
        double average;
        while (cur != null) {
            sum = sum + cur.person.age;
            cur = cur.next;
        }
        average = (double) sum / size;
        System.out.println(average);
    }

// S???p x???p theo t??n t??ng d???n, n???u tr??ng nhau th?? s???p x???p theo ID t??ng d???n
    void sort() {
        ArrayList<Person> list = new ArrayList<>();
        // Cho t???ng ph???n t??? v??o trong array list
        Node cu = head;
        while (cu != null) {
            list.add(cu.person);
            cu = cu.next;
        }
        // S??? d???ng comparator v?? collections.sort ????? th???c hi???n vi???c s???p x???p
        Comparator<Person> sort = new Comparator<Person>() {
            @Override
            public int compare(Person t, Person t1) {
                int value;
                if (t.name.compareTo(t1.name) > 0) {
                    value = 1;
                } else if (t.name.compareTo(t1.name) < 0) {
                    value = -1;
                } else {
                    value = t.ID.compareTo(t1.ID);
                }
                return value;
            }
        };
        Collections.sort(list, sort);
        // G??n l???i gi?? tr??? cho t???ng ph???n t??? trong danh s??ch ban ?????u
        cu = head;
        int i = 0;
        while (cu != null) {
            cu.person = list.get(i);
            i++;
            cu = cu.next;
        }
    }

}
