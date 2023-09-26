package OOP.hashMap;
import java.util.Iterator;
import java.util.Map;

public class HashMapExample {
    public void iterateUsingForLoop(Map<String, String> map){
        for(Map.Entry<String, String> entry : map.entrySet()){
            String key = entry.getKey();
            String value = entry.getValue();
            System.out.println("Key = " + key + ", Value = " + value);
        }
    }

    public void iterateUsingWhileLoop(Map<String, String> map){
        Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();

        while(iterator.hasNext()){
            Map.Entry<String, String> entry = iterator.next();
            String key = entry.getKey();
            String value = entry.getValue();

            System.out.println("Key = " + key + ", Value = " + value);
        }
    }

    public void iterateUsingLambda(Map<String, String> map){
        map.forEach((key, value) -> {
            System.out.println("Key = " + key + ", Value = " + value);
        });
    }
}
