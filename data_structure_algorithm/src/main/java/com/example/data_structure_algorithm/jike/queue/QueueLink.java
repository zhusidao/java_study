package com.example.data_structure_algorithm.jike.queue;

/**
 * 添加一个哨兵节点来增加代码的可读性
 *
 * @param <T>
 */
public class QueueLink<T> {
    private Node<T> head;
    private Node<T> tail;

    public T dequeue() {
        if (head == null) {
            return null;
        }
        T text = head.text;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        return text;
    }

    public boolean enqueue(T text) {
        if (tail == null) {
            // 当没有节点的时候构造一个空的节
            tail = new Node<>(text);
            head = tail;
        } else {
            tail.next = new Node<>(text);
            tail = tail.next;
        }
        return true;
    }

    private static class Node<T> {
        private T text;
        private Node<T> next;

        public Node(T text) {
            this.text = text;
        }
    }

    public static void main(String[] args) {

    }
}
