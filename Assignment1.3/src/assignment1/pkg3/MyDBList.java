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
public class MyDBList {

    Node head, tail;
    int size;

    public MyDBList() {
        head = tail = null;
        size = 0;
    }

    boolean isEmpty() {
        return head == null;
    }
// Hien thi ra man hinh
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
// Hien thi ra man hinh theo chieu nguoc lai
    void preDisplay() {
        Node cur = tail;
        String string = "";
        while (cur != null) {
            string = string + cur.person + ",";
            cur = cur.pre;
        }
        if (string.isEmpty()) {
            System.out.println("");
        } else {
            String s = string.substring(0, string.length() - 1);
            System.out.println(s);
            System.out.println("");
        }
    }
// Them vao dau danh sach
    void addFirst(Person person) {
        Node node = new Node(person);
        String ch = person.name.substring(0, 1).toLowerCase();
        if (ch.equals("u") || ch.equals("e") || ch.equals("o") || ch.equals("a") || ch.equals("i")) {
        } else {
            if (isEmpty() == true) {
                head = tail = node;
            } else {
                node.next = head;
                head.pre = node;
                head = node;
            }
            size++;
        }
    }
    
// Them vao cuoi danh sach
    void addLast(Person person) {
        Node node = new Node(person);
        if (isEmpty() == true) {
            head = tail = node;
        } else {
            node.pre = tail;
            tail.next = node;
            tail = node;
        }
        size++;
    }
// Them vao mot vi tri index
    void addIndex(Person person, int index) {
        if (index <= 0) {
            addFirst(person);
            return;
        }
        if (index >= size) {
            addLast(person);
            return;
        }
        if (index < size / 2) {
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
        } else {
            int count = size;
            Node cu = tail;
            while (cu != null && count != index + 1) {
                count--;
                cu = cu.pre;
            }
            if (cu == null) {
                return;
            } else {
                Node node = new Node(person);
                node.next = cu;
                node.pre = cu.pre;
                cu.pre.next = node;
                size++;
            }
        }
    }
// xóa phan tu dau
    void deleteFirst() {
        if (isEmpty() == true) {
            return;
        }
        head = head.next;
        size--;
    }
// xoa phan tu cuoi
    void deleteLast() {
        if (isEmpty() == true) {
            return;
        }
        tail.pre.next = null;
        tail = tail.pre;
        size--;
    }
// xoa mot phan tu o vi tri bat ki
    void deleteIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        } else if (index <= 0) {
            deleteFirst();

        } else if (index >= size - 1) {
            deleteLast();

        } else {
            if (index < size / 2) {
                int count = 0;
                Node cu = head;
                while (count != index - 1) {
                    cu = cu.next;
                    count++;
                }
                cu.next.next.pre = cu.next.pre;
                cu.next = cu.next.next;
                size--;

            } else {
                int count = size - 1;
                Node cu = tail;
                while (count != index + 1) {
                    cu = cu.pre;
                    count--;
                }
                cu.pre.pre.next = cu.pre.next;
                cu.pre = cu.pre.pre;
                size--;
            }

        }
    }
// xoa ten ma ket thuc bang phu am
    void deletePhuam() {
        Node cur = head;
        int index = 0;
        while (cur != null) {
            // Lấy ra chữ cái cuối cùng của từng phần tử
            String ch = cur.person.name.substring(cur.person.name.length() - 1).toLowerCase();
            if (ch.equals("u") || ch.equals("e") || ch.equals("o") || ch.equals("a") || ch.equals("i")) {
                return;
            // xoa phan tu
            } else {
                if (index < 0 || index >= size) {
                    return;
                } else if (index <= 0) {
                    deleteFirst();
                    index--;
                } else if (index >= size - 1) {
                    deleteLast();
                } else {
                    if (index < size / 2) {
                        int count = 0;
                        Node cu = head;
                        while (count != index - 1) {
                            cu = cu.next;
                            count++;
                        }
                        cu.next.next.pre = cu.next.pre;
                        cu.next = cu.next.next;
                        size--;

                    } else {
                        int count = size - 1;
                        Node cu = tail;
                        while (count != index + 1) {
                            cu = cu.pre;
                            count--;
                        }
                        cu.pre.pre.next = cu.pre.next;
                        cu.pre = cu.pre.pre;
                        size--;
                        index--;
                    }

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

        //Tìm index max và car max
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
        // xóa phần tử ở vị trí index max
        deleteIndex(index_max);
        display();
        // cho max lên đầu
        addFirst(person);
        display();
        //cho max xuống cuối
        deleteFirst();
        addLast(person);
        display();
    }
// Tìm min age
    void minAge() {
        Node cur = head;
        int index = 0;
        int index_min = 0;
        Person person = new Person();

        //Tìm index max và car max
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
        // xóa phần tử ở vị trí index min
        deleteIndex(index_min);
        display();
        // cho min lên đầu
        addFirst(person);
        display();
        //cho min xuống cuối
        deleteFirst();
        addLast(person);
        display();
    }
// Tính tuổi trung bình
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
// Sắp xếp theo tên tăng dần, nếu trùng nhau thì sắp xếp theo ID tăng dần
    void sort() {
        ArrayList<Person> list = new ArrayList<>();
        Node cu = head;
        // Cho từng phần tử vào trong array list
        while (cu != null) {
            list.add(cu.person);
            cu = cu.next;
        }
        // Sử dụng comparator và collections.sort để thực hiện việc sắp xếp
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
        // Gán lại giá trị cho từng phần tử trong danh sách ban đầu
        cu = head;
        int i = 0;
        while(cu!=null){
            cu.person = list.get(i);
            i++;
            cu = cu.next;
        }
    }

}
