/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demobst;

/**
 *
 * @author DUC THINH
 */
public class MyTree {

    Node root;

    public MyTree() {
    }

    boolean isEmpty() {
        return root == null;
    }

    void add(Car value) {
        Node node = new Node(value);
        if (isEmpty()) {
            root = node;
            return;
        }
        Node cu = root;
        Node father = null;
        while (cu != null) {
            if (cu.value.price == value.price) {
                System.out.println("Không thể add " + value + " vào trong tree!");// BST không chấp nhận giá trị trùng nhau
                return;
            }
            father = cu;
            if (cu.value.price < value.price) {
                cu = cu.right;
            } else {
                cu = cu.left;
            }
        }
        if (father == null) {
            root = node;
        } else if (father.value.price < value.price) {
            father.right = node;
        } else {
            father.left = node;
        }
    }
// check nếu xOwner.charA(0)=”B” hay xPrice>100 thì do nothing, ngược lại thì insert new car với owner=xOwner, price=xPrice vảo tree

    void insert(String xOwner, int xPrice) {
        if (xOwner.toUpperCase().charAt(0) == 'B' || xPrice > 100) {
            return;
        } else {
            Car value = new Car(xOwner, xPrice);
            add(value);
        }
    }

    void visit(Node p) {
        System.out.print(p.value + "");
    }

    void preOrder(Node p) {
        if (p == null) {
            return;
        }
        visit(p);
        preOrder(p.left);
        preOrder(p.right);
    }

    void preOrder() {
        preOrder(root);
    }
//Thực hiện PreOrder từ root nhưng display f2 các nodes có giá trong khoảng [3.5] ( thực hiện bằng cách copy hàm preOrder() thành hàm preorder2() và sửa nó

    void preOrder2(Node p) {
        if (p == null) {
            return;
        }
        if (p.value.price >= 3 && p.value.price <= 5) {
            visit(p);
        }

        preOrder2(p.left);
        preOrder2(p.right);

    }

    void preOrder2() {
        preOrder2(root);
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

    //height of tree
    int height(Node p) {
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

    int height() {
        int height = height(root);
        return height;
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

    public Node search(Node p, int key) {
        if (p == null) {
            return null;
        }
        if (p.value.price == key) {
            return p;
        } else if (p.value.price > key) {
            return search(p.left, key);
        } else {
            return search(p.right, key);
        }
    }

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
            if (q.value.price > p.value.price) {
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
            p.value = q.value;
            //delete q
            if (f == null) {
                p.left = q.left;
            } else {
                f.right = q.left;
            }
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

    Node findNode(int key) { // Tìm node bất kỳ để xóa
        Node cu = root;
        while (cu != null) {
            if (cu.value.price == key) {
                return cu;
            }
            cu = cu.value.price < key ? cu.right : cu.left;
        }
        return null;
    }

    void deleteByMerging(Node p) {
        Node father = getParent(p);
        if (father == null) {
            if (p.value.price != root.value.price) { // Không có node p trong tree
                System.out.println("Khong ton tai node p");
                return;
            }
            if (root.left == null) { // Không có con trái thì xóa con phải
                root = root.right;
                return;
            }

            if (root.left.right == null) {// giá trị ngoài cùng bên phải của con 
                // bên trái chính là con bên trái
                root.left.right = root.right;
                root = root.left;
                return;
            }
            Node q = root.left;
            while (q.right != null) {
                q = q.right;
            }
        }

    }

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
            if (q.value.price > p.value.price) {
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
//            Node t = null;
            while (q.right != null) {
//                t = q;
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
// Quay cây phải

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

// Void f3(): Thực hiện Breadth-First từ root và delete by copying node đầu tiên có 2 con và giá <7.
    void f3() {
        // Duyệt cây theo breadth-first
        BreathFirstOder();
        Node q = new Node();
        MyQueue queue = new MyQueue();

        if (isEmpty()) {
            return;
        }
        // Đi từng node trong cây
        queue.Enqueue(root);
        while (!queue.isEmpty()) {
            Node node = queue.Dequeue();
            if (node.left != null) {
                queue.Enqueue(node.left);
            }
            if (node.right != null) {
                queue.Enqueue(node.right);
            }
            // kiểm tra node là cha có 2 con đầu tiên và có price < 7
            if (node.right != null && node.left != null && node.value.price < 7) {
                q = node; // lấy ra node đúng với yêu cầu
                break;
            }
        }
        // delete bằng copying node
        deleteByMerging(12);
//        System.out.println("");
//        deleteByCopy(12);
        System.out.println("");
        BreathFirstOder();
    }

//Void f4(): Thực hiện Breadth-First từ  root và tìm node p có con trái và giá nhỏ hơn 7. Quay p sang phải với con trái của nó.
    void f4() {
        BreathFirstOder();
        Node q = new Node();
        MyQueue queue = new MyQueue();

        if (isEmpty()) {
            return;
        }
        // Đi từng node trong cây
        queue.Enqueue(root);
        while (!queue.isEmpty()) {
            Node node = queue.Dequeue();
            if (node.left != null) {
                queue.Enqueue(node.left);
            }
            if (node.right != null) {
                queue.Enqueue(node.right);
            }
            // kiểm tra node là cha có 2 con đầu tiên và có price < 7
            if (node.left != null && node.value.price < 7) {
                q = node; // lấy ra node đúng với yêu cầu
                break;
            }
        }
//        rotateRight(q);
        if (q == null) {
            System.out.println("Không tồn tại");
        } else {
            Node father = getParent(q);
            Node father1 = rotateRight(q);
            if (father == null) {
                root = father1;
            } else {
                if (father.value.price < q.value.price) {
                    father.right = father1;
                } else {
                    father.left = father1;
                }
            }
        }

        System.out.println("");
        BreathFirstOder();
    }
}
