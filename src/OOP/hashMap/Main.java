package OOP.hashMap;

import java.util.Map;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        HashMapExample hashMapExample = new HashMapExample();

        Map<String, String> myMap = new HashMap<>(){
            {
                put("1", "a");
                put("2", "c");
            }

        };

        System.out.println("\nBelow is printed by 'For Loop': ");
        hashMapExample.iterateUsingForLoop(myMap);

        System.out.println("\nBelow is printed by 'While Loop': ");
        hashMapExample.iterateUsingWhileLoop(myMap);

        System.out.println("\nBelow is printed by 'Lambda ForEach Loop': ");
        hashMapExample.iterateUsingLambda(myMap);
    }
}
