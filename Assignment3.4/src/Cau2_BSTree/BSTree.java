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
public class BSTree {

    Node root;

    public BSTree() {
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
            if (cur.info.weight == castor.weight) {
                System.out.println("Không thể add " + castor + " vào trong tree!");
                return;
            }
            father = cur;
            if (cur.info.weight < castor.weight) {
                cur = cur.right;
            } else {
                cur = cur.left;
            }
        }
        if (father.info.weight < castor.weight) {
            father.right = node;
        } else {
            father.left = node;
        }
    }

    public void insert(String xPlace, int xDepth, int xType) {
        if (xPlace.charAt(0) == 'A') {
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
        if (p.info.depth < 7) {
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
    
    //get parent
    Node getParent(Node p) {
        if (p == root) {
            return null;
        }
        Node father = null;
        Node cu = root;
        while (cu != null && cu.info.weight != p.info.weight) {
            father = cu;
            if (cu.info.weight < p.info.weight) {
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
    
    Node rotateLeft(Node p) {
        if (p == null || p.right == null) {
            return null;
        }
        Node child = p.right;
        p.right = child.left;
        child.left = p;
        return child;
    }

    public void deleteByCopy(Node p) {
        //find f is father of p
        Node f = null, q = root;
        while (q != p) {
            f = q;
            if (q.info.weight > p.info.weight) {
                q = q.left;
            } else {
                q = q.right;
            }
        }
        //1.p has no child
        if (p.left == null && p.right == null) {
            if (f == null) {
                root = null;
            } else if (f.left == p) {
                f.left = null;
            } else {
                f.right = null;
            }
        } //2.p has left child only
        else if (p.left != null && p.right == null) {
            if (f == null) {
                root = p.left;
            } else if (f.left == p) {
                f.left = p.left;
            } else {
                f.right = p.left;
            }
        } //3.p has right child only
        else if (p.left == null && p.right != null) {
            if (f == null) {
                root = p.right;
            } else if (f.left == p) {
                f.left = p.right;
            } else {
                f.right = p.right;
            }
        } //4.p has both child
        else if (p.left != null && p.right != null) {
            //tim q la node lon nhat ben con trai cua p -> q la con phai lon nhat
            //cua con trai cua p
            q = p.left;
            f = null;
            while (q.right != null) {
                f = q;
                q = q.right;
            }
            p.info = q.info;
            //delete q
            if (f == null) {
                p.left = q.left;
            } else {
                f.right = q.left;
            }
        }
    }
    
      void deleteByCopyR(Node p) { // xóa node p theo con trái
        if (p == null) {// node bằng null
            return;
        }
        if (p.right == null) { // Khong có con trái thì copy con phải
            return;
        }
         if (p.right.left == null) {
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

    void f2() {
        postOrder2();
    }

    void f3() {
        MyQueue queue = new MyQueue();
        int count = 0;
        Node q = null;
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
            if (node.right != null) {
                if (count == 1) {
                    q = node;
                    break;
                }
                count++;
            }
        }

        MyQueue queue1 = new MyQueue();
        Node p = null;
        int min = q.info.weight;
        p = q;
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
            if (node.info.weight < min) {
                min = node.info.weight;
                p = node;
            }
        }
        deleteByCopyR(p);
    }

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
            if (node.right != null) {
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
            Node father1 = rotateLeft(q);
            if (father.info.depth > q.info.depth) {
                father.left = father1;
            } else {
                father.right = father1;
            }
        }
    }

}
