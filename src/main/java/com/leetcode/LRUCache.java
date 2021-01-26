package com.leetcode;

import java.util.HashMap;

public class LRUCache {
    private HashMap<Integer, Node> map;
    private int capicity, count;
    private Node head, tail;

    LRUCache(int cap) {
        this.capicity = cap;
        map = new HashMap<>();

        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.pre = head;
        head.pre = null;
        tail.next = null;
        count = 0;
    }

    // This method works in O(1)
    public int get(int key) {
        // your code here
        if (map.get(key) != null) {
            Node node = map.get(key);
            deleteNode(node);
            addNodeHead(node);
            return node.value;
        } else {
            return -1;
        }
    }

    private void addNodeHead(Node node) {
        Node node2 = head.next;
        head.next = node;
        node.pre = head;
        node.next = node2;
        node2.pre = node;
    }

    private void deleteNode(Node node) {
        Node pre = node.pre;
        Node next = node.next;
        pre.next = next;
        next.pre = pre;
    }

    // This method works in O(1)
    public void put(int key, int value) {
        if (map.get(key) != null) {
            Node node = map.get(key);
            node.value = value;
            deleteNode(node);
            addNodeHead(node);
        } else {
            Node node = new Node(key, value);
            map.put(key, node);
            if (count < capicity) {
                count++;
            } else {
                map.remove(tail.pre.key);
                deleteNode(tail.pre);
            }
            addNodeHead(node);
        }
    }

    class Node {
        int key;
        int value;
        Node pre;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
