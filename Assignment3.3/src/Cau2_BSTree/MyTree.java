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
// Kiểm tra trống

    public boolean isEmpty() {
        return root == null;
    }
// add vào tree

    public void add(Castor castor) {
        Node node = new Node(castor);
        if (isEmpty()) {
            root = node;
            return;
        }
        Node cur = root;
        Node father = null;
        while (cur != null) {
            if (cur.info.depth == castor.depth) {
                System.out.println("Không thể add " + castor + " vào trong tree!");
                return;
            }
            father = cur;
            if (cur.info.depth < castor.depth) {
                cur = cur.right;
            } else {
                cur = cur.left;
            }
        }
        if (father.info.depth < castor.depth) {
            father.right = node;
        } else {
            father.left = node;
        }
    }

    public void insert(String xPlace, int xDepth, int xType) {
        if (xPlace.charAt(0) == 'B') {
        } else {
            add(new Castor(xPlace, xDepth, xType));
        }
    }

    public void visit(Node p) {
        System.out.print(p.info + "");
    }
//preorder

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
//postorder

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

    void postOrder2(Node p) {
        if (p == null) {
            return;
        }
        postOrder2(p.left);
        postOrder2(p.right);
        if (p.info.type < 7) {
            visit(p);
        }
    }

    void postOrder2() {
        postOrder2(root);
    }
//inorder

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
//breathfirstorder

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
// delete by copy 
    void deleteByCopyL(Node p) { // xóa node p theo con trái
        if (p == null) {// node bằng null
            return;
        }
        if (p.right == null) { // Khong có con trái thì copy con phải
            return;
        }
        if (p.left.right == null) { // Nếu p chỉ có con trái
            p.info = p.left.info;
            p.left = p.left.left; // thằng giàu nhất của con phải là chính nó
            return;
        } else if (p.left.left == null) {
            p.info = p.right.info;
            p.right = p.right.right;
            return;
        }
        else {
            Node father = p.left; // father sẽ quản lý node cha của node
        // ngoài cùng bên phải cua con bên trái
        Node cu = p.left.right;
        while (father.right.right != null) {
            father = father.right;
            p.info = father.right.info;
            if (father.right.left == null) {
                father.right = null;
                return;
            }
            father.right = father.right.left;
        }
    }
}
//Quay phải
Node rotateRight(Node p) {
        if (p == null || p.left == null) {
            return null;
        }
        Node child = p.left;
        p.left = child.right;
        child.right = p;
        return child;
    }
// Xác định cha của một node
    Node getParent(Node p) {
        if (p == root) {
            return null;
        }
        Node father = null;
        Node cu = root;
        while (cu != null && cu.info.depth != p.info.depth) {
            father = cu;
            if (cu.info.depth < p.info.depth) {
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
//postorder khi type < 7

    void f2() {
        postOrder2();
    }
    
//Xác định nốt có con trái thứ 2 rồi lấy node có depth max từ subtree
    void f3() {
        MyQueue queue = new MyQueue();
        int count = 0;
        Node q = new Node();
        if (isEmpty()) {
            return;
        }
        //Đưa vào trong queue
        queue.Enqueue(root);
        while (!queue.isEmpty()) {
            Node node = queue.Dequeue();
            if (node.left != null) {
                queue.Enqueue(node.left);
            }
            if (node.right != null) {
                queue.Enqueue(node.right);
            }
            if (node.left != null) {
                if (count == 1) {
                    q = node;
                    break;
                }
                count++;
            }
        }
        
        MyQueue queue1 = new MyQueue();
        int max = 0;
        Node q1 = new Node();
        if (isEmpty()) {
            return;
        }
        queue1.Enqueue(q);
        while (!queue1.isEmpty()) {
            Node node = queue1.Dequeue();
            if (node.left != null) {
                queue1.Enqueue(node.left);
            }
            if (node.right != null) {
                queue1.Enqueue(node.right);
            }
            if (max < node.info.depth) {
                max = node.info.depth;
                q1 = node;
            }
        }
        deleteByCopyL(q1);

    }

// Xác định node có con trái thứ 2 và quay phải
    void f4() {
        MyQueue queue = new MyQueue();
        int count = 0;
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
            if (node.left != null) {
                if (count == 1) {
                    q = node;
                    break;
                }
                count++;
            }
        }

        if (q == null) {
            System.out.println("Không tồn tại");
        } else {
            Node father = getParent(q);
            Node father1 = rotateRight(q);
            if (father.info.depth > q.info.depth) {
                father.left = father1;
            } else {
                father.right = father1;
            }
        }
    }

}
