package com.example.data_structure_algorithm.jike.tree;

/**
 * 二叉查找树
 * 二叉查找树要求，在树中的任意一个节点，其左子树中的每个节点的值，都要小于这个节点的值，而右子树节点的值都大于这个节点的值
 *
 * @Author: sidao.zhu
 * @Date: 2021/3/4
 */
public class BinarySearchTreeTest<T extends Comparable<T>> {
    Node<T> root;

    /**
     * 插入
     */
    void insert(T t) {
        if (root == null) {
            root = new Node<>(t);
            return;
        }
        Node<T> node = root;
        while (true) {
            if (t.compareTo(node.data) > 0) {
                if (node.right == null) {
                    node.right = new Node<>(t);
                    return;
                }
                node = node.right;
            }
            if (t.compareTo(node.data) < 0) {
                if (node.left == null) {
                    node.left = new Node<>(t);
                    return;
                }
                node = node.left;
            }
        }
    }

    /**
     * 递归搜索
     */
    Node<T> search(Node<T> node, T t) {
        if (node == null) {
            return null;
        }
        int result = node.data.compareTo(t);
        if (result == 0) {
            return node;
        } else if (result < 0) {
            return search(node.right, t);
        } else {
            return search(node.left, t);
        }
    }

    /**
     * 搜索
     */
    Node<T> search1(T t) {
        Node<T> node = root;
        while (node != null) {
            int result = node.data.compareTo(t);
            if (result == 0) {
                return node;
            } else if (result < 0) {
                node = node.right;
            } else {
                node = node.left;
            }
        }
        return null;
    }

    /**
     * 删除树
     *
     * @param data
     */
    public void delete(T data) {
        Node<T> p = root; // p指向要删除的节点，初始化指向根节点
        Node<T> pp = null; // pp记录的是p的父节点
        while (p != null && p.data != data) {
            pp = p;
            if (data.compareTo(p.data) > 0) {
                p = p.right;
            } else {
                p = p.left;
            }
        }
        if (p == null) {
            return; // 没有找到
        }

        // 要删除的节点有两个子节点
        if (p.left != null && p.right != null) { // 查找右子树中最小节点
            Node<T> minP = p.right;
            Node<T> minPP = p; // minPP表示minP的父节点
            while (minP.left != null) {
                minPP = minP;
                minP = minP.left;
            }
            p.data = minP.data; // 将minP的数据替换到p中
            p = minP; // 下面就变成了删除minP了
            pp = minPP;
        }

        // 删除节点是叶子节点或者仅有一个子节点
        Node<T> child; // p的子节点
        if (p.left != null) {
            child = p.left;
        } else if (p.right != null) {
            child = p.right;
        } else {
            child = null;
        }

        if (pp == null) {
            root = child; // 删除的是根节点
        } else if (pp.left == p) {
            pp.left = child;
        } else {
            pp.right = child;
        }
    }

    /**
     * 查找值最小结点的父结点
     */
    Node<T> searchMinValueParentNode(Node<T> node) {
        if (node.left == null) {
            return node;
        }
        if (node.left.left == null) {
            return node;
        }
        return searchMinValueParentNode(node.left);
    }

    /**
     * 查找最小值
     */
    T searchMinValue(Node<T> node) {
        if (node == null) {
            return null;
        }
        if (node.left == null) {
            return node.data;
        }
        return searchMinValue(node.left);
    }

    /**
     * 先序遍历
     */
    void firstTraversal(Node<T> node) {
        if (node != null) {
            System.out.print(node.data + " ");
            firstTraversal(node.left);
            firstTraversal(node.right);
        }
    }

    /**
     * 中序遍历输入的结果为有序
     */
    void middleTraversal(Node<T> node) {
        if (node != null) {
            middleTraversal(node.left);
            System.out.print(node.data + " ");
            middleTraversal(node.right);
        }
    }

    public static void main(String[] args) {
        BinarySearchTreeTest<Integer> treeTest = new BinarySearchTreeTest<>();
        treeTest.insert(13);
        treeTest.insert(10);
        treeTest.insert(16);
        treeTest.insert(9);
        treeTest.insert(11);
        treeTest.insert(14);

        // 先序遍历
        treeTest.firstTraversal(treeTest.root);
        System.out.println();
        // 中序遍历
        treeTest.middleTraversal(treeTest.root);

        //  Node<Integer> search = treeTest.search(treeTest.root, 11);
        //     System.out.println("\n" + (search == null ? null : search.data));

        //
    }

    static class Node<T extends Comparable<T>> {
        T data;
        Node<T> left;
        Node<T> right;

        public Node(T data) {
            this.data = data;
        }
    }
}
