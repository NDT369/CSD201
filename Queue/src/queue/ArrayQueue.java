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
public class ArrayQueue {

    protected Object[] a;
    protected int max;
    protected int first, last;

    public ArrayQueue() {
        this(10);
    }

    public ArrayQueue(int max1) {
        max = max1;
        a = new Object[max];
        first = last = -1;
    }

    public boolean isEmpty() {
        return first == -1;
    }

    public boolean isFull() {
        return ((first == 0 && last == max - 1) || (first == last + 1));
    }

    private boolean grow() {
        int max1 = max + max / 2;
        Object[] a1 = new Object[max1];
        if (a1 == null) {
            return false;
        }
        // Lưu các giá trị từ mảng cũ vào mảng mới
        if (last > first) {
            for (int i = first; i <= last; i++) {
                a1[i - first] = a[i];
            }
        } else {
            for (int i = first; i < max; i++) {
                a1[i - first] = a[i];
                i = max - first;
                for (int j = 0; j <= last; j++) {
                    a[i + j] = a[j];
                }
            }
        }
        // Gán mảng mới cho mảng cũ
        a = a1;
        first = 0;
        last = max - 1;
        max = max1;
        return true;
    }

    // Thêm một phần tử vào cuỗi queue
    void enqueue(Object x) {
        if (isFull() && !grow()) {
            return;
        }
        // Khi index của phần tử last ở đầu cuối của mảng hoặc queue rỗng
        // gán giá trị thêm cho phần tử đầu tiên của mảng (index = 0 = last)
        if (last == max - 1 || last == -1) {
            a[0] = x;
            last = 0;
            // indexfirst = indexlast = 0
            if (first == -1) {
                first = 0;
            }
        } // Tăng index của phần tử last
        else {
            a[++last] = x;
        }
    }

    // Lấy ra phần tử đầu tiên (first) trong queue và không xóa nó
    Object front() throws Exception {
        if (isEmpty()) {
            throw new Exception();
        }
        return a[first];
    }

    // Lấy ra phần tử đầu tiên trong queue
    public Object deQueue() throws Exception {
        // Nếu queue chưa có phần tử nào throw exception
        if (isEmpty()) {
            throw new Exception();
        }
        Object x = a[first];
        // Dịch index của first
        // Khi dequeue chỉ có một phần tử
        if (first == last) {
            first = last = -1;
        } // Khi first nằm ở cuối mảng
        else if (first == max - 1) {
            first = 0;
        } // Khi phàn tử first nằm ở đầu và giữa mảng
        else {
            first++;
        }
        return x;
    }

    public void display() {
        int i;
        // Queue rỗng in ra empty
        if (first == -1) {
            System.out.printf("\nQueue is empty\n");
            return;
        }
        // Dịch i từ phần tử first đến phần tử last
        for (i = first; i <= last; i++) {
            if (i == last) {
                System.out.println(a[i]);
            } else {
                System.out.print(a[i] + ", ");
            }
        }
        return;
    }

}
