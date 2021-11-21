/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package queue;

/**
 *
 * @author DUC THINH
 */
public class PriorityQueue {

    protected int[] a;
    int top, max;

    // Constructor không tham số khai báo dung lượng mảng
    public PriorityQueue() {
        this(50);
    }

    // Constructor có tham số khai báo dung lượng của mảng  = max 1
    public PriorityQueue(int max1) {
        max = max1;
        a = new int[max];
        top = -1;
    }

    // Tăng dung lượng của mảng
    protected boolean grow() {
        int max1 = max + max / 2;
        int[] a1 = new int[max1];
        if (a1 == null) {
            return false;
        }
        for (int i = 0; i <= top; i++) {
            a1[i] = a[i];
        }
        a = a1;
        return true;
    }

    // Kiểm tra mảng có rỗng queue hay không
    public boolean isEmpty() {
        return top == -1;
    }

    // Kiểm tra mảng đã full queue hay chưa
    public boolean isFull() {
        return top == max - 1;
    }

    // Xóa toàn bộ queue trong mảng
    public void clear() {
        top = -1;
    }

    // Enqueue phần tử theo thứ tự ưu tiên tăng dần
    public void enqueue(int x) {
        if (isFull() && !grow()) {
            return;
        }
        if (top == -1) {
            a[0] = x;
            top = 0;
            return;
        }
        int i = top;
        while (i >= 0 && x < a[i]) {
            a[i + 1] = a[i];
            i--;
        }
        a[i + 1] = x;
        top++;
    }

    // Lấy phần tử lớn nhất nhưng không xóa
    public float front() {
        assert (!isEmpty());
        return a[top];
    }

    // Dequeue phần tử lớn nhất
    public float deQueue() {
        assert (isEmpty());
        float x = a[top];
        top--;
        return x;
    }

    public void display() {
        // Queue rỗng in ra empty
        if (top == -1) {
            System.out.printf("\nQueue is empty\n");
            return;
        }
        // Dịch i từ phần tử first đến phần tử last
        for (int i = 0; i <= top; i++) {
            if (i == top) {
                System.out.println(a[i]);
            } else {
                System.out.print(a[i] + ", ");
            }
        }
        return;
    }
}
