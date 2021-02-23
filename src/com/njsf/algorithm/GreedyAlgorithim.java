package com.njsf.algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class GreedyAlgorithim {
    public static void main(String[] args) {
        HashMap<String, HashSet<String>> broadcasts = new HashMap<String,HashSet<String>>();
        HashSet<String> hashSet1 = new HashSet<String>();
        hashSet1.add("北京");
        hashSet1.add("上海");
        hashSet1.add("天津");

        HashSet<String> hashSet2 = new HashSet<String>();
        hashSet2.add("广州");
        hashSet2.add("北京");
        hashSet2.add("深圳");

        HashSet<String> hashSet3 = new HashSet<String>();
        hashSet3.add("成都");
        hashSet3.add("上海");
        hashSet3.add("杭州");

        HashSet<String> hashSet4 = new HashSet<String>();
        hashSet4.add("上海");
        hashSet4.add("天津");

        HashSet<String> hashSet5 = new HashSet<String>();
        hashSet5.add("杭州");
        hashSet5.add("大连");


        broadcasts.put("K1",hashSet1);
        broadcasts.put("K2",hashSet2);
        broadcasts.put("K3",hashSet3);
        broadcasts.put("K4",hashSet4);
        broadcasts.put("K5",hashSet5);

        HashSet<String> allAreas = new HashSet<String>();

        allAreas.addAll(hashSet1);
        allAreas.addAll(hashSet2);
        allAreas.addAll(hashSet3);
        allAreas.addAll(hashSet4);
        allAreas.addAll(hashSet5);

        ArrayList<String> selects = new ArrayList<String>();

        HashSet<String> tempSet = new HashSet<String>();

        String maxKey = null;

        while(allAreas.size() != 0){
            maxKey = null;
            for(String key : broadcasts.keySet()){
                tempSet.clear();
                tempSet.addAll(broadcasts.get(key));
                tempSet.retainAll(allAreas);

                if(tempSet.size() > 0 && (maxKey == null || tempSet.size() > broadcasts.get(maxKey).size())){
                    maxKey = key;
                }

            }

            if(maxKey != null){
                selects.add(maxKey);
                allAreas.removeAll(broadcasts.get(maxKey));
            }
        }

        System.out.println(selects);


    }
}
