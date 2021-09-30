package 数据结构题库;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/design-hashmap/
 */
public class 设计hash {

    public static void main(String[] args) {
        new HashMap<>();
        MyHashMap myHashMap = new MyHashMap();
        myHashMap.put(1,1);
        myHashMap.put(2,2);
        System.out.println(myHashMap.get(1));
        System.out.println(myHashMap.get(2));
        System.out.println(myHashMap.get(3));
        myHashMap.put(2,1);
        System.out.println(myHashMap.get(2));
        myHashMap.remove(2);
        System.out.println(myHashMap.get(2));
    }
}

class MyHashMap {

    private List<List<Object>> map;

    public MyHashMap() {
        this.map = new ArrayList<>();
    }

    public void put(int key, int value) {
        if (containsKey(key) > -1){
            this.map.get(containsKey(key)).set(1, value);
        }else {
            List<Object> list = new ArrayList<>();
            list.add(key);
            list.add(value);
            this.map.add(list);
        }
    }

    public int get(int key) {
        if (containsKey(key) > -1){
            return Integer.parseInt(this.map.get(containsKey(key)).get(1).toString());
        }
        return -1;
    }

    public void remove(int key) {
        if (containsKey(key) > -1){
            this.map.remove(containsKey(key));
        }
    }

    private int containsKey(int key) {
        for (int i = 0; i < this.map.size(); i++) {
            if (Integer.parseInt(map.get(i).get(0).toString()) == key) {
                return i;
            }
        }
        return -1;
    }
}
