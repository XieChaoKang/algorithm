package 缓存淘汰算法;

import java.util.HashMap;

/**
 * 缓存淘汰算法-LRU 每次淘汰最近最少使用
 * 哈希表 + 双向链表 实现 哈希表保证其查询速度够快 双向链表保证写入速度够快
 * 思路：
 * 写数据 每次插入节点时，判断该节点是否已经存在
 * 1，存在则删除该节点，然后头插进链表
 * 2，不存在则通过 对比当前链表长度和最大容量 判断当前链表已经满了，满了则先删除链表的尾节点再头插入；没满则直接头插入
 * 以此保证热点数据永远在链表第一位
 * 读数据
 * 读完数据需要调用一次put方法把读的节点放到链表的第一位 保证热点数据永远在第一位
 * 不管是读数据还是写数据都保证热点数据在第一位 当缓存满了需要删除数据的时候直接删除最后一个节点即可 因为该节点的数据永远是最近最少使用的数据
 * 图解双向链表：https://www.cnblogs.com/bigsai/p/14593196.html
 * 图解LRU：
 */
public class LRU {

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(10);
        for (int i = 0; i < 10; i++) {
            cache.put(i,i);
        }
        cache.fmt();
        System.out.println("\t");
        cache.get(1);
        cache.fmt();
    }
}

//双向链表
class Node {
    public int key, val;
    public Node next, prev;
    public Node(int k, int v) {
        this.key = k;
        this.val = v;
    }

    @Override
    public String toString() {
        return "Node{" +
                "key=" + key +
                ", val=" + val +
                '}';
    }
}

//构建双向链表及其相关操作
class doubleList{
    Node head;

    //头插
    public void addFirst(Node x){
        //链表不为空
        if (this.head != null) {
            x.next = head;
            head.prev = x;
        }
        this.head = x;
    }

    //尾插
    public void addTail(Node x){
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = x;
        x.prev = temp;
    }

    //删除节点
    public Node remove(Node x){
        if (head == null){
            System.out.println("链表为空！");
            return null;
        }
        Node temp = head;
        boolean flag = false;
        while (true){
            if (temp == null){
                break;
            }
            if (temp.key == x.key){
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag){
            //注意判断要删除的节点是否是普通节点 注意边界 以防造成空指针
            //头节点删除
            if (temp.prev == null){
                head = head.next;
                return temp;
            }
            //尾节点删除
            if (temp.next == null){
                temp.prev.next = null;
                temp.prev = null;
                return temp;
            }
            //普通节点删除
            temp.prev.next = temp.next;
            temp.next.prev = temp.prev;
            return temp;
        }else {
            System.out.println("删除的节点不存在！");
            return null;
        }
    }

    //删除最后一个节点
    public Node removeLast(){
        if (head == null){
            System.out.println("链表为空！");
            return null;
        }
        Node temp = head;
        while (temp.next != null){
            temp = temp.next;
        }
        if (temp.prev == null){
            head = head.next;
            return temp;
        }
        temp.prev.next = null;
        temp.prev = null;
        return temp;
    }

    public int size(){
        int size = 0;
        Node temp = head;
        while (temp != null){
            size++;
            temp = temp.next;
        }
        return size;
    }

    public void fmt(){
        if (this.head == null) {
            return;
        }
        Node temp = head;
        while (temp != null){
            System.out.println(temp);
            temp = temp.next;
        }
    }
}

//缓存类
class LRUCache{
    private HashMap<Integer,Node> map;
    private doubleList cache;
    //最大容量
    private int cap;

    public LRUCache(int cap){
        map = new HashMap<>();
        cache = new doubleList();
        this.cap = cap;
    }

    //存数据
    public void put(int key,int value){
        Node node = new Node(key, value);

        //如果节点已经存在就先删除节点
        if (map.containsKey(key)){
            cache.remove(node);
        }else {
            //如果已经到达最大容量 则删除链表最后一个节点
            if (cap == cache.size()){
                Node lastNode = cache.removeLast();
                map.remove(lastNode.key);
            }
        }
        cache.addFirst(node);
        map.put(key,node);
    }

    //读数据
    public int get(int key){
        if (!map.containsKey(key)){
            return -1;
        }
        int value = map.get(key).val;
        //利用put方法把该节点放到链表的首位 保证热点数据永远在链表第一位
        put(key,value);
        return value;
    }

    public void fmt(){
        cache.fmt();
    }
}
