/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cau2_BSTree;

/**
 *
 * @author DUC THINH
 */
public class MyTree {

    Node root;

    public MyTree() {
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void add(Car car) {
        Node node = new Node(car);
        if (isEmpty()) {
            root = node;
            return;
        }
        Node cur = root;
        Node father = null;
        while (cur != null) {
            if (cur.value.price == car.price) {
                System.out.println("Không thể add " + car + " vào trong tree!");
                return;
            }
            father = cur;
            if (cur.value.price < car.price) {
                cur = cur.right;
            } else {
                cur = cur.left;
            }
        }
        if (father.value.price < car.price) {
            father.right = node;
        } else {
            father.left = node;
        }
    }
// Void insert (string xOwner, int xPrice), check nếu xOwner.charA(0)=”B” hay xPrice>100 thì do nothing, 
//ngược lại thì insert new car với owner=xOwner, price=xPrice vảo tree

    public void insert(String xOwner, int xPrice) {
        if (xOwner.toUpperCase().charAt(0) == 'B' || xPrice > 100) {
        } else {
            add(new Car(xOwner, xPrice));
        }
    }

    public void visit(Node p) {
        System.out.print(p.value + "");
    }

    public void preOrder(Node p) {
        if (p == null) {
            return;
        }
        visit(p);
        preOrder(p.left);
        preOrder(p.right);
    }

    public void preOrder() {
        preOrder(root);
    }

    void postOrder(Node p) {
        if (p == null) {
            return;
        }
        postOrder(p.left);
        postOrder(p.right);
        visit(p);
    }

    void postOrder() {
        postOrder(root);
    }

    void inOrder(Node p) {
        if (p == null) {
            return;
        }
        inOrder(p.left);
        visit(p);
        inOrder(p.right);
    }

    void inOrder() {
        inOrder(root);
    }

    void BreathFirstOder() {
        BreathFirstOder(root);
    }

    void BreathFirstOder(Node p) {
        MyQueue queue = new MyQueue();
        if (isEmpty()) {
            return;
        }
        queue.Enqueue(root);
        while (!queue.isEmpty()) {
            Node node = queue.Dequeue();
            if (node.left != null) {
                queue.Enqueue(node.left);
            }
            if (node.right != null) {
                queue.Enqueue(node.right);
            }
            visit(node);
        }
    }

    Node getParent(Node p) {
        if (p == root) {
            return null;
        }
        Node father = null;
        Node cu = root;
        while (cu != null && cu.value.price != p.value.price) {
            father = cu;
            if (cu.value.price < p.value.price) {
                cu = cu.right;
            } else {
                cu = cu.left;
            }
        }
        if (cu == null) { // không tìm thấy giá trị p trong list
            return null;
        }
        return father;
    }

    void deleteByCopyL(Node p) { // xóa node p theo con trái
        if (p == null) {// node bằng null
            return;
        }
        if (p.left == null) { // Khong có con trái thì copy con phải
            return;
        }
        if (p.left.right == null) { // Nếu p chỉ có con trái
            p.value = p.left.value;
            p.left = p.left.left; // thằng giàu nhất của con phải là chính nó
            return;
        } else {
            Node father = p.left; // father sẽ quản lý node cha của node
            // ngoài cùng bên phải cua con bên trái
            Node cu = p.left.right;
            while (father.right.right != null) {
                father = father.right;
                p.value = father.right.value;
                if (father.right.left == null) {
                    father.right = null;
                    return;
                }
                father.right = father.right.left;
            }
        }
    }

    Node rotateRight(Node p) {
        if (p == null || p.left == null) {
            return null;
        }
        Node child = p.left;
        p.left = child.right;
        child.right = p;
        return child;
    }

    //Void f2(): Thực hiện PreOrder từ root nhưng display f2 các nodes có giá trong khoảng [3.5]
    public void preOrder2(Node p) {
        if (p == null) {
            return;
        }
        if (p.value.price >= 3 && p.value.price <= 5) {
            visit(p);
        }
        preOrder2(p.left);
        preOrder2(p.right);
    }

    public void preOrder2() {
        preOrder2(root);
    }

    public void f2() {
        preOrder2();
    }
//

    public void f3() {
        MyQueue queue = new MyQueue();
        Node q = new Node();
        if (isEmpty()) {
            return;
        }
        queue.Enqueue(root);
        while (!queue.isEmpty()) {
            Node node = queue.Dequeue();
            if (node.left != null) {
                queue.Enqueue(node.left);
            }
            if (node.right != null) {
                queue.Enqueue(node.right);
            }
            if (node.right != null && node.left != null && node.value.price < 7) {
                q = node;
                break;
            }
        }
        deleteByCopyL(q);
        BreathFirstOder();
    }
//

    public void f4() {
        MyQueue queue = new MyQueue();
        Node q = new Node();
        if (isEmpty()) {
            return;
        }
        queue.Enqueue(root);
        while (!queue.isEmpty()) {
            Node node = queue.Dequeue();
            if (node.left != null) {
                queue.Enqueue(node.left);
            }
            if (node.right != null) {
                queue.Enqueue(node.right);
            }
            if (node.left != null && node.value.price < 7) {
                q = node;
                break;
            }
        }
        if(q == null){
            System.out.println("Không tồn tại");
        }else{
        Node father  = getParent(q);
        Node father1 = rotateRight(q);
        if(father.value.price > q.value.price){
            father.left = father1;
        }else{
            father.right = father1;
        }
        }    
        BreathFirstOder();
    }

}
