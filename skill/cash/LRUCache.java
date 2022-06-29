package skill.cash;

import sun.applet.Main;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * 146. LRU 缓存
 * 请你设计并实现一个满足  LRU (最近最少使用) 缓存 约束的数据结构。
 * 实现 LRUCache 类：
 * LRUCache(int capacity) 以 正整数 作为容量 capacity 初始化 LRU 缓存
 * int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
 * void put(int key, int value) 如果关键字 key 已经存在，则变更其数据值 value ；如果不存在，则向缓存中插入该组 key-value 。如果插入操作导致关键字数量超过 capacity ，则应该 逐出 最久未使用的关键字。
 * 函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入
 * ["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
 * [[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
 * 输出
 * [null, null, null, 1, null, -1, null, -1, 3, 4]
 * <p>
 * 解释
 * LRUCache lRUCache = new LRUCache(2);
 * lRUCache.put(1, 1); // 缓存是 {1=1}
 * lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
 * lRUCache.get(1);    // 返回 1
 * lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
 * lRUCache.get(2);    // 返回 -1 (未找到)
 * lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
 * lRUCache.get(1);    // 返回 -1 (未找到)
 * lRUCache.get(3);    // 返回 3
 * lRUCache.get(4);    // 返回 4
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= capacity <= 3000
 * 0 <= key <= 10000
 * 0 <= value <= 105
 * 最多调用 2 * 105 次 get 和 put
 */
public class LRUCache {

    //哈希表+双端链表
    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1,1);
        lruCache.put(2,2);
        lruCache.get(1);

        lruCache.put(3,3);
        lruCache.get(2);

        lruCache.put(4,4);
        lruCache.get(1);

        lruCache.get(3);

        lruCache.get(4);

    }

    int capacity;

    Map<Integer, Node> map;

    Node front;

    Node end;

    public LRUCache(int capacity) {
        map = new HashMap<>(capacity);
        this.capacity = capacity;
    }

    public int get(int key) {
        Node node = map.get(key);
        if (node == null) {
            return -1;
        }
        del(key);
        put(key, node.val);
        return node.val;
    }

    public void put(int key, int value) {
        del(key);
        if (capacity == map.size()) {
            del(front.key);
        }
        Node node = new Node(key, value);
        if (end == null) {
            front = node;
            end = node;
        } else {
            end.next = node;
            node.pre = end;
            end = node;
        }
        map.put(key, node);
    }

    private void del(int key) {
        Node node = map.get(key);
        if (node == null) {
            return;
        }
        if (node == front && node == end) {
            front = null;
            end = null;
        } else if (front == node) {
            node.next.pre = null;
            front = node.next;
            node.next = null;
        } else if (end == node) {
            node.pre.next = null;
            end = node.pre;
            node.pre = null;
        } else {
            node.next.pre = node.pre;
            node.pre.next = node.next;
            node.next = null;
            node.pre = null;
        }
        map.remove(key);
    }

    class Node {
        Node pre;

        Node next;

        int key;

        int val;

        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
}
