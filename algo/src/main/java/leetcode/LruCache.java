package leetcode;

import java.util.*;

/**
 * @author xiaohuajun
 * @version 1.0
 * @date 2023/1/18 下午2:18
 * @description LruCache lru :最近最少使用缓存淘汰策略
 */
public class LruCache {




    class DoubleListNode{

        int key;
        int value;

        public DoubleListNode(){}

        public DoubleListNode(int key,int value){
            this.value = value;
            this.key = key;
        }

        

    }


    private Map<Character,Integer> map = new HashMap<>();

    public static void main(String[] args) {
        String s = "";
        String[] split = s.split(" ");
        Map<String,Integer> map = new HashMap<>();
        List<Map.Entry<String,Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((a,b) -> {
           if(b.getValue() < a.getValue()){
               //次数降序排列
               return -1;
               //次数相同
           } else if (b.getValue().equals(a.getValue())){
               if(b.getKey().length() > a.getKey().length()){
                   // 字母长度升序
                   return  -1;
               }else if(b.getKey().length() == a.getKey().length()) {
                   //字典升序
                   return a.getKey().compareTo(b.getKey());
               }
           }
           return  -1;
        });

        String res = "";

        for(int i = 0; i < list.size();i++){
            for(int j = 0;j < list.get(i).getValue();j++){
                res += list.get(i).getKey() + " ";
            }
        }
        System.out.println(res.substring(0,res.length() - 1));
    }


}
