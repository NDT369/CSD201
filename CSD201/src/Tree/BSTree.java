/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tree;

import java.util.ArrayList;

/**
 *
 * @author DUC THINH
 */
public class BSTree {

    Node root;

    public BSTree() {
    }

    boolean isEmpty() {
        return root == null;
    }
// Thêm các node vào tree

    void add(Car value) {
        Node node = new Node(value);
        if (isEmpty()) {
            root = node;
            return;
        }
        Node cu = root;
        Node father = null;
        while (cu != null) {
            if (cu.info.price == value.price) {
                System.out.println("Không thể add " + value + " vào trong tree!");// BST không chấp nhận giá trị trùng nhau
                return;
            }
            father = cu;
            if (cu.info.price < value.price) {
                cu = cu.right;
            } else {
                cu = cu.left;
            }
        }
        if (father == null) {
            root = node;
        } else if (father.info.price < value.price) {
            father.right = node;
        } else {
            father.left = node;
        }
    }

//get parent
    Node getParent(Node p) {
        if (p == root) {
            return null;
        }
        Node father = null;
        Node cu = root;
        while (cu != null && cu.info.price != p.info.price) {
            father = cu;
            if (cu.info.price < p.info.price) {
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

//count node in tree
    public int count(Node p) {
        if (p == null) {
            return (0);
        }
        int k, h, r;
        k = count(p.left);
        h = count(p.right);
        r = k + h + 1;
        return (r);
    }
//count node have 1 child

    int countModifer(Node p) {
        int n = 0;
        MyQueue m = new MyQueue();
        m.Enqueue(p);
        while (!m.isEmpty()) {
            Node q = (Node) m.Dequeue();
            if (q.left != null) {
                m.Enqueue(q.left);
            }
            if (q.right != null) {
                m.Enqueue(q.right);
            }
            // If q has only one child, increment c by 1
            if (q.left == null && q.right != null) {
                n++;
            }
            if (q.right == null && q.left != null) {
                n++;
            }
        }
        return n;
    }

//count node have exactly 2 child
    int countNodeCo2con(Node p) {
        int n = 0;
        MyQueue m = new MyQueue();
        m.Enqueue(p);
        while (!m.isEmpty()) {
            Node q = (Node) m.Dequeue();
            if (q.left != null) {
                m.Enqueue(q.left);
            }
            if (q.right != null) {
                m.Enqueue(q.right);
            }
            if (q.left != null && q.right != null) {
                n++;
            }
        }
        return n;
    }

//-------------------------------- Duyet tree ----------------------------------
// Visit node p
    void visit(Node p) {
        System.out.print(p.info + "");
    }

    //preorder a tree
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

    //postorder a tree
    public void postOrder(Node p) {
        if (p == null) {
            return;
        }
        postOrder(p.left);
        postOrder(p.right);
        visit(p);
    }

    public void postOrder() {
        postOrder(root);
    }

    //inorder a tree
    public void inOrder(Node p) {
        if (p == null) {
            return;
        }
        inOrder(p.left);
        visit(p);
        inOrder(p.right);
    }

    public void inOrder() {
        inOrder(root);
    }

    //BreathFirstOder a tree
    public void BreathFirstOder(Node p) {
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

    public void BreathFirstOder() {
        BreathFirstOder(root);
    }

    //height of tree
    public int height(Node p) {
        if (p == null) {
            return 0;
        } else {
            int lDepth = height(p.left);//compute the depth of each subtree
            int rDepth = height(p.right);
            if (lDepth > rDepth) {
                return (lDepth + 1);//use the larger one
            } else {
                return (rDepth + 1);
            }
        }
    }

    public int height() {
        int height = height(root);
        return height;
    }

    //C1: return a Node which has key = given key in the tree p
    public Node search(Node p, int key) {
        if (p == null) {
            return null;
        }
        if (p.info.price == key) {
            return p;
        } else if (p.info.price > key) {
            return search(p.left, key);
        } else {
            return search(p.right, key);
        }
    }

    //C2: return a Node which has key = given key in the tree p
    Node findNode(int key) { // Tìm node bất kỳ để xóa
        Node cu = root;
        while (cu != null) {
            if (cu.info.price == key) {
                return cu;
            }
            cu = cu.info.price < key ? cu.right : cu.left;
        }
        return null;
    }
//------------------------------------------------------------------------------

// ------------------------ delete from tree -----------------------------------
//delete by copying
    public void deleteByCopy(int x) {
        Node p = search(root, x);
        if (p == null) {
            System.out.println("Key " + x + " does not exists, deletion failed");
            return;
        }
        //find f is father of p
        Node f = null, q = root;
        while (q != p) {
            f = q;
            if (q.info.price > p.info.price) {
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

    public void deleteByCopy1(Node p) {
        //find f is father of p
        Node f = null, q = root;
        while (q != p) {
            f = q;
            if (q.info.price > p.info.price) {
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
// Delete by merging

    public void deleteByMerging(int x) {
        Node p = search(root, x);
        if (p == null) {
            System.out.println("Key " + x + " does not exists, deletion failed");
            return;
        }
        //find f is father of p
        Node f = null, q = root;
        while (q != p) {
            f = q;
            if (q.info.price > p.info.price) {
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
            //tim q la node lon nhat ben con trai cua p -> q la con phai nhat
            //cua con trai cua p
            q = p.left;
            Node t = null;
            while (q.right != null) {
                t = q;
                q = q.right;
            }
            Node rp = p.right;
            q.right = rp;
            if (f == null) {
                root = p.left;
            } else if (f.left == p) {
                f.left = p.left;
            } else {
                f.right = p.left;
            }
        }
    }
    
//------------------------------------------------------------------------------
//---------------------------- Rotation tree -----------------------------------
//Quay cây phải
    Node rotateRight(Node p) {
        if (p == null || p.left == null) {
            return null;
        }
        Node child = p.left;
        p.left = child.right;
        child.right = p;
        return child;
    }

//Quay cây trái 
    Node rotateLeft(Node p) {
        if (p == null || p.right == null) {
            return null;
        }
        Node child = p.right;
        p.right = child.left;
        child.left = p;
        return child;
    }
    
    
//------------------------------------------------------------------------------
//--------------------------------- balance tree -------------------------------
//balance tree
    public void balance(Node p) {
        ArrayList a = new ArrayList();
        buildArray(a, p);
        int l = a.size(), f = 0;
        //create a new tree and insert all items from a to the BST
        BSTree t = new BSTree();
        t.balance(a, f, l - 1);
        root = t.root;
    }

 //(USE FOR BALANCE)insert all items from an array to a new BST
    public void balance(ArrayList a, int f, int l) {
        if (f > l) {
            return;
        }
        int m = (f + l) / 2;
        Node p = (Node) a.get(m);
        add(p.info);
        balance(a, f, m - 1);
        balance(a, m + 1, l);
    }

//(USE FOR BALANCE)inorder a BST and save all items to an array
    public void buildArray(ArrayList a, Node p) {
        if (p == null) {
            return;
        }
        buildArray(a, p.left);
        a.add(p);
        buildArray(a, p.right);
    }

}
