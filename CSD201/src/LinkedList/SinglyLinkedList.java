/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LinkedList;

/**
 *
 * @author DUC THINH
 */
public class SinglyLinkedList {

    Node head;
    Node tail;
    int size;

    public SinglyLinkedList() {
        head = tail = null;
        size = 0;
    }
// Kiểm tra linkedlist có trống không?  

    public boolean isEmpty() {
        return (head == null);
    }
// Add vào đầu linkedlist không trả về

    public void addFirst(int value) {
        Node node = new Node(value);
        if (isEmpty()) {
            head = tail = node;
        } else {
            node.next = head;
            head = node;
        }
        size++;
    }

// Add vào cuối linkedlist không trả về
    public void addLast(int value) {
        Node node = new Node(value);
        if (isEmpty()) {
            head = tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
        size++;
    }
    
// Add vào một vị trí bất kì khác
    public void addIndex(int value, int index) {
        if (index <= 0) {
            addFirst(value);
            return;
        }
        if (index >= size) {
            addLast(value);
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
            size++;
        }
    }
// Delete phần tử đầu tiên trong linkedlist không trả về

    public void deleteFirst() {
        if (isEmpty()) {
            return;
        } else {
            head = head.next;
            size--;
        }
    }

// Delete phần tử đầu tiên trong linkedlist có trả về
    public int deleteFirst1() {
        if (isEmpty()) {
        }
        int value = head.value;
        head = head.next;
        size--;
        return value;
    }

// Delete phần tử cuối cùng trong linkedlist không trả về
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

// Delete phần tử cuối cùng trong linkedlist và trả về
    public int deleteLast1() {
        if (isEmpty()) {
            return -99999;
        }
        if (head.next == null) {
            int value = head.value;
            head = null;
            size = 0;
            return value;
        }
        Node cur = head;
        while (cur.next.next != null) {
            cur = cur.next;
        }
        int value = cur.next.value;
        cur.next = null;
        tail = cur;
        size--;
        return value;
    }

// Delete phần tử bất kỳ trong linkedlist
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

// Delete một node
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

// Hiển thị list ra màn hình
    public void display() {
        Node cur = head;
        while (cur != null) {
            if (cur != tail) {
                System.out.print(cur.value + ",");
            } else {
                System.out.print(cur.value);
            }
            cur = cur.next;
        }
        System.out.println("");
    }

//return a Node at position k
    public Node get(int k) {
        Node node = head;
        int count = 0;
        while (node != null && count < k) {
            count++;
            node = node.next;
        }
        return node;
    }

//sort the list ascending 
    public void sort() {
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                if (get(i).value > get(j).value) {
                    int temp = get(i).value;
                    get(i).value = get(j).value;
                    get(j).value = temp;
                }
            }
        }
    }

//return the first Node which infor = given x otherwise return null
    public Node search(int x) {
        Node p = head;
        while (p != null && p.value != x) {
            p = p.next;
        }
        return p;
    }
// Kich thuoc cua linkedlist
    public int size() {
        Node p = head;
        int c = 0;
        while (p != null) {
            c++;
            p = p.next;
        }
        return c;
    }
// Đảo ngược linkedlist
    public void reverse() {
        int n = size(), i, j;
        for (i = 0, j = n - 1; i < j; i++, j--) {
            Node pi = get(i);// create a node = getnode index i
            Node pj = get(j);// create a node = getnode index j
            int temp = pi.value;// Note: change value of node, not change node
            pi.value = pj.value;
            pj.value = temp;
        }
    }
    
    
	
////delete node
//	public void dele(Node q){
//		Node f,p; f=null;p=head;
//		while(p!=null){
//			if(p==q) break;
//			f=p;p=p.next;
//		}
//		if(p==null) return;
//		if(f==null){
//			head=head.next;
//			if(head==null) tail=null;
//			return;
//		}
//		f.next=p.next;
//		if(f.next==null) tail=f;
//	 }
//	 
////delete all
//	public void deleAll(int xAge){
//		Node q;
//		while(true){
//			q = searchByAge(xAge);
//			if(q==null) break;
//			dele(q);
//		}   
//    }
//	 
////delete at position k
//	public void deleteAt(int k) {
//        if (isEmpty()) return;
//        if (k == 0) {//check if node is head
//            Node p = head;
//            head = head.next;
//            p.next = null;
//        } else {
//            Node p = getNode(k);//get node position k
//            if (p == null) return;
//            Node q = getNode(k - 1);//q is node before of p
//            // Remove p
//            q.next = p.next;
//            p.next = null;
//            if (p == tail) tail = q;
//        }
//    }
//
////delete first no age < 6
//    public void deleteFirstCondition(){
//		Node p = head;
//		while(p != null){
//			if(p.info.age<6) dele(p);
//			p=p.next;
//		}
//    }
//	
////delete a node after position k
//    public void deleteAfterPosK(int k){
//        if(isEmpty()) return;
//        //remove head
//        if(k == -1) {
//            Node p = head;
//            head = head.next;
//            p.next = null;
//        }else {
//            Node p = getNode(k + 1);
//            if(p == null) return;
//            Node q = getNode(k);
//            //remove p
//            q.next = p.next;
//            p.next = null;
//            if(p == tail) tail = q;
//        }
//    }
//	
////delete node after 2 node have age < 9
//	public void deleteAfterTwoNodeAgeSmallerNine(){
//		Node p = head;
//		while(p != null && p.info.age >= 9){
//			p = p.next;
//		}
//		if(p == null && p.next == null){
//			return;
//		}
//		remove(p.next.next);
//	}
//	
////delete node thirdth have age < 6
//	public void removeThirthAgeSmallerSix(){
//		Node p = head;
//		int count = 0;
//		while(p != null){
//			if(p.info.age < 6 && count != 3) count ++;
//			else if(p.info.age < 6 && count == 3) break;
//			p = p.next;
//		}
//		remove(p);
//	}
//	
////delete node first after node have position k
//	public void deleteFirstAfterPosition(int k){
//		Node p = getNode(k);
//        if(p == null || p.next == null){//if p is tail then donothing
//            return;
//        }
//        Node q = p.next;//if p is before tail then remove tail
//        if(q.next == null){
//            tail = p;
//            p.next = null;
//        }
//        else{
//            p.next = q.next;
//            q.next = null;
//        }
//	}
//	
////delete node after node have price > xPrice
//	public void deleteAfterCondition(double xPrice){
//		Node p = head;
//		while (p != null && p < xPrice) {
//			p = p.next;
//		}
//		if (p == null || p.next == null) return;
//		Node q = p.next;
//		if (q == tail) tail = p;
//		p.next = q.next;
//		q.next = null;
//	}
//
////delete 2 node last have age > 5
//	public void removeTwoLastNodeCondition(){
//		int c = 0; int sz = size();
//		for(int i = sz - 1; i >= 0; i--){
//			Node p = getNode(i);
//			if(p.info.age > 5){
//				c++;
//				remove(p);
//            if(c >= 2) break;
//			}
//		}
//    }
//	
}
