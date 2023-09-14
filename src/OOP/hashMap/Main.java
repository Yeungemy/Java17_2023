package OOP.hashMap;

import java.util.Map;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        HashMapExample hashMapExample = new HashMapExample();
        Map<String, Item> map = new HashMap<>();
        map.put("WIDG-001", new Item("Widget", 3.99));
        map.put("GADG-002", new Item("Gadget", 5.99));
        map.put("THNG-003", new Item("Thingamajig", 2.99));
        map.put("DBOO-004", new Item("Doo-dad", 4.99));
        map.put("WIDG-005", new Item("Super Widget", 6.99));
        map.put("GADG-006", new Item("Super Gadget", 8.99));
        map.put("THNG-007", new Item("Super Thingamajig", 15));
        map.put("DOFO-008", new Item("Super Doo-dad", 10));


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

        System.out.println("\nSKU \t\tPrice\tItem");
        map.forEach((key, item) -> {
            System.out.println(key + " \t" + item.getPrice() + "\t" + item.getName());
        });
    }
}
