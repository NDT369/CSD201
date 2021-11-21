/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stack;

import java.util.*;

/**
 *
 * @author DUC THINH
 */
public class MyStack {

    ArrayList h;

    public MyStack() {
        h = new ArrayList();
    }

    boolean isEmpty() {
        return h.isEmpty();
    }

    void push(Object x) {
        h.add(x);
    }

    Object pop() {
        if (isEmpty()) {
            return null;
        }
        return h.remove(h.size() - 1);

    }

    public static void decToBin(int k) {
        MyStack s = new MyStack();
        System.out.print(k + " in binary system is: ");
        while (k > 0) {
            s.push(new Integer(k % 2));
            k = k / 2;
        }
        while(!s.isEmpty()){
            System.out.print(s.pop());
        }
        System.out.println();
    }
}
