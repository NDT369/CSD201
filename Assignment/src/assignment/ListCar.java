/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment;

import java.util.Scanner;

/**
 *
 * @author DUC THINH
 */
public class ListCar {

    private static final Scanner sc = new Scanner(System.in);

    Node head, tail;
    int size;

    boolean isEmpty() {
        return head == null;
    }

    void addLastCondition(Car car) {
        Node node = new Node(car);
        if (node.car.name.startsWith("B") || node.car.price > 100) {

        } else {
            if (isEmpty()) {
                head = tail = node;
            } else {
                tail.next = node;
                tail = node;
            }
            size++;
        }

    }

    void addFirst(Car car) {
        Node node = new Node(car);
        if (isEmpty()) {
            head = tail = node;
        } else {
            node.next = head;
            head = node;
        }
        size++;
    }

    void addLast(Car car) {
        Node node = new Node(car);
        if (isEmpty()) {
            head = tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
        size++;
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

    void display() {
        Node cur = head;
        String string = "";
        while (cur != null) {
            string = string + cur.car + ",";
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

    int findIndex(Car car) {
        int index = 0;
        Node cu = head;
        while (cu != null) {
            if (cu.car.getPrice() < car.price) {
                return index + 1;
            }
            cu = cu.next;
            index++;
        }
        return 0;
    }

    void addIndex(Car car, int index) {
        if (index <= 0) {
            addFirst(car);
            return;
        }
        if (index >= size) {
            addLast(car);
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
            Node node = new Node(car);
            node.next = cu.next;
            cu.next = node;
            size++;
        }
    }

    void interchangeSort() {
        Node cur = head;
        int i = 0;
        Car[] cars = new Car[3];
        while (i < 3) {                              // l???y ra 3 ph???n t??? c?? price l?? m???t s??? nguy??n t???
            if (checkPrime(cur.car.price)) {
                cars[i] = cur.car;
                i++;
            }
            cur = cur.next;
        }

        Car temp;
        for (int j = 0; j < cars.length - 1; j++) {            // interchange sort
            for (int k = j + 1; k < cars.length; k++) {
                if (cars[j].price > cars[k].price) {
                    temp = cars[j];
                    cars[j] = cars[k];
                    cars[k] = temp;
                }
            }
        }

        cur = head;                                        // g??n l???i gi?? tr??? sau khi s???p x???p
        i = 0;
        while (cur != null) {
            if (checkPrime(cur.car.price) && i < 3) {
                cur.car = cars[i];
                i++;
            }
            cur = cur.next;
        }
    }

    void bubbleSort() {
        Node cur = head;
        int i = 0;
        Car[] cars = new Car[3];
        while (i < 3) {                             // l???y ra 3 ph???n t??? c?? price l?? m???t s??? nguy??n t???
            if (checkPrime(cur.car.price)) {
                cars[i] = cur.car;
                i++;
            }
            cur = cur.next;
        }

        int n = cars.length;
        for (int k = 0; k < n - 1; k++) {                 // bubble sort
            for (int j = 0; j < n - k - 1; j++) {
                if (cars[j].price > cars[j + 1].price) {
                    Car temp = cars[j];
                    cars[j] = cars[j + 1];
                    cars[j + 1] = temp;
                }
            }
        }

        cur = head;                                       // g??n l???i gi?? tr??? sau khi s???p x???p
        i = 0;
        while (cur != null) {
            if (checkPrime(cur.car.price) && i < 3) {
                cur.car = cars[i];
                i++;
            }
            cur = cur.next;
        }

    }

    void selectionSort() {
        Node cur = head;
        int i = 0;
        Car[] cars = new Car[3];
        while (i < 3) {                             // l???y ra 3 ph???n t??? c?? price l?? m???t s??? nguy??n t???
            if (checkPrime(cur.car.price)) {
                cars[i] = cur.car;
                i++;
            }
            cur = cur.next;
        }
        int n = cars.length;

        // Duy???t qua t???ng ph???n t??? c???a m???ng
        for (int k = 0; k < n - 1; k++) {                              // selection sort

            // T??m ph???n t??? nh??? nh???t trong m???ng ch??a ???????c s???p x???p
            int min_idx = k;
            for (int j = k + 1; j < n; j++) {
                if (cars[j].price < cars[min_idx].price) {
                    min_idx = j;
                }
            }

            // Ho??n ?????i ph???n t??? nh??? nh???t v?? ph???n t??? ?????u ti??n
            Car temp = cars[min_idx];
            cars[min_idx] = cars[k];
            cars[k] = temp;
        }

        cur = head;
        i = 0;
        while (cur != null) {
            if (checkPrime(cur.car.price) && i < 3) {          // g??n l???i gi?? tr??? sau khi s???p x???p
                cur.car = cars[i];
                i++;
            }
            cur = cur.next;
        }

    }

// Ki???m tra s??? nguy??n t???
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
    
//f4
// S???p x???p i ph???n t??? ?????u ti??n
    void interchange() {
        Node cur = head;
        System.out.print("Nhap i = ");
        int i = sc.nextInt();
        Car[] cars = new Car[i];
        int count = 0;
        while (count < i) {
            cars[count] = cur.car;
            count++;
            cur = cur.next;
        }

        Car temp;
        for (int j = 0; j < cars.length - 1; j++) {            
            for (int k = j + 1; k < cars.length; k++) {
                if (cars[j].price > cars[k].price) {
                    temp = cars[j];
                    cars[j] = cars[k];
                    cars[k] = temp;
                }
            }
        }

        cur = head;                                      
        count = 0;
        while (count < i) {
            cur.car = cars[count];
            count++;
            cur = cur.next;
        }
    }
    
//f5
// xO?? b??? m???t ph???n t??? n???u gi?? c???a n?? l?? m???t s??? nguy??n t???
    void deleteIndex(int index) {
        Node cu = head;
        Car[] cars = new Car[size];
        int i = 0;
        while (cu != null) {
            cars[i] = cu.car;
            cu = cu.next;
            i++;
        }

        for (int j = 0; j < cars.length; j++) {
            if (j == index && checkPrime(cars[index].price)) {
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
                    cur = cur.next;
                    count++;
                }
//                Car car = cur.next.car;
                cur.next = cur.next.next;
                size--;
            } else {
            }
        }

    }
//f6
// x??a t???t c??? ph???n t??? car c?? price l?? m???t s??? nguy??n t???
    void deletePrime() {
        Node cu = head;
        System.out.print("Enter i = ");
        int i = sc.nextInt();
        int k = 0;
        int index = 0;
        while (cu != null && k < i) {
            if (checkPrime(cu.car.price)) {
                if (index == 0) {
                    deleteFirst();
                    index--;
                } else if (index == size - 1) {
                    deleteLast();
                } else {
                    int count = 0;
                    Node cur = head;
                    while (count != index - 1) {
                        cur = cur.next;
                        count++;
                    }
//                    Car car = cur.next.car;
                    cur.next = cur.next.next;
                    size--;
                    index--;
                }
                k++;
            }
            index++;
            cu = cu.next;
        }
    }

//    void deleteMaxPrice() {
//        Node cu = head;
//        int index = 0;
//        int index_max = 0;
//        double max = head.car.price;
//        while (cu != null) {
//            if (cu.car.price > max) {
//                max = cu.car.price;
//                index_max = index;
//            }
//            index++;
//            cu = cu.next;
//        }
//
//        if (index_max == 0) {
//            deleteFirst();
//        } else {
//            int count = 0;
//            Node cur = head;
//            while (count != index_max - 1) {
//                cur = cur.next;
//                count++;
//            }
////            Car car = cur.next.car;
//            cur.next = cur.next.next;
//            size--;
//        }
//    }
//
//    void addFirstMaxPrice() {
//        Node cu = head;
//        Car car = new Car();
//        double max = head.car.price;
//        while (cu != null) {
//            if (cu.car.price > max) {
//                max = cu.car.price;
//                car = cu.car;
//            }
//            cu = cu.next;
//        }
//        deleteMaxPrice();
//        addFirst(car);
//    }
//
//    void addLastMaxPrice() {
//        Node cu = head;
//        Car car = new Car();
//        double max = head.car.price;
//        while (cu != null) {
//            if (cu.car.price > max) {
//                max = cu.car.price;
//                car = cu.car;
//            }
//            cu = cu.next;
//        }
//        deleteMaxPrice();
//        addLast(car);
//    }

    void f7() {
        Node cu = head;
        int index = 0;
        int index_max = 0;
        Car car1 = new Car();
        
        //T??m index max v?? car max
        double max = head.car.price;
        while (cu != null) {
            if (cu.car.price > max) {
                max = cu.car.price;
                index_max = index;
                car1 = cu.car;
            }
            index++;
            cu = cu.next;
        }
        
        // x??a ph???n t??? ??? v??? tr?? index max
        if (index_max == 0) {
            deleteFirst();
        } else {
            int count = 0;
            Node cur = head;
            while (count != index_max - 1) {
                cur = cur.next;
                count++;
            }
//            Car car = cur.next.car;
            cur.next = cur.next.next;
            size--;
        }
        display();
        // cho max l??n ?????u
        addFirst(car1);
        display();
        //cho max xu???ng cu???i
        deleteFirst();     
        addLast(car1);
        display();
    }
}
