package test123;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class tests {
	public static void main(String[] args) {
		List<String> list = Arrays.asList("orange123",  "banana123", "apple123", "apple456","banana789", "orange456","test","te23","oracls2");
        
        Map<String, List<String>> map = new HashMap<>();
        
//    	테이블 명을 앞에 5글자 순으로 정리한다.
        for (String item : list) {
            String key = item.substring(0, Math.min(5, item.length())); // 앞 5글자 추출
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(item);
        }
        
     //   List<String> result = new ArrayList<>();
        Collection<List<String>> result2 = map.values();
        for (List<String> group : map.values()) {
           //result.addAll(group);
        	for(String i:group) {
        		 System.out.println(i);
        	}            
        }
        
        // 결과 출력
       // System.out.println(result);
    }
	

	
}
