package com.example.data_structure_algorithm.jike.link.回文字;

/**
 * 单向链表实现回文
 *
 * @author zhusidao
 */
public class SinglyLinkedList {
    public static void main(String[] args) {
        char[] chars = new char[]{'1', '2', '4', '3', '2', '1'};
        // a1 > b1 > c1 > d > c > b > a
        Node header = new Node(chars[0], null);
        Node index = header;
        for (int i = 1; i < chars.length; i++) {
            index.next = new Node(chars[i]);
            index = index.next;
        }
        System.out.println(isHw(header));
    }

    /**
     * 快慢指针便利链表找到中间节点w
     * <p>
     * 奇数个数
     * a1 > b1 > c1 > d > c > b > a
     * slow指针遍历数  a1 b1 c1 d
     * quick指针遍历数 a1 c1 c  a
     * reverseNode节点 d -> c1 -> b1 -> a1
     * <p>
     * <p>
     * 偶数个数
     * a1 > b1 > c1 > d > c > b
     * slow指针遍历数  a1 b1 c1
     * quick指针遍历数 a1 c1 c
     * reverseNode节点 c1 -> b1 -> a1
     *
     * @param node
     * @return
     */
    private static boolean isHw(Node node) {
        Node slow = node, quick = node;
        Node reverseNode = new Node(node);
        while (quick.next != null && (quick = quick.next.next) != null) {
            slow = slow.next;
            Node reverse = new Node(slow);
            reverse.next = reverseNode;
            reverseNode = reverse;
        }
/*        while (reverseNode != null) {
            System.out.println(reverseNode.text);
            reverseNode = reverseNode.next;
        }*/
        if (quick != null) {
            // 奇数，回退一格
            reverseNode = reverseNode.next;
        }
        slow = slow.next;
        while (reverseNode != null) {
            if (reverseNode.text != slow.text) {
                return false;
            }
            reverseNode = reverseNode.next;
            slow = slow.next;
        }
        return true;
    }

    static class Node {
        private final char text;
        private Node next;

        public Node(char text) {
            this.text = text;
        }

        public Node(Node node) {
            this.text = node.text;
        }

        public Node(char text, Node next) {
            this.text = text;
            this.next = next;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "text=" + text +
                    ", next=" + next +
                    "}";
        }
    }
}
