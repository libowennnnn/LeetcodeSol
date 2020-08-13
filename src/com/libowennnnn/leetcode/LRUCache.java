package com.libowennnnn.leetcode;

import java.util.HashMap;
import java.util.Map;

class LRUCache {

    class Node{
        int key;
        int val;
        Node next;
        Node pre;
        public Node(){};
        public Node(int _k, int _v){
            key = _k;
            val = _v;
        }
    }
    private Map<Integer, Node> cache = new HashMap<>();
    private int size;
    private int capacity;
    private Node head;
    private Node tail;


    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.pre = head;
    }

    public static void main(String[] args){

        LRUCache lru = new LRUCache(1);
        lru.put(2,1);
        lru.get(2);
        lru.put(3,2);
        lru.get(2);       // 返回  1
        // 该操作会使得关键字 2 作废
        lru.get(3);       // 返回 -1 (未找到)


    }

    public int get(int key) {
        Node res = cache.get(key);
        if(res == null){
            return -1;
        }
        moveToHead(res);
        return res.val;
    }

    public void put(int key, int value) {
        Node putting = new Node(key, value);
        Node res = cache.get(key);
        if (res != null) {
            res.val = value;
            moveToHead(res);
            return;
        }
        cache.put(key, putting);
        if( this.size < this.capacity ){
            addToHead(putting);
            this.size++;
        }
        else{
            Node toBeRemoved = tail.pre;
            removeNode(toBeRemoved);
            addToHead(putting);
            cache.remove(toBeRemoved.key);
        }
    }

    public void addToHead(Node putting){
        putting.next = head.next;
        head.next.pre = putting;
        putting.pre = head;
        head.next = putting;
    }

    public void removeNode(Node node){
        node.next.pre = node.pre;
        node.pre.next = node.next;
    }

    public void moveToHead(Node node){
        removeNode(node);
        addToHead(node);
    }
}